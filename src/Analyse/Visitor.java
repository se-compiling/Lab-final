package Analyse;

import Antlr.miniSysY.miniSysYBaseVisitor;
import Antlr.miniSysY.miniSysYParser;
import Global.Const;
import Global.SymbolTable;
import Types.*;
import Values.*;
import Values.Inst.MemInst;
import Values.Inst.Tag;
import Values.Inst.TerminatorInst;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import static java.lang.System.exit;

public class Visitor extends miniSysYBaseVisitor<Void> {

    private int nodeValue = 0;
    private int curdim;
    private Value curVal=new Value("",Type.VoidType.getVoidTy());
    private ArrayList<Value> curArr;
    private Type curTp;
    private ArrayList<Type> curTps;
    private boolean isConst = false;
    private boolean isRel = false;
    private boolean isGlobal = false;
    private boolean isintCall = false;
    private boolean isArrCall = false;
    private boolean isParamsTp = false;
    private boolean isParamsVal = false;
    private int visitTimes = 0;
    private ArrayList<Integer> dims=new ArrayList<>();
    private HashMap<String,ArrayList<Integer>> valDims;
    private final Constant.ConstantInt C0 = new Constant.ConstantInt(IntegerType.getI32(),0);
    private IntegerType i32 = IntegerType.getI32();
    private IntegerType I1 = IntegerType.getI1();
    private Type.VoidType voidType = Type.VoidType.getVoidTy();
    private PointerType i32Arr = new PointerType(i32);
    private MyModule module = MyModule.getInstance();
    private Builder builder = Builder.getInstance();
    private SymbolTable ST=new SymbolTable();
    private BasicBlock BB = new BasicBlock();
    private BasicBlock continue_cond = new BasicBlock();
    private BasicBlock break_next = new BasicBlock();
    private BasicBlock ifBlock = new BasicBlock();
    private BasicBlock elseBlock = new BasicBlock();
    private Function func = new Function("main",new FunctionType(i32,new ArrayList<>(Collections.emptyList())),false);

    private String[] SysYFunc={"getint","getch","getarray","putint","putch","putarray","memset"};
    private boolean[] isSysYDef={false,false,false,false,false,false,false};


    @Override public Void visitProgram(miniSysYParser.ProgramContext ctx) {

        //module.funcList.add(func);
        //func.setMainBlock(BB);
        Const.IR.append("declare void @memset(i32*, i32, i32)\n");
        ST.addSymbol("main",func);
        ST.addSymbol(SysYFunc[0], builder.createFunc(SysYFunc[0], new FunctionType(i32,new ArrayList<Type>(Collections.emptyList())), true));
        ST.addSymbol(SysYFunc[1], builder.createFunc(SysYFunc[1], new FunctionType(i32, new ArrayList<Type>(Collections.emptyList())), true));
        ST.addSymbol(SysYFunc[2], builder.createFunc(SysYFunc[2], new FunctionType(i32, new ArrayList<>(Collections.singletonList(i32Arr))), true));
        ST.addSymbol(SysYFunc[3], builder.createFunc(SysYFunc[3], new FunctionType(voidType, new ArrayList<>(Collections.singletonList(i32))), true));
        ST.addSymbol(SysYFunc[4], builder.createFunc(SysYFunc[4], new FunctionType(voidType, new ArrayList<>(Collections.singletonList(i32))), true));
        ST.addSymbol(SysYFunc[5], builder.createFunc(SysYFunc[5], new FunctionType(voidType, new ArrayList<>(Arrays.asList(i32,i32Arr))), true));
        ST.addSymbol(SysYFunc[6], builder.createFunc(SysYFunc[6], new FunctionType(voidType, new ArrayList<>(Arrays.asList(i32Arr, i32, i32))), true));
        return super.visitProgram(ctx);
    }

    @Override public Void visitCompUnit(miniSysYParser.CompUnitContext ctx) {
        return super.visitCompUnit(ctx);
    }

    @Override public Void visitDecl(miniSysYParser.DeclContext ctx) { return super.visitDecl(ctx); }

    @Override public Void visitConstDecl(miniSysYParser.ConstDeclContext ctx) { return super.visitConstDecl(ctx); }

    @Override public Void visitBType(miniSysYParser.BTypeContext ctx) { return super.visitBType(ctx); }

