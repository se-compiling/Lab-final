package Types;

public class PointerType extends Type{

    private Type command = new Type();

    public PointerType(Type command){
        this.command = command;
    }

    public Type getCommand() {
        return command;
    }

    public void setCommand(Type command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return command.toString()+"* ";
    }
}
