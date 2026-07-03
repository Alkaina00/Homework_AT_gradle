package ru.alfa.homework12.error;

public class ConveyorBeltMalfunctionError extends Error {
    public ConveyorBeltMalfunctionError() {
        super("Критическая ситуация, блокирующая работу пункта приема багажа");
    }
}
