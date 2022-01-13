package Values;

import Types.PointerType;
import Types.Type;

import java.util.ArrayList;

public class Constant extends User{

    public Constant(String name, Type type, int OP_num) {
        super(name, type, OP_num);
    }

    public static class ConstantInt extends Constant{

        public ConstantInt(Type type,int val) {
            super("", type, 0);
            this.setValue(val);
        }

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "i32 " + this.value;
        }
        @Override
        public String getName() {
            return String.valueOf(this.getValue());
        }
    }
    public static class ConstantArr extends Constant{
        public ArrayList<Constant> constantArr;
        public ArrayList<Integer> dims;

        public ConstantArr(Type type, ArrayList<Constant> arr){
            super("",type,arr.size());
            for(int i=0;i<arr.size();i++)
                setOperand(arr.get(i),i );
            this.constantArr=new ArrayList<>(arr);
        }

        public ArrayList<Integer> getDims() {
            return dims;
        }

        public void setDims(ArrayList<Integer> dims) {
            this.dims = new ArrayList<>(dims);
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getType().toString()).append("[");
            for (int i = 0; i < constantArr.size(); i++) {
                sb.append(constantArr.get(i).toString());
                if(i!=constantArr.size()-1)
                    sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }
    public static class GlobalVar extends User{
        private MyModule module = MyModule.getInstance();
        public Constant constant;
        public Constant constantArr;
        public boolean isConst;
        public GlobalVar(String name, final Type type, Constant constantArr, Constant constant) {
            super("@"+name, new PointerType(type),0);
            if (constant != null)
                this.addOperand(constant);
            this.constant = constant;
            this.constantArr = constantArr;
            module.globalVars.add(this);
        }

        public MyModule getModule() {
            return module;
        }

        public void setModule(MyModule module) {
            this.module = module;
        }

        public Constant getConstant() {
            return constant;
        }

        public void setConstant(Constant constant) {
            this.constant = constant;
        }

        public Constant getConstantArr() {
            return constantArr;
        }

        public void setConstantArr(Constant constantArr) {
            this.constantArr = constantArr;
        }

        public boolean isConst() {
            return isConst;
        }

        public void setConst(boolean aConst) {
            isConst = aConst;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getName()+" = dso_local ");
            if (isConst) {
                sb.append("constant ");
            } else {
                sb.append("global ");
            }
            Type comTy=((PointerType) this.getType()).getCommand();
            if (comTy.isIntegerType()) {
                sb.append(comTy.toString()).append(" ");
                sb.append(this.constant == null ? "0 " : ((ConstantInt) this.constant).getValue()+"\n");
            } else if (comTy.isArrayType()) {
                if (this.constantArr == null) {
                    sb.append(comTy.toString()).append(" ");
                    sb.append("zeroinitializer \n");
                } else {
                    sb.append(constantArr.toString()+"\n");
                }
            }
            return sb.toString();
        }
    }
}
