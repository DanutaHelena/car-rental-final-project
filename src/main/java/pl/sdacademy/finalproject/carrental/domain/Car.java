package pl.sdacademy.finalproject.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    //@Column(name = "plate_number")
    @NotBlank
    private String plateNumber;
    @NotBlank
    private String brand;
    private String model;
   // @Column(name = "body_type" )
    private String bodyType;
   // @Column(name = "production_year")
    private Integer productionYear;
    private String colour;
    @Enumerated(EnumType.STRING)
    private CarRentStatus status;
    @Min(0)
    @NotNull
    private Integer mileage;
    private BigDecimal cost;


}
