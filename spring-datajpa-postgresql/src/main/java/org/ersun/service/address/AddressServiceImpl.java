package org.ersun.service.address;

import lombok.RequiredArgsConstructor;
import org.ersun.dto.address.AddressDto;
import org.ersun.dto.address.CreateAddressRequest;
import org.ersun.dto.address.UpdateAddressRequest;
import org.ersun.model.address.Address;
import org.ersun.repository.AddressRepository;
import org.ersun.exception.AddressNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;

    @Override
    public List<AddressDto> findAllAddresses() {
        return convertToAddressDto(addressRepository.findAll());
    }

    @Override
    public AddressDto createAddress(CreateAddressRequest request) {
        return AddressDto.of(
                addressRepository.save(
                        new Address(
                                request.getAddress(),
                                request.getAdresTip(),
                                request.getCoordinate(),
                                request.getIndividual()
                        )
                )
        );
    }

    @Override
    public List<AddressDto> createAddresses(List<CreateAddressRequest> request) {
        List<Address> addressList = new ArrayList<>();

        request.forEach(address -> {
            addressList.add(
                    new Address(
                            address.getAddress(),
                            address.getAdresTip(),
                            address.getCoordinate(),
                            address.getIndividual()
                    )
            );
        });

        return convertToAddressDto(addressRepository.saveAll(addressList));
    }

    @Override
    public AddressDto getAddressById(Long id) {
        return convertToAddressDto(findAddressById(id));
    }

    @Override
    public AddressDto updateAddressById(Long id , UpdateAddressRequest request) {

        final Address address = findAddressById(id);
        address.setAddress(request.getAddress());
        address.setAdresTip(request.getAdresTip());
        address.setCoordinate(request.getCoordinate());
        address.setIndividual(request.getIndividual());

        return convertToAddressDto(addressRepository.save(address));

    }

    @Override
    public AddressDto deactivateAddress(Long id) {
        final Address address = findAddressById(id);
        address.setActive(false);
        return convertToAddressDto(addressRepository.save(address));

    }

    @Override
    public AddressDto activateAddress(Long id) {
        final Address address = findAddressById(id);
        address.setActive(true);
        return convertToAddressDto(addressRepository.save(address));
    }

    @Override
    public List<UpdateAddressRequest> updateAddressList(List<UpdateAddressRequest> request) {
        List<Address> addressList = new ArrayList<>();

        request.forEach(address -> {
            addressList.add(
                    new Address(
                            address.getAddress(),
                            address.getAdresTip(),
                            address.getCoordinate()
                    )
            );
        });

        return addressRepository.saveAll(addressList).stream().map(UpdateAddressRequest::of).collect(Collectors.toList());
    }

    private Address findAddressById(final Long id){
        return addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("Address coudl not be found by id : " + id));
    }

    private AddressDto convertToAddressDto(Address address){
        return AddressDto.of(address);
    }

    private List<AddressDto> convertToAddressDto(List<Address> addresses){
        return addresses.stream().map(AddressDto::of).collect(Collectors.toList());
    }

}