import com.fasterxml.jackson.databind.ObjectMapper;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LexerTest {
    public static void main(String[] args) throws Exception {
        String content = readFile("src/sample.script");
        CharStream input = CharStreams.fromString(content);
        IlangCodeGenerationLexer lexer = new IlangCodeGenerationLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ObjectMapper mapper = new ObjectMapper();

        for (Token token = tokens.LT(1); token.getType() != Token.EOF; token = tokens.LT(1)) {
            TokenObject tokenObject = new TokenObject(
                    IlangCodeGenerationLexer.VOCABULARY.getSymbolicName(token.getType()),
                    token.getText(),
                    token.getLine(),
                    token.getStartIndex(),
                    token.getStopIndex(),
                    token.getType()
            );
            String json = mapper.writeValueAsString(tokenObject);
            System.out.println(json);
            tokens.consume();
        }
    }

    private static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }
}

class TokenObject {
    public String name;
    public String value;
    public int lineNumber;
    public int startPos;
    public int endPos;
    public int tokenId;

    public TokenObject(String name, String value, int lineNumber, int startPos, int endPos, int tokenId) {
        this.name = name;
        this.value = value;
        this.lineNumber = lineNumber;
        this.startPos = startPos;
        this.endPos = endPos;
        this.tokenId = tokenId;
    }
}
