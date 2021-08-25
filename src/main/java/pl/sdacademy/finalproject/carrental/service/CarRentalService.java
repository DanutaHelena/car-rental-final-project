package pl.sdacademy.finalproject.carrental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.finalproject.carrental.repositories.CarRentalRepository;
import pl.sdacademy.finalproject.carrental.domain.CarRental;
import pl.sdacademy.finalproject.carrental.exceptions.NotFoundException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CarRentalService {

    private final CarRentalRepository carRentalRepository;

    public CarRental createRental(CarRental carRental) {
        carRentalRepository.save(carRental);
        return carRentalRepository.findById(carRental.getId()).orElseThrow(() ->
                new NotFoundException("Couldn't create rental")
        );
    }

    public void removeRental(Integer id) {
        carRentalRepository.deleteById(id);
    }

    public CarRental updateRental(Integer id, CarRental carRental) {
        CarRental carRental1 = carRentalRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Couldn't find rental")
        );

        carRental1.setCar(carRental.getCar());
        carRental1.setEndDate(carRental.getEndDate());
        carRental1.setPrice(carRental.getPrice());
        carRental1.setStartDate(carRental.getStartDate());
        return carRental1;

    }

    public List<CarRental> getCarRentalList() {
        return carRentalRepository.findAll();
    }
    public CarRental getCarRental(Integer id) {
        return carRentalRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Couldn't find rental"));
    }
}