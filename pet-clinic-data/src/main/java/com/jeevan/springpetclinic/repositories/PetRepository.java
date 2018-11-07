package com.jeevan.springpetclinic.repositories;

import com.jeevan.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
