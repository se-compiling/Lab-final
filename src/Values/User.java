package Values;

import Types.Type;

import java.util.ArrayList;

public class User extends Value{
    private ArrayList<Value> use_def;

    public ArrayList<Value> getUse_def() {
        return use_def;
    }

    private int OP_num;

    public int getOP_num() {
        return OP_num;
    }

    public void setOP_num(int OP_num) {
        this.OP_num = OP_num;
    }

    public User(String name, Type type, int OP_num){
        super(name,type);
        this.OP_num=OP_num;
        use_def=new ArrayList<>();
        for(int i=0;i<OP_num;i++)
          use_def.add(new Value("", Type.VoidType.getVoidTy()));
    }

    public void addOperand(Value v){
        this.use_def.add(v);
        v.addUse(new Use(v,this,OP_num));
        this.OP_num++;
    }

    public void setOperand(Value v, int index){
        //assert this.OP_num>index;
        this.use_def.set(index,v);
        if(v!=null){
            v.addUse(new Use(v,this,index));
        }
    }
    public Value getOperand(int index){
        return use_def.get(index);
    }
    public static class Use{
        private int operandRank;

        private Value v;

        private User u;

        public Use(Value v,User u,int operandRank){
            this.v=v;
            this.u=u;
            this.operandRank=operandRank;
        }

    }
}
