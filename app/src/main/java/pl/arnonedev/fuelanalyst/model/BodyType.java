package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum BodyType {
    SEDAN("Sedan", 20, 3),
    COUPE("Coupe", 18, 1),
    CABRIO("Cabriolet", 17, 0),
    COMBI("Combi", 19, 2),
    HATCHBACK("Hatchback", 24, 7),
    LIFTBACK("Liftback", 25, 8),
    PICKUP("Pick-up", 29, 12),
    SUV("SUV", 21, 4),
    MINIVAN("Minivan", 28, 11),
    LIMOUSINE("Limousine", 26, 9),
    ROADSTER("Roadster", 30, 13),
    VAN("Van", 32, 15),
    DUAL_COWL("Dual cowl", 22, 5),
    FASTBACK("Fastback", 23, 6),
    MICROVAN("Microvan", 27, 10),
    TARGA("Targa", 31, 14);

    private String title;
    private int dbId;
    private int arrayIndex;

    BodyType(String title, int dbId, int arrayIndex) {
        this.title = title;
        this.dbId = dbId;
        this.arrayIndex = arrayIndex;
    }

    public String getTitle() {
        return title;
    }

    public int getDbId() {
        return dbId;
    }

    public int getArrayIndex() {
        return arrayIndex;
    }
}
