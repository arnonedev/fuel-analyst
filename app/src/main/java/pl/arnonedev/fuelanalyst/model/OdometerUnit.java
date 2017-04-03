package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum OdometerUnit {
    MILE("Mile", 15),
    METRIC("Metric",16);

    private String title;
    private int dbId;

    OdometerUnit(String title, int dbId) {
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
