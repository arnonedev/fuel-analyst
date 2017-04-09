package pl.arnonedev.fuelanalyst.helper;

import pl.arnonedev.fuelanalyst.model.FuelType;

/**
 * Created by Arek on 2017-04-09.
 */
public class FuelTypeHelper {
    private FuelTypeHelper() {}

    public static FuelType getFuelTypeById(int id) {
        FuelType[] fuelTypes = FuelType.values();
        for (FuelType fuelType : fuelTypes) {
            if (fuelType.getDbId() == id) {
                return fuelType;
            }
        }
        return null;
    }

    public static FuelType getFuelTypeByIndex(int index) {
        FuelType[] fuelTypes = FuelType.values();
        for (FuelType fuelType : fuelTypes) {
            if (fuelType.getArrayIndex() == index) {
                return fuelType;
            }
        }
        return null;
    }
}
