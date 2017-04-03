package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum RoutesType {
    CITY("City", 11),
    HIGHWAY("Highway", 10),
    MIXED("Mixed", 12);

    private String title;
    private int dbId;

    RoutesType(String title, int dbId) {
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
