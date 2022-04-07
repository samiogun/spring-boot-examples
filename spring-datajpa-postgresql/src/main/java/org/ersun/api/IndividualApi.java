package org.ersun.api;

import org.ersun.dto.individual.CreateIndividualRequest;
import org.ersun.dto.individual.IndividualDto;
import org.ersun.dto.individual.UpdateIndividualRequest;
import org.ersun.exception.IndividualNotFoundException;
import org.ersun.model.individual.Individual;
import org.ersun.service.address.AddressService;
import org.ersun.service.individual.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Set;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = "/api")
public class IndividualApi {

    @Autowired
    private IndividualService individualService;
    @Autowired
    private AddressService addressService;

    @PostMapping()
    public ResponseEntity<IndividualDto> createIndividual(@RequestBody CreateIndividualRequest request){
        return new ResponseEntity<>(individualService.createIndividual(request), CREATED);
    }

    @PostMapping("v1/individual/")
    public ResponseEntity<Individual> createIndividual(@RequestBody Individual individual){
        return new ResponseEntity<>(individualService.createIndividual(individual), CREATED);
    }

    @GetMapping("v1/individual/all")
    public ResponseEntity<List<IndividualDto>> getAllIndividuals(){
        return new ResponseEntity<>(individualService.getAllIndividuals(),OK);
    }

    @GetMapping(path = "v1/individual/{id}")
    public ResponseEntity<IndividualDto> getIndividualById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(individualService.getIndividual(id),OK);
    }

    @GetMapping(path = "v1/individual/")
    public ResponseEntity<IndividualDto> getIndividualByIdentityNumber(@PathParam(value = "identityNumber") long identityNumber){
        return new ResponseEntity<>(individualService.getIndividualByIdentityNumber(identityNumber),OK);
    }

    @GetMapping(path = "v1/individual/a")
    public ResponseEntity<IndividualDto> getIndividualByFirstnameAndIdentityNumber(@PathParam(value = "identityNumber") long identityNumber,
                                                                                   @PathParam(value = "firstName") String firstName){
        return new ResponseEntity<>(individualService.getIndividualByFirstNameAndIdentityNumber(firstName,identityNumber),OK);
    }

    @GetMapping(path = "v1/individual/byname/{firstname}")
    public ResponseEntity<List<IndividualDto>> getIndividualsByFirstname(@PathVariable(value = "firstname") String firstName){

        return new ResponseEntity<>(individualService.getIndividualsByFirstname(firstName),OK);
    }

    @GetMapping(path = "v1/individual/names")
    public ResponseEntity<List<IndividualDto>> getIndividualsByFirstnames(@RequestBody Set<String> firstNames){

        return new ResponseEntity<>(individualService.getIndividualsByFirstnames(firstNames),OK);
    }

    @GetMapping(path = "v1/individual/longitudege")
    public ResponseEntity<List<IndividualDto>> getUsersByLongitudeGreaterThanThirty(){

        return new ResponseEntity<>(individualService.getUsersByLongitudeGreaterThanThirty(),OK);

    }

    @PutMapping(path = "v1/individual/{id}")
    public ResponseEntity<IndividualDto> updateIndividualById(@PathVariable(name = "id") Long id ,
                                                              @RequestBody UpdateIndividualRequest request){
        return new ResponseEntity<>(individualService.updateIndividual(id , request),OK);
    }

    @DeleteMapping(path = "v1/individual/delete/{id}")
    public ResponseEntity<Void> deleteIndividual(@PathVariable Long id){
        individualService.deleteIndividual(id);
        return new ResponseEntity<>(OK);
    }


    @ExceptionHandler(IndividualNotFoundException.class)
    public ResponseEntity<String> handleIndividualNotFoundException(IndividualNotFoundException ex){

        return new ResponseEntity<>(ex.getMessage(),NOT_FOUND);

    }

}
