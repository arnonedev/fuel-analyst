package pl.arnonedev.fuelanalyst.helper;

import pl.arnonedev.fuelanalyst.model.OdometerUnit;

/**
 * Created by Arek on 2017-04-09.
 */
public class OdometerUnitHelper {
    private OdometerUnitHelper() {}

    public static OdometerUnit getOdometerUnitById(int id) {
        OdometerUnit[] odometerUnits = OdometerUnit.values();
        for (OdometerUnit odometerUnit : odometerUnits) {
            if (odometerUnit.getDbId() == id) {
                return odometerUnit;
            }
        }
        return null;
    }

    public static OdometerUnit getOdometerUnitByIndex(int index) {
        OdometerUnit[] odometerUnits = OdometerUnit.values();
        for (OdometerUnit odometerUnit : odometerUnits) {
            if (odometerUnit.getArrayIndex() == index) {
                return odometerUnit;
            }
        }
        return null;
    }
}
