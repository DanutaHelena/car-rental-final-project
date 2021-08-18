package pl.sdacademy.finalproject.carrental.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<RentCar, Integer> {


}
