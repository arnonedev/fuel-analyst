package pl.arnonedev.fuelanalyst.persistence.table;

/**
 * Created by Arek on 2017-03-27.
 */
public class EventTable {
    public static final String TABLE_NAME = "EVENT";
    public static final String ID_COLUMN = "_id";
    public static final String ID_VEHICLE_COLUMN = "ID_VEHICLE";
    public static final String ID_EVENT_TYPE_COLUMN = "ID_EVENT_TYPE";
    public static final String DATE_COLUMN = "DATE";
    public static final String REMINDER_COLUMN = "REMINDER";
    public static final String DESCRIPTION_COLUMN = "DESCRIPTION";

    private EventTable() {}

    public static String getCreateQuery() {
        return "CREATE TABLE " + TABLE_NAME + " (" + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINKREMENT, " +
                ID_VEHICLE_COLUMN + " INTEGER, " +
                ID_EVENT_TYPE_COLUMN + " INTEGER, " +
                DATE_COLUMN + " NUMBER, " +
                REMINDER_COLUMN + " NUMBER, " +
                DESCRIPTION_COLUMN + " TEXT);";
    }
}
