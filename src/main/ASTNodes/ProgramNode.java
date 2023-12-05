import java.util.ArrayList;
import java.util.List;

public class ProgramNode extends ASTNode {
    private final List<ASTNode> programNodes;

    public ProgramNode() {
        super("Program", 0);
        programNodes = new ArrayList<>();
    }

    public void addProgramNode(ASTNode node) {
        programNodes.add(node);
    }
}
