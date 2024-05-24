import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Column(name="registration_date")
    private Date registrationDate;

    public Student() {
        this.id = 0;
        this.name = "-";
        this.age = 0;
        this.registrationDate = null;
    }
    public Student(int id, String name, int age, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}
