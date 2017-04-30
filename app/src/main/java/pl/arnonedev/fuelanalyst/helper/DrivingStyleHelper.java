package pl.arnonedev.fuelanalyst.helper;

import pl.arnonedev.fuelanalyst.model.DrivingStyle;

/**
 * Created by Arek on 2017-04-30.
 */
public class DrivingStyleHelper {
    private DrivingStyleHelper() {}

    public static DrivingStyle getDrivingStyleById(int id) {
        DrivingStyle[] drivingStyles = DrivingStyle.values();
        for (DrivingStyle drivingStyle : drivingStyles) {
            if (drivingStyle.getDbId() == id) {
                return drivingStyle;
            }
        }
        return null;
    }

    public static DrivingStyle getDrivingStyleByIndex(int index) {
        DrivingStyle[] drivingStyles = DrivingStyle.values();
        for (DrivingStyle drivingStyle : drivingStyles) {
            if (drivingStyle.getArrayIndex() == index) {
                return drivingStyle;
            }
        }
        return null;
    }
}
