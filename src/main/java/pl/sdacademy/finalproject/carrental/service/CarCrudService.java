package pl.sdacademy.finalproject.carrental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.finalproject.carrental.domain.Car;
import pl.sdacademy.finalproject.carrental.domain.CarRentStatus;
import pl.sdacademy.finalproject.carrental.exceptions.NotFoundException;
import pl.sdacademy.finalproject.carrental.repositories.CarRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional
public class CarCrudService {

    private final CarRepository carRepository;

    public Car findByPlateNumber(String plate) {
        return carRepository.findById(plate).orElseThrow(() -> {
            throw new NotFoundException("Car plate number not found");
        });
    }

    public Car addCar(Car car) {
        carRepository.save(car);
        return carRepository.findById(car.getPlateNumber()).orElseThrow(() -> {
            throw new NotFoundException("Couldn't add to the repository");
        });
    }


    public String removeCar(String plate) {
        try {
            carRepository.deleteById(plate);
            return "Succesfully deleted";
        } catch (Exception e) {
            throw new NotFoundException("the car was not found");
        }
    }

    public Car updateCar(String plate, BigDecimal cost, Integer mileage, CarRentStatus status) {
        Car car = carRepository.findById(plate).orElseThrow(() -> new NotFoundException("the car was not found"));
        car.setCost(cost);
        car.setMileage(mileage);
        car.setStatus(status);
        return car;
    }
}


