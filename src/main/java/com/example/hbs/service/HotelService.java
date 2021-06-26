package com.example.hbs.service;

import com.example.hbs.domain.Account;
import com.example.hbs.domain.Address;
import com.example.hbs.domain.Hotel;
import com.example.hbs.repo.AccountRepository;
import com.example.hbs.repo.AddressRepository;
import com.example.hbs.repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class HotelService  {

    private HotelRepository hotelRepository;
    private AccountRepository accountRepository;
    private AddressRepository addressRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel createHotel(String name, String description, String photoUrl, Address address){
//        Account account1 = accountRepository.findById(Integer.parseInt(address)).orElseThrow(()->
//                new RuntimeException("Account does not exist: " + accountRepository));
//
//        Address address1 = addressRepository.findById(Integer.parseInt(address)).orElseThrow(()->
//                new RuntimeException("Address does not exist: " + hotelRepository));

        return hotelRepository.save(new Hotel(name, description,photoUrl, address));
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
