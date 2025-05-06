package javaCollectionFramework.Assignment4;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.PriorityQueue;

// Main class
public class TaskPrioritizationEngine {

    // Task class with name, priority, deadline
    static class Task {
        private String name;
        private int priority; // higher = more important
        private LocalDate deadline;

        public Task(String name, int priority, LocalDate deadline) {
            this.name = name;
            this.priority = priority;
            this.deadline = deadline;
        }

        public String getName() {
            return name;
        }

        public int getPriority() {
            return priority;
        }

        public LocalDate getDeadline() {
            return deadline;
        }

        @Override
        public String toString() {
            return name + " | Priority: " + priority + " | Deadline: " + deadline;
        }
    }

    // Comparator: order by closest deadline, then highest priority
    static class TaskComparator implements Comparator<Task> {
        @Override
        public int compare(Task t1, Task t2) {
            int byDeadline = t1.getDeadline().compareTo(t2.getDeadline());
            if (byDeadline != 0) return byDeadline;
            return Integer.compare(t2.getPriority(), t1.getPriority()); // higher priority first
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(new TaskComparator());

        taskQueue.offer(new Task("Submit report", 2, LocalDate.of(2025, 5, 1)));
        taskQueue.offer(new Task("Team meeting", 3, LocalDate.of(2025, 4, 30)));
        taskQueue.offer(new Task("Code review", 1, LocalDate.of(2025, 5, 1)));
        taskQueue.offer(new Task("Update website", 2, LocalDate.of(2025, 4, 30)));

        System.out.println("Tasks execution order:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }
}
