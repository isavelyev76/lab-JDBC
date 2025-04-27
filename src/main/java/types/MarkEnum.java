package types;

public enum MarkEnum {
    IMPLEMENTATION_COMPLETED("implementation completed"),
    TESTED_SUCCESSFUL("tested, successful"),
    TESTED_UNSUCCESSFUL("tested, unsuccessful"),
    TESTED_NEEDS_REVISION("tested, needs revision");

    private final String value;

    MarkEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}