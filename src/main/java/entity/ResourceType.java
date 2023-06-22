package entity;

public enum ResourceType {
    URL,
    VIDEO,
    BOOK;

    public static Enum resourceType() {
        if (Additional.getCount() % 2 == 0) {
            return URL;
        }
        if (Additional.getCount() % 3 == 0) {
            return VIDEO;
        }
        return BOOK;
    }
}
