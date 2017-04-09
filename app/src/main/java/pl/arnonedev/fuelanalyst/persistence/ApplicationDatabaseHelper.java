package pl.arnonedev.fuelanalyst.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import pl.arnonedev.fuelanalyst.persistence.table.*;

/**
 * Created by Arek on 2017-03-27.
 */
public class ApplicationDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "FUEL_ANALYST";
    private static final int DB_VERSION = 1;

    public ApplicationDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(EventTable.getCreateQuery());
        sqLiteDatabase.execSQL(FuelingTable.getCreateQuery());
        sqLiteDatabase.execSQL(PartsTypeTable.getCreateQuery());
        sqLiteDatabase.execSQL(ReminderTable.getCreateQuery());
        sqLiteDatabase.execSQL(VehicleTable.getCreateQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long save(SQLiteDatabase db, ContentValues values, String tableName) {
        return db.insert(tableName, null, values);
    }

    public void modify(SQLiteDatabase db, ContentValues values, String tableName, String whereClause, String... whereArgs) {
        db.update(tableName, values, whereClause, whereArgs);
    }

    public int delete(SQLiteDatabase db, String tableName, String whereClause, String... whereArgs) {
        return db.delete(tableName, whereClause, whereArgs);
    }

    public Cursor find(SQLiteDatabase db, String tableName, String[] columns, String whereClause, String[] whereArgs,
                       String groupby, String having, String orderBy) {
        return db.query(tableName, columns, whereClause, whereArgs, groupby, having, orderBy);
    }
}
