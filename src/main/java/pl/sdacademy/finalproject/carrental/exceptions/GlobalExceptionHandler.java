package pl.sdacademy.finalproject.carrental.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handle(NotFoundException exception){
        return new Error(exception.getMessage());
    }
    @ExceptionHandler(CarAlreadyAssignedToBranchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handle(CarAlreadyAssignedToBranchException exception){
        return new Error(exception.getMessage());
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handle(Exception exception){
        return new Error("Unexpected error");
    }

}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Error {
    private String message;

}
