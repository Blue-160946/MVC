import model.Student_Model;
import view.Student_View;
import controller.Student_Controller;

public class Main { // ต้องมีคลาสสำหรับ main method
    public static void main(String[] args) {
        // สร้างออบเจกต์สำหรับ Model, View และ Controller
        Student_Model model = new Student_Model();
        Student_View view = new Student_View();
        Student_Controller controller = new Student_Controller(model, view);

        // เรียกใช้ Controller เพื่อรันโปรแกรม
        controller.run();
    }
}
