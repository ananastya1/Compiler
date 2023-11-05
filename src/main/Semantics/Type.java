public enum Type {
    BOOLEAN("boolean"),
    INT("integer"),
    REAL("real"),
    RECORD("record"),
    ARRAY("array");
    private String stringRepresentation;

    Type(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public String getString() {
        return stringRepresentation;
    }
}

