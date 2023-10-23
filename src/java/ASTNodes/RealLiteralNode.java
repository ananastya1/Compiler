package ASTNodes;

public class RealLiteralNode extends PrimaryNode {
    private double value;

    public RealLiteralNode(double value, int lineNumber) {
        super(lineNumber);
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
