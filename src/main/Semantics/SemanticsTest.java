import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    }

    private static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }
}