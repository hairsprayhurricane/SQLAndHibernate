import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;


@Entity
@Table(name = "Purchaselist")
public class Purchaselist {
    @Id
    private String student_name;
    private String course_name;
    private Integer price;
    private Date subscription_date;

    public Purchaselist() {
        this.student_name = null;
        this.course_name = null;
        this.price = null;
        this.subscription_date = null;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getSubscription_date() {
        return subscription_date;
    }

    public void setSubscription_date(Date subscription_date) {
        this.subscription_date = subscription_date;
    }

    @Override
    public String toString() {
        return "Purchaselist{" +
                "student_name='" + student_name + '\'' +
                ", course_name='" + course_name + '\'' +
                ", price=" + price +
                ", subscription_date=" + subscription_date +
                '}';
    }
}
