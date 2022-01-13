package Values;


import Types.FunctionType;
import Types.Type;

import java.util.ArrayList;

public class Function extends Value{
    public class Param extends Value{
        private int argsNum;
        public Param(Type type,int num){
            super("%arg"+num,type);
            this.argsNum=num;
        }

        @Override
        public String toString() {
//            if(this.getType() instanceof PointerType) {
//                if(((PointerType)this.getType()).getCommand().isArrayType()){
//                    ArrayType arrayType = (ArrayType) ((PointerType)this.getType()).getCommand();
//                    if(arrayType.getDim()==1)arrayType.setI32(true);
//                }
//            }
            return this.getType() + " " + this.getName();
        }
    }


    private boolean isSysY;
    private boolean isDef= false;
    private BasicBlock mainBlock;

    public boolean isDef() {
        return isDef;
    }

    public void setDef(boolean def) {
        isDef = def;
    }

    private FunctionType funcTy;
    private int blockNum=0;
    private ArrayList<Param> params = new ArrayList<>();
    private ArrayList<BasicBlock> blocks = new ArrayList<>();

    public int getBlockNum() {
        return blockNum;
    }

    public void setBlockNum(int blockNum) {
        this.blockNum = blockNum;
    }

    public Function(String name, Type type, boolean isSysY) {
        super(name, type);
        setFuncTy();
        this.isSysY=isSysY;
        for(int i=0;i<funcTy.getParams().size();i++){
            params.add(new Param(funcTy.getParams().get(i),i));
        }
    }

    public boolean isSysY() {
        return isSysY;
    }

    public void setSysY(boolean sysY) {
        isSysY = sysY;
    }

    public BasicBlock getMainBlock() {
        return mainBlock;
    }

    public void setMainBlock(BasicBlock mainBlock) {
        this.mainBlock = mainBlock;
    }

    public FunctionType getFuncTy() {
        return funcTy;
    }

    public void setFuncTy() {
        this.funcTy = (FunctionType) this.type;
    }
    public void insertBlock(BasicBlock bb){
        this.blocks.add(bb);
        this.blockNum++;
    }

    public ArrayList<Param> getParams() {
        return params;
    }

    public void setParams(ArrayList<Param> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        String str ="define dso_local "+
                this.funcTy.typeToString()+
                " @"+this.name+"(";
        for(int i=0;i<this.params.size();i++){
            str+= this.params.get(i).toString();
            if(i!=this.params.size()-1)
                str+=", ";
        }
        str+=")"+" {\n"+mainBlock.toString();
        if(!this.blocks.isEmpty()){
            for(var block:blocks){
                str+=block.getName()+":\n"+block.toString();
            }
        }
        return str+"}\n";
    }
}
