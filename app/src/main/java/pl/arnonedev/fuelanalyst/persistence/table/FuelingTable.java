package pl.arnonedev.fuelanalyst.persistence.table;

/**
 * Created by Arek on 2017-03-27.
 */
public class FuelingTable {
    public static final String TABLE_NAME = "FUELING";
    public static final String ID_COLUMN = "_id";
    public static final String ID_VEHICLE_COLUMN = "ID_VEHICLE";
    public static final String DATE_COLUMN = "DATE";
    public static final String ODOMETER_COLUMN = "ODOMETER";
    public static final String TRIP_COLUMN = "TRIP";
    public static final String QUANTITY_COLUMN = "QUANTITY";
    public static final String FULL_FUELING_COLUMN = "FULL_FUELING";
    public static final String ID_FUEL_TYPE_COLUMN = "ID_FUEL_TYPE";
    public static final String COST_COLUMN = "COST";
    public static final String ID_TIRES_COLUMN = "ID_TIRES";
    public static final String ID_DRIVING_STYLE_COLUMN = "ID_DRIVING_STYLE";
    public static final String ID_ROUTES_COLUMN = "ID_ROUTES";
    public static final String EXTRAS_COLUMN = "EXTRAS";
    public static final String AVERAGE_COMBUSTION_COLUMN = "AVERAGE_COMBUSTION";
    public static final String FUEL_UNIT_COST_COLUMN = "FUEL_UNIT_COST";

    public static final String[] COLUMNS = {
            ID_COLUMN, ID_VEHICLE_COLUMN, DATE_COLUMN, ODOMETER_COLUMN, TRIP_COLUMN, QUANTITY_COLUMN, FULL_FUELING_COLUMN,
            ID_FUEL_TYPE_COLUMN, COST_COLUMN, ID_TIRES_COLUMN, ID_DRIVING_STYLE_COLUMN, ID_ROUTES_COLUMN,
            EXTRAS_COLUMN, AVERAGE_COMBUSTION_COLUMN, FUEL_UNIT_COST_COLUMN
    };

    private FuelingTable() {}

    public static String getCreateQuery() {
        return "CREATE TABLE " + TABLE_NAME + " (" + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ID_VEHICLE_COLUMN + " INTEGER, " +
                DATE_COLUMN + " NUMBER, " +
                ODOMETER_COLUMN + " INTEGER, " +
                TRIP_COLUMN + " REAL, " +
                QUANTITY_COLUMN + " REAL, " +
                FULL_FUELING_COLUMN + " NUMBER, " +
                ID_FUEL_TYPE_COLUMN + " INTEGER, " +
                COST_COLUMN + " REAL, " +
                ID_TIRES_COLUMN + " INTEGER, " +
                ID_DRIVING_STYLE_COLUMN + " INTEGER, " +
                ID_ROUTES_COLUMN + " INTEGER, " +
                EXTRAS_COLUMN + " TEXT, " +
                AVERAGE_COMBUSTION_COLUMN + " REAL, " +
                FUEL_UNIT_COST_COLUMN + " REAL);";
    }
}
