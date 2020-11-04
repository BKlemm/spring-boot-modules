package org.jentix.pm2.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Pm2 {

    private Pm2Config config;

    public Pm2(Pm2Config config) {
        this.config = config;
    }

    public void start() throws IOException {
        Process           process = new ProcessBuilder("pm2","start").start();
        InputStream       is      = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader    br  = new BufferedReader(isr);
        String            line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
