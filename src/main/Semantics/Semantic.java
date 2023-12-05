import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Semantic {
    public static String main() throws Exception{

        String content = GeneralHelper.readFile("src/sample.script");

        ParseTree tree = GeneralHelper.createTree(content);

        SemanticsVisitor semanticsVisitor = new SemanticsVisitor();

        semanticsVisitor.visit(tree);

        HelperStore.clearVariables();

        Listener listener = new Listener();

        String optimizedContent = content;
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
        Set<String> keys = Listener.expressions.keySet();

        for (String key:keys) {

            String output = key.replaceAll("([\\\\+\\\\*])", " \\\\$1 ");
            output = output.replaceAll("([-/%])", " $1 ");
            output = output.replaceAll("(and|or|xor|&&|<=|>|<|>=)", " $1 ");

            String [] outarr = output.split("\\s");
            StringBuilder newString = new StringBuilder();
            for (String i : outarr){
                newString.append("\\s*").append(i);
            }

            newString.append("\\s*");
            String s ="("+newString+")";

            String sWithEndLine = "("+newString+"\n)";
            Pattern pattern = Pattern.compile(sWithEndLine);
            Matcher matcher = pattern.matcher(optimizedContent);
            if (matcher.find()){
                optimizedContent =  matcher.replaceAll(" " + Listener.expressions.get(key)+"\n");

            }
            else{
                Pattern pattern2 = Pattern.compile(s);
                Matcher matcher2 = pattern2.matcher(optimizedContent);
                optimizedContent = matcher2.replaceAll(" " + Listener.expressions.get(key)+ " ");}

        }

        ParseTree treeOptimized = GeneralHelper.createTree(optimizedContent);

        SemanticsVisitor semanticsVisitorOptimized = new SemanticsVisitor();

        semanticsVisitorOptimized.visit(treeOptimized);

        return optimizedContent;
    }
}