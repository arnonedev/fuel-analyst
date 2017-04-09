package pl.arnonedev.fuelanalyst.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import pl.arnonedev.fuelanalyst.model.*;
import pl.arnonedev.fuelanalyst.persistence.table.VehicleTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arek on 2017-03-27.
 */
public class VehicleHelper extends DatabaseModelHelper<Vehicle> {

    public VehicleHelper(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            ContentValues values = getContentValuesFromVehicle(vehicle);
            long vehicleId = applicationDatabaseHelper.save(database, values, VehicleTable.TABLE_NAME);
            vehicle.setId(vehicleId);
            database.close();
        } catch (SQLiteException e) {
            Log.e(VehicleHelper.class.getName(), "Save vehicle error " + e);
        }
        return vehicle;
    }

    @Override
    public Vehicle refresh(Vehicle vehicle) {
        Vehicle refreshedVehicle = null;
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            Cursor cursor = applicationDatabaseHelper.find(database, VehicleTable.TABLE_NAME, VehicleTable.COLUMNS, "_id = ?",
                    new String[]{Integer.toString((int) vehicle.getId())}, null, null, null);
            if (cursor.moveToFirst()) {
                refreshedVehicle = getVehicleFromCursor(cursor);
            }
            database.close();
            cursor.close();
        } catch (SQLiteException e) {
            Log.e(VehicleHelper.class.getName(), "Refresh vehicle error " + e);
        }
        return refreshedVehicle == null ? vehicle : refreshedVehicle;
    }

    @Override
    public Vehicle modify(Vehicle vehicle) {
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            ContentValues values = getContentValuesFromVehicle(vehicle);
            applicationDatabaseHelper.modify(database, values, VehicleTable.TABLE_NAME, "_id = ?", Long.toString(vehicle.getId()));
            database.close();
        } catch (SQLiteException e) {
            Log.e(VehicleHelper.class.getName(), "Modify vehicle error " + e);
        }
        return vehicle;
    }

    @Override
    public Vehicle find(int id) {
        Vehicle foundedVehicle = null;
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            Cursor cursor = applicationDatabaseHelper.find(database, VehicleTable.TABLE_NAME, VehicleTable.COLUMNS, "_id = ?",
                    new String[]{Integer.toString(id)}, null, null, null);
            if (cursor.moveToFirst()) {
                foundedVehicle = getVehicleFromCursor(cursor);
            }
            database.close();
            cursor.close();
        } catch (SQLiteException e) {
            Log.e(VehicleHelper.class.getName(), "Find vehicle error " + e);
        }
        return foundedVehicle;
    }

    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> foundedVehicles = new ArrayList<>();
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            Cursor cursor = applicationDatabaseHelper.find(database, VehicleTable.TABLE_NAME, VehicleTable.COLUMNS, null,
                    null, null, null, null);
            while (cursor.moveToNext()) {
                foundedVehicles.add(getVehicleFromCursor(cursor));
            }
            database.close();
            cursor.close();
        } catch (SQLiteException e) {
            Log.e(VehicleHelper.class.getName(), "Find vehicles error " + e);
        }
        return foundedVehicles;
    }

    @Override
    public boolean delete(Vehicle vehicle) {
        int result = 0;
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            result = applicationDatabaseHelper.delete(database, VehicleTable.TABLE_NAME, "_id = ?", Long.toString(vehicle.getId()));
            database.close();
        } catch (SQLiteException e) {
            Log.e(VehicleHelper.class.getName(), "Delete vehicle error " + e);
        }
        return result != 0;
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

    private Vehicle getVehicleFromCursor(Cursor cursor) {
        Vehicle result = new Vehicle();
        result.setId(cursor.getInt(0));
        result.setMake(cursor.getString(1));
        result.setModel(cursor.getString(2));
        result.setYearOfManufacture(cursor.getInt(3));
        result.setFuelType(getFuelById(cursor.getInt(4)));
        result.setWeight(cursor.getInt(5));
        result.setLicenseNumber(cursor.getString(6));
        result.setPower(cursor.getInt(7));
        result.setEngineCapacity(cursor.getInt(8));
        result.setOdometer(cursor.getInt(9));
        result.setTransmissionType(getTransmissionTypeById(cursor.getInt(10)));
        result.setOdometerUnit(getOdometerUnitById(cursor.getInt(11)));
        result.setBodyType(getBodyTypeById(cursor.getInt(12)));
        return result;
    }

    private ContentValues getContentValuesFromVehicle(Vehicle vehicle) {
        ContentValues resutl = new ContentValues();
        resutl.put(VehicleTable.ID_COLUMN, vehicle.getId());
        resutl.put(VehicleTable.MAKE_COLUMN, vehicle.getMake());
        resutl.put(VehicleTable.MODEL_COLUMN, vehicle.getModel());
        resutl.put(VehicleTable.YEAR_OF_MANUFACTURE_COLUMN, vehicle.getYearOfManufacture());
        resutl.put(VehicleTable.ID_FUEL_TYPE_COLUMN, vehicle.getFuelType().getDbId());
        resutl.put(VehicleTable.WEIGHT_COLUMN, vehicle.getWeight());
        resutl.put(VehicleTable.LICENSE_NUMBER_COLUMN, vehicle.getLicenseNumber());
        resutl.put(VehicleTable.POWER_COLUMN, vehicle.getPower());
        resutl.put(VehicleTable.ENGINE_CAPACITY_COLUMN, vehicle.getEngineCapacity());
        resutl.put(VehicleTable.ODOMETER_COLUMN, vehicle.getOdometer());
        resutl.put(VehicleTable.ID_TRANSMISSION_COLUMN, vehicle.getTransmissionType().getDbId());
        resutl.put(VehicleTable.ID_ODOMETER_UNIT_COLUMN, vehicle.getOdometerUnit().getDbId());
        resutl.put(VehicleTable.ID_BODY_TYPE_COLUMN, vehicle.getBodyType().getDbId());
        return resutl;
    }
}
