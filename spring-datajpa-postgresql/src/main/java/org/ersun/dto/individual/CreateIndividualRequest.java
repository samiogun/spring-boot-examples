package org.ersun.dto.individual;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.ersun.model.address.Address;
import org.ersun.model.identity.Identity;
import org.ersun.model.individual.Individual;

import java.util.List;

@Getter
@AllArgsConstructor
public class CreateIndividualRequest {

    private final String firstName;
    private final String lastName;
    private final List<Address> addresses;
    private final Identity identity;

    public static CreateIndividualRequest of(Individual individual){

        return new CreateIndividualRequest(
                individual.getFirstName(),
                individual.getLastName(),
                individual.getAddresses(),
                individual.getIdentity()
        );

    }

}
