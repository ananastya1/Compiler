package ASTNodes;

public class BuiltInRoutineNode extends RoutineCallNode {

    public BuiltInRoutineNode(String label, int lineNumber) {
        super("BuiltInRoutineNode " + label, lineNumber);
    }
}
