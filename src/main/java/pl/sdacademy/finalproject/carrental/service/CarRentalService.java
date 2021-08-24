package pl.sdacademy.finalproject.carrental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.finalproject.carrental.datalayer.CarRentalRepository;
import pl.sdacademy.finalproject.carrental.datalayer.RentCar;

@Service
@Transactional
@RequiredArgsConstructor
public class CarRentalService {
    private final CarRentalRepository carRentalRepository;




    }