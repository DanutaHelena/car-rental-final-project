package pl.sdacademy.finalproject.carrental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.finalproject.carrental.domain.Car;
import pl.sdacademy.finalproject.carrental.domain.RentalBranch;
import pl.sdacademy.finalproject.carrental.exceptions.CarAlreadyAssignedToBranchException;
import pl.sdacademy.finalproject.carrental.exceptions.NotFoundException;
import pl.sdacademy.finalproject.carrental.repositories.CarRepository;
import pl.sdacademy.finalproject.carrental.repositories.RentalBranchRepository;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class RentalBranchService {

    private final RentalBranchRepository rentalBranchRepository;
    private final CarRepository carRepository;

    public RentalBranch findById(String city){
        return rentalBranchRepository.findById(city).orElseThrow(() ->
                new NotFoundException("Couldn't find localization"));
    }

    public RentalBranch addRentalBranch(RentalBranch rentalBranch) {
        return rentalBranchRepository.save(rentalBranch);
    }

    public RentalBranch updateRentalBranch(String city, RentalBranch rentalBranchToUpdate) {
        RentalBranch existingRentalBranch = rentalBranchRepository.findById(city).orElseThrow(()->
                new NotFoundException("Couldn't find branch by id: " + city));

        existingRentalBranch.setCity(rentalBranchToUpdate.getCity());
        existingRentalBranch.setAddress(rentalBranchToUpdate.getAddress());
        return existingRentalBranch;
    }

    public List<RentalBranch> getRentalBranchList() {
        return rentalBranchRepository.findAll();
    }

    public void removeRentalBranch(String city) {
        rentalBranchRepository.deleteById(city);
    }

    public RentalBranch addCarToBranch (String branchId, String carId) {
        RentalBranch branch = rentalBranchRepository.findByIdWithCars(branchId).orElseThrow(() ->
                new NotFoundException("Couldn't find branch"));
        boolean carAlreadyAssigned = branch.getCars().stream().anyMatch((car) -> car.getPlateNumber().equals(carId));
        if (carAlreadyAssigned) {
            throw new CarAlreadyAssignedToBranchException("Car with " + carId + " plate number is assinged to " + branchId);
        }
        Car car = carRepository.findById(carId).orElseThrow(() -> new NotFoundException("Car not found"));
        branch.getCars().add(car);
        //car.getCarBranch().getCity();
        return branch;
    }
}
