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
    @PutMapping("/{id}")
    public RentalBranch updateRentalBranch(@PathVariable Integer id, @Valid @RequestBody RentalBranch rentalBranch){
        return rentalBranchService.updateRentalBranch(id, rentalBranch);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeRentalBranch(@PathVariable Integer id){
        rentalBranchService.removeRentalBranch(id);
    }

    @GetMapping
    public List<RentalBranch> rentalBranchList(){
        return rentalBranchService.getRentalBranchList();
    }

    @GetMapping("/{id}")
    public RentalBranch getRentalBranch (@PathVariable Integer id){
        return  rentalBranchService.findById(id);
    }

    @PostMapping("/{branchId}/cars/{carId}")
    public RentalBranch addCarToBranch(@PathVariable("branchId") Integer id, @PathVariable("carId") String carPlateNumber ){
        return rentalBranchService.addCarToBranch(id, carPlateNumber);
    }

}
