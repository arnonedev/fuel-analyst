package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum EventType {
    INSPECTION("Inspection", 35),
    INSURANCE("Insurance", 36),
    CHANGE_TIRES("Change tires", 37),
    CHANGE_OIL("Change oil", 33),
    CHANGE_TIMING_GEAR("Change timing gear", 34);

    private String title;
    private int dbId;

    EventType(String title, int dbId) {
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
