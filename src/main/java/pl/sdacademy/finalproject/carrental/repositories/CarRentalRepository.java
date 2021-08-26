package pl.sdacademy.finalproject.carrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sdacademy.finalproject.carrental.domain.CarRental;

import java.time.LocalDate;
import java.util.List;


public interface CarRentalRepository extends JpaRepository<CarRental, Integer> {
    @Query("SELECT cr from CarRental cr where cr.startDate < :startDate and cr.endDate > :endDate or" +
            " cr.startDate < :startDate and cr.endDate < :endDate or" +
            " cr.startDate > :startDate and cr.endDate < :endDate or" +
            " cr.startDate > :startDate and cr.endDate > :endDate")
    List<CarRental> findRentalsInDateRange(@Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate);


}
