package com.mikhaylov.spring.springboot.nexign_lottery_rest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "lottery_winners")
@NoArgsConstructor
@Getter
@Setter
public class Winner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "winner_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "city")
    private String city;

    @Column(name = "lottery_start_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime lotteryStartDate;

    @Column(name = "winning_amount")
    private int winningAmount;

    public Winner(String name, int age, String city, LocalDateTime lotteryStartDate, int winningAmount) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.lotteryStartDate = lotteryStartDate;
        this.winningAmount = winningAmount;
    }
}
