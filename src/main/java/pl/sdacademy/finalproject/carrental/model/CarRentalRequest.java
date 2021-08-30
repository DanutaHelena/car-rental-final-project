package pl.sdacademy.finalproject.carrental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRentalRequest {

    @NotBlank
    private String carPlateNumber;

    @NotNull
    @FutureOrPresent
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;
    
    @AssertTrue
    public boolean isEndDateValid() {
        if (startDate != null && endDate != null) {
            return endDate.isAfter(startDate);
        }
        return false;
    }
}

