package pl.arnonedev.fuelanalyst.helper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import pl.arnonedev.fuelanalyst.model.Vehicle;
import pl.arnonedev.fuelanalyst.persistence.ApplicationDatabaseHelper;
import pl.arnonedev.fuelanalyst.persistence.table.VehicleTable;

/**
 * Created by Arek on 2017-03-27.
 */
public class VehicleHelper implements IVehicleHelper {
    private AppCompatActivity activity = null;
    private ApplicationDatabaseHelper applicationDatabaseHelper = null;
    private SQLiteDatabase database = null;

    public VehicleHelper(AppCompatActivity activity) {
        this.activity = activity;
        this.applicationDatabaseHelper = new ApplicationDatabaseHelper(activity);
        this.database = this.applicationDatabaseHelper.getWritableDatabase();
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        ContentValues values = new ContentValues();
        values.put(VehicleTable.ID_COLUMN, vehicle.getId());
        values.put(VehicleTable.MAKE_COLUMN, vehicle.getMake());
        values.put(VehicleTable.MODEL_COLUMN, vehicle.getModel());
        values.put(VehicleTable.YEAR_OF_MANUFACTURE_COLUMN, vehicle.getYearOfManufacture());
        values.put(VehicleTable.ID_FUEL_TYPE_COLUMN, vehicle.getFuelType().getDbId());
        values.put(VehicleTable.WEIGHT_COLUMN, vehicle.getWeight());
        values.put(VehicleTable.LICENSE_NUMBER_COLUMN, vehicle.getLicenseNumber());
        values.put(VehicleTable.POWER_COLUMN, vehicle.getPower());
        values.put(VehicleTable.ENGINE_CAPACITY_COLUMN, vehicle.getEngineCapacity());
        values.put(VehicleTable.ODOMETER_COLUMN, vehicle.getOdometer());
        values.put(VehicleTable.ID_TRANSMISSION_COLUMN, vehicle.getTransmissionType().getDbId());
        values.put(VehicleTable.ID_ODOMETER_UNIT_COLUMN, vehicle.getOdometerUnit().getDbId());
        values.put(VehicleTable.ID_BODY_TYPE_COLUMN, vehicle.getBodyType().getDbId());

        long vehicleId = applicationDatabaseHelper.save(this.database, values, VehicleTable.TABLE_NAME);
        vehicle.setId(vehicleId);
        return vehicle;
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
