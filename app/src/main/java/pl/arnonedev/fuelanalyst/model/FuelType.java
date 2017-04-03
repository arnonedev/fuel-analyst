package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum FuelType {
    DIESEL("Diesel", 38),
    GAS("Gas", 43),
    PETROL("Petrol", 39),
    ELECTRIC("Electric", 41),
    HYBRID("Hybrid", 42),
    GAS_AND_PETROL("Petrol + Gas", 40);

    private String title;
    private int dbId;

    FuelType(String title, int dbId) {
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
