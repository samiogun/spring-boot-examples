package org.ersun.repository.individual;

import org.ersun.model.individual.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends JpaRepository<Individual , Long>, CustomIndividualRepository {

    Individual findByIdentityIdentityNumber(long identityNumber);

//    @Query(value = "select i from Individual i where i.firstName = :first and i.identity.identityNumber = :identity") // Individual class adı olan, firstName ve identity.identityNumber ise classlardaki parametrelerin isimleri
    @Query(value = "select * from individual where first_name = :firstName and identity_number = :identityNumber",nativeQuery = true) // Tamamen DB sorgusu yazıyoruz ve methodun parametreleri ile eşleştiriyoruz.
    Individual findByFirstNameAndIdentityIdentityNumber(@Param("firstName") String firstName, @Param("identityNumber")long identityNumber);
}
