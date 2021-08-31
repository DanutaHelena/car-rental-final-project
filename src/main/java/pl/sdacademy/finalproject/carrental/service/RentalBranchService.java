package pl.sdacademy.finalproject.carrental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.finalproject.carrental.domain.RentalBranch;
import pl.sdacademy.finalproject.carrental.exceptions.NotFoundException;
import pl.sdacademy.finalproject.carrental.repositories.RentalBranchRepository;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class RentalBranchService {

    private final RentalBranchRepository rentalBranchRepository;

    public RentalBranch findById(Integer id){
        return rentalBranchRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Couldn't find localization"));
    }
    public RentalBranch addRentalBranch(RentalBranch rentalBranch) {
        rentalBranchRepository.save(rentalBranch);
        return rentalBranchRepository.findById(rentalBranch.getId()).orElseThrow(()->
                new NotFoundException("Couldn't add new branch"));
    }
    public RentalBranch updateRentalBranch(Integer id, RentalBranch rentalBranch) {
        RentalBranch rentalBranch1 = rentalBranchRepository.findById(id).orElseThrow(()->
                new NotFoundException("Couldn't find branch by id: " + id));

        rentalBranch1.setLocalization(rentalBranch.getLocalization());

        return rentalBranch1;
    }

    public List<RentalBranch> getRentalBranchList() {
        return rentalBranchRepository.findAll();
    }
    public void removeRentalBranch(Integer id) {
        rentalBranchRepository.deleteById(id);
    }
}
