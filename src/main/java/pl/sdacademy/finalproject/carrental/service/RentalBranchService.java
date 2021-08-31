package pl.sdacademy.finalproject.carrental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.finalproject.carrental.domain.RentalBranch;
import pl.sdacademy.finalproject.carrental.exceptions.NotFoundException;
import pl.sdacademy.finalproject.carrental.repositories.CarRepository;
import pl.sdacademy.finalproject.carrental.repositories.RentalBranchRepository;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class RentalBranchService {

    private final RentalBranchRepository rentalBranchRepository;

    public RentalBranch findById(Integer id){
        return rentalBranchRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Couldn't find localization"));
    }

    public RentalBranch addRentalBranch(RentalBranch rentalBranch) {
        return rentalBranchRepository.save(rentalBranch);
    }

    public RentalBranch updateRentalBranch(Integer id, RentalBranch rentalBranchToUpdate) {
        RentalBranch existingRentalBranch = rentalBranchRepository.findById(id).orElseThrow(()->
                new NotFoundException("Couldn't find branch by id: " + id));

        existingRentalBranch.setCity(rentalBranchToUpdate.getCity());
        existingRentalBranch.setAddress(rentalBranchToUpdate.getAddress());
        return existingRentalBranch;
    }

    public List<RentalBranch> getRentalBranchList() {
        return rentalBranchRepository.findAll();
    }

    public void removeRentalBranch(Integer id) {
        rentalBranchRepository.deleteById(id);
    }

    public RentalBranch addCarToBranch (Integer branchId, String carId) {
        RentalBranch branch = rentalBranchRepository.findByIdWithCars(branchId).orElseThrow(()->
                new NotFoundException("Couldn't find cars"));
        branch.getCars().stream().anyMatch((car)-> car.getPlateNumber().equals(carId));
        branch.getCars().add(carRepository.getById(carId));

        return branch;
    }
}
