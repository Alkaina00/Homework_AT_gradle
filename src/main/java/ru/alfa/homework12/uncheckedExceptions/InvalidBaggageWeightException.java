package ru.alfa.homework12.uncheckedExceptions;

public class InvalidBaggageWeightException extends RuntimeException {
    public InvalidBaggageWeightException() {
        super("Вес багажа меньше или равен нулю");
    }
}
