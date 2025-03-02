package com.project.student_grade_tracker;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Grade: " + grade;
    }
}

public class Student_Grade_Tracker {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Grade Tracker");
            System.out.println("1. Add Student");
            System.out.println("2. View Students and their Performance");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent(students, scanner);
                    break;
                case 2:
                    viewStudentsAndStatistics(students);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student grade: ");
        int grade = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        students.add(new Student(name, grade));
        System.out.println("Student added successfully!");
    }

    private static void viewStudentsAndStatistics(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        System.out.println("\nStudent List:");
        for (Student student : students) {
            System.out.println(student);
        }

        calculateAndDisplay(students);
    }

    private static void calculateAndDisplay(ArrayList<Student> students) {
        if (students.isEmpty()) {
            return;
        }

        int sum = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (Student student : students) {
            int grade = student.getGrade();
            sum += grade;
            highest = Math.max(highest, grade);
            lowest = Math.min(lowest, grade);
        }

        double average = (double) sum / students.size();

        System.out.println("\nComputing Grades...");
        System.out.println("Average Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
    }
}