package pl.arnonedev.fuelanalyst.model;

import java.util.Date;

/**
 * Created by Arek on 2017-03-26.
 */
public class Reminder {
    private int id;
    private Date date;
    private int dateRepeating;
    private int odometer;
    private int odometerRepeating;
    private String description;
    private Car car;

    public Reminder() {}

    public Reminder(Date date, int dateRepeating, int odometer, int odometerRepeating, String description, Car car) {
        this.date = date;
        this.dateRepeating = dateRepeating;
        this.odometer = odometer;
        this.odometerRepeating = odometerRepeating;
        this.description = description;
        this.car = car;
    }

    public Reminder(int id, Date date, int dateRepeating, int odometer, int odometerRepeating, String description, Car car) {
        this.id = id;
        this.date = date;
        this.dateRepeating = dateRepeating;
        this.odometer = odometer;
        this.odometerRepeating = odometerRepeating;
        this.description = description;
        this.car = car;
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
        return id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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
                ", car=" + car +
                '}';
    }
}
