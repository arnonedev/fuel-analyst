package pl.arnonedev.fuelanalyst.persistence.table;

/**
 * Created by Arek on 2017-03-27.
 */
public class PartsTypeTable {
    public static final String TABLE_NAME = "PARTS_TYPE";
    public static final String ID_COLUMN = "_id";
    public static final String TYPE_COLUMN = "TYPE";
    public static final String PARTS_GROUP_COLUMN = "PARTS_GROUP";

    public static final String[] COLUMNS = {
            ID_COLUMN, TYPE_COLUMN, PARTS_GROUP_COLUMN
    };

    private PartsTypeTable() {}

    public static String getCreateQuery() {
        return "CREATE TABLE " + TABLE_NAME + " (" + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TYPE_COLUMN + " TEXT, " +
                PARTS_GROUP_COLUMN + " TEXT);";
    }
}
