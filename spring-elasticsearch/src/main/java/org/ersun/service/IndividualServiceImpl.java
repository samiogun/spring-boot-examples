package org.ersun.service;

import lombok.RequiredArgsConstructor;
import org.ersun.model.Individual;
import org.ersun.repository.IndividualRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndividualServiceImpl implements IndividualService{

    private final IndividualRepository individualRepository;

    @Override
    public List<Individual> findByName(String name) {
        return individualRepository.findByAd(name);
    }

    @Override
    public List<Individual> findByAdSoyad(String ad, String soyad) {
        return individualRepository.findByAdSoyad(ad,soyad);
    }

    @Override
    public Individual addIndividual(Individual individual) {
        return individualRepository.save(individual);
    }

    @Override
    public void deleteAll() {
        individualRepository.deleteAll();
    }
}
