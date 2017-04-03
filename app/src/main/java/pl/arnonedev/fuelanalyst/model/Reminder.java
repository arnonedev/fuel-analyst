package pl.arnonedev.fuelanalyst.model;

import java.util.Date;

/**
 * Created by Arek on 2017-03-26.
 */
public class Reminder {
    private long id;
    private Date date;
    private int dateRepeating;
    private int odometer;
    private int odometerRepeating;
    private String description;
    private Vehicle vehicle;

    public Reminder() {}

    public Reminder(Date date, int dateRepeating, int odometer, int odometerRepeating, String description, Vehicle vehicle) {
        this.date = date;
        this.dateRepeating = dateRepeating;
        this.odometer = odometer;
        this.odometerRepeating = odometerRepeating;
        this.description = description;
        this.vehicle = vehicle;
    }

    public Reminder(long id, Date date, int dateRepeating, int odometer, int odometerRepeating, String description, Vehicle vehicle) {
        this.id = id;
        this.date = date;
        this.dateRepeating = dateRepeating;
        this.odometer = odometer;
        this.odometerRepeating = odometerRepeating;
        this.description = description;
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reminder reminder = (Reminder) o;

        return id == reminder.id;
    }

    @Override
    public int hashCode() {
        return (int)id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDateRepeating() {
        return dateRepeating;
    }

    public void setDateRepeating(int dateRepeating) {
        this.dateRepeating = dateRepeating;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public int getOdometerRepeating() {
        return odometerRepeating;
    }

    public void setOdometerRepeating(int odometerRepeating) {
        this.odometerRepeating = odometerRepeating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", date=" + date +
                ", dateRepeating=" + dateRepeating +
                ", odometer=" + odometer +
                ", odometerRepeating=" + odometerRepeating +
                ", description='" + description + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
