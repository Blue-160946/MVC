package view;

import java.util.List;
import java.util.Scanner;

public class Student_View {
    private Scanner scanner = new Scanner(System.in);

    public void display() {
        System.out.println("""
            Registration_system

            1.Add Student
            2.Delete Student
            3.view Student
            4.Exit
            """);
    }

    public String input_menu(){
        System.out.print("Enter Menu (1-4): ");
        return scanner.nextLine();
    }

    public void invalid_menu(){
        System.out.println("Invalid option, please try again.");
        System.out.println("");
    }

    public String get_studentnumber() {
        System.out.print("Enter Student number : ");
        return scanner.nextLine();
    }

    public String get_firstname() {
        System.out.print("Enter FirstName : ");
        return scanner.nextLine();
    }

    public String get_lastname() {
        System.out.print("Enter LastName : ");
        return scanner.nextLine();
    }

    public String delete_student() {
        System.out.println("Delete Student");
        System.out.print("Enter Student ID : ");
        return scanner.nextLine();
    }

    public void view_student(List<String> students) {
        System.out.println("View Student");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

}
