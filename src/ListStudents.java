
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListStudents extends JPanel {
    private MainFrame parent;
    private JLabel label;
    private JButton back;

    private String header[] = {"Name","Surname","Age"};
    private JTable table;
    private JScrollPane scrollPane;

    public ListStudents(MainFrame parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        label = new JLabel("LIST OF STUDENTS:");
        label.setSize(300,30);
        label.setLocation(10,10);
        add(label);

        back = new JButton("Back");
        back.setSize(300,30);
        back.setLocation(100,220);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //  parent.getAddStudentPage().setVisible(false);
                parent.getListStudentsPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });

        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(460,150);
        scrollPane.setLocation(10,50);
        add(scrollPane);
    }

    public void generateTable(ArrayList<Students> students){
        Object data[][] = new Object[students.size()][3];

        for(int i =0;i<students.size();i++){
            data[i][0]=students.get(i).getName();
            data[i][1] = students.get(i).getSurname();
            data[i][2] = students.get(i).getAge();
        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);

    }
}
