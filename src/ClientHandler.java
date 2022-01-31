
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread{
    private Socket socket;
    private int id;
    private DBManager db;


    public ClientHandler(Socket socket,int id, DBManager db) {
        this.socket = socket;
        this.id = id;
        this.db=db;
    }

    public void run(){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData data = null;

            while((data = (PackageData) inputStream.readObject()).getOperationType()!=null) {
                PackageData response = null;

                if (data.getOperationType().equals("ADD_STUDENTS")) {
                    db.addStudent(data.getStudent());
                    System.out.println("Client "+id+" has added student: name:"+data.getStudent().getName()+"; surname:"
                            +data.getStudent().getSurname()+"; age:"+data.getStudent().getAge());
                    response=new PackageData("STUDENT_ADDED", null, data.getStudent());
                    outputStream.writeObject(response);
                } else if (data.getOperationType().equals("LIST_STUDENTS")) {
                    System.out.println("Client "+id+" has requested "+data.getOperationType());
                    ArrayList<Students> students = db.getAllStudents();
                    response = new PackageData("LIST_STUDENTS_SEND", db.getAllStudents(), null);
                    outputStream.writeObject(response);
                } else {
                    System.out.println("Data is empty");
                }
                data=null;
            }
        }catch (Exception e){
            // e.printStackTrace();
            System.out.println("Client "+id+" has disconnected\n"+"THE SERVER KEEPS LISTENING");
        }
    }
}