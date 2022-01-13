package Values;


import Values.Inst.Inst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MyModule {
    public static MyModule getInstance() {
        return myModule;
    }
    private static final MyModule myModule = new MyModule();
    public LinkedList<Function> funcList = new LinkedList<>();
    public HashMap<Integer, Inst> instList = new HashMap<>();
    public ArrayList<Constant.GlobalVar> globalVars = new ArrayList<>();
    public HashMap<String, Constant.ConstantArr> globalConstArrs = new HashMap<>();
}
