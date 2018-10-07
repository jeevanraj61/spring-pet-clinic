package com.jeevan.springpetclinic.service;

import com.jeevan.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
