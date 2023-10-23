package ASTNodes;

public class TypeDeclarationNode extends SimpleDeclarationNode {
    private IdentifierNode typeName;
    private TypeNode type;

    public TypeDeclarationNode(IdentifierNode typeName, TypeNode type, int lineNumber) {
        super("TypeDeclaration", lineNumber);
        this.typeName = typeName;
        this.type = type;
    }

    public IdentifierNode getTypeName() {
        return typeName;
    }

    public TypeNode getType() {
        return type;
    }
}
