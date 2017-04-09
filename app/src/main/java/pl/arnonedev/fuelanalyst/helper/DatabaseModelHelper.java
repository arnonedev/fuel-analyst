package pl.arnonedev.fuelanalyst.helper;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import pl.arnonedev.fuelanalyst.model.Vehicle;
import pl.arnonedev.fuelanalyst.persistence.ApplicationDatabaseHelper;

import java.util.List;

/**
 * Created by Arek on 2017-03-27.
 */
public abstract class DatabaseModelHelper<T> {
    protected AppCompatActivity activity = null;
    protected ApplicationDatabaseHelper applicationDatabaseHelper = null;
    protected SQLiteDatabase database = null;

    public DatabaseModelHelper(AppCompatActivity activity) {
        this.activity = activity;
        this.applicationDatabaseHelper = new ApplicationDatabaseHelper(activity);
    }

    abstract T save(T t);
    abstract T refresh(T t);
    abstract T modify(T t);
    abstract T find(int id);
    abstract List<T> findAll();
    abstract boolean delete(T t);
}
