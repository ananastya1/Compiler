public class RoutineCallNode extends PrimaryNode implements StatementNode {

    public RoutineCallNode(int lineNumber) {
        super("RoutineCall", lineNumber);
    }

    public RoutineCallNode(String label, int lineNumber) {
        super(label, lineNumber);
    }
}
