package com.reman8683.util;

import net.dv8tion.jda.api.utils.ImageProxy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.concurrent.ExecutionException;

public class Util {
    public static String toBase64(ImageProxy imageProxy, int size) throws IOException, ExecutionException, InterruptedException {
        InputStream image = imageProxy.download(size).get();
        byte[] imageBytes = image.readAllBytes();

        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
