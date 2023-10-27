public class TypeNode extends ASTNode {
    Type type = null;

    public TypeNode(String label, int lineNumber, Type type) {
        super(label, lineNumber);
        this.type = type;
    }

    @Override
    public void printNode(int depth) {

    }
}

