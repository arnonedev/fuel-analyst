package pl.arnonedev.fuelanalyst.helper;

import pl.arnonedev.fuelanalyst.model.BodyType;

/**
 * Created by Arek on 2017-04-09.
 */
public class BodyTypeHelper {
    private BodyTypeHelper() {}

    public static BodyType getBodyTypeById(int id) {
        BodyType[] bodyTypes = BodyType.values();
        for (BodyType bodyType : bodyTypes) {
            if (bodyType.getDbId() == id) {
                return bodyType;
            }
        }
        return null;
    }

    public static BodyType getBodyTypeByIndex(int index) {
        BodyType[] bodyTypes = BodyType.values();
        for (BodyType bodyType : bodyTypes) {
            if (bodyType.getArrayIndex() == index) {
                return bodyType;
            }
        }
        return null;
    }
}
