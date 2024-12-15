package com.mikhaylov.spring.springboot.nexign_lottery_rest.exception_handling;

public class NoSuchWinnerException extends RuntimeException {
    public NoSuchWinnerException(String message) {
        super(message);
    }
}
