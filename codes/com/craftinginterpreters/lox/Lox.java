package com.craftinginterpreters.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Lox {

    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Usage: jlox [script]");
            System.exit(64);
        } else if (args.length == 1) {
            runFile(args[0]);
        } else {
            runPrompt();
        }
    }

    private static void runFile(String path) throws IOException {
        String source = java.nio.file.Files.readString(java.nio.file.Paths.get(path));
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        for (Token token : tokens) {
            System.out.println(token);
        }
    }

    private static void runPrompt() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (;;) {
            System.out.print("> ");
            String line = reader.readLine();
            if (line == null) break;
            Scanner scanner = new Scanner(line);
            List<Token> tokens = scanner.scanTokens();
            for (Token token : tokens) {
                System.out.println(token);
            }
        }
    }

    public static void error(int line, String message) {
        System.err.println("[line " + line + "] Error: " + message);
    }
}
