package Types;

import java.util.ArrayList;

public class ArrayType extends Type{
    private Type arrTy;
    private int dim;
    private boolean isI32;
    private ArrayList<Integer> dims;
    public ArrayType (Type type,int dim){
        this.arrTy=type;
        this.dim=dim;
    }

    @Override
    public boolean isI32() {
        return isI32;
    }

    public void setI32(boolean i32) {
        isI32 = i32;
    }

    public ArrayList<Integer> getDims() {
        return dims;
    }

    public void setDims(ArrayList<Integer> dims) {
        this.dims = new ArrayList<>(dims);
    }

    public Type getArrTy() {
        return arrTy;
    }

    public void setArrTy(Type arrTy) {
        this.arrTy = arrTy;
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        if(isI32&&dim==1)return "i32 ";
        sb.append("[");
        sb.append(dim);
        sb.append(" x ");
        sb.append(arrTy.toString());
        sb.append("] ");
        return sb.toString();
    }
}
