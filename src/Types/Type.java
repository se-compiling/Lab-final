package Types;

public class Type {
    public static class VoidType extends Type {
        private VoidType() {}

        private static VoidType type = new VoidType();

        public static VoidType getVoidTy() {
            return type;
        }

        @Override
        public String toString() {
            return "void";
        }

    }
    public static class LabelType extends Type {
        private LabelType() {}

        private static LabelType type = new LabelType();

        public static LabelType getLabelTy() {
            return type;
        }

        @Override
        public String toString() {
            return "label ";
        }


    }
    public boolean isVoidType() {
        return this instanceof VoidType;
    }

    public boolean isLabelType() {
        return this instanceof LabelType;
    }

    public boolean isIntegerType() {
        return this instanceof IntegerType;
    }

    public boolean isFunctionType() {
        return this instanceof FunctionType;
    }

    public boolean isArrayType() {
        return this instanceof ArrayType;
    }

    public boolean isPointerType() {
        return this instanceof PointerType;
    }
    public boolean isI32() {
        if (this.isIntegerType()) {
            return ((IntegerType) this).getBits() == 32;
        }
        return false;
    }

    public boolean isI1() {
        if (this.isIntegerType()) {
            return ((IntegerType) this).getBits() == 1;
        }
        return false;
    }
}
