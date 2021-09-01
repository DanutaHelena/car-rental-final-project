package pl.sdacademy.finalproject.carrental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.finalproject.carrental.domain.RentalBranch;
import pl.sdacademy.finalproject.carrental.service.RentalBranchService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/rental-branches")
public class RentalBranchController {

    private final RentalBranchService rentalBranchService;

    public RentalBranchController(RentalBranchService rentalBranchService) {
        this.rentalBranchService = rentalBranchService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RentalBranch addRentalBranch(@Valid @RequestBody RentalBranch rentalBranch) {
        return rentalBranchService.addRentalBranch(rentalBranch);
    }
    @PutMapping("/{city}")
    public RentalBranch updateRentalBranch(@PathVariable String city, @Valid @RequestBody RentalBranch rentalBranch){
        return rentalBranchService.updateRentalBranch(city, rentalBranch);
    }
    @DeleteMapping("/{city}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeRentalBranch(@PathVariable String city){
        rentalBranchService.removeRentalBranch(city);
    }

    @GetMapping
    public List<RentalBranch> rentalBranchList(){
        return rentalBranchService.getRentalBranchList();
    }

    @GetMapping("/{city}")
    public RentalBranch getRentalBranch (@PathVariable String city){
        return  rentalBranchService.findById(city);
    }

    @PostMapping("/{branchId}/cars/{carId}")
    public RentalBranch addCarToBranch(@PathVariable("branchId") String id, @PathVariable("carId") String carPlateNumber ){
        return rentalBranchService.addCarToBranch(id, carPlateNumber);
    }

}
