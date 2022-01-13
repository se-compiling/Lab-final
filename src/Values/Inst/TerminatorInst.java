package Values.Inst;

import Types.FunctionType;
import Types.Type;
import Values.BasicBlock;
import Values.Function;
import Values.Value;

import java.util.ArrayList;

public class TerminatorInst extends Inst{
    public TerminatorInst(Tag tag, Type type, int OP_num) {
        super(tag, type, OP_num);
    }
    public static class CallInst extends TerminatorInst{

        public CallInst(Function func, ArrayList<Value> params) {
            super(Tag.Call, ((FunctionType)func.getType()).getRetType(), params.size()+1);
            this.setOperand(func,0);
            for(int i=1;i<=params.size();i++){
                this.setOperand(params.get(i-1),i );
            }
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("  ");
            if (((FunctionType) this.getOperand(0).getType()).getRetType().isVoidType()) {
                sb.append("call ").append(this.getType()+" @").append(this.getOperand(0).getName());
            } else {
                sb.append(this.getName()+" = call ").append(this.getType()+" @").append(this.getOperand(0).getName());
            }
            sb.append("(");
            boolean a = false;
            for (int i = 1; i < this.getUse_def().size(); i++) {
                a = true;
                sb.append(this.getOperand(i).getType()+" ").append(this.getOperand(i).getName()).append(",");
            }
            if (a) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(")");
            return sb.toString();
        }
    }


    public static class BrInst extends TerminatorInst{
        public BrInst(BasicBlock trueblock) {
            super(Tag.Br, Type.VoidType.getVoidTy(), 1);
            this.setOperand( trueblock,0);
        }
        public BrInst(Value cond, BasicBlock ifBlock, BasicBlock elseBlock) {
            super(Tag.Br, Type.VoidType.getVoidTy(), 3);
            this.setOperand( cond,0);
            this.setOperand( ifBlock,1);
            this.setOperand( elseBlock,2);
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("  br ");
            if (this.getOP_num() == 1) {
                sb.append(this.getOperand(0).getType()).append("%" + this.getOperand(0).getName());
            } else if (this.getOP_num() == 3) {
                sb.append(this.getOperand(0).getType()+" ").append(this.getOperand(0).getName()).append(", ");
                sb.append(this.getOperand(1).getType()).append("%" + this.getOperand(1).getName()).append(", ");
                sb.append(this.getOperand(2).getType()).append("%" + this.getOperand(2).getName()).append(" ");
            }
            sb.append("\n");
            return sb.toString();
        }
    }


    public static class RetInst extends TerminatorInst{

        public RetInst(){
            super(Tag.Ret, Type.VoidType.getVoidTy(), 1);
        }
        public RetInst(Value val) {
            super(Tag.Ret, Type.VoidType.getVoidTy(), 1);
            this.setOperand(val,0);
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("  ret ");
            if (this.getOP_num() == 1) {
                sb.append(getOperand(0).getType() + " " + getOperand(0).getName());
            } else {
                sb.append("void ");
            }
            sb.append("\n");
            return sb.toString();
        }
    }

}
