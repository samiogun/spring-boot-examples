package org.ersun.dto.individual;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.ersun.dto.address.AddressDto;
import org.ersun.model.identity.Identity;
import org.ersun.model.individual.Individual;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class IndividualDto {

    private Long id;
    private String firstName;
    private String lastName;
    private List<AddressDto> addresses;
    private long identityNumber;

    public IndividualDto(Long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static IndividualDto of(Individual individual){

        List<AddressDto> addressDtoList = individual.getAddresses().stream().map(AddressDto::of).collect(Collectors.toList());

        return new IndividualDto(
                individual.getId(),
                individual.getFirstName(),
                individual.getLastName(),
                addressDtoList,
                individual.getIdentity().getIdentityNumber()
        );

    }

    public static List<IndividualDto> of(List<Individual> individualList){

        List<IndividualDto> individualDtoList = new ArrayList<>();

        individualList.forEach(individual -> {

            individualDtoList.add(new IndividualDto(
                    individual.getId(),
                    individual.getFirstName(),
                    individual.getLastName(),
                    individual.getAddresses().stream().map(AddressDto::of).collect(Collectors.toList()),
                    individual.getIdentity().getIdentityNumber()
            ));

        });

        return individualDtoList;

    }

}
