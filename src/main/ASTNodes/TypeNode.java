public class TypeNode extends ASTNode {
    TypeClass type;

    public TypeNode(String label, int lineNumber, TypeClass type) {
        super(label, lineNumber);
        this.type = type;
    }

}

