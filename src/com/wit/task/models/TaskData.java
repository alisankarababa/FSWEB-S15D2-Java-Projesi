package com.wit.task.models;

import java.util.*;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;

    public TaskData() {
        this.annsTasks = new HashSet<>();
        this.bobsTasks = new HashSet<>();
        this.carolsTasks = new HashSet<>();
    }

    private Set<Task> getTasks(String queryParam) {

        Set<Task> tasks = new HashSet<>();

        switch (queryParam) {

            case "ann":
                tasks.addAll(annsTasks);
                break;
            case "bob":
                tasks.addAll(bobsTasks);
                break;
            case "carol":
                tasks.addAll(carolsTasks);
                break;
            case "all":
                tasks.addAll(annsTasks);
                tasks.addAll(bobsTasks);
                tasks.addAll(carolsTasks);
                break;
            default:
                System.out.println("TaskData.java.getTasks.InvalidParameter. Valid parameters: ann, bob, carol, all");
        }

        return tasks;
    }

    public Set<Task> getAllTasks() {
        return getUnion(Arrays.asList(annsTasks, carolsTasks, bobsTasks));
    }

    public Set<Task> getAllTasksAssignedToMoreThanOnePerson() {

        Set<Task> ac = getIntersect(annsTasks, carolsTasks);
        Set<Task> ab = getIntersect(annsTasks, bobsTasks);
        Set<Task> bc = getIntersect(bobsTasks, carolsTasks);
        return getUnion(Arrays.asList(ac, ab, bc));
    }

    public boolean addTask(Task task, String assignee) {

        if(null == task)
            return false;

        String retAssign = task.assign(assignee);
        if(null == retAssign)
            return false;

        switch (retAssign) {

            case "ann":
                return annsTasks.add(task);
            case "bob":
                return bobsTasks.add(task);
            case "carol":
                return carolsTasks.add(task);
            default:
                break;
        }

        return false;
    }


    private Set<Task> getUnion(List<Set<Task>> list) {
        Set<Task> union = new HashSet<>();
        for(Set<Task> set : list) {

            union.addAll(set);
        }
        return union;
    }

    private Set<Task> getIntersect(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        return intersection;
    }

    private Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {
        Set<Task> difference = new HashSet<>(set1);
        difference.removeAll(set2);

        return difference;
    }

}