    @Override public Void visitConstDef(miniSysYParser.ConstDefContext ctx) {
        if(ST.top().get(ctx.IDENT().getText())!=null){
            exit(255);
        }
        if(ctx.constExp().size()==0){
            visit(ctx.constInitVal());
            ST.addSymbol(ctx.IDENT().getText(), curVal);
            return null;
        }
        if(ctx.constExp().size()!=0) {
            int dim=1;
            dims.clear();
            for(var cons:ctx.constExp()){
                visit(cons);
                int curDim = ((Constant.ConstantInt)curVal).getValue();
                dim*=curDim;
                dims.add(curDim);
            }
            curdim=dim;
            Type arrTy=new ArrayType(i32,dim);
            var name = ctx.IDENT().getText();
            if(ctx.constInitVal()==null){
                if(ST.isGlobal()){
                    ArrayList<Constant> globalCons = new ArrayList<>();
                    for(int i=0;i<dim;i++){
                        globalCons.add(C0);
                    }
                    Constant.ConstantArr constant = new Constant.ConstantArr(arrTy,globalCons);
                    //Constant.GlobalVar globalVar = builder.getGlobalVar(name,arrTy,null);
                    ST.addSymbol(name,constant);
                }else {
                    var alloca = builder.createAlloca(BB,arrTy);
                    ST.addSymbol(name,alloca);
                }
            }else {
                ctx.constInitVal().dims=dims;
                if(ST.isGlobal()){
                    isGlobal=true;
                    visit(ctx.constInitVal());
                    isGlobal=false;
                    ArrayList<Constant> globalCons = new ArrayList<>();
                    for(var c:curArr){
                        globalCons.add((Constant) c);
                    }
                    Constant.ConstantArr constantArr=new Constant.ConstantArr(arrTy,globalCons);
                    constantArr.setDims(dims);
                    module.globalConstArrs.put(name,constantArr);
                    //Constant.GlobalVar globalVar = builder.getGlobalVar(name,arrTy,constantArr);
                    //globalVar.setConst(true);
                    ST.addSymbol(name,constantArr);
                }else {
                    var alloca = builder.createAlloca(BB,arrTy);
                    ST.addSymbol(name,alloca);
                    //MemInst.GepInst gep = builder.createGep(BB,alloca,C0);
                    visit(ctx.constInitVal());
                    ArrayList<Constant> globalCons = new ArrayList<>();
                    for(var c:curArr){
                        globalCons.add((Constant) c);
                    }
                    Constant.ConstantArr constantArr=new Constant.ConstantArr(arrTy,globalCons);
                    constantArr.setDims(dims);
                    BB.addConstArrs(name,constantArr);
                    ST.addSymbol(name,constantArr);
                }
            }
        }
        return null;
    }

    @Override public Void visitConstInitVal(miniSysYParser.ConstInitValContext ctx) {
        if(ctx.constExp()!=null) {
            visit(ctx.constExp());
        }else {
            ArrayList<Value> arr_in_dim = new ArrayList<>();
            int size = ctx.dims.get(0),valSize=0;
            boolean isVisitExp=false;
            for(var initVal:ctx.constInitVal()){
                if(initVal.constExp()!=null){
                    visit(initVal);
                    arr_in_dim.add(curVal);
                    valSize++;
                    isVisitExp=true;
                }else {
                    for(int i = valSize;i<size&&isVisitExp;i++)arr_in_dim.add(C0);
                    ArrayList<Integer> newDims = new ArrayList<>(ctx.dims.subList(1,ctx.dims.size()));
                    initVal.dims=newDims;
                    visit(initVal);
                    arr_in_dim.addAll(curArr);
                }
            }
            for(int i=1;i<ctx.dims.size();i++)size*=ctx.dims.get(i);
            for(int i=arr_in_dim.size();i<size;i++)arr_in_dim.add(C0);
            curArr=arr_in_dim;
        }

        return null;
    }

    @Override public Void visitConstExp(miniSysYParser.ConstExpContext ctx) {
        isConst = true;
        visit(ctx.addExp());
        curVal = builder.getConstantInt(nodeValue);
        isConst = false;
        return null;
    }

    @Override public Void visitVarDecl(miniSysYParser.VarDeclContext ctx) { return super.visitVarDecl(ctx); }

