package com.wit.task.models;

import com.wit.task.enums.Priority;
import com.wit.task.enums.Status;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Task {

    private String project;
    private String description;
    private String assignee;
    private Status status;
    private Priority priority;

    private List<String> employees = Arrays.asList("ann", "carol", "bob");


    public Task(String project, String description, Priority priority) {
        this.project = project;
        this.description = description;
        this.priority = priority;
        this.status = Status.IN_QUEUE;
    }

    public String assign(String assignee) {

        if(null == assignee)
            return null;

        String formattedAssignee = assignee.trim().toLowerCase();

        if(employees.indexOf(formattedAssignee) < 0)
            return null;

        this.assignee = formattedAssignee;
        this.status = Status.ASSIGNED;
        return formattedAssignee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(project, task.project) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, description);
    }

    @Override
    public String toString() {
        return "Task{" +
                "project='" + project + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
