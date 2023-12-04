public class AssignmentNode extends ASTNode implements StatementNode {
    private ModifiablePrimaryNode modifiablePrimary;
    private ExpressionNode expression;

    public AssignmentNode(ModifiablePrimaryNode modifiablePrimary, ExpressionNode expression, int lineNumber) {
        super("Assignment", lineNumber);
        this.modifiablePrimary = modifiablePrimary;
        this.expression = expression;
    }

    public ModifiablePrimaryNode getModifiablePrimary() {
        return modifiablePrimary;
    }

    public ExpressionNode getExpression() {
        return expression;
    }

}
