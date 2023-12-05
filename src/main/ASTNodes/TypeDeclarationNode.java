public class TypeDeclarationNode extends SimpleDeclarationNode {
    private final TypeClass type;

    public TypeDeclarationNode(TypeClass type, int lineNumber) {
        super("TypeDeclaration", lineNumber);
        this.type = type;
    }

    public TypeClass getType() {
        return type;
    }
}
