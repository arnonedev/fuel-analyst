package pl.arnonedev.fuelanalyst.helper;

import pl.arnonedev.fuelanalyst.model.TireType;

/**
 * Created by Arek on 2017-04-30.
 */
public class TireTypeHelper {
    private TireTypeHelper() {}

    public static TireType getTireTypeById(int id) {
        TireType[] tireTypes = TireType.values();
        for (TireType tireType : tireTypes) {
            if (tireType.getDbId() == id) {
                return tireType;
            }
        }
        return null;
    }

    public static TireType getTireTypeByIndex(int index) {
        TireType[] tireTypes = TireType.values();
        for (TireType tireType : tireTypes) {
            if (tireType.getArrayIndex() == index) {
                return tireType;
            }
        }
        return null;
    }
}
