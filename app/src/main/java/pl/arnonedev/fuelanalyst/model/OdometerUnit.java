package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum OdometerUnit implements PartsType {
    MILE("Mile", 15, 0),
    METRIC("Metric",16, 1);

    private String title;
    private int dbId;
    private int arrayIndex;

    OdometerUnit(String title, int dbId, int arrayIndex) {
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
        return "ODOMETER_UNIT";
    }
}
