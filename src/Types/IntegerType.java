package Types;

public class IntegerType extends Type{
    public IntegerType(){};

    private int bits;

    public static IntegerType getI32(){
        IntegerType integerType=new IntegerType();
        integerType.setBits(32);
        return integerType;
    }

    public static IntegerType getI1(){
        IntegerType integerType=new IntegerType();
        integerType.setBits(1);
        return integerType;
    }

    public void setBits(int num){
        this.bits=num;
    }

    public int getBits(){
        return this.bits;
    }

    @Override
    public String toString() {
        if(this.bits==1) return "i1";
        else return "i32";
    }
}
