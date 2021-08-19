package pl.sdacademy.finalproject.carrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.finalproject.carrental.domain.Car;

public interface CarRepository extends JpaRepository<Car, String> {


}
