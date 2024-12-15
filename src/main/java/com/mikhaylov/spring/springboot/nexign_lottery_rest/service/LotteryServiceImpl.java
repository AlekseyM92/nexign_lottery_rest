package com.mikhaylov.spring.springboot.nexign_lottery_rest.service;

import com.mikhaylov.spring.springboot.nexign_lottery_rest.entity.Participant;
import com.mikhaylov.spring.springboot.nexign_lottery_rest.entity.Winner;
import com.mikhaylov.spring.springboot.nexign_lottery_rest.repository.ParticipantRepository;
import com.mikhaylov.spring.springboot.nexign_lottery_rest.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class LotteryServiceImpl implements LotteryService {

    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private WinnerRepository winnerRepository;

    private RestTemplate restTemplate;
    private final String URL = "https://www.random.org/integers/?num=1&min=minValue&max=maxValue&col=1&base=10&format=plain&rnd=new";

    @Override
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    @Override
    public Participant getParticipantById(int id) {
        Participant participant = null;
        Optional<Participant> optionalParticipant = participantRepository.findById(id);
        if (optionalParticipant.isPresent()) {
            participant = optionalParticipant.get();
        }
        return participant;
    }

    @Override
    public List<Participant> getParticipantByName(String name) {
        return participantRepository.findAllByName(name);
    }

    @Override
    public void safeParticipant(Participant participant) {
        participantRepository.save(participant);
    }

    @Override
    public void deleteAllParticipants() {
        participantRepository.deleteAll();
    }

    @Override
    public List<Winner> getAllWinners() {
        return winnerRepository.findAll();
    }

    @Override
    public Winner getWinnerById(int id) {
        Winner winner = null;
        Optional<Winner> optionalWinner = winnerRepository.findById(id);
        if (optionalWinner.isPresent()) {
            winner = optionalWinner.get();
        }
        return winner;
    }

    @Override
    public void safeWinner(Winner winner) {
        winnerRepository.save(winner);
    }

    @Override
    public List<Winner> getWinnerByName(String name) {
        return winnerRepository.findAllByName(name);
    }

    @Override
    public Integer getRandomSumOfPrize(int minValue, int maxValue) {
        restTemplate = new RestTemplate();

        String url = URL
                .replaceAll("minValue", Integer.toString(minValue))
                .replaceAll("maxValue", Integer.toString(maxValue));

        //System.out.println(url);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String result = response
                    .getBody()
                    .replaceAll("\n","")
                    .replaceAll(" ","");
            //System.out.println(result);
            try {
                return Integer.parseInt(result);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        }
        System.out.println("HttpStatus: " + response.getStatusCode() + " " + response.getBody());
        int sumOfPrize = minValue + (int) (Math.random() * (maxValue - minValue + 1));
        return sumOfPrize;
    }

    @Override
    public Participant getRandomParticipant(List<Participant> participants) {
        var random = new SecureRandom();
        return participants.get(random.nextInt(participants.size()));
    }
}
