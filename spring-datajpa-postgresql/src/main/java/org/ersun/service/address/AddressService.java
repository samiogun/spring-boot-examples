package org.ersun.service.address;

import org.ersun.dto.address.AddressDto;
import org.ersun.dto.address.CreateAddressRequest;
import org.ersun.dto.address.UpdateAddressRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    List<AddressDto> findAllAddresses();

    AddressDto createAddress(CreateAddressRequest request);

    AddressDto getAddressById(Long id);

    AddressDto updateAddressById(Long id , UpdateAddressRequest request);

    AddressDto deactivateAddress(Long id);

    AddressDto activateAddress(Long id);

    List<UpdateAddressRequest> updateAddressList(List<UpdateAddressRequest> request);

    List<AddressDto> createAddresses(List<CreateAddressRequest> request);
}
