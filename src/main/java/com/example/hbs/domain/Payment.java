package com.example.hbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer cardHolder;

    @Column
    private String cardNum;

    @Column
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column
    private Double paymentAmount;

    public Payment(){}

    public Payment(Customer cardHolder, String cardNum, Date paymentDate, Double paymentAmount) {
        this.cardHolder = cardHolder;
        this.cardNum = cardNum;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(cardHolder, payment.cardHolder) && Objects.equals(cardNum, payment.cardNum) && Objects.equals(paymentDate, payment.paymentDate) && Objects.equals(paymentAmount, payment.paymentAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNum, paymentDate, paymentAmount);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(Customer cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
