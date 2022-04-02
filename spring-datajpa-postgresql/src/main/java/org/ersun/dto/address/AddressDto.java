package org.ersun.dto.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.ersun.model.address.Address;
import org.ersun.model.address.AdresTip;
import org.ersun.model.coordinate.Coordinate;

@AllArgsConstructor
@Getter
public class AddressDto {

    private final Long id;
    private final String address;
    private final AdresTip adresTip;
    private final Coordinate coordinate;
//    private Individual individual;

    public static AddressDto of(Address address){

        return new AddressDto(
                address.getId(),
                address.getAddress(),
                address.getAdresTip(),
                address.getCoordinate()
        );

    }

}
