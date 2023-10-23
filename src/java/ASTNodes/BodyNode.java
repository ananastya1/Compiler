package ASTNodes;

import java.util.List;

public class BodyNode extends ASTNode {
    private List<OneLineBodyNode> oneLineBodyNode;

    public BodyNode(List<OneLineBodyNode> oneLineBodyNode, int lineNumber) {
        super("Body", lineNumber);
        this.oneLineBodyNode = oneLineBodyNode;
    }

    public List<OneLineBodyNode> getOneLineBodyNode() {
        return oneLineBodyNode;
    }

    @Override
    public void printNode(int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(this.label);
        System.out.print(indent + "|__");
        for (int i = 0; i < oneLineBodyNode.size() - 1; i++) {
            oneLineBodyNode.get(i).printNode(depth + 1);
            System.out.print(indent + "|__");
        }
        oneLineBodyNode.get(oneLineBodyNode.size() - 1).printNode(depth + 1);
    }
}
