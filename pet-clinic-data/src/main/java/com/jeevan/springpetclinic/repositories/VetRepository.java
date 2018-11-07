package com.jeevan.springpetclinic.repositories;

import com.jeevan.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
