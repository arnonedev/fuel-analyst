package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum TransmissionType {
    MANUAL("Manual", 13, 0),
    AUTOMATIC("Automatic", 14, 1);

    private String title;
    private int dbId;
    private int arrayIndex;

    TransmissionType(String title, int dbId, int arrayIndex) {
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
