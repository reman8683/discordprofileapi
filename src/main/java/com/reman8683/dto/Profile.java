package com.reman8683.dto;

import com.reman8683.DiscordAPI;
import io.micronaut.serde.annotation.SerdeImport;
import net.dv8tion.jda.api.entities.User;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@SerdeImport(Profile.class)
public class Profile {
    long id;
    User user;
    Avatar avatar;
    Banner banner;

    public Profile(long id, boolean base64, int size) {
        this.id = id;
        this.user = new DiscordAPI().getUserById(id);

        try {
            this.avatar = new Avatar(this.user, size);
            this.banner = new Banner(this.user, size);

            this.avatar.setVisibleBase64(base64);
            this.banner.setVisibleBase64(base64);

        } catch (IOException | ExecutionException | InterruptedException e) {
            this.avatar = null;
            this.banner = null;
            throw new RuntimeException(e);
        }
    }

    public long getId() {
        return id;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public Banner getBanner() {
        return banner;
    }
}
