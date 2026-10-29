# java-priority-queue

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In computer science, a priority queue is an abstract data type which is like a regular queue, but where additionally each element has a "priority" associated with it. In a priority queue, an element with high priority is served before an element with low priority. - [Wikipedia](https://en.wikipedia.org/wiki/Priority_queue)
***

In this problem we will test your knowledge on [Java Priority Queue](https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html). 

There are a number of students in a school who wait to be served. Two types of events, *ENTER* and *SERVED*, can take place which are described below.

- *ENTER*: A student with some priority enters the queue to be served.
- *SERVED*: The student with the highest priority is served (removed) from the queue.

A unique id is assigned to each student entering the queue. The queue serves the students based on the following criteria (priority criteria):

1. The student having the highest *Cumulative Grade Point Average* (CGPA) is served first. 
2. Any students having the *same CGPA* will be served by name in ascending case-sensitive alphabetical order. 
3. Any students having the *same CGPA and name* will be served in ascending order of the id.

Create the following two classes:

- The *Student* class should implement:
	- The constructor `Student(int id, String name, double cgpa)`.
    - The method `int getID()` to return the id of the student.
    - The method `String getName()` to return the name of the student.
    - The method `double getCGPA()` to return the CGPA of the student.
- The *Priorities* class should implement the method `List<Student> getStudents(List<String> events)` to process all the given events and return all the students yet to be served in the priority order.

**Input Format**

The first line contains an integer, $n$, describing the total number of events. Each of the $n$ subsequent lines will be of the following two forms:

- `ENTER name CGPA id`: The student to be inserted into the priority queue.
- `SERVED`: The highest priority student in the queue was served.

The locked stub code in the editor reads the input and tests the correctness of the *Student* and *Priorities* classes implementation.

**Constraints**

- $2 \le n \le 1000$
- $0 \le CGPA \le 4.00$
- $1 \le id \le 10^{5}$
- $2 \le |name| \le 30$

**Output Format**

The locked stub code prints the names of the students yet to be served in the priority order. If there are no such student, then the code prints `EMPTY`.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T09:12:05.045Z  

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */
class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        java.util.PriorityQueue<Student> queue = new java.util.PriorityQueue<>(
            (s1, s2) -> {
                int cgpaCompare = Double.compare(s2.getCGPA(), s1.getCGPA());
                if (cgpaCompare != 0) {
                    return cgpaCompare;
                }

                int nameCompare = s1.getName().compareTo(s2.getName());
                if (nameCompare != 0) {
                    return nameCompare;
                }

                return Integer.compare(s1.getID(), s2.getID());
            }
        );

        for (String event : events) {
            String[] parts = event.split(" ");

            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);

                queue.add(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                queue.poll();
            }
        }

        List<Student> students = new ArrayList<>();

        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }

        return students;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-priority-queue/problem)