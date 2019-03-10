package com.vedantue.test.server.utils.exceptions;

public class LANException extends Exception {

    private String problem;

    public LANException(String problem) {
        super(problem);
        this.problem = problem;
    }

    public LANException(String message, String problem) {
        super(message);
        this.problem = problem;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}
