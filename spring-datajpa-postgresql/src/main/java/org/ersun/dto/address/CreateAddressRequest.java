package org.ersun.dto.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.ersun.model.address.Address;
import org.ersun.model.address.AdresTip;
import org.ersun.model.coordinate.Coordinate;
import org.ersun.model.individual.Individual;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class CreateAddressRequest {

    private String address;
    private AdresTip adresTip;
    private Coordinate coordinate;
    private Individual individual;

    public static CreateAddressRequest of(Address address){

        return new CreateAddressRequest(
                address.getAddress(),
                address.getAdresTip(),
                address.getCoordinate(),
                address.getIndividual()
        );

    }

    public static List<CreateAddressRequest> of(List<Address> address){

        List<CreateAddressRequest> createAddressRequestList = new ArrayList<>();

        address.forEach(address1 -> createAddressRequestList.add(CreateAddressRequest.of(address1)));

        return createAddressRequestList;

    }

}
