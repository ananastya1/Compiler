public class TypeDeclarationNode extends SimpleDeclarationNode {
    private IdentifierNode typeName;
    private TypeClass type;

    public TypeDeclarationNode(IdentifierNode typeName, TypeClass type, int lineNumber) {
        super("TypeDeclaration", lineNumber);
        this.typeName = typeName;
        this.type = type;
    }

    public IdentifierNode getTypeName() {
        return typeName;
    }

    public TypeClass getType() {
        return type;
    }
}
