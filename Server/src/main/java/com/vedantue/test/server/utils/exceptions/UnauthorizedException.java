package com.vedantue.test.server.utils.exceptions;

public class UnauthorizedException extends LANException {
    public UnauthorizedException(String problem) {
        super(problem);
    }

    public UnauthorizedException(String message, String problem) {
        super(message, problem);
    }
}
