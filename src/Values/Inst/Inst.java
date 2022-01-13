package Values.Inst;


import Global.Const;
import Types.Type;
import Values.MyModule;
import Values.User;

public class Inst extends User {

    public Tag tag;
    public MyModule module = MyModule.getInstance();
    public Inst(Tag tag, Type type, int OP_num) {
        super("%x"+Const.reg, type, OP_num);
        this.tag=tag;
        module.instList.put(Const.reg,this);
        Const.reg++;
    }
    public boolean isBinary() {
        return this.tag.getIndex() <= Tag.Or.getIndex()
                && this.tag.getIndex() >= Tag.Add.getIndex();
    }

    public boolean isRelBinary() {
        return this.tag.getIndex() >= Tag.Lt.getIndex() &&
                this.tag.getIndex() <= Tag.Ne.getIndex();
    }

    public boolean isArithmeticBinary() {
        return this.tag.getIndex() >= Tag.Add.getIndex()
                && this.tag.getIndex() <= Tag.Div.getIndex();
    }

    public boolean isLogicalBinary() {
        return this.tag.getIndex() >= Tag.Lt.getIndex()
                && this.tag.getIndex() <= Tag.Or.getIndex();
    }

    public boolean isTerminator() {
        return this.tag.getIndex() >= Tag.Br.getIndex()
                && this.tag.getIndex() <= Tag.Ret.getIndex();
    }

    public boolean isMemOP() {
        return this.tag.getIndex() >= Tag.Alloca.getIndex()
                && this.tag.getIndex() <= Tag.Phi.getIndex();
    }
    public boolean isRetInst(){
        return this instanceof TerminatorInst.RetInst;
    }
    public boolean isBrInst(){
        return this instanceof TerminatorInst.BrInst;
    }

}

