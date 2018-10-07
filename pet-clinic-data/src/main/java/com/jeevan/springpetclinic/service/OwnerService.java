package com.jeevan.springpetclinic.service;

import com.jeevan.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findOwnerByLastName(String lastName);

    Owner findById(long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
