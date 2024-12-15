package com.mikhaylov.spring.springboot.nexign_lottery_rest.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "lottery_winners")
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

    public Winner() {
    }

    public Winner(String name, int age, String city, LocalDateTime lotteryStartDate, int winningAmount) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.lotteryStartDate = lotteryStartDate;
        this.winningAmount = winningAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getLotteryStartDate() {
        return lotteryStartDate;
    }

    public void setLotteryStartDate(LocalDateTime lotteryStartDate) {
        this.lotteryStartDate = lotteryStartDate;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(int winningAmount) {
        this.winningAmount = winningAmount;
    }
}
