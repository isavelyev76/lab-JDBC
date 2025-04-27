package types;

public enum LevelEnum {
    SURFACE("surface"),
    MEDIUM("medium"),
    DEEP("deep");

    private final String value;

    LevelEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}