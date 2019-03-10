package com.vedantue.test.server.utils.exceptions;

public class EntityNotFoundException extends LANException{
    public EntityNotFoundException(String problem) {
        super(problem);
    }

    public EntityNotFoundException(String message, String problem) {
        super(message, problem);
    }
}
