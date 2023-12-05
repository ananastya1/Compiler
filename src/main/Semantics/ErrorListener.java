import org.antlr.v4.runtime.*;

public class ErrorListener extends BaseErrorListener{

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        System.err.println("SYNTAX ERROR\nLine - " + line + "\nColumn - " + charPositionInLine + "\nDescription - " + msg);
        System.exit(1);
    }

}
