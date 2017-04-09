package pl.arnonedev.fuelanalyst.helper;

import pl.arnonedev.fuelanalyst.model.TransmissionType;

/**
 * Created by Arek on 2017-04-09.
 */
public class TransmissionTypeHelper {
    private TransmissionTypeHelper() {}

    public static TransmissionType getTransmissionTypeById(int id) {
        TransmissionType[] transmissionTypes = TransmissionType.values();
        for (TransmissionType transmissionType : transmissionTypes) {
            if (transmissionType.getDbId() == id) {
                return transmissionType;
            }
        }
        return null;
    }

    public static TransmissionType getTransmissionTypeByIndex(int index) {
        TransmissionType[] transmissionTypes = TransmissionType.values();
        for (TransmissionType transmissionType : transmissionTypes) {
            if (transmissionType.getArrayIndex() == index) {
                return transmissionType;
            }
        }
        return null;
    }
}
