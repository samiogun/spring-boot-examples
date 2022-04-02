package org.ersun.api;


import lombok.RequiredArgsConstructor;
import org.ersun.model.Individual;
import org.ersun.service.IndividualService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/individual")
@RequiredArgsConstructor
public class IndividualApi {

    private final IndividualService individualService;

    @PostMapping()
    public Individual addIndividual(@RequestBody Individual individual){

        return individualService.addIndividual(individual);

    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Individual>> findIndividualsByName(@PathVariable(name = "name") String name){

        return new ResponseEntity<>(individualService.findByName(name), OK);

    }

    @GetMapping("")
    public ResponseEntity<List<Individual>> findIndividualsByName(@RequestParam(name = "ad") String ad , @RequestParam(name = "soyad") String soyad){

        return new ResponseEntity<>(individualService.findByAdSoyad(ad,soyad), OK);

    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<Void> deleteAll(){

        individualService.deleteAll();
        return new ResponseEntity<>(OK);

    }

}
