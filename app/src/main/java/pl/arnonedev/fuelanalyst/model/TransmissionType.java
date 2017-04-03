package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum TransmissionType {
    MANUAL("Manual", 13),
    AUTOMATIC("Automatic", 14);

    private String title;
    private int dbId;

    TransmissionType(String title, int dbId) {
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
