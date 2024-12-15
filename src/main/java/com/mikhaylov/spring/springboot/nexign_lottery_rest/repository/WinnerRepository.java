package com.mikhaylov.spring.springboot.nexign_lottery_rest.repository;

import com.mikhaylov.spring.springboot.nexign_lottery_rest.entity.Winner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WinnerRepository extends JpaRepository<Winner, Integer> {

    List<Winner> findAllByName(String name);
}

