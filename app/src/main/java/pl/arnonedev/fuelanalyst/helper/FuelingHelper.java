package pl.arnonedev.fuelanalyst.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import pl.arnonedev.fuelanalyst.model.Fueling;
import pl.arnonedev.fuelanalyst.persistence.table.FuelingTable;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arek on 2017-04-30.
 */
public class FuelingHelper extends  DatabaseModelHelper<Fueling> {
    public FuelingHelper(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public Fueling save(Fueling fueling) {
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            ContentValues values = getContentValuesFromFueling(fueling);
            long fuelingId = applicationDatabaseHelper.save(database, values, FuelingTable.TABLE_NAME);
            fueling.setId(fuelingId);
            database.close();
        } catch (SQLiteException e) {
            Log.e(FuelingHelper.class.getName(), "Save fueling error " + e);
        }
        return fueling;
    }

    @Override
    public Fueling refresh(Fueling fueling) {
        Fueling refreshedFueling = null;
        try {
            database = this.applicationDatabaseHelper.getReadableDatabase();
            Cursor cursor = applicationDatabaseHelper.find(database, FuelingTable.TABLE_NAME, FuelingTable.COLUMNS, "_id = ?",
                    new String[]{Long.toString(fueling.getId())}, null, null, null);
            if (cursor.moveToFirst()) {
                refreshedFueling = getFuelingFromCursor(cursor);
            }
            database.close();
            cursor.close();
        } catch (SQLiteException | ParseException e) {
            Log.e(FuelingHelper.class.getName(), "Refresh fueling error " + e);
        }
        return refreshedFueling == null ? fueling : refreshedFueling;
    }

    @Override
    public Fueling modify(Fueling fueling) {
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            ContentValues values = getContentValuesFromFueling(fueling);
            applicationDatabaseHelper.modify(database, values, FuelingTable.TABLE_NAME, "_id = ?", Long.toString(fueling.getId()));
            database.close();
        } catch (SQLiteException e) {
            Log.e(FuelingHelper.class.getName(), "Modify fueling error " + e);
        }
        return fueling;
    }

    @Override
    public Fueling find(int id) {
        Fueling foundedFueling = null;
        try {
            database = this.applicationDatabaseHelper.getReadableDatabase();
            Cursor cursor = applicationDatabaseHelper.find((database), FuelingTable.TABLE_NAME, FuelingTable.COLUMNS, "_id = ?",
                    new String[]{Integer.toString(id)}, null, null, null);
            if (cursor.moveToFirst()) {
                foundedFueling = getFuelingFromCursor(cursor);
            }
            database.close();
            cursor.close();
        } catch (SQLiteException | ParseException e) {
            Log.e(FuelingHelper.class.getName(), "Find fueling error " + e);
        }
        return foundedFueling;
    }

    @Override
    public List<Fueling> findAll() {
        List<Fueling> foundedFuelings = new ArrayList<>();
        try {
            database = this.applicationDatabaseHelper.getReadableDatabase();
            Cursor cursor = applicationDatabaseHelper.find(database, FuelingTable.TABLE_NAME, FuelingTable.COLUMNS, null,
                    null, null, null, null);
            while (cursor.moveToNext()) {
                foundedFuelings.add(getFuelingFromCursor(cursor));
            }
            database.close();
            cursor.close();
        } catch (SQLiteException | ParseException e) {
            Log.e(FuelingHelper.class.getName(), "Find fuelings error " + e);
        }
        return foundedFuelings;
    }

    @Override
    public List<Fueling> findAllByVehicleId(int id) {
        List<Fueling> foundedFuelings = new ArrayList<>();
        String whereClause = FuelingTable.ID_VEHICLE_COLUMN + " = ?";
        try {
            database = this.applicationDatabaseHelper.getReadableDatabase();
            Cursor cursor = applicationDatabaseHelper.find((database), FuelingTable.TABLE_NAME, FuelingTable.COLUMNS, whereClause,
                    new String[]{Integer.toString(id)}, null, null, null);
            while (cursor.moveToNext()) {
                foundedFuelings.add(getFuelingFromCursor(cursor));
            }
            database.close();
            cursor.close();
        } catch (SQLiteException | ParseException e) {
            Log.e(FuelingHelper.class.getName(), "Find fueling error " + e);
        }
        return foundedFuelings;
    }

    @Override
    public boolean delete(Fueling fueling) {
        int result = 0;
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            result = applicationDatabaseHelper.delete(database, FuelingTable.TABLE_NAME, "_id = ?", Long.toString(fueling.getId()));
            database.close();
        } catch (SQLiteException e) {
            Log.e(FuelingHelper.class.getName(), "Delete fueling error " + e);
        }
        return result != 0;
    }

    private ContentValues getContentValuesFromFueling(Fueling fueling) {
        ContentValues result = new ContentValues();
        result.put(FuelingTable.ID_VEHICLE_COLUMN, fueling.getVehicle().getId());
        result.put(FuelingTable.DATE_COLUMN, dateFormat.format(fueling.getDate()));
        result.put(FuelingTable.ODOMETER_COLUMN, fueling.getOdometer());
        result.put(FuelingTable.TRIP_COLUMN, fueling.getTrip());
        result.put(FuelingTable.QUANTITY_COLUMN, fueling.getQuantity());
        result.put(FuelingTable.FULL_FUELING_COLUMN, fueling.isFullFueling());
        result.put(FuelingTable.ID_FUEL_TYPE_COLUMN, fueling.getFuelType().getDbId());
        result.put(FuelingTable.COST_COLUMN, fueling.getCost());
        result.put(FuelingTable.ID_TIRES_COLUMN, fueling.getTireType().getDbId());
        result.put(FuelingTable.ID_DRIVING_STYLE_COLUMN, fueling.getDrivingStyle().getDbId());
        result.put(FuelingTable.ID_ROUTES_COLUMN, fueling.getRoutesType().getDbId());
        result.put(FuelingTable.EXTRAS_COLUMN, fueling.getExtras());
        result.put(FuelingTable.AVERAGE_COMBUSTION_COLUMN, fueling.getAverageConsumption());
        result.put(FuelingTable.FUEL_UNIT_COST_COLUMN, fueling.getFuelUnitCost());
        return result;
    }

    private Fueling getFuelingFromCursor(Cursor cursor) throws ParseException {
        VehicleHelper vehicleHelper = new VehicleHelper(activity);
        Fueling result = new Fueling();
        result.setId(cursor.getInt(0));
        result.setVehicle(vehicleHelper.find(cursor.getInt(1)));
        result.setDate(dateFormat.parse(cursor.getString(2)));
        result.setOdometer(cursor.getInt(3));
        result.setTrip(cursor.getDouble(4));
        result.setQuantity(cursor.getDouble(5));
        result.setFullFueling(cursor.getInt(6) > 0);
        result.setCost(cursor.getDouble(7));
        result.setTireType(TireTypeHelper.getTireTypeById(cursor.getInt(8)));
        result.setDrivingStyle(DrivingStyleHelper.getDrivingStyleById(cursor.getInt(9)));
        result.setRoutesType(RoutesTypeHelper.getRoutesTypeById(cursor.getInt(10)));
        result.setExtras(cursor.getString(11));
        result.setAverageConsumption(cursor.getDouble(12));
        result.setFuelUnitCost(cursor.getDouble(13));
        return result;
    }
}
