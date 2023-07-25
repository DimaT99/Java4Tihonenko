package entity;

import exception.ValidationException;
import lombok.Data;
import workLog.LogUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.regex.Pattern;
@Entity
@Data
public class Person implements Serializable {

    private static int count;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int courseId;
    private EnumRole enumRole;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public Person(int id, int courseId, EnumRole enumRole, String firstName, String lastName, String phone, String email) {
        this.id = id;
        this.courseId = courseId;
        this.enumRole = enumRole;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        count++;
    }
    public Person() {
        count++;
    }

    public Person(String email) {
        this.email = email;
        count++;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public EnumRole getEnumRole() {
        return enumRole;
    }

    public void setEnumRole(EnumRole enumRole) {
        this.enumRole = enumRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", enumRole=" + enumRole +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String validEmail(String email) {
        try {
            if (Pattern.matches("\\w+@\\w+\\.\\w+", email)) {
                System.out.println("email ok");
                return email;
            } else {
                System.out.println("Invalid email, please enter a valid email");
                throw new ValidationException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Wrong email";
    }

    public String validPhone(String phone) {
        try {
            if (Pattern.matches("\\d{10}||\\d{3} \\d{3} \\d{2} \\d{2}||\\d{3} \\d{7}", phone)) {
                System.out.println("phone ok");
                return phone;
            } else {
                LogUtils.className = Person.class;
                System.out.println("Invalid phone, please enter a valid phone");
                throw new ValidationException();


            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Wrong phone";
    }

    public String validFirstName(String firstName) {
        try {
            if (Pattern.matches("\\D+", firstName)) {
                System.out.println("First name ok");
                return firstName;
            } else {
                System.out.println("Invalid First name, please enter a valid First name");
                throw new ValidationException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Wrong First name";
    }

    public String validLastName(String lastName) {
        try {
            if (Pattern.matches("\\D+", lastName)) {
                System.out.println("Last name ok");
                return lastName;
            } else {
                System.out.println("Invalid Last name, please enter a valid Last name");
                throw new ValidationException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Wrong Last name";
    }
}
