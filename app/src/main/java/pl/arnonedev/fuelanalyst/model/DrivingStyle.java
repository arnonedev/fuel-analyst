package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum DrivingStyle {
    ECO("Eco", 9),
    NORMAL("Normal", 8),
    DYNAMIC("Dynamic", 7);

    private String title;
    private int dbId;

    DrivingStyle(String title, int dbId) {
        this.title = title;
        this.dbId = dbId;
    }

    public String getTitle() {
        return title;
    }

    public int getDbId() {
        return dbId;
    }
}
