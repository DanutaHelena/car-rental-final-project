package pl.sdacademy.finalproject.carrental.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.finalproject.carrental.datalayer.CarRepository;
import pl.sdacademy.finalproject.carrental.datalayer.RentCar;

@Service
public class CarRentalService {
    private final CarRepository carRepository;

    public CarRentalService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    public String rent(RentCar rentCar) {
        String text = null;
        if (rentCar.isStatus()) {
            text = "This car is available";
            carRepository.getById(rentCar.getId()).setStatus(false);
        } else if (!rentCar.isStatus()) {
            text = "This car is rented";
        }
        return text;
    }
}
