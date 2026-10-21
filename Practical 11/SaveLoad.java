import java.io.*;

class Student implements Serializable {
    int id;
    String name;
    transient String password;

    Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String toString() {
        return id + " " + name + " " + password;
    }
}

public class SaveLoad {
    public static void main(String[] args) throws Exception {
        Student[] s = {
            new Student(1, "Neel", "abc123"),
            new Student(2, "Rahul", "xyz456")
        };

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.dat"));
        out.writeObject(s);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.dat"));
        Student[] a = (Student[]) in.readObject();
        in.close();

        for (Student x : a) {
            System.out.println(x);
        }
    }
}