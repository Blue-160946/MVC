import model.Student_Model;
import view.Student_View;
import controller.Student_Controller;

public class Main {
    public static void main(String[] args) {
        
        Student_Model model = new Student_Model();
        Student_View view = new Student_View();
        Student_Controller controller = new Student_Controller(model, view);

        
        controller.run();
    }
}
