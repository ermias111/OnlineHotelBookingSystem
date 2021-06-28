package com.example.hbs.service;

import com.example.hbs.domain.Address;
import com.example.hbs.domain.Hotel;
import com.example.hbs.domain.Room;
import com.example.hbs.domain.RoomType;
import com.example.hbs.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createRAddress(String street, String district, String city, String postalCode, String phone){
        return addressRepository.findByPhone(phone).orElse(addressRepository.save(new Address(street,district,city,postalCode,phone)));
    }

    /**
     * Lookup All Tour packages
     *
     * @return
     */
    public Iterable<Address> lookup(){
        return addressRepository.findAll();
    }

    public long total() {
        return addressRepository.count();
    }

}
