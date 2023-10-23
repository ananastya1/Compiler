package ASTNodes;

public class SimpleDeclarationNode extends ASTNode {

    public SimpleDeclarationNode(String label, int lineNumber) {
        super(label, lineNumber);
    }

    @Override
    public void printNode(int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(this.label);
    }
}
