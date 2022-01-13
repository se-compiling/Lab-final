package Global;

import Values.Value;

import java.util.ArrayList;
import java.util.HashMap;

public class SymbolTable {

    public SymbolTable() {
        table = new ArrayList<>();
        table.add(new HashMap<>());
    }

    private final ArrayList<HashMap<String, Value>> table;

    public HashMap<String, Value> top() {
        return table.get(table.size() - 1);
    }
    public HashMap<String,Value> getGlo(){return table.get(0);}

    public Value find(String name) {
        for (int i = table.size() - 1; i >= 0; i--) {
            Value t = table.get(i).get(name);
            if (t != null) {
                return t;
            }
        }
        return null;
    }

    public void addSymbol(String name, Value v) {
        if (top().get(name) != null) {
            System.out.println("name已存在");
        } else {
            top().put(name, v);
        }
    }
    public void addGlobal(String name,Value v){
        if(table.get(0).get(name)!=null){
            System.out.println("全局变量已存在");
        }else
        table.get(0).put(name,v);
    }
    
    public void addBlock() {
        table.add(new HashMap<>());
    }

    public void popBlock() {
        table.remove(table.size() - 1);
    }

    public boolean isGlobal() {
        return this.table.size() == 1;
    }
}