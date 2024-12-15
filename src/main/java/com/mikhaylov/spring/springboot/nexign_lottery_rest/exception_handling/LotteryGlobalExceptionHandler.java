package com.mikhaylov.spring.springboot.nexign_lottery_rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LotteryGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<LotteryExceptionData> handleException(
            NoSuchParticipantException exception) {

        LotteryExceptionData data = new LotteryExceptionData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<LotteryExceptionData> handleException(
            NoSuchWinnerException exception) {

        LotteryExceptionData data = new LotteryExceptionData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<LotteryExceptionData> handleException(InsufficientNumberOfParticipantsException exception) {
        LotteryExceptionData data = new LotteryExceptionData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<LotteryExceptionData> handleException(
            Exception e) {

        LotteryExceptionData data = new LotteryExceptionData();
        data.setInfo(e.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
