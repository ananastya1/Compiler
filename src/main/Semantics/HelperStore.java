import java.util.HashMap;

public class HelperStore {
    static String scope = null; // Null - global; "someText" routine someText()...

    static TypeAnalysis typeAnalysis = new TypeAnalysis();

    static HashMap<String,Type> globalVariables = new HashMap<>(); // variables in global scope

    static HashMap<String, RoutineDeclarationNode> routines = new HashMap<>();
}
