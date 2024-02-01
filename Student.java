
import java.util.Scanner;

public class Student {
    private String name;
    private double[] scores;
    private char grade;

    // Constructor to initialize the student's attributes
    public Student(String name, int numberOfSubjects) {
        this.name = name;
        scores = new double[numberOfSubjects];
    }

    // Method to take user input for the student's scores
    public void enterMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        for (int i = 0; i < scores.length; i++) {
            System.out.print("Enter Subject "+ (i + 1) + " Score : ");
            try {
                double marks=scanner.nextDouble();
                if(marks > 100  || marks<0){
                    System.out.println("Invalid Input  'Please enter Marks between 0 to 100 !'");
                    i--; // Retry input for the same score
                }else{
                    scores[i] = marks;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid numeric score.");
                scanner.next(); // Consume invalid input
                i--; // Retry input for the same score
            }
        }
        scanner.close();
    }

    // Method to calculate the average score and determine the corresponding grade
    public void calculateGrade() {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        double average = sum / scores.length;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    // Method to display the student's name, scores, average, and grade
    public void displayInformation() {

        System.out.println("Student Name: " + name);
        System.out.println("Scores: ");
        int subjectNumber=0;
        for (double score : scores) {
            System.out.println("        Subject "+ ++subjectNumber +" : " + score + " ");
        }
        System.out.println();
        System.out.println("Average Score: " + calculateAverage());
        System.out.println("Grade: " + grade);
        System.out.println();
    }

    // Method to calculate and return the average score
    public double calculateAverage() {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

    public static void main(String[] args) {
        int numberOfSubjects;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        do{
            System.out.print("Enter the number of subjects : ");
            numberOfSubjects = scanner.nextInt();
            if(numberOfSubjects <= 0){
                System.out.println(" Invalid Input - Subjects Should be Greater than 0 ");
            }      
        }while(numberOfSubjects <= 0);

        Student student = new Student(name, numberOfSubjects);
        student.enterMarks();
        student.calculateGrade();
        student.displayInformation();

        scanner.close();;
    }
}
