package pl.sdacademy.finalproject.carrental.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    private BigDecimal price;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private Car car;

    public CarRental(LocalDate startDate, LocalDate endDate, BigDecimal price, Car car) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.car = car;
    }
}
