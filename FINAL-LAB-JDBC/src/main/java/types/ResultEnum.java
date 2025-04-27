package types;

public enum ResultEnum {
    PASSED("passed"),
    FAILED("failed");

    private final String value;

    ResultEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}