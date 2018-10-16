package com.jeevan.springpetclinic.service;

import com.jeevan.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findOwnerByLastName(String lastName);


}
