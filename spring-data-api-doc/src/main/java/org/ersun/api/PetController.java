package org.ersun.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.ersun.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Api(value = "Benim Pet API dökümantasyonum")
public class PetController {

    private List<Pet> petList = new ArrayList<>();

    @PostConstruct
    public void init(){
        petList.add(new Pet(1,"Test Pet",new Date()));
    }

    @PostMapping()
    @ApiOperation(value = "Yeni Pet ekleme methodu",notes = "Pet eklemek için Pet sınıfının bir objesini girdi olarak alır")
    public @ApiResponse(code = 201, message = "") ResponseEntity<Pet> createPet(@RequestBody @ApiParam(value = "Yeni Pet ekleme methodunun RequestBody parametresi") Pet pet){
        petList.add(pet);
        return new ResponseEntity<>(pet, CREATED);
    }

    @GetMapping()
    @ApiOperation(value = "Mevcut Petlerin tamamını getiren method")
    public ResponseEntity<List<Pet>> getAllPets(){
        return new ResponseEntity<>(petList,OK);
    }

}
