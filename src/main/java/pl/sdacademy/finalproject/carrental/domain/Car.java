package pl.sdacademy.finalproject.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    //@Column(name = "plate_number")
    private String plateNumber;
    private String brand;
    private String model;
   // @Column(name = "body_type" )
    private String bodyType;
   // @Column(name = "production_year")
    private Integer productionYear;
    private String colour;
    @Enumerated(EnumType.STRING)
    private CarRentStatus status;
    private Integer mileage;
    private BigDecimal cost;


}
