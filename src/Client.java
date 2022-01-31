import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        try {
            Socket socket = new Socket("localhost", 5555);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            PackageData pd  = null;
            while (true) {
                System.out.println("Waiting request");
                if((pd=mainFrame.getMessage()).getOperationType()!=null) {
                    System.out.println("Request: "+pd.getOperationType());
                    outputStream.writeObject(pd);
                    pd = (PackageData) inputStream.readObject();
                    mainFrame.setMessage(pd);
                    if(pd!=null){
                        if(pd.getOperationType().equals("STUDENT_ADDED")){
                            System.out.println("Response: "+pd.getOperationType());
                            mainFrame.setMessage(new PackageData());
                        }else if(pd.getOperationType().equals("LIST_STUDENTS_SEND")){
                            System.out.println("Response: "+pd.getOperationType());
                            ArrayList<Students> students=pd.getStudents();
                            mainFrame.getListStudentsPage().generateTable(students);
                            mainFrame.setMessage(new PackageData());
                            pd=null;
                        }
                    }
                    pd=null;
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
