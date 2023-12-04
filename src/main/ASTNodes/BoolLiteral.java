public class BoolLiteral extends PrimaryNode {
    private boolean value;

    public BoolLiteral(boolean value, int lineNumber) {
        super(lineNumber);
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
}
