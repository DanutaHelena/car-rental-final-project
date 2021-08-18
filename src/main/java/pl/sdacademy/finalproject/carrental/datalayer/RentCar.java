package pl.sdacademy.finalproject.carrental.datalayer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RentCar {
    @Id
    private int id;
    private String registrationNumber;
    private String mark;
    private boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public RentCar() {

    }
}
