package pl.sdacademy.finalproject.carrental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRentalRequest {

    private String carPlateNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal price;

}
