package pl.sdacademy.finalproject.carrental.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CarRentalRepository extends JpaRepository<RentCar, Integer> {


}
