package com.apuestatotal.pago.service.controller.generic;

import static com.apuestatotal.pago.service.controller.generic.CodeEnum.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class GenericController {

    protected ResponseEntity<List<Map<String, String>>> getErrors(BindingResult result) {

        List<Map<String, String>> errors = result.getFieldErrors().stream().map(err -> {

            Map<String, String> error = new HashMap<>();

            error.put(err.getField(), err.getDefaultMessage());
            return error;
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    protected <T> ResponseEntity<?> getCreated(T t, String msg) {
        CustomResponse response = new CustomResponse();
        response.setCode(SUCCESS);
        response.setMessage(msg);
        response.setData(t);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    protected ResponseEntity<?> getBadRequest(String msg) {
        CustomResponse response = new CustomResponse();
        response.setCode(ERROR);
        response.setMessage(msg);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    protected ResponseEntity<?> getError(String msg, String path) {
        CustomResponse response = new CustomResponse();
        response.setCode(ERROR);
        response.setMessage(msg);
        response.setPath(path);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    protected ResponseEntity<?> getErrorCsv(List<String> errors, String path) {
        CustomResponse response = new CustomResponse();
        response.setCode(WARNING);
        response.setMessage(errors);
        response.setPath(path);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    protected ResponseEntity<?> getNotContent() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    protected <T> ResponseEntity<?> getOk(T t, String msg) {
        CustomResponse response = new CustomResponse();
        response.setCode(SUCCESS);
        response.setMessage(msg);
        response.setData(t);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
