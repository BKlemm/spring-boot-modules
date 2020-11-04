package org.jentix.pm2.example;

import org.jentix.pm2.library.Pm2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pm2ExampleApplication implements CommandLineRunner {

    @Autowired
    private Pm2 pm2;

    public static void main(String[] args) {
        SpringApplication.run(Pm2ExampleApplication.class, args);
    }

    public void run(String... args) throws Exception {
        pm2.start();
    }
}
