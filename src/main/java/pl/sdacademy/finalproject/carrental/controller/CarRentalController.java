package pl.sdacademy.finalproject.carrental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.finalproject.carrental.datalayer.RentCar;
import pl.sdacademy.finalproject.carrental.domain.Car;
import pl.sdacademy.finalproject.carrental.domain.CarRentStatus;
import pl.sdacademy.finalproject.carrental.service.CarCrudService;
import pl.sdacademy.finalproject.carrental.service.CarRentalService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarRentalController {

    private final CarRentalService carRentalService;
    private final CarCrudService carCrudService;

    public CarRentalController(CarRentalService carRentalService, CarCrudService carCrudService) {
        this.carRentalService = carRentalService;
        this.carCrudService = carCrudService;
    }


    @PostMapping("/rent-car")
    public String rentCar(@ModelAttribute RentCar rentCar) {
        return carRentalService.rent(rentCar);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car create(@Valid @RequestBody Car car) {
        return carCrudService.addCar(car);
        // 201

    }

    @GetMapping("/{carPlate}")
    public Car getCarByCarPlate(@PathVariable String carPlate) {
        return carCrudService.findByPlateNumber(carPlate);
    }

    @GetMapping
    public List<Car> getCars() {
        return carCrudService.getCars();
    }

    @DeleteMapping("/{carPlate}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable String carPlate) {
        carCrudService.removeCar(carPlate);
        // dodać status NO_CONTENT-204
    }

    @PutMapping("/{carPlate}")
    public Car updateCar(@PathVariable String carPlate, @Valid @RequestBody Car car ) {
        return  carCrudService.updateCar(carPlate, car);
    }
}
