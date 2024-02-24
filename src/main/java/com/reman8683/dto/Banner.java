package com.reman8683.dto;

import com.reman8683.util.Util;
import io.micronaut.serde.annotation.SerdeImport;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.utils.ImageProxy;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@SerdeImport(Banner.class)
public class Banner {
    User.Profile profile;
    String id;
    String URL;
    ImageProxy imageProxy;
    boolean visibleBase64;
    String base64;


    public Banner(User user, int size) throws IOException, ExecutionException, InterruptedException {
        this.profile = user.retrieveProfile().complete();
        this.id = this.profile.getBannerId();
        this.imageProxy = this.profile.getBanner();

        assert this.imageProxy != null;
        this.URL = this.imageProxy.getUrl(size);
        this.base64 = Util.toBase64(this.imageProxy, size);
    }

    public void setVisibleBase64(boolean visibleBase64) {
        this.visibleBase64 = visibleBase64;
    }

    public String getId() {
        return id;
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
