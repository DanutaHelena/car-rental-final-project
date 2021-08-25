package pl.sdacademy.finalproject.carrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import pl.sdacademy.finalproject.carrental.datalayer.RentCar;
import pl.sdacademy.finalproject.carrental.domain.CarRental;


public interface CarRentalRepository extends JpaRepository<CarRental, Integer> {


}
