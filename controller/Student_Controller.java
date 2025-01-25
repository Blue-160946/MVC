package controller;

import java.util.List;

import model.Student_Model;
import view.Student_View;

public class Student_Controller {
    private Student_Model model;
    private Student_View view;

    public Student_Controller(Student_Model model, Student_View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        boolean status = true;
        do {
            view.display();
            String input = view.input_menu();
            switch (input) {
                case "1":
                    add_student();
                    break;
                case "2":
                    delete_student();
                    break;
                case "3":
                    view_student();
                    break;
                case "4":
                    status = false;
                    break;
                default:
                    view.invalid_menu();
            }
        } while (status);
    }

    public void add_student() {
        String student_id = view.get_studentnumber();
        String student_firstname = view.get_firstname();
        String student_lastname = view.get_lastname();

        model.add_student(student_id, student_firstname, student_lastname);
    }

    public void delete_student() {
        String student_id = view.delete_student();

        model.delete_student(student_id);
    }

    public void view_student() {
        List<String> students = model.view_student();

        view.view_student(students);
    }
}
