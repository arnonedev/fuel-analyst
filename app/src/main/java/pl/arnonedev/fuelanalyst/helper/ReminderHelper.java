package pl.arnonedev.fuelanalyst.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import pl.arnonedev.fuelanalyst.model.Reminder;
import pl.arnonedev.fuelanalyst.persistence.table.ReminderTable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arek on 2017-04-30.
 */
public class ReminderHelper extends DatabaseModelHelper<Reminder> {
    private SimpleDateFormat dateFormat;

    public ReminderHelper(AppCompatActivity activity) {
        super(activity);
        dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    }

    @Override
    public Reminder save(Reminder reminder) {
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            ContentValues values = getContentValuesFromReminder(reminder);
            long reminderId = applicationDatabaseHelper.save(database, values, ReminderTable.TABLE_NAME);
            reminder.setId(reminderId);
            database.close();
        } catch (SQLiteException exception) {
            Log.e(ReminderHelper.class.getName(), "Save reminder error " + exception);
        }
        return reminder;
    }

    @Override
    public Reminder refresh(Reminder reminder) {
        Reminder refreshedReminder = null;
        try {
            database = this.applicationDatabaseHelper.getReadableDatabase();
            Cursor cursor = applicationDatabaseHelper.find(database, ReminderTable.TABLE_NAME, ReminderTable.COLUMNS, "_id = ?",
                    new String[]{Integer.toString((int) reminder.getId())}, null, null, null);
            if (cursor.moveToFirst()) {
                refreshedReminder = getReminderFromCursor(cursor);
            }
            database.close();
            cursor.close();
        } catch (SQLException | ParseException e) {
            Log.e(ReminderHelper.class.getName(), "Refresh reminder error " + e);
        }
        return refreshedReminder == null ? reminder : refreshedReminder;
    }

    @Override
    public Reminder modify(Reminder reminder) {
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            ContentValues values = getContentValuesFromReminder(reminder);
            applicationDatabaseHelper.modify(database, values, ReminderTable.TABLE_NAME, "+id = ?", Long.toString(reminder.getId()));
            database.close();
        } catch (SQLException e) {
            Log.e(ReminderHelper.class.getName(), "Modify reminder error " + e);
        }
        return reminder;
    }

    @Override
    public Reminder find(int id) {
        Reminder foundedReminder = null;
        try {
            database = this.applicationDatabaseHelper.getReadableDatabase();
            Cursor cursor = applicationDatabaseHelper.find(database, ReminderTable.TABLE_NAME, ReminderTable.COLUMNS, "_id = ?",
                    new String[]{Integer.toString(id)}, null, null, null);
            if (cursor.moveToFirst()) {
                foundedReminder = getReminderFromCursor(cursor);
            }
            database.close();
            cursor.close();
        } catch (SQLException | ParseException e) {
            Log.e(ReminderHelper.class.getName(), "Find reminder error " + e);
        }
        return foundedReminder;
    }

    @Override
    public List<Reminder> findAll() {
        List<Reminder> foundedReminders = new ArrayList<>();
        try {
            database = this.applicationDatabaseHelper.getReadableDatabase();
            Cursor cursor = applicationDatabaseHelper.find(database, ReminderTable.TABLE_NAME, ReminderTable.COLUMNS, null,
                    null, null, null, null);
            while (cursor.moveToNext()) {
                foundedReminders.add(getReminderFromCursor(cursor));
            }
            database.close();
            cursor.close();
        } catch (SQLException | ParseException e) {
            Log.e(ReminderHelper.class.getName(), "Find reminders error " + e);
        }
        return foundedReminders;
    }

    @Override
    public boolean delete(Reminder reminder) {
        int result = 0;
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            result = applicationDatabaseHelper.delete(database, ReminderTable.TABLE_NAME, "_id = ?", Long.toString(reminder.getId()));
            database.close();
        } catch (SQLException e) {
            Log.e(ReminderHelper.class.getName(), "Delete reminder error " + e);
        }
        return result != 0;
    }

    private ContentValues getContentValuesFromReminder(Reminder reminder) {
        ContentValues result = new ContentValues();
        result.put(ReminderTable.ID_VEHICLE_COLUMN, reminder.getVehicle().getId());
        result.put(ReminderTable.DATE_COLUMN, dateFormat.format(reminder.getDate()));
        result.put(ReminderTable.DATE_REPEATING_COLUMN, reminder.getDateRepeating());
        result.put(ReminderTable.ODOMETER_COLUMN, reminder.getOdometer());
        result.put(ReminderTable.ODOMETER_REPEATING_COLUMN, reminder.getOdometerRepeating());
        result.put(ReminderTable.DESCRIPTION_COLUMN, reminder.getDescription());
        return result;
    }

    private Reminder getReminderFromCursor(Cursor cursor) throws ParseException {
        VehicleHelper vehicleHelper = new VehicleHelper(activity);
        Reminder result = new Reminder();
        result.setId(cursor.getInt(0));
        result.setVehicle(vehicleHelper.find(cursor.getInt(1)));
        result.setDate(dateFormat.parse(cursor.getString(2)));
        result.setDateRepeating(cursor.getInt(3));
        result.setOdometer(cursor.getInt(4));
        result.setOdometerRepeating(cursor.getInt(5));
        result.setDescription(cursor.getString(6));
        return result;
    }
}
