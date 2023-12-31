package by.iba.sfpetclinic.services.springdatajpa;

import by.iba.sfpetclinic.model.Owner;
import by.iba.sfpetclinic.repositories.OwnerRepository;
import by.iba.sfpetclinic.repositories.PetRepository;
import by.iba.sfpetclinic.repositories.PetTypeRepository;
import by.iba.sfpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@Profile("springdatajpa")

public class OwnerJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;
    public OwnerJpaService(OwnerRepository ownerRepository, PetRepository
            petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }
    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }
    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }
    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }
    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }
    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }


}

