package com.example.hbs.web;

import com.example.hbs.domain.Hotel;
import com.example.hbs.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/hotels")
public class HotelController {
    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping(path = "/findByAddressDistrict")
    public List<Hotel> getByDistrict(@RequestParam String district){
        return hotelService.getHotelsByAddressDistrict(district);
    }

    @GetMapping(path = "/findByAddressCity")
    public List<Hotel> getByCity(@RequestParam String city){
        return hotelService.getHotelsByAddressCity(city);
    }

    @GetMapping(path = "{hotelId}")
    public Hotel getById(@RequestParam Integer hotelId){
        return hotelService.getHotelById(hotelId);
    }
}
