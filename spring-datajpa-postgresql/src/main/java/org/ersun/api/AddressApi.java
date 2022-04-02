package org.ersun.api;

import lombok.RequiredArgsConstructor;
import org.ersun.dto.address.AddressDto;
import org.ersun.dto.address.CreateAddressRequest;
import org.ersun.dto.address.UpdateAddressRequest;
import org.ersun.service.address.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/v1/address")
@RequiredArgsConstructor
public class AddressApi {

    private final AddressService addressService;

    @PostMapping()
    public ResponseEntity<AddressDto> createAddress(@RequestBody CreateAddressRequest request) {
        return new ResponseEntity<>(addressService.createAddress(request), CREATED);
    }

    @PostMapping(path = "/list")
    public ResponseEntity<List<AddressDto>> createAddresses(@RequestBody List<CreateAddressRequest> request) {
        return new ResponseEntity<>(addressService.createAddresses(request), CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<AddressDto>> findAllAddresses() {
        return new ResponseEntity<>(addressService.findAllAddresses(), OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressDto> findAddressById(@PathVariable Long id) {
        return new ResponseEntity<>(addressService.getAddressById(id), OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AddressDto> updateAddressById(@PathVariable Long id, @RequestBody UpdateAddressRequest request) {
        return new ResponseEntity<>(addressService.updateAddressById(id, request), OK);
    }

    @PutMapping()
    public ResponseEntity<List<UpdateAddressRequest>> updateAddressList(@RequestBody List<UpdateAddressRequest> request) {
        return new ResponseEntity<>(addressService.updateAddressList(request), OK);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<AddressDto> deactivateAddress(@PathVariable Long id) {
        return new ResponseEntity<>(addressService.deactivateAddress(id), OK);
    }

}

