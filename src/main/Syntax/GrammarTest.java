import org.antlr.v4.runtime.tree.ParseTree;

public class GrammarTest {
    public static void main(String[] args) throws Exception{

        String content = GeneralHelper.readFile("src/sample.script");

        ParseTree tree = GeneralHelper.createTree(content);
        System.out.println(tree.toStringTree());
    }
}
