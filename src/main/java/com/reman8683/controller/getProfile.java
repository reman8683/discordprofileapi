package com.reman8683.controller;

import com.reman8683.dto.Profile;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

import static com.reman8683.Application.logger;

@Controller
public class getProfile {

    @Get("/{id}")
    public Profile profile(long id, @Nullable @QueryValue Integer size, @Nullable @QueryValue Boolean base64) {
        logger.info(id + " is searched.");
        base64 = base64 != null;
        size = size == null ? 128 : size;
        return new Profile(id, base64, size);
    }
}