    @Override public Void visitVarDef(miniSysYParser.VarDefContext ctx) {
        if(ST.top().get(ctx.IDENT().getText())!=null){
            exit(255);
        }
        //if(ST.getGlo().get(ctx.IDENT().getText())!=null)exit(255);
        String name = ctx.IDENT().getText();
        if(ctx.constExp().size()==0){
            if(!ST.isGlobal()){
                String val=ctx.IDENT().getText();
                MemInst allca = builder.createAlloca(BB,i32);
                ST.addSymbol(val,allca);
                if(ctx.initVal()!=null) {
                    visit(ctx.initVal());
                    builder.createStore(BB, curVal, allca);
                }
            }else{
                if (ctx.initVal() != null) {
                    isGlobal = true;
                    visit(ctx.initVal());
                    isGlobal = false;
                    Constant constant = (Constant) curVal;
                    var v = builder.getGlobalVar(name, i32, constant);
                    ST.addSymbol(name, v);
                } else {
                    Constant constant = C0;
                    var v = builder.getGlobalVar(name, i32,constant );
                    ST.addSymbol(name, v);
                }
            }
        }
        else if(ctx.constExp().size()!=0){
            int dim=1;
            dims.clear();
            System.out.println("VarDef检查点");
            for(var cons:ctx.constExp()){
                visit(cons);
                int tmpval = ((Constant.ConstantInt)curVal).getValue();
                dim*=tmpval;
                dims.add(tmpval);
            }
            System.out.println(name);
            System.out.println(dims.size());
            curdim=dim;
            Type arrTy = new ArrayType(i32,dim);
            ((ArrayType)arrTy).setDims(dims);
            if(ctx.initVal()==null){
                if(ST.isGlobal()){
                    Constant.GlobalVar globalVar = builder.getGlobalVar(name,arrTy,null);
                    ST.addSymbol(name,globalVar);
                }else {
                    var alloca = builder.createAlloca(BB,arrTy);
                    ST.addSymbol(name,alloca);
                }
            }else {
                if(ST.isGlobal()){
                    ctx.initVal().dims=dims;
                    isGlobal = true;
                    visit(ctx.initVal());
                    isGlobal=false;
                    ArrayList<Constant> globalCons = new ArrayList<>();
                    for(var c:curArr){
                        globalCons.add((Constant) c);
                    }
                    Constant.ConstantArr constantArr=new Constant.ConstantArr(arrTy,globalCons);
                    constantArr.setDims(dims);
                    module.globalConstArrs.put(name,constantArr);
                    Constant.GlobalVar globalVar = builder.getGlobalVar(name,arrTy,constantArr);
                    ST.addSymbol(name,globalVar);
                }
                else {
                    var alloca = builder.createAlloca(BB,arrTy);
                    ST.addSymbol(name,alloca);
                    if(ctx.initVal().initVal().size()==0){
                        MemInst.GepInst gep = builder.createGep(BB,alloca,C0);
                        Function memset = (Function) ST.find("memset");
                        builder.createCall(BB,memset, new ArrayList<>(Arrays.asList(gep, C0, new Constant.ConstantInt(i32, dim * 4))));
                    }else {
                        ctx.initVal().dims = dims;
                        visit(ctx.initVal());
                        MemInst.GepInst gep = builder.createGep(BB,alloca,C0);
                        Function memset = (Function) ST.find("memset");
                        builder.createCall(BB,memset, new ArrayList<>(Arrays.asList(gep, C0, new Constant.ConstantInt(i32, dim * 4))));
                        for(int i=0;i<curArr.size();i++){
                            Value val = curArr.get(i);
                            if(val instanceof Constant.ConstantInt&&((Constant.ConstantInt)val).getValue()==0)continue;
                            if(i==0)builder.createStore(BB,val,gep);
                            else {
                                Constant.ConstantInt constant = new Constant.ConstantInt(i32,i);
                                MemInst.GepInst newGep = builder.createGep(BB,alloca,constant);
                                builder.createStore(BB,val,newGep);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Void visitInitVal(miniSysYParser.InitValContext ctx) {
        if(ctx.exp()!=null){
            if(!isGlobal){
                visit(ctx.exp());
            }else {
                isConst= true;
                visit(ctx.exp());
                isConst = false;
                curVal = new Constant.ConstantInt(i32,nodeValue);
            }
        }else{
            ArrayList<Value> arr_in_dim = new ArrayList<>();
            int size = ctx.dims.get(0),valSize=0;
            boolean isVisitExp=false;
            //for(int i = 1;i<ctx.dims.size();i++)size*=ctx.dims.get(i);
            for(var initVal:ctx.initVal()){
                if(initVal.exp()!=null){
                    if(!isGlobal){
                        visit(initVal.exp());
                    }else {
                        isConst = true;
                        visit(initVal.exp());
                        isConst = false;
                        curVal = new Constant.ConstantInt(i32,nodeValue);
                    }
                    arr_in_dim.add(curVal);
                    valSize++;
                    isVisitExp=true;
                }else {
                    for(int i = valSize;i<size&&isVisitExp;i++)arr_in_dim.add(C0);
                    ArrayList<Integer> newDims = new ArrayList<>(ctx.dims.subList(1,ctx.dims.size()));
                    initVal.dims=newDims;
                    visit(initVal);
                    arr_in_dim.addAll(curArr);
                }
            }
            for(int i = 1;i<ctx.dims.size();i++)size*=ctx.dims.get(i);
            for(int i=arr_in_dim.size();i<size;i++)arr_in_dim.add(C0);
            curArr=arr_in_dim;
        }
        return null;
    }

    @Override public Void visitFuncDef(miniSysYParser.FuncDefContext ctx) {
        String name = ctx.IDENT().getText();
        String funcType = ctx.funcType().getText();
        boolean haveParams = false;
        if(ctx.funcFParams()!=null)haveParams=true;
        Type retTp ;
        if(funcType.equals("int"))retTp=i32;
        else retTp=voidType;
        ArrayList<Type> params = new ArrayList<>();
        if(haveParams){
             isParamsTp = true;
             visit(ctx.funcFParams());
             isParamsTp = false;
             params.addAll(curTps);
        }
        Function newfunction = builder.createFunc(name,new FunctionType(retTp,params),false);
        func=newfunction;
        module.funcList.add(func);
        ST.addSymbol(name,func);
        BasicBlock newEntryBB = new BasicBlock();
        func.setMainBlock(newEntryBB);
        ST.addBlock();
        BB=newEntryBB;
        if(haveParams){
            isParamsVal = true;
            visit(ctx.funcFParams());
            isParamsVal = false;
        }
        visit(ctx.block());
        if(BB.instList.size()==0){
            if(((FunctionType)func.getType()).getRetType().isVoidType())builder.createRet(BB);
            else builder.createRet(C0,BB);
        }else if((!(BB.instList.getLast() instanceof TerminatorInst.BrInst))&&(!(BB.instList.getLast() instanceof TerminatorInst.RetInst))){
            if(((FunctionType)func.getType()).getRetType().isVoidType())builder.createRet(BB);
            else builder.createRet(C0,BB);
        }
        ST.popBlock();
        return null;
    }

    @Override public Void visitFuncType(miniSysYParser.FuncTypeContext ctx) { return super.visitFuncType(ctx); }

    @Override public Void visitFuncFParams(miniSysYParser.FuncFParamsContext ctx){
        ArrayList<Type> pTps = new ArrayList<>();
        for(int i=0;i<ctx.funcFParam().size();i++){
            ctx.funcFParam(i).index=i;
            visit(ctx.funcFParam(i));
            if(isParamsTp)
                pTps.add(curTp);
        }
        if(isParamsTp)
            curTps = pTps;
        return null;
    }

    @Override public Void visitFuncRParams(miniSysYParser.FuncRParamsContext ctx) {
        return super.visitFuncRParams(ctx);
    }

    @Override public Void visitFuncFParam(miniSysYParser.FuncFParamContext ctx) {
        int i=ctx.index;
        String name = ctx.IDENT().getText();
        if(ctx.LBRACKT().size()==0){
            if(isParamsTp){
                curTp = i32;
                return null;
            }
            if(isParamsVal){
                MemInst.AllocaInst allocaInst = builder.createAlloca(BB,i32);
                builder.createStore(BB,func.getParams().get(i),allocaInst);
                ST.addSymbol(name,allocaInst);
            }
        }else {
            int size = 1;
            ArrayList<Integer> dims = new ArrayList<>();
            dims.add(0);
            for(var exp:ctx.exp()){
                isConst = true;
                visit(exp);
                isConst = false;
                size*=nodeValue;
                dims.add(nodeValue);
            }
            Type type = i32;
            if(size!=1){
                type = new ArrayType(i32,size);
                ((ArrayType)type).setDims(dims);
            }
            if(isParamsTp){
                curTp = new PointerType(type);
                return null;
            }
            if(isParamsVal){
                MemInst.AllocaInst allocaInst = builder.createAlloca(BB,new PointerType(type));
                builder.createStore(BB,func.getParams().get(i),allocaInst);
                ST.addSymbol(name,allocaInst);
            }
        }
        return null;
    }

    @Override public Void visitBlock(miniSysYParser.BlockContext ctx) {
        ST.addBlock();
        visitChildren(ctx);
        ST.popBlock();
        return null;
    }

    @Override public Void visitBlockItem(miniSysYParser.BlockItemContext ctx) { return super.visitBlockItem(ctx); }

    @Override public Void visitStmt(miniSysYParser.StmtContext ctx) { return super.visitStmt(ctx); }

    @Override public Void visitAssign_stmt(miniSysYParser.Assign_stmtContext ctx) {
        visit(ctx.lVal());
        Value lval = curVal;
        visit(ctx.exp());
        Value rval = curVal;
        //System.out.println("赋值检查点");
        //System.out.println(rval.getName());
        //System.out.println(rval.getType());
        if(rval.getType().isIntegerType()){
            builder.createStore(BB,rval,lval);
        }
        else
            builder.createStore(BB,lval,rval);
        return null;
    }

    @Override public Void visitExp_stmt(miniSysYParser.Exp_stmtContext ctx) { return super.visitExp_stmt(ctx); }

    @Override public Void visitIf_stmt(miniSysYParser.If_stmtContext ctx) {
        BasicBlock ifBlock = new BasicBlock("if_then_"+func.getBlockNum());
        func.insertBlock(ifBlock);
        BasicBlock nextBlock = new BasicBlock("next_"+func.getBlockNum());
        func.insertBlock(nextBlock);
        BasicBlock elseBlock;
        if(ctx.ELSE()!=null) {
            elseBlock = new BasicBlock("else_"+func.getBlockNum());
            func.insertBlock(elseBlock);
        }else {
            elseBlock = nextBlock;
        }
        ctx.cond().elseBlock=elseBlock;
        ctx.cond().ifBlock = ifBlock;
        visitCond(ctx.cond());
        BB=ifBlock;
        visitStmt(ctx.stmt(0));
        builder.createBr(nextBlock,BB);
        if(ctx.ELSE()!=null) {
            BB=elseBlock;
            visitStmt(ctx.stmt(1));
            builder.createBr(nextBlock,BB);
        }
        BB=nextBlock;
        return null;
    }

    @Override public Void visitWhile_stmt(miniSysYParser.While_stmtContext ctx) {
        BasicBlock condBlock = new BasicBlock("cond_"+func.getBlockNum());
        func.insertBlock(condBlock);
        BasicBlock loopBlock = new BasicBlock("loop_"+func.getBlockNum());
        func.insertBlock(loopBlock);
        BasicBlock nextBlock = new BasicBlock("next_"+func.getBlockNum());
        func.insertBlock(nextBlock);
        BasicBlock tmpBreak = break_next;
        //BasicBlock tmpContinue = continue_cond;
        continue_cond=condBlock;
        break_next=nextBlock;
        builder.createBr(condBlock,BB);
        ctx.cond().ifBlock=loopBlock;
        ctx.cond().elseBlock=nextBlock;
        BB=condBlock;
        visit(ctx.cond());
        BB=loopBlock;
        visit(ctx.stmt());
        builder.createBr(condBlock,BB);
        BB=nextBlock;
        break_next = tmpBreak;
        return null;
    }

    @Override public Void visitBreak_stmt(miniSysYParser.Break_stmtContext ctx) {
        BasicBlock parent=BB;
        BasicBlock breakBlock = new BasicBlock("break_"+func.getBlockNum());
        func.insertBlock(breakBlock);
        builder.createBr(breakBlock,BB);
        BB=breakBlock;
        builder.createBr(break_next,BB);
        BB=parent;
        return null;
    }

    @Override public Void visitContinue_stmt(miniSysYParser.Continue_stmtContext ctx) {
        //System.out.println("continue检查点");
        BasicBlock parent=BB;
        BasicBlock continueBlock = new BasicBlock("continue_"+func.getBlockNum());
        func.insertBlock(continueBlock);
        builder.createBr(continueBlock,BB);
        BB=continueBlock;
        builder.createBr(continue_cond,BB);
        BB=parent;
        System.out.println(BB.getName());
        //BB=parent;
        return null;
    }

    @Override public Void visitReturn_stmt(miniSysYParser.Return_stmtContext ctx) {
        if(ctx.exp()!=null) {
            visit(ctx.exp());
            builder.createRet(curVal,BB);
        }else {
            builder.createRet(BB);
        }
        return null;
    }
    @Override public Void visitExp(miniSysYParser.ExpContext ctx) {
        return super.visitExp(ctx);
    }

    @Override public Void visitCond(miniSysYParser.CondContext ctx) {
        ctx.lOrExp().elseBlock = ctx.elseBlock;
        ctx.lOrExp().ifBlock = ctx.ifBlock;
        visit(ctx.lOrExp());
        return null;
    }

    @Override public Void visitLVal(miniSysYParser.LValContext ctx) {
        String name = ctx.IDENT().getText();
        Value val = ST.find(name);
        //System.out.println("LVal检查点");
        //System.out.println(val.getName());
        if(val == null){
            System.out.println("未定义的变量名");
            exit(255);
        }
        if(val instanceof Constant.ConstantArr){
            if(ctx.exp().isEmpty()){
                curVal = val;
            }else {
                int index=0;
                Constant.ConstantArr constantArr = (Constant.ConstantArr) val;

                for(int i =0;i<ctx.exp().size();i++){
                    isConst=true;
                    visit(ctx.exp(i));
                    isConst=false;
                    int size = 1;
                    if(ctx.exp().size()>constantArr.getDims().size())exit(20);
                    for(int j=i+1;j<ctx.exp().size();j++)size*=constantArr.getDims().get(j);
                    index+=size*nodeValue;
                }
                curVal = constantArr.constantArr.get(index);
            }
            return null;
        }
        if(val.getType().isIntegerType()){
            curVal = val;
        }else if(val.getType().isPointerType()){
            int flag=0;
            Type com = ((PointerType)val.getType()).getCommand();
            if(com.isIntegerType())flag=1;
            else if(com.isArrayType())flag=2;
            else if(com.isPointerType())flag=3;
            //System.out.println("flag:"+flag);
            switch (flag){
                case 1 ->{
                    if(ctx.exp().isEmpty()){
                        curVal = val;
                        return null;
                    }else {
                        System.out.println("int数组");
                        return null;
                    }
                }
                case 2 ->{
                    if(ctx.exp().isEmpty()){
                        if(isintCall)exit(255);
                        curVal = builder.createGep(BB,val,C0);
                        return null;
                    }else {
                        ArrayType arrayType=(ArrayType) com;
                        Value l,r;
                        int size = 1;
                        //for(int j= 1;j<ctx.exp().size();j++)size*=arrayType.getDims().get(j);
                        r=builder.createBinary(BB,Tag.Add,C0,C0);
                        for(int i =0;i<ctx.exp().size();i++){
                            visit(ctx.exp(i));
                            size=1;
                            //System.out.println("LVal检查点");
                            //System.out.println(name);
                            //System.out.println(ctx.exp().size());
                            //System.out.println(arrayType.getDims().size());
                            if (ctx.exp().size()>arrayType.getDims().size()) exit(21);
                            for(int j= i+1;j<ctx.exp().size();j++)size*=arrayType.getDims().get(j);
                            l=builder.createBinary(BB,Tag.Mul,curVal,new Constant.ConstantInt(i32,size));
                            r=builder.createBinary(BB,Tag.Add,l,r);
                        }
                        curVal = builder.createGep(BB,val,r);
                        return null;
                    }
                }
                case 3->{
                    if(ctx.exp().isEmpty()){
                        curVal = builder.createLoad(((PointerType) val.getType()).getCommand(),val,BB);
                        return null;
                    }else{
                        PointerType con = (PointerType) com;
                        MemInst.LoadInst load = builder.createLoad(con,val,BB);
                        if(ctx.exp().size()==1){
                            visit(ctx.exp(0));
                            MemInst.GepInst gep = builder.createI32Gep(BB,load,curVal);
                            curVal=gep;
                            return null;
                        }else {
                            ArrayType arrayType=(ArrayType) con.getCommand();
                            Value l,r;
                            int size = 1;
                            //for(int j= 1;j<ctx.exp().size();j++)size*=arrayType.getDims().get(j);
                            visit(ctx.exp(0));
                            MemInst.GepInst gep = builder.createI32Gep(BB,load,C0);
                            val=gep;
                            ((PointerType)val.getType()).setCommand(arrayType);
                            r=builder.createBinary(BB,Tag.Add,C0,C0);
                            for(int i =1;i<ctx.exp().size();i++){
                                visit(ctx.exp(i));
                                size=1;
                                //System.out.println("LVal检查点");
                                //System.out.println(name);
                                //System.out.println(ctx.exp().size());
                                //System.out.println(arrayType.getDims().size());
                                if (ctx.exp().size()>arrayType.getDims().size()) exit(21);
                                for(int j= i+1;j<ctx.exp().size();j++)size*=arrayType.getDims().get(j);
                                l=builder.createBinary(BB,Tag.Mul,curVal,new Constant.ConstantInt(i32,size));
                                r=builder.createBinary(BB,Tag.Add,l,r);
                            }
                            //((PointerType)val.getType()).setCommand(arrayType);
                            curVal = builder.createGep(BB,val,r);
                            return null;
                        }
                    }
                }
                default -> {
                    //System.out.println("LVal检查点");
                    System.out.println("Pointertype中switch出错");
                    exit(255);
                }
            }
        }
        return null;
    }

    @Override public Void visitPrimaryExp(miniSysYParser.PrimaryExpContext ctx) {
        switch (ctx.children.size()){
            case 3 ->{
                visit(ctx.exp());
            }
            case 1 ->{
                if(ctx.number()!=null)visit(ctx.number());
                else {
                    visit(ctx.lVal());
                    if(isArrCall)return null;
                    if(isConst){
                        nodeValue = ((Constant.ConstantInt)curVal).getValue();
                    }else {
                        if(curVal.getType().isIntegerType()){
                            return null;
                        }
                        //System.out.println("Load检查点");
                        //System.out.println(curVal.getName());
                        //System.out.println(((PointerType)curVal.getType()).getCommand());
                        curVal = builder.createLoad(((PointerType)curVal.getType()).getCommand(),curVal,BB);
                    }
                }
            }
        }
         return null;
    }

    @Override public Void visitNumber(miniSysYParser.NumberContext ctx) {
        if (ctx.DECIMAL_CONST() != null) {
            nodeValue = (new BigInteger(ctx.DECIMAL_CONST().getText(), 10).intValue());
        }
        else if (ctx.HEXADECIMAL_CONST() != null) {
            nodeValue = (new BigInteger(ctx.HEXADECIMAL_CONST().getText().substring(2), 16).intValue());
        }
        else if (ctx.OCTAL_CONST() != null) {
            nodeValue = (new BigInteger(ctx.OCTAL_CONST().getText(), 8)).intValue();
        }
        else {
            System.out.println("在Number_const中不是三种number之一");
            exit(255);
        }
        if (!isConst) {
            curVal = builder.getConstantInt(nodeValue);
        }
        return null;
    }

    @Override public Void visitUnaryExp(miniSysYParser.UnaryExpContext ctx) {
            switch (ctx.children.size()){
                case 1 ->{
                    if(isConst&&ctx.callee()!=null){exit(255);}
                    if(ctx.callee()!=null)visit(ctx.callee());
                    else visit(ctx.primaryExp());
                }
                case 2 ->{
                    visit(ctx.unaryExp());
                    if(isConst) {
                        if (ctx.unaryOp().SUB() != null) {
                            nodeValue = -nodeValue;
                        }
                        if (ctx.unaryOp().NOT() != null) {
                            nodeValue = nodeValue == 1 ? 0 : 1;
                        }
                    }else {
                        Value tmp = curVal;
                        if(tmp.getType()==null)return null;
                        //System.out.println("UnaryExp检查点");
                        //System.out.println("name:"+tmp.getName());
                        //System.out.println("type:"+tmp.getType());
                        if (tmp.getType().isI1()) {
                            builder.createZext(tmp, BB);
                        }

                        if (ctx.unaryOp().SUB() != null) {
                            if (tmp.getType().isI1()) {
                                tmp = builder.createZext(tmp, BB);
                            }
                            curVal = builder.createBinary(BB, Tag.Sub, C0, tmp);
                        }
                        if (ctx.unaryOp().NOT() != null) {
                            curVal = builder.createBinary(BB, Tag.Eq, tmp, C0);
                        }
                    }
                }
            }
        return null;
    }

    @Override public Void visitCallee(miniSysYParser.CalleeContext ctx) {
        Value called = ST.find(ctx.IDENT().getText());
        Function calledFunc = (Function) called;
        var params = new ArrayList<Value>();
//        System.out.println("callee检查点");
//        System.out.println(calledFunc.name);
//        System.out.println(calledFunc.isSysY());
        if(calledFunc.isSysY()){
            //System.out.println("isSysY检查点");
            switch (calledFunc.name){
                case "getint" ->{
                    if(!isSysYDef[0]){
                        //System.out.println(isSysYDef[0]);
                        Const.IR.append("declare i32 @getint()\n");
                        isSysYDef[0]=true;
                    }
                    //System.out.println("getint检查点");
                    curVal = builder.createCall(BB,calledFunc,params);
                }
                case "getch" ->{
                    if(!isSysYDef[1]){
                        Const.IR.append("declare i32 @getch()\n");
                        isSysYDef[1]=true;
                    }
                    curVal = builder.createCall(BB,calledFunc,params);
                }case "getarray" ->{
                    if(!isSysYDef[2]){
                        Const.IR.append("declare i32 @getarray(i32*)\n");
                        isSysYDef[2]=true;
                    }
                    isArrCall = true;
                    visit(ctx.funcRParams().exp(0));
                    isArrCall = false;
                    params.add(curVal);
                    curVal = builder.createCall(BB,calledFunc,params);
                }case "putint" ->{
                    if(!isSysYDef[3]){
                        Const.IR.append("declare void @putint(i32)\n");
                        isSysYDef[3]=true;
                    }
                    System.out.println("putint检查点");
                    isintCall=true;
                    visit(ctx.funcRParams().exp(0));
                    isintCall=false;
                    //if(isLoad_Gep())exit(200);
                    params.add(curVal);
                    curVal = builder.createCall(BB,calledFunc,params);
                }case "putch" ->{
                    if(!isSysYDef[4]){
                        Const.IR.append("declare void @putch(i32)\n");
                        isSysYDef[4]=true;
                    }
                    visit(ctx.funcRParams().exp(0));
                    //if(isLoad_Gep())exit(200);
                    params.add(curVal);
                    curVal = builder.createCall(BB,calledFunc,params);
                }case "putarray" ->{
                    if(!isSysYDef[5]){
                        Const.IR.append("declare void @putarray(i32, i32*)\n");
                        isSysYDef[5]=true;
                    }
                    visit(ctx.funcRParams().exp(0));
                    params.add(curVal);
                    isArrCall = true;
                    visit(ctx.funcRParams().exp(1));
                    isArrCall =false;
                    params.add(curVal);
                    curVal = builder.createCall(BB,calledFunc,params);
                }
                default -> throw new IllegalStateException("Unexpected value: " + calledFunc.name);
            }
        }else{
            if(ctx.funcRParams()!=null){
                ArrayList<Type> pTps = ((FunctionType)calledFunc.getType()).getParams();
                for(int i =0;i<ctx.funcRParams().exp().size();i++){
                    var exp = ctx.funcRParams().exp().get(i);
                    var pTp = pTps.get(i);
                    if(pTp.isIntegerType()){
                        isArrCall = false;
                    }else {
                        isArrCall = true;
                    }
                    visit(exp);
                    isArrCall = false;
                    var tmp = curVal;

//                    if(tmp instanceof MemInst.GepInst){
//                        var tmpval= ((MemInst.GepInst) tmp).getOperand(0);
//                        if(tmpval instanceof MemInst.AllocaInst){
//                            var end = ((MemInst.GepInst) tmp).getOperand(2);
//                            tmp = builder.createI32Gep(BB,tmpval,end);
//                        }
//                    }
//                    if(tmp instanceof MemInst.GepInst){
//                        var tmpval= ((MemInst.GepInst) tmp).getOperand(0);
//                        Type tmpTy = ((MemInst.GepInst) tmp).getOperand(0).getType();
//                        if(tmpTy.isPointerType()){
//                            ArrayType arrTy = (ArrayType) ((PointerType)tmpTy).getCommand();
//                            if(arrTy.getDims().size()>1){
//                                int size =1;
//                                for(int j=1;j< arrTy.getDims().size();j++)size*=arrTy.getDims().get(i);
//                                Type newArrTp = new ArrayType(i32,size);
//                                ((PointerType)tmp.getType()).setCommand(newArrTp);
//                            }
//                        }
//                    }
                    params.add(tmp);
                }
            }
            curVal = builder.createCall(BB,calledFunc,params);
        }
        return null;
    }





    @Override public Void visitMulExp(miniSysYParser.MulExpContext ctx) {
        if(isConst){
            switch (ctx.children.size()){
                case 1 -> {
                    visit(ctx.unaryExp());
                }
                case 3 ->{
                    int l=0,r=0,result=0;
                    visit(ctx.mulExp());
                    l=nodeValue;
                    visit(ctx.unaryExp());
                    r=nodeValue;
                    if(ctx.MUL()!=null)result=l*r;
                    else if(ctx.DIV()!=null){
                        if(r==0)exit(255);
                        else result=l/r;
                    }else if(ctx.MOD()!=null)result=l%r;
                    nodeValue=result;
                }
            }
            return null;
        } else {
            switch (ctx.children.size()){
                case 1 -> {
                    visit(ctx.unaryExp());
                }
                case 3 ->{
                    Value l,r;
                    visit(ctx.mulExp());
                    l=curVal;
                    visit(ctx.unaryExp());
                    r=curVal;
                    if (l.getType().isI1()) {
                        l = builder.createZext(l,BB);
                    }
                    if (r.getType().isI1()) {
                        r = builder.createZext(r, BB);
                    }
                    if(ctx.MUL()!=null)l = builder.createBinary(BB,Tag.Mul, l, r);
                    else if(ctx.DIV()!=null){
                        l = builder.createBinary(BB,Tag.Div, l, r);
                    }else if(ctx.MOD()!=null){
                        if (r instanceof Constant.ConstantInt) {
                            int num = ((Constant.ConstantInt) r).getValue();
                            if (Math.abs(num) == 1) {
                                l = builder.createBinary(BB,Tag.Mod, l, r);
                            } else if ((Math.abs(num) & (Math.abs(num) - 1)) == 0) {
                                l = builder.createBinary(BB,Tag.Mod, l, r);
                            } else if (num < 0) {
                                var a = builder.createBinary(BB,Tag.Div, l, r);
                                var b = builder.createBinary(BB,Tag.Mul, a,
                                        new Constant.ConstantInt(i32, Math.abs(((Constant.ConstantInt) r).getValue())));
                                l = builder.createBinary(BB,Tag.Sub, l, b);
                            } else if (num > 0) {
                                var a = builder.createBinary(BB,Tag.Div, l, r);
                                var b = builder.createBinary(BB,Tag.Mul, a, r);
                                l = builder.createBinary(BB,Tag.Sub, l, b);
                            }
                        } else {
                            var a = builder.createBinary(BB,Tag.Div, l, r);
                            var b = builder.createBinary(BB,Tag.Mul, a, r);
                            l = builder.createBinary(BB,Tag.Sub, l, b);
                        }
                    }
                    curVal=l;
                }
            }
        }
        return null; 
    }


    @Override public Void visitAddExp(miniSysYParser.AddExpContext ctx) {
        if(isConst){
            switch (ctx.children.size()){
                case 1 -> {
                    visit(ctx.mulExp());
                }
                case 3 ->{
                    int l=0,r=0,result=0;
                    visit(ctx.addExp());
                    l=nodeValue;
                    visit(ctx.mulExp());
                    r=nodeValue;
                    if(ctx.ADD()!=null)result=l+r;
                    else if(ctx.SUB()!=null){
                        result=l-r;
                    }
                    nodeValue=result;
                }
            }
        }else {
            switch (ctx.children.size()){
                case 1 -> {
                    visit(ctx.mulExp());
                }
                case 3 ->{
                    Value l,r;
                    visit(ctx.addExp());
                    l=curVal;
                    visit(ctx.mulExp());
                    r=curVal;
                    if (l.getType().isI1()) {
                        l = builder.createZext(l,BB);
                    }else if (r.getType().isI1()) {
                        r = builder.createZext(r, BB);
                    }else if (ctx.ADD() != null) {
                        l = builder.createBinary(BB,Tag.Add, l, r);
                    }else if (ctx.SUB() != null) {
                        l = builder.createBinary(BB,Tag.Sub, l, r);
                    }

                    curVal=l;
                }
            }
        }
        return null; 
    }
    
    @Override public Void visitRelExp(miniSysYParser.RelExpContext ctx) {
        switch (ctx.children.size()){
            case 1 -> {
                visit(ctx.addExp());
            }
            case 3 ->{
                isRel=false;
                Value l,r;
                visit(ctx.relExp());
                l=curVal;
                visit(ctx.addExp());
                r=curVal;
                if (ctx.LE() != null) {
                    l = builder.createBinary(BB,Tag.Le, l, r);
                }
                if (ctx.GE() != null) {
                    l = builder.createBinary(BB,Tag.Ge, l, r);
                }
                if (ctx.GT() != null) {
                    l = builder.createBinary(BB,Tag.Gt, l, r);
                }
                if (ctx.LT() != null) {
                    l = builder.createBinary(BB,Tag.Lt, l, r);
                }
                curVal=l;
            }
        }
        return null; 
    }
    
    @Override public Void visitEqExp(miniSysYParser.EqExpContext ctx) {
        switch (ctx.children.size()){
            case 1 -> {
                visit(ctx.relExp());
            }
            case 3 ->{
                isRel=false;
                Value l,r;
                visit(ctx.eqExp());
                l=curVal;
                visit(ctx.relExp());
                r=curVal;
                if (ctx.EQ() != null) {
                    l = builder.createBinary(BB,Tag.Eq, l, curVal);
                }
                if (ctx.NE() != null) {
                    l = builder.createBinary(BB,Tag.Ne, l, curVal);
                }
                curVal=l;
            }
        }
        return null;
    }
    
    @Override public Void visitLAndExp(miniSysYParser.LAndExpContext ctx) {
        for(var exp:ctx.eqExp()) {
            BasicBlock newbb = new BasicBlock("and_jump_"+func.getBlockNum());
            func.insertBlock(newbb);
            isRel = true;
            visit(exp);
            if (isRel) {
                curVal = builder.createBinary(BB,Tag.Ne, curVal, C0);
                isRel = false;
            }
            builder.createBr(curVal, newbb, elseBlock, BB);
            BB=newbb;
        }
        builder.createBr(ifBlock, BB);
        return null;
    }

    @Override public Void visitLOrExp(miniSysYParser.LOrExpContext ctx) {
        for (int i = 0; i < ctx.lAndExp().size() - 1; i++) {
            BasicBlock newbb = new BasicBlock("or_jump_"+func.getBlockNum());
            func.insertBlock(newbb);
            ifBlock = ctx.ifBlock;
            elseBlock = newbb;
            visit(ctx.lAndExp(i));
            BB = newbb;
        }
        ifBlock = ctx.ifBlock;
        elseBlock = ctx.elseBlock;
        visit(ctx.lAndExp(ctx.lAndExp().size() - 1));
        return null;
    }



    public void globalConstArrDef(miniSysYParser.ConstDefContext ctx,Type arrTy){
        var name = ctx.IDENT().getText();
        if(ctx.constInitVal()==null){
            Constant.GlobalVar globalVar = builder.getGlobalVar(name,arrTy,null);
            ST.addSymbol(name,globalVar);
        }else {
            isGlobal=true;
            visit(ctx.constInitVal());
            isGlobal=false;
            ArrayList<Constant> globalCons = new ArrayList<>();
            for(var c:curArr){
                globalCons.add((Constant) c);
            }
            Constant.ConstantArr constantArr=new Constant.ConstantArr(arrTy,globalCons);
            Constant.GlobalVar globalVar = builder.getGlobalVar(name,arrTy,constantArr);
            globalVar.setConst(true);
            ST.addSymbol(name,globalVar);
        }
    }
    public boolean isLoad_Gep(){
        if(curVal instanceof MemInst.LoadInst){
            if(((MemInst.LoadInst) curVal).getOperand(0) instanceof MemInst.GepInst)return true;
        }
        return false;
    }
}

