package pl.sdacademy.finalproject.carrental.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.sdacademy.finalproject.carrental.domain.Car;
import pl.sdacademy.finalproject.carrental.domain.CarRentStatus;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class CarCrudServiceTest {

    @Mock
    private CarCrudService mockedCarCrudService;

    @Test
    void shouldFindPlateNumber() {
        //given
        String plateNumber = "SG 341LW";
        String brand = "Volvo";
        String model = "v40";
        String bodyType = "combi";
        Integer productionYear = 2015;
        String colour = "black";
        CarRentStatus status = CarRentStatus.AVAILABLE;
        Integer mileage = 176222;
        BigDecimal cost = BigDecimal.valueOf(23000);

        Car car = new Car(plateNumber, brand, model, bodyType, productionYear, colour, status, mileage, cost);

        //when

        Car car2 = mockedCarCrudService.findByPlateNumber("SG 341LW");


        //then

        assertThat(car2).isEqualTo(car);

    }



}