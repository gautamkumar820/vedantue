package com.vedantue.test.server.utils.exceptions;

import org.springframework.http.ResponseEntity;

public interface Executor<T> {

    ResponseEntity<T> execute() throws Exception;

}
