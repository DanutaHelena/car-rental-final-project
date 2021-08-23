package pl.sdacademy.finalproject.carrental.controller;

import org.springframework.web.bind.annotation.*;
import pl.sdacademy.finalproject.carrental.datalayer.RentCar;
import pl.sdacademy.finalproject.carrental.domain.Car;
import pl.sdacademy.finalproject.carrental.domain.CarRentStatus;
import pl.sdacademy.finalproject.carrental.service.CarCrudService;
import pl.sdacademy.finalproject.carrental.service.CarRentalService;

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
    public Car create(@RequestBody Car car) {
        return carCrudService.addCar(car);

    }

    @GetMapping("/{carPlate}")
    public Car getCarByCarPlate(@PathVariable String carPlate) {
        return carCrudService.findByPlateNumber(carPlate);
    }
    @GetMapping("/cars")
    public List<Car> getCars() {
        return carCrudService.getCars();
    }
    @DeleteMapping("/{carPlate}")
    public void deleteCar(@PathVariable String carPlate) {
        carCrudService.removeCar(carPlate);
    }
    @PutMapping("/{carPlate}")
    public Car updateCar(@PathVariable String carPlate, @RequestParam BigDecimal cost,
                         @RequestParam (required = false)Integer mileage, @RequestParam CarRentStatus status) {
        return  carCrudService.updateCar(carPlate,cost, mileage, status);
    }
}
