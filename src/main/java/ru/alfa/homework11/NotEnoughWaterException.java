package ru.alfa.homework11;

public class NotEnoughWaterException extends RuntimeException {
    public NotEnoughWaterException(String messageError) {
        super(messageError);
    }
}
