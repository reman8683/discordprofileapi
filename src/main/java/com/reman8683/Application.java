package com.reman8683;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OpenAPIDefinition(
        info = @Info(
                title = "discordprifileapi",
                description = "API for DiscordProfile",
                version = "0.0"
        )
)

//MTIxMDUxMzYyNDYwMzI5OTg1MA.Gt9w3P.yxz6fZ4ftQ616dL3vNIXGjrbIZjdW8kKVqxTgc
public class Application {
    public static final Logger logger = LogManager.getLogger();
    public static final String token = "MTIxMDUxMzYyNDYwMzI5OTg1MA.Gt9w3P.yxz6fZ4ftQ616dL3vNIXGjrbIZjdW8kKVqxTgc";
    public static JDA jda = JDABuilder.createDefault(token).build();

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}