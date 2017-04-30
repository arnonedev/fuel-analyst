package pl.arnonedev.fuelanalyst.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import pl.arnonedev.fuelanalyst.model.Event;
import pl.arnonedev.fuelanalyst.persistence.table.EventTable;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arek on 2017-04-30.
 */
public class EventHelper extends DatabaseModelHelper<Event> {
    public EventHelper(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public Event save(Event event) {
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            ContentValues values = getContentValuesFromEvent(event);
            long eventId = applicationDatabaseHelper.save(database, values, EventTable.TABLE_NAME);
            event.setId(eventId);
            database.close();
        } catch (SQLiteException e) {
            Log.e(EventHelper.class.getName(), "Save event error " + e);
        }
        return event;
    }

    @Override
    public Event refresh(Event event) {
        Event refreshedEvent = null;
        try {
            database = applicationDatabaseHelper.getReadableDatabase();
            Cursor cursor = applicationDatabaseHelper.find(database, EventTable.TABLE_NAME, EventTable.COLUMNS, "_id = ?",
                    new String[]{Long.toString(event.getId())}, null, null, null);
            if (cursor.moveToFirst()) {
                refreshedEvent = getEventFromCursor(cursor);
            }
            database.close();
            cursor.close();
        } catch (SQLiteException | ParseException e) {
            Log.e(EventHelper.class.getName(), "Refresh event error " + e);
        }
        return refreshedEvent == null ? event : refreshedEvent;
    }

    @Override
    public Event modify(Event event) {
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            ContentValues values = getContentValuesFromEvent(event);
            applicationDatabaseHelper.modify(database, values, EventTable.TABLE_NAME, "_id = ?", Long.toString(event.getId()));
            database.close();
        } catch (SQLiteException e) {
            Log.e(EventHelper.class.getName(), "Modify event error " + e);
        }
        return event;
    }

    @Override
    public Event find(int id) {
        Event foundedEvent = null;
        try {
            database = this.applicationDatabaseHelper.getReadableDatabase();
            Cursor cursor = applicationDatabaseHelper.find(database, EventTable.TABLE_NAME, EventTable.COLUMNS, "_id = ?",
                    new String[]{Integer.toString(id)}, null, null, null);
            if (cursor.moveToFirst()) {
                foundedEvent = getEventFromCursor(cursor);
            }
            database.close();
            cursor.close();
        } catch (SQLiteException | ParseException e) {
            Log.e(EventHelper.class.getName(), "Find event error " + e);
        }
        return foundedEvent;
    }

    @Override
    public List<Event> findAll() {
        List<Event> foundedEvents = new ArrayList<>();
        try {
            database = this.applicationDatabaseHelper.getReadableDatabase();
            Cursor cursor = applicationDatabaseHelper.find(database, EventTable.TABLE_NAME, EventTable.COLUMNS, null,
                    null, null, null, null);
            while (cursor.moveToNext()) {
                foundedEvents.add(getEventFromCursor(cursor));
            }
            database.close();
            cursor.close();
        } catch (SQLiteException | ParseException e) {
            Log.e(EventHelper.class.getName(), "Find events error " + e);
        }
        return foundedEvents;
    }

    @Override
    public boolean delete(Event event) {
        int result = 0;
        try {
            database = this.applicationDatabaseHelper.getWritableDatabase();
            result = applicationDatabaseHelper.delete(database, EventTable.TABLE_NAME, "_id = ?", Long.toString(event.getId()));
            database.close();
        } catch (SQLiteException e) {
            Log.e(EventHelper.class.getName(), "Delete event error " + e);
        }
        return result != 0;
    }

    private ContentValues getContentValuesFromEvent(Event event) {
        ContentValues result = new ContentValues();
        result.put(EventTable.ID_VEHICLE_COLUMN, event.getVehicle().getId());
        result.put(EventTable.ID_EVENT_TYPE_COLUMN, event.getEventType().getDbId());
        result.put(EventTable.DATE_COLUMN, dateFormat.format(event.getDate()));
        result.put(EventTable.REMINDER_COLUMN, event.isReminder());
        result.put(EventTable.DESCRIPTION_COLUMN, event.getDescription());
        return result;
    }

    private Event getEventFromCursor(Cursor cursor) throws ParseException {
        VehicleHelper vehicleHelper = new VehicleHelper(activity);
        Event result = new Event();
        result.setId(cursor.getInt(0));
        result.setVehicle(vehicleHelper.find(cursor.getInt(1)));
        result.setEventType(EventTypeHelper.getEventTypeById(cursor.getInt(2)));
        result.setDate(dateFormat.parse(cursor.getString(3)));
        result.setReminder(cursor.getInt(4) > 0);
        result.setDescription(cursor.getString(5));
        return result;
    }
}
