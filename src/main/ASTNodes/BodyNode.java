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
}
