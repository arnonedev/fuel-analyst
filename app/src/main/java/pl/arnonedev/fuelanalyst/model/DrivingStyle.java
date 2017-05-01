package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum DrivingStyle implements PartsType {
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
        return "DRIVING_STYLE";
    }
}
