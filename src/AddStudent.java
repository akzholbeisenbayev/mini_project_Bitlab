
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddStudent extends JPanel {
    private MainFrame parent;

    private JLabel label;

    private JButton buttonAdd;
    private JButton buttonBack;

    private JTextField textFieldId;
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldAge;

    public AddStudent(MainFrame parent){
        this.parent=parent;

        setSize(500,300);
        setLayout(null);

        label = new JLabel("NAME:");
        label.setSize(100, 30);
        label.setLocation(70, 40);
        add(label);

        textFieldName = new JTextField("");
        textFieldName.setSize(300,30);
        textFieldName.setLocation(120, 40);
        add(textFieldName);

        label = new JLabel("SURNAME:");
        label.setSize(100, 30);
        label.setLocation(50,80);
        add(label);

        textFieldSurname = new JTextField("");
        textFieldSurname.setSize(300, 30);
        textFieldSurname.setLocation(120, 80);
        add(textFieldSurname);

        label = new JLabel("AGE: ");
        label.setSize(100, 30);
        label.setLocation(80,120);
        add(label);

        textFieldAge = new JTextField("");
        textFieldAge.setSize(300, 30);
        textFieldAge.setLocation(120, 120);
        add(textFieldAge);


        buttonAdd = new JButton("ADD");
        buttonAdd.setSize(125,30);
        buttonAdd.setLocation(100, 200);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldName.getText()!= null &&
                        textFieldSurname.getText()!=null &&
                        textFieldAge.getText()!=null){
                    Students s = new Students( null,textFieldName.getText(),textFieldSurname.getText(),Integer.parseInt(textFieldAge.getText()));
                    PackageData pd = new PackageData("ADD_STUDENTS", null, s);
                    parent.setMessage(pd);
                    textFieldAge.setText("");
                    textFieldName.setText("");
                    textFieldSurname.setText("");
                }
            }
        });

        add(buttonAdd);

        buttonBack = new JButton("BACK");
        buttonBack.setSize(125,30);
        buttonBack.setLocation(275, 200);
        add(buttonBack);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAddStudentPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }

}


