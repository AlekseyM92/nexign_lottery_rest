package com.mikhaylov.spring.springboot.nexign_lottery_rest.controller;

import com.mikhaylov.spring.springboot.nexign_lottery_rest.entity.Participant;
import com.mikhaylov.spring.springboot.nexign_lottery_rest.entity.Winner;
import com.mikhaylov.spring.springboot.nexign_lottery_rest.exception_handling.InsufficientNumberOfParticipantsException;
import com.mikhaylov.spring.springboot.nexign_lottery_rest.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @Autowired
    LotteryService lotteryService;

    public static int MIN_VALUE = 1;
    public static int MAX_VALUE = 1000;

    @GetMapping("/participant")
    public List<Participant> getAllParticipants() {
        return lotteryService.getAllParticipants();
    }

    @PostMapping("/participant")
    public void saveParticipant(@RequestBody Participant participant) {
        lotteryService.safeParticipant(participant);
    }

    @GetMapping("/start")
    public Winner start() {
        List<Participant> participants = lotteryService.getAllParticipants();

        if (participants.size() < 2) {
            throw new InsufficientNumberOfParticipantsException("Number of participants is less than 2");
        }

        int sumOfPrize = lotteryService.getRandomSumOfPrize(MIN_VALUE, MAX_VALUE);
        Participant randomParticipant = lotteryService.getRandomParticipant(participants);

        Winner winner = new Winner(
                randomParticipant.getName(),
                randomParticipant.getAge(),
                randomParticipant.getCity(),
                LocalDateTime.now(),
                sumOfPrize
        );
        lotteryService.safeWinner(winner);
        lotteryService.deleteAllParticipants();
        return winner;
    }

    @GetMapping("/winners")
    public List<Winner> getAllWinners() {
        return lotteryService.getAllWinners();
    }
}
