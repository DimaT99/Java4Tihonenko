package workLog;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogService {
    public static void writeToFile() {
        File file = new File("src/workLog", "Log.txt");

        try (BufferedWriter bwriter = new BufferedWriter(new FileWriter(file))) {
            List<Log> logList = LogUtils.getLogList();
            for (Log log : logList) {
                if (getText("src/workLog/LogSet.txt").equals("DEBUG")) {
                    bwriter.write("\n" + "Date " + String.valueOf(log.getDateLog()) + "\n");
                    bwriter.write("Level " + String.valueOf(log.getLevel()) + "\n");
                    bwriter.write("Class " + String.valueOf(log.getName()) + "\n");
                    bwriter.write("Message " + String.valueOf(log.getMessage()) + "\n");
                }
                if (getText("src/workLog/LogSet.txt").equals("INFO")) {
                    bwriter.write("\n" + "Date " + String.valueOf(log.getDateLog()) + "\n");
                    bwriter.write("Level " + String.valueOf(log.getLevel()) + "\n");
                    bwriter.write("Class " + String.valueOf(log.getName()) + "\n");
                    bwriter.write("Message " + String.valueOf(log.getMessage()) + "\n");
                }
                if (getText("src/workLog/LogSet.txt").equals("WARNING")) {
                    bwriter.write("\n" + "Date " + String.valueOf(log.getDateLog()) + "\n");
                    bwriter.write("Level " + String.valueOf(log.getLevel()) + "\n");
                    bwriter.write("Class " + String.valueOf(log.getName()) + "\n");
                    bwriter.write("Message " + String.valueOf(log.getMessage()) + "\n");
                }
                if (getText("src/workLog/LogSet.txt").equals("ERROR")) {
                    bwriter.write("\n" + "Date " + String.valueOf(log.getDateLog()) + "\n");
                    bwriter.write("Level " + String.valueOf(log.getLevel()) + "\n");
                    bwriter.write("Class " + String.valueOf(log.getName()) + "\n");
                    bwriter.write("Message " + String.valueOf(log.getMessage()) + "\n");
                }
                if (getText("src/workLog/LogSet.txt").equals("OFF")) {
                    bwriter.write("\n" + "Date " + String.valueOf(log.getDateLog()) + "\n");
                    bwriter.write("Level " + String.valueOf(log.getLevel()) + "\n");
                    bwriter.write("Class " + String.valueOf(log.getName()) + "\n");
                    bwriter.write("Message " + String.valueOf(log.getMessage()) + "\n");
                }
                if (log.getLevel().equals(EnumLogLevel.WARNING) || log.getLevel().equals(EnumLogLevel.ERROR)) {
                    String stackTrace = Arrays.toString(log.stackTrace);
                    bwriter.write("Stacktrace" + String.valueOf(log.stackTrace) + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readToFile() {
        try (Reader reader = new BufferedReader(
                new FileReader("src/workLog/Log.txt"));
             PushbackReader pushbackReader = new PushbackReader(reader)) {

            StringBuilder newText = new StringBuilder();
            boolean inComment = false;

            int ch;
            while ((ch = pushbackReader.read()) != -1) {
                if (inComment) {
                    if (ch == '\n') {
                        newText.append((char) ch);
                        inComment = false;
                    }
                    continue;
                } else {
                    if (ch == '-') {
                        int nextChar = pushbackReader.read();
                        if (nextChar == -1 || nextChar != '-') {
                            newText.append((char) ch);
                            pushbackReader.unread(nextChar);
                        } else {
                            inComment = true;
                        }
                    } else {
                        newText.append((char) ch);
                    }
                }
            }
            System.out.println(newText);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeLog(final String path) {
        try {
            final Path p = Paths.get(path);

            if (!Files.exists(p)) {
                throw new IllegalStateException();
            }
            List<Log> logList = LogUtils.getLogList();
            for (Log log : logList) {
                if (getText("src/workLog/LogSet.txt").equals("DEBUG")) {
                    Files.write(p, System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
                    Files.write(p, ("Date " + log.getDateLog() + "\n").getBytes(), StandardOpenOption.APPEND);
                    Files.write(p, ("Level " + log.getLevel().toString() + "\n").getBytes(), StandardOpenOption.APPEND);
                    Files.write(p, ("Class " + log.getName().toString() + "\n").getBytes(), StandardOpenOption.APPEND);
                    Files.write(p, ("Message " + log.getMessage() + "\n").getBytes(), StandardOpenOption.APPEND);
                }
                if (getText("src/workLog/LogSet.txt").equals("INFO")) {
                    if (log.getLevel().equals(EnumLogLevel.INFO) || log.getLevel().equals(EnumLogLevel.WARNING)
                            || log.getLevel().equals(EnumLogLevel.ERROR) || log.getLevel().equals(EnumLogLevel.OFF)) {
                        Files.write(p, System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Date " + log.getDateLog() + "\n").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Level " + log.getLevel().toString() + "\n").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Class " + log.getName().toString() + "\n").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Message " + log.getMessage() + "\n").getBytes(), StandardOpenOption.APPEND);
                    }
                }
                if (getText("src/workLog/LogSet.txt").equals("WARNING")) {
                    if (log.getLevel().equals(EnumLogLevel.WARNING) || log.getLevel().equals(EnumLogLevel.ERROR) || log.getLevel().equals(EnumLogLevel.OFF)) {
                        Files.write(p, System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Date " + log.getDateLog() + "\n").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Level " + log.getLevel().toString() + "\n").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Class " + log.getName().toString() + "\n").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Message " + log.getMessage() + "\n").getBytes(), StandardOpenOption.APPEND);
                    }
                }
                if (getText("src/workLog/LogSet.txt").equals("ERROR")) {
                    if (log.getLevel().equals(EnumLogLevel.ERROR) || log.getLevel().equals(EnumLogLevel.OFF)) {
                        Files.write(p, System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Date " + log.getDateLog() + "\n").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Level " + log.getLevel().toString() + "\n").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Class " + log.getName().toString() + "\n").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Message " + log.getMessage() + "\n").getBytes(), StandardOpenOption.APPEND);
                    }
                }
                if (getText("src/workLog/LogSet.txt").equals("OFF")) {
                    if (log.getLevel().equals(EnumLogLevel.OFF)) {
                        Files.write(p, System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Date " + log.getDateLog() + "\n").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Level " + log.getLevel().toString() + "\n").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Class " + log.getName().toString() + "\n").getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, ("Message " + log.getMessage() + "\n").getBytes(), StandardOpenOption.APPEND);
                        String stackTrace = Arrays.toString(log.stackTrace);
                        Files.write(p, stackTrace.getBytes(), StandardOpenOption.APPEND);
                    }
                }
                if (log.getLevel().equals(EnumLogLevel.WARNING) || log.getLevel().equals(EnumLogLevel.ERROR)) {
                    String stackTrace = Arrays.toString(log.stackTrace);
                    Files.write(p, ("StackTrace " + stackTrace + "\n").getBytes(), StandardOpenOption.APPEND);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readText(final String path) {
        try {
            final Path p = Paths.get(path);
            String strings = Files.readString(p);
            System.out.println("Log level set " + strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getText(final String path) {
        try {
            final Path p = Paths.get(path);
            String strings = Files.readString(p);
            return strings;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException();
    }

    public static void writeLogSet(final String pathFrom, final String pathTo) {
        try {
            final Path p1 = Paths.get(pathTo);
            if (!Files.exists(p1)) {
                Files.createFile(p1);
            }
            final Path p2 = Paths.get(pathFrom);
            final String levelLog = String.valueOf(p2);
            Files.write(p1, levelLog.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}