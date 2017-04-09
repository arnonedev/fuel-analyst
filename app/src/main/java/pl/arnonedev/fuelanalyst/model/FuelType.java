package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum FuelType {
    DIESEL("Diesel", 38, 0),
    GAS("Gas", 43, 5),
    PETROL("Petrol", 39, 1),
    ELECTRIC("Electric", 41, 3),
    HYBRID("Hybrid", 42, 4),
    GAS_AND_PETROL("Petrol + Gas", 40, 2);

    private String title;
    private int dbId;
    private int arrayIndex;

    FuelType(String title, int dbId, int arrayIndex) {
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
