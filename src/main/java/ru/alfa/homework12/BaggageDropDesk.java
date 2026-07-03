package ru.alfa.homework12;

import ru.alfa.homework12.checkedExceptions.AirportServiceException;
import ru.alfa.homework12.checkedExceptions.BaggageTagPrintException;
import ru.alfa.homework12.checkedExceptions.FlightNotFoundException;
import ru.alfa.homework12.checkedExceptions.OverweightBaggageException;
import ru.alfa.homework12.uncheckedExceptions.InvalidBaggageWeightException;
import ru.alfa.homework12.uncheckedExceptions.InvalidPassengerNameException;

public class BaggageDropDesk {
    private String[] flights;

    public BaggageDropDesk(String[] flights) {
        this.flights = flights;
    }

    public BaggageTicket checkInBaggage(String namePassenger, String numFlight, int weightBaggage) throws AirportServiceException {
        boolean namePassengerUncorrected = namePassenger == null || namePassenger.isEmpty();
        boolean weightBaggageUncorrected = weightBaggage < 0;
        boolean weightBaggageOver = weightBaggage > 23;
        boolean flightNumError = numFlight.equals("AE-404");

        boolean flightsContains = false;
        for(String flight: flights) {
            if(flight.equals(numFlight)) {
                flightsContains = true;
                break;
            }
        }


        if(namePassengerUncorrected)
            throw new InvalidPassengerNameException();
        else if(weightBaggageUncorrected)
            throw new InvalidBaggageWeightException();
        else if(!flightsContains)
            throw new FlightNotFoundException();
        else if (weightBaggageOver)
            throw new OverweightBaggageException();
        else if(flightNumError)
            throw new BaggageTagPrintException();
        else return new BaggageTicket(namePassenger, numFlight, weightBaggage);
    }
}
