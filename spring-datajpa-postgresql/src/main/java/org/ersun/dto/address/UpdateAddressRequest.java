package org.ersun.dto.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.ersun.model.address.Address;
import org.ersun.model.address.AdresTip;
import org.ersun.model.coordinate.Coordinate;
import org.ersun.model.individual.Individual;

@Getter
@AllArgsConstructor
public class UpdateAddressRequest {

    private String address;
    private AdresTip adresTip;
    private Coordinate coordinate;
    private Individual individual;

    public static UpdateAddressRequest of(Address address){

        return new UpdateAddressRequest(
                address.getAddress(),
                address.getAdresTip(),
                address.getCoordinate(),
                address.getIndividual()
        );

    }

}
