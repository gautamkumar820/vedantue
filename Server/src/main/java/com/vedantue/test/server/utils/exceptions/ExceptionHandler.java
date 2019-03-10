package com.vedantue.test.server.utils.exceptions;

import com.google.gson.JsonSyntaxException;
import com.vedantue.test.server.utils.JsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionHandler {

    public static ResponseEntity handle(Executor<String> executor, String exceptionMessage){
        try {
            return executor.execute();
        } catch (JsonSyntaxException jsonSyntaxException ) {
            jsonSyntaxException.printStackTrace();
            return new ResponseEntity<>(
                    JsonResponse.constructResponse(
                            "failed",
                            "Json Syntax is not correct"
                    ), HttpStatus.BAD_REQUEST
            );
        } catch (ConstraintViolationException constraintViolationException) {
            return new ResponseEntity<>(
                    JsonResponse.constructResponse(
                            "failed",
                            constraintViolationException.getProblem()
                    ),
                    HttpStatus.BAD_REQUEST
            );
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            return new ResponseEntity<>(
                    JsonResponse.constructResponse(
                            "failed",
                            dataIntegrityViolationException.getProblem()
                    ),
                    HttpStatus.BAD_REQUEST
            );
        } catch (EntityNotFoundException entityNotFoundException) {
            return new ResponseEntity<>(
                    JsonResponse.constructResponse(
                            "failed",
                            entityNotFoundException.getProblem()
                    ),
                    HttpStatus.NOT_FOUND
            );
        } catch (UnauthorizedException unauthorizedException) {
            return new ResponseEntity<>(
                    JsonResponse.constructResponse(
                            "failed",
                            unauthorizedException.getProblem()
                    ), HttpStatus.UNAUTHORIZED
            );
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(
                    JsonResponse.constructResponse(
                            "failed",
                            exceptionMessage
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
