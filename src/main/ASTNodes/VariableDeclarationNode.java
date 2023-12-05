public class VariableDeclarationNode extends SimpleDeclarationNode {
    private final IdentifierNode variableName;
    private final TypeClass type;

    public VariableDeclarationNode(IdentifierNode variableName, TypeClass type, int lineNumber) {
        super("VariableDeclaration", lineNumber);
        this.variableName = variableName;
        this.type = type;
    }

    public IdentifierNode getVariableName() {
        return variableName;
    }

    public TypeClass getType() {
        return type;
    }

}
