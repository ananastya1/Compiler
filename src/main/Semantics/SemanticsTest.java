import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class SemanticsTest {
    public static void main(String[] args) throws Exception{

        String content = readFile("src/sample.script");
        CharStream input = CharStreams.fromString(content);
        ILangLexer lexer = new ILangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ILangParser parser = new ILangParser(tokens);


        ParseTree tree = parser.main();
        System.out.println(tree.toStringTree());

        Visitor visitor = new Visitor();

        ASTNode node = visitor.visit(tree);
        System.out.println("AST created");

        Listener listener = new Listener();

        String optimizedContent = content;

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        Set<String> keys = Listener.expressions.keySet();

        for (String key:keys) {
            String formattedExpression = key.replaceAll("(\\\\+|\\\\-|\\\\*|/|%|<|<=|>|>=|=|/=|xor|or|and)", " $1 ");
//            String[] expressionArray = formattedExpression.split("\\s+");
//            String expressionForFinding = "(["
            System.out.println("this" + formattedExpression);
            optimizedContent = optimizedContent.replaceAll(key, Listener.expressions.get(key));
        }

        System.out.println(tree.getText() + "\n\n");
        System.out.println(optimizedContent);

        String filePath = "src/sampleOptimized.script";
        FileWriter writer = new FileWriter(filePath, true);
        writer.write(content);
        writer.close();
        File file = new File(filePath);

    }

    private static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }
}