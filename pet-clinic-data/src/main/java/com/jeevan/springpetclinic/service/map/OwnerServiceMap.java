package com.jeevan.springpetclinic.service.map;

import com.jeevan.springpetclinic.model.Owner;
import com.jeevan.springpetclinic.model.Pet;
import com.jeevan.springpetclinic.service.CrudService;
import com.jeevan.springpetclinic.service.OwnerService;
import com.jeevan.springpetclinic.service.PetService;
import com.jeevan.springpetclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    private  final PetTypeService petTypeService;

    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if(object!= null){
            if(object.getPets() != null){
                object.getPets().forEach(pets->{
                    if(pets.getPetType() != null){
                        if(pets.getPetType().getId() == null){
                            pets.setPetType(petTypeService.save(pets.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is Required");
                    }
                    if(pets.getId() == null){
                       Pet savedPetObject =  petService.save(pets);
                       pets.setId(savedPetObject.getId());
                    }
                });
            }
            return super.save(object);
        }
        else return null;
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findOwnerByLastName(String lastName) {
        return null;
    }
}
