package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum TireType {
    SUMMER("Summer", 5),
    WINTER("Winter", 4),
    MULTI_SEASON("Multi-season", 6);

    private String title;
    private int dbId;

    TireType(String title, int dbId) {
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
