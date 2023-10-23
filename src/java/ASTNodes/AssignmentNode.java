package ASTNodes;

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

    @Override
    public void printNode(int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(this.label);
        System.out.print(indent + "|__");
        modifiablePrimary.printNode(depth + 1);
        System.out.print(indent + "|__");
        expression.printNode(depth + 1);
    }
}
