package pl.arnonedev.fuelanalyst.persistence.table;

/**
 * Created by Arek on 2017-03-27.
 */
public class VehicleTable {
    public static final String TABLE_NAME = "VEHICLE";
    public static final String ID_COLUMN = "_id";
    public static final String MAKE_COLUMN = "MAKE";
    public static final String MODEL_COLUMN = "MODEL";
    public static final String YEAR_OF_MANUFACTURE_COLUMN = "YEAR_OF_MANUFACTURE";
    public static final String ID_FUEL_TYPE_COLUMN = "ID_FUEL_TYPE";
    public static final String WEIGHT_COLUMN = "WEIGHT";
    public static final String LICENSE_NUMBER_COLUMN = "LICENSE_NUMBER";
    public static final String POWER_COLUMN = "POWER";
    public static final String ENGINE_CAPACITY_COLUMN = "ENGINE_CAPACITY";
    public static final String ODOMETER_COLUMN = "ODOMETER";
    public static final String ID_TRANSMISSION_COLUMN = "ID_TRANSMISSION";
    public static final String ID_ODOMETER_UNIT_COLUMN = "ID_ODOMETER_UNIT";
    public static final String ID_BODY_TYPE_COLUMN = "ID_BODY_TYPE";

    public static final String[] COLUMNS = {
            ID_COLUMN, MAKE_COLUMN, MODEL_COLUMN, YEAR_OF_MANUFACTURE_COLUMN, ID_FUEL_TYPE_COLUMN, WEIGHT_COLUMN,
            LICENSE_NUMBER_COLUMN, POWER_COLUMN, ENGINE_CAPACITY_COLUMN, ODOMETER_COLUMN, ID_TRANSMISSION_COLUMN,
            ID_ODOMETER_UNIT_COLUMN, ID_BODY_TYPE_COLUMN
    };

    private VehicleTable() {}

    public static String getCreateQuery() {
        return "CREATE TABLE " + TABLE_NAME + " (" + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MAKE_COLUMN + " TEXT, " +
                MODEL_COLUMN + " TEXT, " +
                YEAR_OF_MANUFACTURE_COLUMN + " INTEGER, " +
                ID_FUEL_TYPE_COLUMN + " INTEGER, " +
                WEIGHT_COLUMN + " INTEGER, " +
                LICENSE_NUMBER_COLUMN + " TEXT, " +
                POWER_COLUMN + " INTEGER, " +
                ENGINE_CAPACITY_COLUMN + " INTEGER, " +
                ODOMETER_COLUMN + " INTEGER, " +
                ID_TRANSMISSION_COLUMN + " INTEGER, " +
                ID_ODOMETER_UNIT_COLUMN + " INTEGER, " +
                ID_BODY_TYPE_COLUMN + " INTEGER);";
    }
}
