package pl.arnonedev.fuelanalyst.model;

import java.util.Date;

/**
 * Created by Arek on 2017-03-26.
 */
public class Fueling {
    private int id;
    private Date date;
    private int odometer;
    private double trip;
    private double quantity;
    private boolean fullFueling;
    private double cost;
    private double average_consumption;
    private double fuelUnitCost;
    private String extras;
    private DrivingStyle drivingStyle;
    private RoutesType routesType;
    private Car car;
    private TireType tireType;

    public Fueling() {}

    public Fueling(Date date, int odometer, double trip, double quantity, boolean fullFueling, double cost, double average_consumption, double fuelUnitCost, String extras, DrivingStyle drivingStyle, RoutesType routesType, Car car, TireType tireType) {
        this.date = date;
        this.odometer = odometer;
        this.trip = trip;
        this.quantity = quantity;
        this.fullFueling = fullFueling;
        this.cost = cost;
        this.average_consumption = average_consumption;
        this.fuelUnitCost = fuelUnitCost;
        this.extras = extras;
        this.drivingStyle = drivingStyle;
        this.routesType = routesType;
        this.car = car;
        this.tireType = tireType;
    }

    public Fueling(int id, Date date, int odometer, double trip, double quantity, boolean fullFueling, double cost, double average_consumption, double fuelUnitCost, String extras, DrivingStyle drivingStyle, RoutesType routesType, Car car, TireType tireType) {
        this.id = id;
        this.date = date;
        this.odometer = odometer;
        this.trip = trip;
        this.quantity = quantity;
        this.fullFueling = fullFueling;
        this.cost = cost;
        this.average_consumption = average_consumption;
        this.fuelUnitCost = fuelUnitCost;
        this.extras = extras;
        this.drivingStyle = drivingStyle;
        this.routesType = routesType;
        this.car = car;
        this.tireType = tireType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fueling fueling = (Fueling) o;

        return id == fueling.id;
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

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getTrip() {
        return trip;
    }

    public void setTrip(double trip) {
        this.trip = trip;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public boolean isFullFueling() {
        return fullFueling;
    }

    public void setFullFueling(boolean fullFueling) {
        this.fullFueling = fullFueling;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getAverage_consumption() {
        return average_consumption;
    }

    public void setAverage_consumption(double average_consumption) {
        this.average_consumption = average_consumption;
    }

    public double getFuelUnitCost() {
        return fuelUnitCost;
    }

    public void setFuelUnitCost(double fuelUnitCost) {
        this.fuelUnitCost = fuelUnitCost;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public DrivingStyle getDrivingStyle() {
        return drivingStyle;
    }

    public void setDrivingStyle(DrivingStyle drivingStyle) {
        this.drivingStyle = drivingStyle;
    }

    public RoutesType getRoutesType() {
        return routesType;
    }

    public void setRoutesType(RoutesType routesType) {
        this.routesType = routesType;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public TireType getTireType() {
        return tireType;
    }

    public void setTireType(TireType tireType) {
        this.tireType = tireType;
    }

    @Override
    public String toString() {
        return "Fueling{" +
                "id=" + id +
                ", date=" + date +
                ", odometer=" + odometer +
                ", trip=" + trip +
                ", quantity=" + quantity +
                ", fullFueling=" + fullFueling +
                ", cost=" + cost +
                ", average_consumption=" + average_consumption +
                ", fuelUnitCost=" + fuelUnitCost +
                ", extras='" + extras + '\'' +
                ", drivingStyle=" + drivingStyle +
                ", routesType=" + routesType +
                ", car=" + car +
                ", tireType=" + tireType +
                '}';
    }
}
