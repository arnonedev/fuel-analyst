package pl.arnonedev.fuelanalyst.model;

/**
 * Created by Arek on 2017-03-26.
 */
public enum BodyType {
    SEDAN("Sedan", 20),
    COUPE("Coupe", 18),
    CABRIO("Cabriolet", 17),
    COMBI("Combi", 19),
    HATCHBACK("Hatchback", 24),
    LIFTBACK("Liftback", 25),
    PICKUP("Pick-up", 29),
    SUV("SUV", 21),
    MINIVAN("Minivan", 28),
    LIMOUSINE("Limousine", 26),
    ROADSTER("Roadster", 30),
    VAN("Van", 32),
    DUAL_COWL("Dual cowl", 22),
    FASTBACK("Fastback", 23),
    MICROVAN("Microvan", 27),
    TARGA("Targa", 31);

    private String title;
    private int dbId;

    BodyType(String title, int dbId) {
        this.title = title;
        this.dbId = dbId;
    }

    public String getTitle() {
        return title;
    }

    public int getDbId() {
        return dbId;
    }
}
