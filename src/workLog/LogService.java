package workLog;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class LogService {
    public void writeToFile() {
        File file = new File("src/workLog", "Log.txt");

        try (BufferedWriter bwriter = new BufferedWriter(new FileWriter(file))) {
            List<Log> logList = LogUtils.getLogList();
            for (Log log : logList) {
                if (getText("src/workLog/LogSet.txt").equals("WARNING")) {
                    bwriter.write(String.valueOf(log.date) + " ");
                    bwriter.write(String.valueOf(log.getLevel()) + " ");
                    bwriter.write(String.valueOf(log.getName()) + " ");
                    bwriter.write(String.valueOf(log.getMessage()) + " ");
                    bwriter.write(String.valueOf(log.stackTrace) + " ");
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
                    String date = log.getDate() + " ";
                    Files.write(p, date.getBytes(), StandardOpenOption.APPEND);
                    String level = String.valueOf(log.getLevel()) + " ";
                    Files.write(p, level.getBytes(), StandardOpenOption.APPEND);
                    Files.write(p, log.getName().toString().getBytes(), StandardOpenOption.APPEND);
                    Files.write(p, log.getMessage().getBytes(), StandardOpenOption.APPEND);
                    String stackTrace = Arrays.toString(log.stackTrace);
                    Files.write(p, stackTrace.getBytes(), StandardOpenOption.APPEND);
                }
                if (getText("src/workLog/LogSet.txt").equals("INFO")) {
                    if (log.getLevel().equals(EnumLogLevel.INFO) || log.getLevel().equals(EnumLogLevel.WARNING)
                            || log.getLevel().equals(EnumLogLevel.ERROR) || log.getLevel().equals(EnumLogLevel.OFF)) {
                        Files.write(p, System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
                        String date = log.getDate() + " ";
                        Files.write(p, date.getBytes(), StandardOpenOption.APPEND);
                        String level = String.valueOf(log.getLevel()) + " ";
                        Files.write(p, level.getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, log.getName().toString().getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, log.getMessage().getBytes(), StandardOpenOption.APPEND);
                        String stackTrace = Arrays.toString(log.stackTrace);
                        Files.write(p, stackTrace.getBytes(), StandardOpenOption.APPEND);
                    }
                }
                if (getText("src/workLog/LogSet.txt").equals("WARNING")) {
                    if (log.getLevel().equals(EnumLogLevel.WARNING) || log.getLevel().equals(EnumLogLevel.ERROR) || log.getLevel().equals(EnumLogLevel.OFF)) {
                        Files.write(p, System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
                        String date = log.getDate() + " ";
                        Files.write(p, date.getBytes(), StandardOpenOption.APPEND);
                        String level = String.valueOf(log.getLevel()) + " ";
                        Files.write(p, level.getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, log.getName().toString().getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, log.getMessage().getBytes(), StandardOpenOption.APPEND);
                        String stackTrace = Arrays.toString(log.stackTrace);
                        Files.write(p, stackTrace.getBytes(), StandardOpenOption.APPEND);
                    }
                }
                if (getText("src/workLog/LogSet.txt").equals("ERROR")) {
                    if (log.getLevel().equals(EnumLogLevel.ERROR) || log.getLevel().equals(EnumLogLevel.OFF)) {
                        Files.write(p, System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
                        String date = log.getDate() + " ";
                        Files.write(p, date.getBytes(), StandardOpenOption.APPEND);
                        String level = String.valueOf(log.getLevel()) + " ";
                        Files.write(p, level.getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, log.getName().toString().getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, log.getMessage().getBytes(), StandardOpenOption.APPEND);
                        String stackTrace = Arrays.toString(log.stackTrace);
                        Files.write(p, stackTrace.getBytes(), StandardOpenOption.APPEND);
                    }
                }
                if (getText("src/workLog/LogSet.txt").equals("OFF")) {
                    if (log.getLevel().equals(EnumLogLevel.OFF)) {
                        Files.write(p, System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
                        String date = log.getDate() + " ";
                        Files.write(p, date.getBytes(), StandardOpenOption.APPEND);
                        String level = String.valueOf(log.getLevel()) + " ";
                        Files.write(p, level.getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, log.getName().toString().getBytes(), StandardOpenOption.APPEND);
                        Files.write(p, log.getMessage().getBytes(), StandardOpenOption.APPEND);
                        String stackTrace = Arrays.toString(log.stackTrace);
                        Files.write(p, stackTrace.getBytes(), StandardOpenOption.APPEND);
                    }
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