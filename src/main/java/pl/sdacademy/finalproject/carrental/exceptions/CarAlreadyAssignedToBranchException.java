package pl.sdacademy.finalproject.carrental.exceptions;

public class CarAlreadyAssignedToBranchException extends RuntimeException {
    public CarAlreadyAssignedToBranchException(String message) {
        super(message);
    }
}
