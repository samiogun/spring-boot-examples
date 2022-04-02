package org.ersun.service;

import org.ersun.model.Individual;

import java.util.List;

public interface IndividualService {

    List<Individual> findByName(String name);

    List<Individual> findByAdSoyad(String ad ,String soyad);

    Individual addIndividual(Individual individual);

    void deleteAll();


}
