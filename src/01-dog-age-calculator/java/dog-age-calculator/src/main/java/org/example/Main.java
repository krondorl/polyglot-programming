package org.example;

public class Main {
    public static Object calculateDogAge(Short age) {
        if (age < 1) {
            throw new IllegalArgumentException("Error: age should be at least 1.");
        }
        return Math.round(16 * Math.log(age) + 31);
    }

    public static void main(String[] args) {
        System.out.println("Dog Age Calculator");
        try {
            Short age = 1;
            Object dogAge = calculateDogAge(age);
            System.out.println("Dog's age in human years: " + dogAge);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}