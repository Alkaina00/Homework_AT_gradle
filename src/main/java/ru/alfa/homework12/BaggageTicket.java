package ru.alfa.homework12;

public class BaggageTicket {
    private String namePassenger;
    private String numFlight;
    private int weightBaggage;

    public BaggageTicket(String namePassenger, String numFlight, int weightBaggage) {
        this.namePassenger = namePassenger;
        this.numFlight = numFlight;
        this.weightBaggage = weightBaggage;
    }

    public String getNamePassenger() {
        return namePassenger;
    }

    public void setNamePassenger(String namePassenger) {
        this.namePassenger = namePassenger;
    }

    public String getNumFlight() {
        return numFlight;
    }

    public void setNumFlight(String numFlight) {
        this.numFlight = numFlight;
    }

    public int getWeightBaggage() {
        return weightBaggage;
    }

    public void setWeightBaggage(int weightBaggage) {
        this.weightBaggage = weightBaggage;
    }

    @Override
    public String toString() {
        return "Багажная бирка: \n" + "Имя пассажира: " + namePassenger + "\nНомер рейса: " + numFlight + "\nВес багажа: " + weightBaggage;
    }
}
