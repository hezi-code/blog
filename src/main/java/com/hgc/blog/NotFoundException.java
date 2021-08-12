package com.hgc.blog;/**
 * ClassName:NotFountException
 * Package:com.hgc.blog
 * description:
 *
 * @Date:2021/3/24 20:19
 * @aUTHOR:HGC
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *ClassName:NotFountException
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
