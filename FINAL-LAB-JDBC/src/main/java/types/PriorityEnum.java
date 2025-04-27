package types;

public enum PriorityEnum {
    HIGH("high"),
    MEDIUM("medium"),
    LOW("low");

    private final String value;

    PriorityEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}