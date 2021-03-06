package pl.sdacademy.finalproject.carrental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.finalproject.carrental.domain.CarRental;
import pl.sdacademy.finalproject.carrental.model.CarRentalRequest;
import pl.sdacademy.finalproject.carrental.service.CarRentalService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class CarRentalController {

    private final CarRentalService carRentalService;

    public CarRentalController(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarRental createRental(@Valid @RequestBody CarRentalRequest carRentalRequest) {
        return carRentalService.createRental(carRentalRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeRental(@PathVariable Integer id) {
        carRentalService.removeRental(id);
    }

    @PutMapping("/{id}")
    public CarRental updateRental(@PathVariable Integer id, @Valid @RequestBody CarRental carRental) {
        return carRentalService.updateRental(id, carRental);
    }

    @GetMapping
    public List<CarRental> carRentalList(){
        return carRentalService.getCarRentalList();
    }

    @GetMapping("/{id}")
    public  CarRental getCarRental(@PathVariable Integer id) {
        return  carRentalService.getCarRental(id);
    }
}