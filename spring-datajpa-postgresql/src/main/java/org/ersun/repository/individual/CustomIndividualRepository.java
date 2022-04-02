package org.ersun.repository.individual;

import org.ersun.model.individual.Individual;

import java.util.List;
import java.util.Set;

public interface CustomIndividualRepository{

    List<Individual>  getUsersByFirstName(String firstNames);

    List<Individual>  getUsersByFirstNames(Set<String> firstNames);

    List<Individual> getUsersByLongitudeGreaterThanThirty();
}
