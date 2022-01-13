package Analyse;

import Types.FunctionType;
import Types.IntegerType;
import Types.Type;
import Values.BasicBlock;
import Values.Constant;
import Values.Function;
import Values.Inst.BinaryInst;
import Values.Inst.MemInst;
import Values.Inst.Tag;
import Values.Inst.TerminatorInst;
import Values.Value;

import java.util.ArrayList;

public class Builder {
    private Builder() {
    }

    private static Builder builder = new Builder();
    private final Constant.ConstantInt C0 = new Constant.ConstantInt(IntegerType.getI32(),0);
    public static Builder getInstance() {
        return builder;
    }

    public Function createFunc(String name, FunctionType type,boolean isSysY){
        return new Function(name,type,isSysY);
    }
    public MemInst.AllocaInst createAlloca(BasicBlock BB, Type type){
        MemInst.AllocaInst alloca = new MemInst.AllocaInst(type);
        BB.insertAlloca(alloca);
        return alloca;
    }
    public MemInst.StoreInst createStore(BasicBlock BB, Value value,Value pointer){
        MemInst.StoreInst storeInst = new MemInst.StoreInst(value,pointer);
        BB.insertInst(storeInst);
        return storeInst;
    }
    public MemInst.LoadInst createLoad(Type type, Value value, BasicBlock BB) {
        MemInst.LoadInst loadInst = new MemInst.LoadInst(type,value);
        BB.insertInst(loadInst);
        return loadInst;
    }

    public TerminatorInst.BrInst createBr(BasicBlock ifBlock,BasicBlock curBB){
        if((!curBB.instList.isEmpty())&&(curBB.instList.getLast().isRetInst()||curBB.instList.getLast().isBrInst()))return null;
        TerminatorInst.BrInst br = new TerminatorInst.BrInst(ifBlock);
        curBB.insertInst(br);
        return br;
    }
    public TerminatorInst.BrInst createBr(Value cond,BasicBlock ifBlock,BasicBlock elseBlock,BasicBlock BB){
        if((!BB.instList.isEmpty())&&(BB.instList.getLast().isRetInst()||BB.instList.getLast().isBrInst()))return null;
        TerminatorInst.BrInst br = new TerminatorInst.BrInst(cond,ifBlock,elseBlock);
        BB.insertInst(br);
        return br;
    }
    public TerminatorInst.RetInst createRet(Value val,BasicBlock BB){
        TerminatorInst.RetInst retInst= new TerminatorInst.RetInst(val);
        BB.insertInst(retInst);
        return retInst;
    }
    public TerminatorInst.RetInst createRet(BasicBlock BB){
        TerminatorInst.RetInst retInst= new TerminatorInst.RetInst();
        BB.insertInst(retInst);
        return retInst;
    }

    public BinaryInst createBinary(BasicBlock BB, Tag tag, Value lVal, Value rVal){
        BinaryInst binaryInst = new BinaryInst(tag, lVal.getType(), lVal,rVal);
        BB.insertInst(binaryInst);
        return binaryInst;
    }
    public MemInst.ZextInst createZext(Value val, BasicBlock BB) {
        MemInst.ZextInst zextInst =  new MemInst.ZextInst(IntegerType.getI32(),val);
        BB.insertInst(zextInst);
        return zextInst;
    }
    public TerminatorInst.CallInst createCall(BasicBlock BB,Function func, ArrayList<Value> params){
        var call = new TerminatorInst.CallInst(func,params);
        BB.insertInst(call);
        return call;
    }
    public MemInst.GepInst createGep(BasicBlock BB,Value ptr,Value end){
        var gep= new MemInst.GepInst(ptr,C0,end);
        BB.insertInst(gep);
        return gep;
    }
    public MemInst.GepInst createI32Gep(BasicBlock BB,Value ptr,Value end){
        var gep = new MemInst.GepInst(ptr,end);
        BB.insertInst(gep);
        return gep;
    }

    public Constant.ConstantInt getConstantInt(int val) {
        return new Constant.ConstantInt(IntegerType.getI32(), val);
    }

    public Constant.GlobalVar getGlobalVar(String name,Type type,Constant constant){
        return new Constant.GlobalVar(name,type,constant,constant);
    }
    public Constant.GlobalVar getGlobalVar(String name,Type type,Constant constantArr,Constant constant){
        return new Constant.GlobalVar(name,type,constantArr,constant);
    }
}
