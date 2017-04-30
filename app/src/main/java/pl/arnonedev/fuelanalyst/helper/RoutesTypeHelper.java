package pl.arnonedev.fuelanalyst.helper;

import pl.arnonedev.fuelanalyst.model.RoutesType;

/**
 * Created by Arek on 2017-04-30.
 */
public class RoutesTypeHelper {
    private RoutesTypeHelper() {}

    public static RoutesType getRoutesTypeById(int id) {
        RoutesType[] routesTypes = RoutesType.values();
        for (RoutesType routesType : routesTypes) {
            if (routesType.getDbId() == id) {
                return routesType;
            }
        }
        return null;
    }

    public static RoutesType getRoutesTypeByIndex(int index) {
        RoutesType[] routesTypes = RoutesType.values();
        for (RoutesType routesType : routesTypes) {
            if (routesType.getArrayIndex() == index) {
                return routesType;
            }
        }
        return null;
    }
}
