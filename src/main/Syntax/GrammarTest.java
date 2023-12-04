import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GrammarTest {
    public static void main(String[] args) throws Exception{

        String content = readFile("src/sample.script");
        CharStream input = CharStreams.fromString(content);
        IlangCodeGenerationLexer lexer = new IlangCodeGenerationLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IlangCodeGenerationParser parser = new IlangCodeGenerationParser(tokens);

        ParseTree tree = parser.main();
        System.out.println(tree.toStringTree());
    }

    private static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }
}
