package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum TransmissionType implements PartsType {
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
        return "TRANSMISSION";
    }
}
