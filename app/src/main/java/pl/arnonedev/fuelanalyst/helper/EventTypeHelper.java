package pl.arnonedev.fuelanalyst.helper;

import pl.arnonedev.fuelanalyst.model.EventType;

/**
 * Created by Arek on 2017-04-30.
 */
public class EventTypeHelper {
    private EventTypeHelper() {}

    public static EventType getEventTypeById(int id) {
        EventType[] eventTypes = EventType.values();
        for (EventType eventType : eventTypes) {
            if (eventType.getDbId() == id) {
                return eventType;
            }
        }
        return null;
    }

    public static EventType getEventTypeByIndex(int index) {
        EventType[] eventTypes = EventType.values();
        for (EventType eventType : eventTypes) {
            if (eventType.getArrayIndex() == index) {
                return eventType;
            }
        }
        return null;
    }
}
