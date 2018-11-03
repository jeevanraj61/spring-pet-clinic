package com.jeevan.springpetclinic.bootstrap;

import com.jeevan.springpetclinic.model.Owner;
import com.jeevan.springpetclinic.model.Pet;
import com.jeevan.springpetclinic.model.PetType;
import com.jeevan.springpetclinic.model.Vet;
import com.jeevan.springpetclinic.service.OwnerService;
import com.jeevan.springpetclinic.service.PetTypeService;
import com.jeevan.springpetclinic.service.VetService;
import com.jeevan.springpetclinic.service.map.OwnerServiceMap;
import com.jeevan.springpetclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    public void run(String... args)throws Exception{

        PetType dog  = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat  = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Jeevan");
        owner1.setLastName("Raj");
        owner1.setAddress("Vaihingen");
        owner1.setCity("Stuttgart");
        owner1.setTelephone("1234556");
        ownerService.save(owner1);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Manja");
        owner2.setLastName("hk");
        owner2.setAddress("Bang");
        owner2.setCity("Bangalore");
        owner2.setTelephone("1234556");
        ownerService.save(owner2);

        Pet fionaCat = new Pet();
        fionaCat.setPetType(savedCatPetType);
        fionaCat.setOwner(owner2);
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setName("Fiona");
        owner1.getPets().add(fionaCat);
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Das");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Kalyan");
        vet2.setLastName("Gv");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
