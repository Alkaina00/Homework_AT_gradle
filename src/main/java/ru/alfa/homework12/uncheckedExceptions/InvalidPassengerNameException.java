package ru.alfa.homework12.uncheckedExceptions;

public class InvalidPassengerNameException extends RuntimeException {
    public InvalidPassengerNameException() {
        super("Имя пассажира null или пустое");
    }
}
