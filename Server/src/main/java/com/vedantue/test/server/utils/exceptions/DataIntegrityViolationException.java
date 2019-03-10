package com.vedantue.test.server.utils.exceptions;

public class DataIntegrityViolationException extends LANException {

    public DataIntegrityViolationException(String problem) {
        super(problem);
    }

    public DataIntegrityViolationException(String message, String problem) {
        super(message, problem);
    }
}
