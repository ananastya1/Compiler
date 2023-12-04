public class TypeNode extends ASTNode {
    TypeClass type = null;

    public TypeNode(String label, int lineNumber, TypeClass type) {
        super(label, lineNumber);
        this.type = type;
    }

}

