package com.jeevan.springpetclinic.bootstrap;

import com.jeevan.springpetclinic.model.Owner;
import com.jeevan.springpetclinic.model.Vet;
import com.jeevan.springpetclinic.service.OwnerService;
import com.jeevan.springpetclinic.service.VetService;
import com.jeevan.springpetclinic.service.map.OwnerServiceMap;
import com.jeevan.springpetclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    public void run(String... args)throws Exception{

        Owner owner1 = new Owner();
        owner1.setFirstName("Jeevan");
        owner1.setLastName("Raj");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Manja");
        owner2.setLastName("hk");
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