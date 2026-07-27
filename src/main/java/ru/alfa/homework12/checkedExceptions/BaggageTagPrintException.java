package ru.alfa.homework12.checkedExceptions;

public class BaggageTagPrintException extends AirportServiceException {
    public BaggageTagPrintException() {
        super("Не получилось напечатать багажную бирку");
    }
}
