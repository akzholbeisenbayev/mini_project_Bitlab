
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    private MainFrame parent;
    private JButton addStudent;
    private JButton listStudents;
    private JButton exitButton;

    public MainMenu(MainFrame parent){
        this.parent=parent;

        setSize(500, 300);
        setLayout(null);

        addStudent = new JButton("ADD STUDENT");
        addStudent.setSize(300,30);
        addStudent.setLocation(100,50);
        add(addStudent);
        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenuPage().setVisible(false);
                parent.getAddStudentPage().setVisible(true);
            }
        });

        listStudents = new JButton("LIST STUDENTS");
        listStudents.setSize(300,30);
        listStudents.setLocation(100,100);
        add(listStudents);
        listStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PackageData pd = new PackageData("LIST_STUDENTS", null, null);
                parent.setMessage(pd);
                parent.getMainMenuPage().setVisible(false);
                parent.getListStudentsPage().setVisible(true);
            }

        });


        exitButton = new JButton("EXIT");
        exitButton.setSize(300,30);
        exitButton.setLocation(100,150);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

    }

}
