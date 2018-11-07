package com.jeevan.springpetclinic.repositories;

import com.jeevan.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
