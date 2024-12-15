package com.mikhaylov.spring.springboot.nexign_lottery_rest.exception_handling;

public class NoSuchParticipantException extends RuntimeException {
    public NoSuchParticipantException(String message) {
        super(message);
    }
}
