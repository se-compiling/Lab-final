package Values.Inst;

public enum Tag {
    Add(0){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return lhsVal + rhsVal;
        }
    },// +
    Sub(1){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return lhsVal - rhsVal;
        }
    },// -
    Mul(2){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return lhsVal * rhsVal;
        }

    },// *
    Div(3){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            assert rhsVal != 0;
            return lhsVal / rhsVal;
        }

    },// /
    Mod(4){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){

            return lhsVal % rhsVal;
        }
    },
    Lt(5){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return (lhsVal < rhsVal) ? 1 : 0;
        }

    }, // <
    Le(6){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return (lhsVal <= rhsVal) ? 1 : 0;
        }

    }, // <=
    Ge(7){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return (lhsVal >= rhsVal) ? 1 : 0;
        }

    }, // >=
    Gt(8){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return (lhsVal > rhsVal) ? 1 : 0;
        }

    }, // >
    Eq(9){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return (lhsVal.equals(rhsVal)) ? 1 : 0;
        }

    }, // ==
    Ne(10){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return (!lhsVal.equals(rhsVal)) ? 1 : 0;
        }

    }, // !=
    And(11){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return (lhsVal != 0 && rhsVal != 0) ? 1 : 0;
        }

    },// &
    Or(12){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return (lhsVal != 0 || rhsVal != 0) ? 1 : 0;
        }

    }, // |
    //terminator
    Br(13){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return 12;
        }

    },
    Call(14){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return 13;
        }

    },
    Ret(15){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return 14;
        }

    },
    //mem op
    Alloca(16){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return 15;
        }

    },
    Load(17){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return 16;
        }

    },
    Store(18){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return 17;
        }

    },
    GEP(19){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return 18;
        }

    },
    Zext(20){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return 19;
        }

    },
    Phi(21){
        @Override
        Integer operate(Integer lhsVal, Integer rhsVal){
            return 20;
        }

    },

    ;//用于 mem2reg
    private int index;

    private Tag(int index) {
        this.index = index;
    }

    abstract Integer operate(Integer lhsVal, Integer rhsVal);

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
