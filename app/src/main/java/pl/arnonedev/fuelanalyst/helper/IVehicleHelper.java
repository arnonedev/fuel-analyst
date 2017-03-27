package pl.arnonedev.fuelanalyst.helper;

import pl.arnonedev.fuelanalyst.model.Vehicle;

/**
 * Created by Arek on 2017-03-27.
 */
public interface IVehicleHelper {
    Vehicle save(Vehicle vehicle);
    Vehicle refresh(Vehicle vehicle);
    Vehicle modify(Vehicle vehicle);
    Vehicle find(int id);
    Vehicle findAll();
    boolean delete(Vehicle vehicle);
}
