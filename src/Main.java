import Analyse.Visitor;
import Antlr.miniSysY.miniSysYLexer;
import Antlr.miniSysY.miniSysYParser;
import Error.*;
import Global.Const;
import Values.MyModule;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ExitNoZero exit=new ExitNoZero();
        Test error=new Test();
        MyModule module = MyModule.getInstance();
        Const.INPUT=args[0];
        Const.OUTPUT=args[1];
        BufferedReader br = null;
        String input="";
        File file=new File(args[1]);
        FileWriter fw=new FileWriter(file);
        try {
            br = new BufferedReader(new FileReader(args[0]));
            String line = "";
            int c=br.read();
            while(c!= -1) {
                input+=(char)c;
                c= br.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(input);
        Const.input=input;
        error.testerror();
        CharStream inputStream = CharStreams.fromString(input);
        miniSysYLexer lexer = new miniSysYLexer(inputStream);
        lexer.addErrorListener(exit);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        miniSysYParser parser = new miniSysYParser(tokenStream);
        parser.addErrorListener(exit);
        ParseTree tree = parser.program();
        Visitor visitor = new Visitor();
        visitor.visit(tree);
        for(var Val:module.globalVars){
            Const.IR.append(Val.toString());
        }
        for(var func:module.funcList){
            Const.IR.append(func.toString());
        }
        System.out.println(Const.IR.toString());
        fw.write(Const.IR.toString());
        fw.flush();
        fw.close();
    }
}
