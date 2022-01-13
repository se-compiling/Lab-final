package Types;

import java.util.ArrayList;

public class FunctionType extends Type{
    private Type retType;

    private ArrayList<Type> params;

    public FunctionType(Type retType,ArrayList<Type> params){
        this.retType=retType;
        this.params=new ArrayList<>(params);
    }

    public Type getRetType() {
        return retType;
    }

    public void setRetType(Type retType) {
        this.retType = retType;
    }

    public ArrayList<Type> getParams() {
        return params;
    }

    public void setParams(ArrayList<Type> params) {
        this.params = params;
    }

    public String typeToString() {
        return retType.toString();
    }
    public String paramsToString() {
        return "";
    }

    @Override
    public String toString() {
        return "";
    }
}
