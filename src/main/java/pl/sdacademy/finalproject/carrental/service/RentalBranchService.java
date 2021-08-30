package pl.sdacademy.finalproject.carrental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.finalproject.carrental.domain.RentalBranch;
import pl.sdacademy.finalproject.carrental.exceptions.NotFoundException;
import pl.sdacademy.finalproject.carrental.repositories.RentalBranchRepository;

@Transactional
@Service
@RequiredArgsConstructor
public class RentalBranchService {

    private final RentalBranchRepository rentalBranchRepository;

    public RentalBranch findById(Integer id){
        return rentalBranchRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Couldn't find localization"));
    }


}
