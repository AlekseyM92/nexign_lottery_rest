package com.mikhaylov.spring.springboot.nexign_lottery_rest.repository;

import com.mikhaylov.spring.springboot.nexign_lottery_rest.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    List<Participant> findAllByName(String name);
}

