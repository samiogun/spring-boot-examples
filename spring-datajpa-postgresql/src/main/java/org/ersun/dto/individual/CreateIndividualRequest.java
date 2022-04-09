package org.ersun.dto.individual;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.ersun.model.address.Address;
import org.ersun.model.identity.Identity;
import org.ersun.model.individual.Individual;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
@AllArgsConstructor
public class CreateIndividualRequest {

    @Size(
            min = 2,
            max = 32,
            message = "Between 2-32"
    )
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
