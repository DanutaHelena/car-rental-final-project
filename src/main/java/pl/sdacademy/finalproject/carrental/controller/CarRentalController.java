package pl.sdacademy.finalproject.carrental.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.finalproject.carrental.datalayer.RentCar;
import pl.sdacademy.finalproject.carrental.service.CarRentalService;

@RestController
public class CarRentalController {
    
    private final CarRentalService carRentalService;

    public CarRentalController(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }


    @PostMapping("/rent-car")
    public String rentCar (@ModelAttribute RentCar rentCar) {
        return carRentalService.rent(rentCar);
    }


}
