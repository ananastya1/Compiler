public class ParameterDeclarationNode extends ASTNode {
    private final IdentifierNode parameterName;
    private final TypeNode type;

    public ParameterDeclarationNode(IdentifierNode parameterName, TypeNode type, int lineNumber) {
        super("ParameterDeclaration", lineNumber);
        this.parameterName = parameterName;
        this.type = type;
    }

    public IdentifierNode getParameterName() {
        return parameterName;
    }

    public TypeNode getType() {
        return type;
    }

}
