package com.reman8683;

import net.dv8tion.jda.api.entities.User;

import static com.reman8683.Application.jda;

public class DiscordAPI {
    public User getUserById(long id) {
        return jda.retrieveUserById(id).complete();
    }
}
