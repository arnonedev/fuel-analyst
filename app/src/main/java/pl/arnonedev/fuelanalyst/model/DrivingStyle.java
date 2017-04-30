package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum DrivingStyle {
    ECO("Eco", 9, 0),
    NORMAL("Normal", 8, 1),
    DYNAMIC("Dynamic", 7, 2);

    private String title;
    private int dbId;
    private int arrayIndex;

    DrivingStyle(String title, int dbId, int arrayIndex) {
        this.title = title;
        this.dbId = dbId;
        this.arrayIndex = arrayIndex;
    }

    public String getTitle() {
        return title;
    }

    public int getDbId() {
        return dbId;
    }

    public int getArrayIndex() {
        return arrayIndex;
    }
}
