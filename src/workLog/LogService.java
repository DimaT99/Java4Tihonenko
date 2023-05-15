package workLog;

import java.io.*;
import java.util.List;

public class LogService {
    public void WriteToFile() {
        File file = new File("src/workLog", "Log.txt");

        try (BufferedWriter bwriter = new BufferedWriter(new FileWriter(file))) {
            List<Log> logList = LogUtils.getLogList();
            for (Log log : logList) {
                bwriter.write(String.valueOf(log.date) + "\n");
                bwriter.write(String.valueOf(log.getLevel() + "\n"));
                bwriter.write(String.valueOf(log.getName() + "\n"));
                bwriter.write(String.valueOf(log.getMessage() + "\n"));
                bwriter.write(String.valueOf(log.stackTrace + "\n"));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ReadToFile() {
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
}