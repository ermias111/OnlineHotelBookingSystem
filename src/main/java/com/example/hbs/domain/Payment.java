package com.example.hbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer cardHolder;

    @Column
    private Long cardNum;

    @Column
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column
    private Double paymentAmount;

    public Payment(){}

    public Payment(Customer cardHolder, Long cardNum, Date paymentDate, Double paymentAmount) {
        this.cardHolder = cardHolder;
        this.cardNum = cardNum;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }
}
