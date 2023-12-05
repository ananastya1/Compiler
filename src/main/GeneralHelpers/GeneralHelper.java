import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GeneralHelper {

    public static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

    public static CommonTokenStream getTokens(String content){
        CharStream input = CharStreams.fromString(content);
        ILangLexer lexer = new ILangLexer(input);
        return new CommonTokenStream(lexer);
    }

    public static ParseTree createTree(String content){
        CommonTokenStream tokens = getTokens(content);

        ILangParser parser = new ILangParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
        return parser.main();
    }

    public static void fileWriter(String filePath, String content){
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);

        } catch (IOException ignored) {
        }
    }

}
