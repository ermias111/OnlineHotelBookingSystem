package com.example.hbs.web;

import com.example.hbs.domain.Customer;

import java.util.Date;

public class BookingDto {
    private Integer roomTypeId;
    private Integer numberOfRooms;
    private Integer customerId;
    private Date checkIn;
    private Date checkOut;
    private Long cardNum;
    private Date paymentDate;

    public BookingDto(Integer roomTypeId, Integer numberOfRooms,
                      Integer customerId, Date checkIn, Date checkOut,
                      Long cardNum, Date paymentDate) {
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

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Long getCardNum() {
        return cardNum;
    }

    public void setCardNum(Long cardNum) {
        this.cardNum = cardNum;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
