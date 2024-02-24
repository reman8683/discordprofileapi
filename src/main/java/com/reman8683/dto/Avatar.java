package com.reman8683.dto;

import com.reman8683.util.Util;
import io.micronaut.serde.annotation.SerdeImport;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.utils.ImageProxy;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@SerdeImport(Avatar.class)
public class Avatar {
    String id;
    String name;
    String URL;
    ImageProxy imageProxy;
    boolean visibleBase64;
    String base64;


    public Avatar(User user, int size) throws IOException, ExecutionException, InterruptedException {
        this.id = user.getAvatarId();
        this.name = user.getEffectiveName();

        this.imageProxy = user.getEffectiveAvatar();

        this.URL = this.imageProxy.getUrl(size);
        this.base64 = Util.toBase64(this.imageProxy, size);
    }

    public void setVisibleBase64(boolean visibleBase64) {
        this.visibleBase64 = visibleBase64;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getURL() {
        return URL;
    }

    public String getBase64() {
        if (this.visibleBase64) {
            return base64;
        }
        return null;
    }
}
