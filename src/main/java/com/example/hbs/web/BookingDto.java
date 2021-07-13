package com.example.hbs.web;

import java.time.LocalDateTime;
import java.util.Date;

public class BookingDto {
    private Integer roomTypeId;
    private Integer numberOfRooms;
    private Integer customerId;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private String cardNum;
    private LocalDateTime paymentDate;

    public BookingDto(Integer roomTypeId, Integer numberOfRooms,
                      Integer customerId, LocalDateTime checkIn, LocalDateTime checkOut,
                      String cardNum, LocalDateTime paymentDate) {
        this.roomTypeId = roomTypeId;
        this.numberOfRooms = numberOfRooms;
        this.customerId = customerId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cardNum = cardNum;
        this.paymentDate = paymentDate;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}
