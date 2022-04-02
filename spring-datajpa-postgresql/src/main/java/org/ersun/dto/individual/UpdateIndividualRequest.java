package org.ersun.dto.individual;

import lombok.Getter;
import org.ersun.model.address.Address;

import java.util.List;

@Getter
public class UpdateIndividualRequest {

    private String firstName;
    private String lastName;
    private List<Address> addresses;

}
