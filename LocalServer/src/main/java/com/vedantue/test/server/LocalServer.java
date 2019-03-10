package com.vedantue.test.server;

import org.eclipse.jetty.runner.Runner;

import java.util.Arrays;

public class LocalServer {
    public static void main(String[] args) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder("/usr/lib/maven/bin/mvn", "clean", "package").inheritIO();
        Process process = processBuilder.start();
        process.waitFor();
        if (process.exitValue() != 0) throw new RuntimeException("Packaging error: " + process.getOutputStream());
        Runner runner = new Runner();
        String[] argu = Arrays.asList("/home/innovatorsbay/Downloads/VedantueTest/vedantue/Server/target/Server.war").toArray(new String[0]);
        runner.configure(argu);
        runner.run();
    }
}