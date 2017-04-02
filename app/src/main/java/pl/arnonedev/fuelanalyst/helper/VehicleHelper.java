package pl.arnonedev.fuelanalyst.helper;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import pl.arnonedev.fuelanalyst.model.Vehicle;
import pl.arnonedev.fuelanalyst.persistence.table.VehicleTable;

/**
 * Created by Arek on 2017-03-27.
 */
public class VehicleHelper implements IVehicleHelper {
    private AppCompatActivity activity = null;

    public VehicleHelper(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        ContentValues values = new ContentValues();
        values.put(VehicleTable.ID_COLUMN, vehicle.getId());
        values.put(VehicleTable.MAKE_COLUMN, vehicle.getMake());
        values.put(VehicleTable.MODEL_COLUMN, vehicle.getModel());
        values.put(VehicleTable.YEAR_OF_MANUFACTURE_COLUMN, vehicle.getYearOfManufacture());
//        values.put(VehicleTable.ID_FUEL_TYPE_COLUMN);
        return null;
    }

    @Override
    public Vehicle refresh(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle modify(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle find(int id) {
        return null;
    }

    @Override
    public Vehicle findAll() {
        return null;
    }

    @Override
    public boolean delete(Vehicle vehicle) {
        return false;
    }
}
