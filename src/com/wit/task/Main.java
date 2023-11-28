package com.wit.task;

import com.wit.task.enums.Priority;
import com.wit.task.models.Task;
import com.wit.task.models.TaskData;

public class Main {
    public static void main(String[] args) {

        TaskData td = new TaskData();

        td.addTask(new Task("proj1", "task1", Priority.LOW), "bob");
        td.addTask(new Task("proj1", "task1", Priority.LOW), "ann");

        td.addTask(new Task("proj1", "task2", Priority.LOW), "bob");

        td.addTask(new Task("proj1", "task3", Priority.HIGH), "carol");
        td.addTask(new Task("proj1", "task3", Priority.HIGH), "ann");
        td.addTask(new Task("proj1", "task4", Priority.HIGH), "carol");
        td.addTask(new Task("proj1", "task5", Priority.LOW), "ann");

        System.out.println(td.getAllTasksAssignedToMoreThanOnePerson());
        System.out.println(td.getAllTasks());



    }
}