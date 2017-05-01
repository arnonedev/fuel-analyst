package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum EventType implements PartsType {
    INSPECTION("Inspection", 35, 0),
    INSURANCE("Insurance", 36, 0),
    CHANGE_TIRES("Change tires", 37, 0),
    CHANGE_OIL("Change oil", 33, 0),
    CHANGE_TIMING_GEAR("Change timing gear", 34, 0);

    private String title;
    private int dbId;
    private int arrayIndex;

    EventType(String title, int dbId, int arrayIndex) {
        this.title = title;
        this.dbId = dbId;
        this.arrayIndex = arrayIndex;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getDbId() {
        return dbId;
    }

    @Override
    public int getArrayIndex() {
        return arrayIndex;
    }

    @Override
    public String getTypeGroup() {
        return "EVENT";
    }
}
