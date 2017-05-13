package pl.arnonedev.fuelanalyst.helper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import pl.arnonedev.fuelanalyst.model.PartsType;
import pl.arnonedev.fuelanalyst.persistence.table.PartsTypeTable;

import java.util.List;

/**
 * Created by Arek on 2017-05-01.
 */
public class PartsTypeHelper extends DatabaseModelHelper<PartsType> {
    public PartsTypeHelper(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public PartsType save(PartsType partsType) {
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            ContentValues values = getContentValuesFromPartsType(partsType);
            database.close();
        } catch (SQLiteException e) {
            Log.e(PartsTypeHelper.class.getName(), "Save part type error " + e);
        }
        return partsType;
    }

    @Override
    public PartsType refresh(PartsType partsType) {
        return partsType;
    }

    @Override
    public PartsType modify(PartsType partsType) {
        return partsType;
    }

    @Override
    public PartsType find(int id) {
        return null;
    }

    @Override
    public List<PartsType> findAll() {
        return null;
    }

    @Override
    public List<PartsType> findAllByVehicleId(int id) {
        return null;
    }

    @Override
    public boolean delete(PartsType partsType) {
        return false;
    }

    private ContentValues getContentValuesFromPartsType(PartsType partsType) {
        ContentValues result = new ContentValues();
        result.put(PartsTypeTable.ID_COLUMN, partsType.getDbId());
        result.put(PartsTypeTable.TYPE_COLUMN, partsType.getTitle());
        result.put(PartsTypeTable.PARTS_GROUP_COLUMN, partsType.getTypeGroup());
        return result;
    }
}
