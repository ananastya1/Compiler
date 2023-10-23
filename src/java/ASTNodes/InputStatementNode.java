package ASTNodes;

public class InputStatementNode extends BuiltInRoutineNode {
    private TypeNode type;

    public InputStatementNode(TypeNode type, int lineNumber) {
        super("InputStatement", lineNumber);
        this.type = type;
    }

    public TypeNode getType() {
        return type;
    }
}
