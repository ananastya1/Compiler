public class WriteStatementNode extends BuiltInRoutineNode {
    private final ExpressionNode expression;
    private final WriteType type;

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
