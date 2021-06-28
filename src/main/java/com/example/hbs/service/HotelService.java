package com.example.hbs.service;

import com.example.hbs.domain.*;
import com.example.hbs.repo.AccountRepository;
import com.example.hbs.repo.AddressRepository;
import com.example.hbs.repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService  {

    private HotelRepository hotelRepository;
//    private AccountRepository accountRepository;
    private AddressRepository addressRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository
            , AddressRepository addressRepository) {
        this.hotelRepository = hotelRepository;
        this.addressRepository = addressRepository;
    }

    public Hotel createHotel(String username, String password, Role role, String name, String description, String photoUrl, Address address){
//        Account account1 = accountRepository.findById(Integer.parseInt(address)).orElseThrow(()->
//                new RuntimeException("Account does not exist: " + accountRepository));
//
        Address address1 = addressRepository.findByPhone(address.getPhone()).orElse(
                addressRepository.save(address)
        );

        return hotelRepository.save(new Hotel(username,password,role,name, description,photoUrl, address1));
    }


    public List<Hotel> getHotelsByAddressDistrict(String district){
        List<Hotel> hotels = hotelRepository.findByAddress_District(district);

        // if no hotels available
        if(hotels.size() == 0){
            throw new RuntimeException("No hotels available with this location");
        }

        return hotels;

    }



    /**
     * Lookup All Tour packages
     *
     * @return
     */
    public Iterable<Hotel> lookup(){
        return hotelRepository.findAll();
    }

    public long total() {
        return hotelRepository.count();
    }


}
