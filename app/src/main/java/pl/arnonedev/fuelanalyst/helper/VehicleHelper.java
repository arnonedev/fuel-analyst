package pl.arnonedev.fuelanalyst.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import pl.arnonedev.fuelanalyst.model.*;
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
        Vehicle refreshedVehicle = new Vehicle();
        Cursor cursor = applicationDatabaseHelper.find(database, VehicleTable.TABLE_NAME, VehicleTable.COLUMNS, "_id = ?",
                new String[]{Integer.toString((int) vehicle.getId())}, null, null, null);
        if (cursor.moveToFirst()) {
            refreshedVehicle.setId(vehicle.getId());
            refreshedVehicle.setMake(cursor.getString(1));
            refreshedVehicle.setModel(cursor.getString(2));
            refreshedVehicle.setYearOfManufacture(cursor.getInt(3));
            refreshedVehicle.setFuelType(getFuelById(cursor.getInt(4)));
            refreshedVehicle.setWeight(cursor.getInt(5));
            refreshedVehicle.setLicenseNumber(cursor.getString(6));
            refreshedVehicle.setPower(cursor.getInt(7));
            refreshedVehicle.setEngineCapacity(cursor.getInt(8));
            refreshedVehicle.setOdometer(cursor.getInt(9));
            refreshedVehicle.setTransmissionType(getTransmissionTypeById(cursor.getInt(10)));
            refreshedVehicle.setOdometerUnit(getOdometerUnitById(cursor.getInt(11)));
            refreshedVehicle.setBodyType(getBodyTypeById(cursor.getInt(12)));
        }
        return refreshedVehicle.getId() == 0 ? vehicle : refreshedVehicle;
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

    private FuelType getFuelById(int id) {
        FuelType[] fuelTypes = FuelType.values();
        for (FuelType fuelType : fuelTypes) {
            if (fuelType.getDbId() == id) {
                return fuelType;
            }
        }
        return null;
    }

    private TransmissionType getTransmissionTypeById(int id) {
        TransmissionType[] transmissionTypes = TransmissionType.values();
        for (TransmissionType transmissionType : transmissionTypes) {
            if (transmissionType.getDbId() == id) {
                return transmissionType;
            }
        }
        return null;
    }

    private OdometerUnit getOdometerUnitById(int id) {
        OdometerUnit[] odometerUnits = OdometerUnit.values();
        for (OdometerUnit odometerUnit : odometerUnits) {
            if (odometerUnit.getDbId() == id) {
                return odometerUnit;
            }
        }
        return null;
    }

    private BodyType getBodyTypeById(int id) {
        BodyType[] bodyTypes = BodyType.values();
        for (BodyType bodyType : bodyTypes) {
            if (bodyType.getDbId() == id) {
                return bodyType;
            }
        }
        return null;
    }
}
