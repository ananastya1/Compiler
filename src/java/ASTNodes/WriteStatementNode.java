package ASTNodes;

public class WriteStatementNode extends BuiltInRoutineNode {
    private ExpressionNode expression;
    private WriteType type;

    public WriteStatementNode(WriteType type, ExpressionNode expression, int lineNumber) {
        super("WriteStatement", lineNumber);
        this.expression = expression;
        this.type = type;
    }

    public ExpressionNode getExpression() {
        return expression;
    }

    public WriteType getType() {
        return type;
    }
}
