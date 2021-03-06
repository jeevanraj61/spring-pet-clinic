package com.jeevan.springpetclinic.service.map;

import com.jeevan.springpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;

    private Long ownerId = 1L;

    final String lastName ="Smith";
    @BeforeEach
    void setUp(){
        ownerMapService = new OwnerMapService(new PetTypeMapService(),
                new PetMapService());
        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setLastName(lastName);
       /// ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1,ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId,owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner =ownerMapService.save(owner2);

        assertEquals(id,savedOwner.getId());
    }

    @Test
        void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findOwnerByLastName() {
        Owner smith = ownerMapService.findOwnerByLastName(lastName);

        assertNotNull(smith);

        assertEquals(ownerId,smith.getId());
    }
}