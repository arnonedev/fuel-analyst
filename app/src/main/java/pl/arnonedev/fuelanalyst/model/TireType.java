package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum TireType implements PartsType {
    SUMMER("Summer", 5, 0),
    WINTER("Winter", 4, 1),
    MULTI_SEASON("Multi-season", 6, 2);

    private String title;
    private int dbId;
    private int arrayIndex;

    TireType(String title, int dbId, int arrayIndex) {
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
        return "TIRES";
    }
}
