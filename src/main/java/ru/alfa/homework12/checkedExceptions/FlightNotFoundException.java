package ru.alfa.homework12.checkedExceptions;

public class FlightNotFoundException extends AirportServiceException {
    public FlightNotFoundException() {
        super("Указанного рейса нет в списке доступных рейсов");
    }
}
