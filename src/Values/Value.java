package Values;

import Types.Type;

import java.util.LinkedList;

public class Value {

    private LinkedList<User.Use> def_use;

    public Type type;

    public String name="";

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Value(String name, Type type){
        this.def_use=new LinkedList<User.Use>();
        this.name=name;
        this.type=type;
    }

    public void addUse(User.Use use){
        this.def_use.add(use);
    }

}
