public class VariableDeclarationNode extends SimpleDeclarationNode {
    private IdentifierNode variableName;
    private Type type;
    private ExpressionNode initialValue;

    public VariableDeclarationNode(IdentifierNode variableName, Type type, ExpressionNode initialValue, int lineNumber) {
        super("VariableDeclaration", lineNumber);
        this.variableName = variableName;
        this.type = type;
        this.initialValue = initialValue;
    }

    public IdentifierNode getVariableName() {
        return variableName;
    }

    public Type getType() {
        return type;
    }

    public ExpressionNode getInitialValue() {
        return initialValue;
    }

}
