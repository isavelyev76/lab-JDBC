package types;

public enum ProbabilityEnum {
    HIGH("high"),
    MEDIUM("medium"),
    LOW("low");

    private final String value;

    ProbabilityEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
