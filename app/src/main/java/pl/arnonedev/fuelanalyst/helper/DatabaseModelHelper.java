package pl.arnonedev.fuelanalyst.helper;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import pl.arnonedev.fuelanalyst.persistence.ApplicationDatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Arek on 2017-03-27.
 */
public abstract class DatabaseModelHelper<T> {
    protected AppCompatActivity activity = null;
    protected ApplicationDatabaseHelper applicationDatabaseHelper = null;
    protected SQLiteDatabase database = null;
    protected SimpleDateFormat dateFormat;

    public DatabaseModelHelper(AppCompatActivity activity) {
        this.activity = activity;
        this.applicationDatabaseHelper = new ApplicationDatabaseHelper(activity);
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public abstract T save(T t);
    public abstract T refresh(T t);
    public abstract T modify(T t);
    public abstract T find(int id);
    public abstract List<T> findAll();
    public abstract List<T> findAllByVehicleId(int id);
    public abstract boolean delete(T t);
}
