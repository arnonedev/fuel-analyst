package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum OdometerUnit {
    MILE("Mile", 15),
    METRIC("Metric",16);

    private String title;
    private int dbID;

    OdometerUnit(String title, int dbID) {
        this.title = title;
        this.dbID = dbID;
    }

    public String getTitle() {
        return title;
    }

    public int getDbID() {
        return dbID;
    }
}
