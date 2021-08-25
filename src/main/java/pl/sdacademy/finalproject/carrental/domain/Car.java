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
    @NotBlank
    private String model;
   // @Column(name = "body_type" )
    @NotBlank
    private String bodyType;
   // @Column(name = "production_year")
   // @NotBlank
    private Integer productionYear;
    @NotBlank
    private String colour;
    @Enumerated(EnumType.STRING)
    @NotBlank
    private CarRentStatus status;
    @Min(0)
    @NotNull
    @NotBlank
    private Integer mileage;
    @NotBlank
    @Min(0)
    @NotNull
    private BigDecimal cost;


}
