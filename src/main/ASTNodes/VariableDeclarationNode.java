public class VariableDeclarationNode extends SimpleDeclarationNode {
    private IdentifierNode variableName;
    private TypeClass type;
    private ExpressionNode initialValue;

    public VariableDeclarationNode(IdentifierNode variableName, TypeClass type, ExpressionNode initialValue, int lineNumber) {
        super("VariableDeclaration", lineNumber);
        this.variableName = variableName;
        this.type = type;
        this.initialValue = initialValue;
    }

    public IdentifierNode getVariableName() {
        return variableName;
    }

    public TypeClass getType() {
        return type;
    }

    public ExpressionNode getInitialValue() {
        return initialValue;
    }

}
