package com.mikhaylov.spring.springboot.nexign_lottery_rest.exception_handling;

public class InsufficientNumberOfParticipantsException extends RuntimeException {
    public InsufficientNumberOfParticipantsException(String message) {
        super(message);
    }
}
