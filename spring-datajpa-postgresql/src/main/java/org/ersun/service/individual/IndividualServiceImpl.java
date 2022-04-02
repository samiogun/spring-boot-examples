package org.ersun.service.individual;


import lombok.RequiredArgsConstructor;
import org.ersun.dto.individual.CreateIndividualRequest;
import org.ersun.dto.individual.IndividualDto;
import org.ersun.dto.individual.UpdateIndividualRequest;
import org.ersun.exception.IndividualNotFoundException;
import org.ersun.model.identity.Identity;
import org.ersun.model.individual.Individual;
import org.ersun.repository.individual.CustomIndividualRepository;
import org.ersun.repository.individual.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class IndividualServiceImpl implements IndividualService{

    @Autowired
    private IndividualRepository individualRepository;

    @Override
    @Transactional
    public IndividualDto createIndividual(CreateIndividualRequest request) {

        final Individual individual = new Individual(
                request.getFirstName(),
                request.getLastName(),
                request.getAddresses(),
                request.getIdentity()
        );

        individual.getIdentity().setIndividual(individual);

        individual.getAddresses().forEach(address -> {
            address.setIndividual(individual);
            address.setActive(true);
        });

        return convertToIndividualDto(individualRepository.save(individual));

    }

    @Override
    public Individual createIndividual(Individual individual) {

        final Identity identity = individual.getIdentity();
//        final List<Address> addressList = individual.getAddresses();

        Individual newIndividual = new Individual(
                individual.getFirstName(),
                individual.getLastName(),
                individual.getAddresses(),
                individual.getIdentity());

        identity.setIndividual(individual);

//        return individualRepository.save(new Individual(individual.getFirstName(),individual.getLastName(),individual.getAddresses(),individual.getIdentity()));
        return individualRepository.save(newIndividual);

    }

    @Override
    public void deleteIndividual(final Long id) {
        findIndividualById(id);
        individualRepository.deleteById(id);
    }

    @Override
    public List<IndividualDto> getAllIndividuals() {
        return individualRepository.findAll().stream().map(IndividualDto::of).collect(Collectors.toList());
    }

    @Override
    public IndividualDto getIndividual(final Long id) {
        return convertToIndividualDto(findIndividualById(id));
    }


    @Override
    public Page<Individual> getAllIndividualsByPage(Pageable pageable) {
        return null;
    }

    @Override
    public IndividualDto updateIndividual(final Long id, final UpdateIndividualRequest request) {
        Individual individual = findIndividualById(id);
        individual.setFirstName(request.getFirstName());
        individual.setLastName(request.getLastName());
        individual.setAddresses(request.getAddresses());
        return convertToIndividualDto(individual);
    }

    @Override
    public IndividualDto getIndividualByIdentityNumber(long identityNumber) {
        return convertToIndividualDto(individualRepository.findByIdentityIdentityNumber(identityNumber));
    }

    @Override
    public IndividualDto getIndividualByFirstNameAndIdentityNumber(String firstName, long identityNumber) {
        return convertToIndividualDto(individualRepository.findByFirstNameAndIdentityIdentityNumber(firstName,identityNumber));
    }

    @Override
    public List<IndividualDto> getIndividualsByFirstname(String firstName) {

        return IndividualDto.of(individualRepository.getUsersByFirstName(firstName));

    }

    @Override
    public List<IndividualDto> getIndividualsByFirstnames(Set<String> firstNames) {
        return IndividualDto.of(individualRepository.getUsersByFirstNames(firstNames));
    }

    @Override
    public List<IndividualDto> getUsersByLongitudeGreaterThanThirty() {
        return IndividualDto.of(individualRepository.getUsersByLongitudeGreaterThanThirty());
    }

    private Individual findIndividualById(final Long id){
        return individualRepository.findById(id).orElseThrow(() -> new IndividualNotFoundException("Individual could not be found by id : " + id));
    }

    private IndividualDto convertToIndividualDto(final Individual individual){
        return IndividualDto.of(individual);
    }

}
