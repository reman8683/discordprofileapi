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
                title = "discordprofileapi",
                description = "API for DiscordProfile",
                version = "0.0"
        )
)

public class Application {
    public static final Logger logger = LogManager.getLogger();
    public static JDA jda;

    public static void main(String[] args) {
        jda = JDABuilder.createDefault(args[0]).build();
        Micronaut.run(Application.class, args);
    }
}