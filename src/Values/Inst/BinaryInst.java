package Values.Inst;

import Types.IntegerType;
import Types.Type;
import Values.Value;

public class BinaryInst extends Inst{
    public BinaryInst(Tag tag, Type type, Value l,Value r) {
        super(tag, type, 2);
        if(this.isLogicalBinary()){
            this.setType(IntegerType.getI1());
        }
        if(this.isArithmeticBinary()){
            this.setType(IntegerType.getI32());
        }
        this.setOperand(l,0);
        this.setOperand(r,1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  "+this.getName() + " = ");
        String str;
        switch (this.tag) {
            case Add -> str="add i32 ";
            case Sub -> str="sub i32 ";
            case Mul -> str="mul i32 ";
            case Div -> str="sdiv i32 ";
            case Mod -> str="srem i32 ";
            case Lt -> str="icmp slt " + this.getOperand(0).getType() + " ";
            case Le -> str="icmp sle " + this.getOperand(0).getType() + " ";
            case Ge -> str="icmp sge " + this.getOperand(0).getType() + " ";
            case Gt -> str="icmp sgt " + this.getOperand(0).getType() + " ";
            case Eq -> str="icmp eq " + this.getOperand(0).getType() + " ";
            case Ne -> str="icmp ne  " + this.getOperand(0).getType() + " ";
            default -> str="";
        }
        sb.append(str);
        sb.append(this.getOperand(0).getName() + ", " + this.getOperand(1).getName());
        return sb.toString();
    }
}
