package pl.sdacademy.finalproject.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CarRental {

    @Id
    @SequenceGenerator(
            name = "generator",
            sequenceName = "generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "generator"
    )
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal price;
    @ManyToOne
    private Car car;

    public CarRental(LocalDate startDate, LocalDate endDate, BigDecimal price, Car car) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.car = car;
    }
}
