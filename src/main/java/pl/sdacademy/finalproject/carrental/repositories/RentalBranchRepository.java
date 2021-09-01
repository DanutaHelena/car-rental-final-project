package pl.sdacademy.finalproject.carrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sdacademy.finalproject.carrental.domain.RentalBranch;

import java.util.Optional;

public interface RentalBranchRepository extends JpaRepository<RentalBranch, String> {
    @Query("SELECT rb from RentalBranch rb left join fetch rb.cars where rb.city = :city")
    Optional<RentalBranch> findByIdWithCars(@Param("city") String city);
    }
