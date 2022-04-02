package org.ersun.service.individual;

import org.ersun.dto.individual.CreateIndividualRequest;
import org.ersun.dto.individual.IndividualDto;
import org.ersun.dto.individual.UpdateIndividualRequest;
import org.ersun.model.individual.Individual;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface IndividualService {

    IndividualDto createIndividual(CreateIndividualRequest request);

    Individual createIndividual(Individual individual);

    void deleteIndividual(Long id);

    List<IndividualDto> getAllIndividuals();

    IndividualDto getIndividual(Long id);

    Page<Individual> getAllIndividualsByPage(Pageable pageable);

    IndividualDto updateIndividual(Long id, UpdateIndividualRequest request);

    IndividualDto getIndividualByIdentityNumber(long identityNumber);

    IndividualDto getIndividualByFirstNameAndIdentityNumber(String firstName ,long identityNumber);

    List<IndividualDto> getIndividualsByFirstname(String firstName);

    List<IndividualDto> getIndividualsByFirstnames(Set<String> firstNames);

    List<IndividualDto> getUsersByLongitudeGreaterThanThirty();
}
