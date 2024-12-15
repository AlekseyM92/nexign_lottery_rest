package com.mikhaylov.spring.springboot.nexign_lottery_rest.service;

import com.mikhaylov.spring.springboot.nexign_lottery_rest.entity.Participant;
import com.mikhaylov.spring.springboot.nexign_lottery_rest.entity.Winner;

import java.util.List;

public interface LotteryService {

    public List<Participant> getAllParticipants();
    public Participant getParticipantById(int id);
    public List<Participant> getParticipantByName(String name);
    public void safeParticipant(Participant participant);
    public void deleteAllParticipants();
    public List<Winner> getAllWinners();
    public Winner getWinnerById(int id);
    public void safeWinner(Winner winner);
    public List<Winner> getWinnerByName(String name);
    public Integer getRandomSumOfPrize(int minValue, int maxValue);
    public Participant getRandomParticipant(List<Participant> participants);
}
