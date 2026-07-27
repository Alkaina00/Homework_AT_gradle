package ru.alfa.homework12;

import ru.alfa.homework12.checkedExceptions.AirportServiceException;
import ru.alfa.homework12.checkedExceptions.BaggageTagPrintException;
import ru.alfa.homework12.checkedExceptions.FlightNotFoundException;
import ru.alfa.homework12.checkedExceptions.OverweightBaggageException;
import ru.alfa.homework12.error.ConveyorBeltMalfunctionError;
import ru.alfa.homework12.uncheckedExceptions.InvalidBaggageWeightException;
import ru.alfa.homework12.uncheckedExceptions.InvalidPassengerNameException;

public class App {
    public static void main(String[] args) {
        String[] flights = { "SU-123", "TK-777", "KC-909", "AE-404" };

        BaggageDropDesk baggageDropDesk = new BaggageDropDesk(flights);

        try {
            baggageDropDesk.checkInBaggage("Anna", "SU-123", 10);
//            baggageDropDesk.checkInBaggage("Anna", "XX-999", 10); // FlightNotFoundException
//            baggageDropDesk.checkInBaggage("Anna", "SU-123", 30); // OverweightBaggageException
//            baggageDropDesk.checkInBaggage("Anna", "ERR-123", 10); // BaggageTagPrintException
            baggageDropDesk.checkInBaggage("", "SU-123", 10); // InvalidPassengerNameException
//            baggageDropDesk.checkInBaggage("Anna", "SU-123", -5); // InvalidBaggageWeightException
        } catch (InvalidPassengerNameException e) {
            System.out.println(e.getMessage());
        } catch (InvalidBaggageWeightException e) {
            System.out.println(e.getMessage());
        } catch (FlightNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println(e.getMessage());
        } catch (BaggageTagPrintException e) {
            System.out.println(e.getMessage());
        } catch (AirportServiceException e) {
            System.out.println("Ошибка сервиса аэропорта");
        }
    }
}
