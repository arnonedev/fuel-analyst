package pl.arnonedev.fuelanalyst.persistence;

import android.content.Context;
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
}
