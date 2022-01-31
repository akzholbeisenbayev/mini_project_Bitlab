
import javax.swing.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private MainMenu mainMenuPage;
    private AddStudent addStudentPage;
    private ListStudents listStudentsPage;
    private PackageData pd = new PackageData();

    private ArrayList<Students> students = new ArrayList<>();

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("STUDENTS APPLICATION");
        setSize(500, 300);
        setLayout(null);
        mainMenuPage = new MainMenu(this);
        mainMenuPage.setVisible(true);
        add(mainMenuPage);

        addStudentPage = new AddStudent(this);
        addStudentPage.setVisible(false);
        add(addStudentPage);

        listStudentsPage = new ListStudents(this);
        listStudentsPage.setVisible(false);
        add(listStudentsPage);

    }

    public MainMenu getMainMenuPage() {
        return mainMenuPage;
    }

    public AddStudent getAddStudentPage() {
        return addStudentPage;
    }

    public ListStudents getListStudentsPage() {
        return listStudentsPage;
    }

    public ArrayList<Students> getStudents() {

        return (students);
    }

    public void setStudents(ArrayList<Students> students) {
        this.students = students;
    }

    public void setMessage(PackageData pd) {
        this.pd = pd;
    }

    public PackageData getMessage() {
        return pd;
    }


}