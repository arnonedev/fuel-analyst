package pl.arnonedev.fuelanalyst.model;

import java.util.Date;

/**
 * Created by Arek on 2017-03-26.
 */
public class Event {
    private long id;
    private boolean reminder;
    private String description;
    private Date date;
    private Vehicle vehicle;
    private EventType eventType;

    public Event() {}

    public Event(boolean reminder, String description, Date date, Vehicle vehicle, EventType eventType) {
        this.reminder = reminder;
        this.description = description;
        this.date = date;
        this.vehicle = vehicle;
        this.eventType = eventType;
    }

    public Event(long id, boolean reminder, String description, Date date, Vehicle vehicle, EventType eventType) {
        this.id = id;
        this.reminder = reminder;
        this.description = description;
        this.date = date;
        this.vehicle = vehicle;
        this.eventType = eventType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        return id == event.id;
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

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", reminder=" + reminder +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", vehicle=" + vehicle +
                ", eventType=" + eventType +
                '}';
    }
}
