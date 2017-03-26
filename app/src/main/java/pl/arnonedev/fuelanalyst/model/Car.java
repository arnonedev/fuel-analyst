package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public class Car {
    private int id;
    private String make;
    private String model;
    private int yearOfManufacture;
    private int weight;
    private String licenseNumber;
    private int power;
    private int engineCapacity;
    private int odometer;
    private FuelType fuelType;
    private TransmissionType transmissionType;
    private OdometerUnit odometerUnit;
    private BodyType bodyType;

    public Car() {}

    public Car(String make, String model, int yearOfManufacture, int weight, String licenseNumber, int power, int engineCapacity, int odometer, FuelType fuelType, TransmissionType transmissionType, OdometerUnit odometerUnit, BodyType bodyType) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.weight = weight;
        this.licenseNumber = licenseNumber;
        this.power = power;
        this.engineCapacity = engineCapacity;
        this.odometer = odometer;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.odometerUnit = odometerUnit;
        this.bodyType = bodyType;
    }

    public Car(int id, String make, String model, int yearOfManufacture, int weight, String licenseNumber, int power, int engineCapacity, int odometer, FuelType fuelType, TransmissionType transmissionType, OdometerUnit odometerUnit, BodyType bodyType) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.weight = weight;
        this.licenseNumber = licenseNumber;
        this.power = power;
        this.engineCapacity = engineCapacity;
        this.odometer = odometer;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.odometerUnit = odometerUnit;
        this.bodyType = bodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        return licenseNumber != null ? licenseNumber.equals(car.licenseNumber) : car.licenseNumber == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (licenseNumber != null ? licenseNumber.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public OdometerUnit getOdometerUnit() {
        return odometerUnit;
    }

    public void setOdometerUnit(OdometerUnit odometerUnit) {
        this.odometerUnit = odometerUnit;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", weight=" + weight +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", power=" + power +
                ", engineCapacity=" + engineCapacity +
                ", odometer=" + odometer +
                ", fuelType=" + fuelType +
                ", transmissionType=" + transmissionType +
                ", odometerUnit=" + odometerUnit +
                ", bodyType=" + bodyType +
                '}';
    }
}
