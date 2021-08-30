package pl.sdacademy.finalproject.carrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.finalproject.carrental.domain.RentalBranch;

public interface RentalBranchRepository extends JpaRepository<RentalBranch, Integer> {
}
