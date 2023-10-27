public class TypeDeclarationNode extends SimpleDeclarationNode {
    private IdentifierNode typeName;
    private Type type;

    public TypeDeclarationNode(IdentifierNode typeName, Type type, int lineNumber) {
        super("TypeDeclaration", lineNumber);
        this.typeName = typeName;
        this.type = type;
    }

    public IdentifierNode getTypeName() {
        return typeName;
    }

    public Type getType() {
        return type;
    }
}
