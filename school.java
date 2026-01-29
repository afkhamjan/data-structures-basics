import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    String grade;
    double marks;

    Student(String name, int rollNo, String grade, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
        this.marks = marks;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Grade: " + grade);
        System.out.println("Marks: " + marks);
        System.out.println("-------------------------");
    }
}

public class school {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        Student[] students = new Student[n];


        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Roll No: ");
            int rollNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Grade: ");
            String grade = sc.nextLine();

            System.out.print("Marks: ");
            double marks = sc.nextDouble();
            sc.nextLine();

            students[i] = new Student(name, rollNo, grade, marks);
        }

        if (n >= 2) {
            System.out.println("\nMarks of second student: " + students[1].marks);
        } else {
            System.out.println("\nThere is no second student.");
        }

        System.out.println("\nAll Student Details:");

        for (int i=0;i<n;i++){
            students[i].displayDetails();
        }
    }
}