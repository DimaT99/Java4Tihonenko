package examination;

import entity.Student;

import java.util.*;

public class MyThreads {
    public static void myThreads() {

        try {
            ArrayList<Integer> taskList = new ArrayList<>();
            Map<String, Integer> result = new HashMap<>();

            for(int i = 1; i < 11; i++){
                taskList.add((i));
            }
            for (int i = 1; i < 11; i++) {
                Student student = new Student();
                student.setName("Student" + Student.getCount());
                result.put(student.getName(), 0);
                Thread timer = new Thread(() -> {
                    try {
                        Thread.sleep(new Random().nextInt(8, 15) * 1000);
                        result.put(Thread.currentThread().getName(), 1);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                });
                timer.setName(student.getName());
                System.out.println(timer.getName() + " get task " + taskList.remove(new Random().nextInt(taskList.size())));
                timer.setDaemon(true);
                timer.start();
            }
            Thread.sleep(12000);
            System.out.println("\n Result");
            ArrayList<String> executedThreads = new ArrayList<>();
            for (String threadNumber : result.keySet()) {
                if (result.get(threadNumber) == 1) {
                    executedThreads.add(threadNumber);
                }
            }
            for (int i = 0; i < executedThreads.size(); i++) {
                System.out.println(executedThreads.get(i) + " finished " + (i + 1));
            }
            for (Object threadNumber : result.keySet()) {
                if (result.get(threadNumber) == 0) {
                    System.out.println(threadNumber + " didn't have time");
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
