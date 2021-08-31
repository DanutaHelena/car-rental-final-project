package pl.sdacademy.finalproject.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalBranch {
    @Id
    @NotBlank
    private String city;

    @NotBlank
    private String address;

    @OneToMany
    @JoinColumn(name = "car_plate_number")
    private Set<Car> cars;
}
