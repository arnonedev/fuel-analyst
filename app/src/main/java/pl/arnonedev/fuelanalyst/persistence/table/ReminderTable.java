package pl.arnonedev.fuelanalyst.persistence.table;

/**
 * Created by Arek on 2017-03-27.
 */
public class ReminderTable {
    public static final String TABLE_NAME = "REMINDER";
    public static final String ID_COLUMN = "_id";
    public static final String ID_VEHICLE_COLUMN = "ID_VEHICLE";
    public static final String DATE_COLUMN = "DATE";
    public static final String DATE_REPEATING_COLUMN = "DATE_REPEATING";
    public static final String ODOMETER_COLUMN = "ODOMETER";
    public static final String ODOMETER_REPEATING_COLUMN = "ODOMETER_REPEATING";
    public static final String DESCRIPTION_COLUMN = "DESCRIPTION";

    private ReminderTable() {}

    public static String getCreateQuery() {
        return "CREATE TABLE " + TABLE_NAME + " (" + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINKREMENT, " +
                ID_VEHICLE_COLUMN + " INTEGER, " +
                DATE_COLUMN + " NUMBER, " +
                DATE_REPEATING_COLUMN + " INTEGER, " +
                ODOMETER_COLUMN + " INTEGER, " +
                ODOMETER_REPEATING_COLUMN + " INTEGER, " +
                DESCRIPTION_COLUMN + " TEXT);";
    }
}
