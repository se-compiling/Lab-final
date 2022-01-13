package Values;

import Types.Type;
import Values.Inst.Inst;
import Values.Inst.MemInst;

import java.util.HashMap;
import java.util.LinkedList;

public class BasicBlock extends Value{

    public Function parent;
    public LinkedList<MemInst.AllocaInst> allocaList = new LinkedList<>();
    public LinkedList<Inst> instList = new LinkedList<>();
    public HashMap<String, Constant.ConstantArr> constArrs;

    public HashMap<String, Constant.ConstantArr> getConstArrs() {
        return constArrs;
    }

    public void addConstArrs(String name, Constant.ConstantArr arr) {
        this.constArrs.put(name,arr);
    }

    public BasicBlock() {
        super("", Type.LabelType.getLabelTy());

    }
    public BasicBlock(String name) {
        super(name, Type.LabelType.getLabelTy());

    }

    public Function getParent() {
        return parent;
    }

    public void setParent(Function parent) {
        this.parent = parent;
    }

    public void insertAlloca(MemInst.AllocaInst alloca){
        this.allocaList.add(alloca);
    }

    public void insertInst(Inst inst){
        this.instList.add(inst);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(var alloca:allocaList){
            s.append(alloca.toString()+"\n");
        }
        for(var inst :instList){
            s.append(inst.toString()+"\n");
        }
        return s.toString();
    }
}
