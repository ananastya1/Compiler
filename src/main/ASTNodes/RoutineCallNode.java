import java.util.List;

public class RoutineCallNode extends PrimaryNode implements StatementNode {
    private IdentifierNode routineName;
    private List<ExpressionNode> arguments;

    public RoutineCallNode(IdentifierNode routineName, List<ExpressionNode> arguments, int lineNumber) {
        super("RoutineCall", lineNumber);
        this.routineName = routineName;
        this.arguments = arguments;
    }

    public RoutineCallNode(String label, int lineNumber) {
        super(label, lineNumber);
    }

    public IdentifierNode getRoutineName() {
        return routineName;
    }

    public List<ExpressionNode> getArguments() {
        return arguments;
    }
}
