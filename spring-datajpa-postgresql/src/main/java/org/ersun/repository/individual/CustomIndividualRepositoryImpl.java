package org.ersun.repository.individual;

import org.ersun.model.address.Address;
import org.ersun.model.coordinate.Coordinate;
import org.ersun.model.individual.Individual;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomIndividualRepositoryImpl implements CustomIndividualRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Individual> getUsersByFirstName(String firstName) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Individual> criteriaQuery = criteriaBuilder.createQuery(Individual.class); // Sorgumuzun bir Individual nesnesi döneceğini belirttik. String.class veya Integer.class vs de yazabilirdik.

        Root<Individual> individualRoot = criteriaQuery.from(Individual.class);

//        Join<Individual , Address> individualAddressJoin = individualRoot.join("addresses");

//        criteriaQuery.select(individualRoot).where(individualRoot.get("fisrtName").in(firstName));

        Predicate equalToFirstName = criteriaBuilder.equal(individualRoot.get("firstName"),firstName);

        criteriaQuery.select(individualRoot).where(equalToFirstName);

        return entityManager.createQuery(criteriaQuery).getResultList();

    }

    @Override
    public List<Individual> getUsersByFirstNames(Set<String> firstNames) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Individual> criteriaQuery = criteriaBuilder.createQuery(Individual.class); // Sorgumuzun bir Individual nesnesi döneceğini belirttik. String.class veya Integer.class vs de yazabilirdik.

        Root<Individual> individualRoot = criteriaQuery.from(Individual.class);

//        Join<Individual , Address> individualAddressJoin = individualRoot.join("addresses");

        Predicate inFirstNames = individualRoot.get("firstName").in(firstNames);

        criteriaQuery.select(individualRoot).where(inFirstNames);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Individual> getUsersByLongitudeGreaterThanThirty() {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Individual> query = builder.createQuery(Individual.class);

        Root<Individual> fromIndividual = query.from(Individual.class);

        Join<Individual , Address> individualAddressListJoin = fromIndividual.join("addresses");
        Join<Address , Coordinate> addressCoordinateJoin = individualAddressListJoin.join("coordinate");

        List<Predicate> predicateList = new ArrayList<>();

        predicateList.add(builder.ge(addressCoordinateJoin.get("longitude"),30));

        query.select(fromIndividual).where(predicateList.toArray(new Predicate[]{})).distinct(true);

        return entityManager.createQuery(query).getResultList();

    }

}
