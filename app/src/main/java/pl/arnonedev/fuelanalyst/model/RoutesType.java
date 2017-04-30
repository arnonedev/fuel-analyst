package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum RoutesType {
    CITY("City", 11, 0),
    HIGHWAY("Highway", 10, 1),
    MIXED("Mixed", 12, 2);

    private String title;
    private int dbId;
    private int arrayIndex;

    RoutesType(String title, int dbId, int arrayIndex) {
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
