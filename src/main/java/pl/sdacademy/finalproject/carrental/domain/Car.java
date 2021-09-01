package pl.sdacademy.finalproject.carrental.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @Column(name = "plate_number")
    @NotBlank
    private String plateNumber;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @Column(name = "body_type" )
    @NotBlank
    private String bodyType;

    @Column(name = "production_year")
    @NotNull
    private Integer productionYear;

    @NotBlank
    private String colour;

    @Min(0)
    @NotNull
    private Integer mileage;

    @Min(0)
    @NotNull
    private BigDecimal cost;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @OneToMany
    @JoinColumn (name = "car_plate_number")
    private Set<CarRental> rentals;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    private RentalBranch carBranch;


}
