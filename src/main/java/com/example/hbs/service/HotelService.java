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
    private AccountRepository accountRepository;
    private AddressRepository addressRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel createHotel(String username, String password, Role role, String name, String description, String photoUrl, Address address, List<Room> rooms){
//        Account account1 = accountRepository.findById(Integer.parseInt(address)).orElseThrow(()->
//                new RuntimeException("Account does not exist: " + accountRepository));
//
//        Address address1 = addressRepository.findById(Integer.parseInt(address)).orElseThrow(()->
//                new RuntimeException("Address does not exist: " + hotelRepository));

        return hotelRepository.save(new Hotel(username,password,role,name, description,photoUrl, address,rooms));
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
