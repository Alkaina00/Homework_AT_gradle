package ru.alfa.homework12.checkedExceptions;

public class OverweightBaggageException extends AirportServiceException {
    public OverweightBaggageException() {
        super("Багаж слишком тяжелый");
    }
}
