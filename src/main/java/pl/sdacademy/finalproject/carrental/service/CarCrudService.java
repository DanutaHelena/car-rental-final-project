package pl.sdacademy.finalproject.carrental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.finalproject.carrental.domain.Car;
import pl.sdacademy.finalproject.carrental.exceptions.NotFoundException;
import pl.sdacademy.finalproject.carrental.repositories.CarRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CarCrudService {

    private final CarRepository carRepository;

    public Car findByPlateNumber(String plate) {
        return carRepository.findById(plate).orElseThrow(() ->
             new NotFoundException("Car plate number not found")
        );
    }

    public Car addCar(Car car) {
        carRepository.save(car);
        return carRepository.findById(car.getPlateNumber()).orElseThrow(() ->
            new NotFoundException("Couldn't add to the repository")
        );
    }

    public void removeCar(String plate) {
            carRepository.deleteById(plate);
    }

    public Car updateCar(String plate,Car car) {
        Car car1 = carRepository.findById(plate).orElseThrow(() ->
                new NotFoundException("The car was not found" + plate)
        );
        car1.setBodyType(car.getBodyType());
        car1.setBrand(car.getBrand());
        car1.setModel(car.getModel());
        car1.setColour(car.getColour());
        car1.setProductionYear(car.getProductionYear());
        car1.setCost(car.getCost());
        car1.setMileage(car.getMileage());
        return car1;
    }
    public List<Car> getCars() {
        return carRepository.findAll();
    }
}


