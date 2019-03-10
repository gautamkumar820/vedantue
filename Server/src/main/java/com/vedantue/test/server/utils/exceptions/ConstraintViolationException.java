package com.vedantue.test.server.utils.exceptions;

public class ConstraintViolationException extends Exception {

    private String problem;

    public ConstraintViolationException(String problem) {
        this.problem = problem;
    }

    public ConstraintViolationException(String message, String problem) {
        super(message);
        if ( problem==null || problem.contains("")) {
            this.problem = "";
        }
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getProblem() {
        return problem;
    }

}
