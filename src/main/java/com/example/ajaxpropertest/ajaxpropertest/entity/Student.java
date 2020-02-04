package com.example.ajaxpropertest.ajaxpropertest.entity;




import com.example.ajaxpropertest.ajaxpropertest.validation.ValidPassword;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="student_tab1")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stud_id")
    private int std_id;

    @Column(name="firstname")
    @NotBlank
    @Size(min = 3)
    @Pattern(regexp = "^[a-zA-Z]*$",message = "FirstName should not contain numeric character and at least 4 character long.")
    private String fname;

    @Column(name="lastname")
    @NotBlank
    @Size(min = 3)
    @Pattern(regexp = "^[a-zA-Z]*$",message = "LastName should not contain numeric character and at least 4 character long.")
    private String lname;

    @Column(name="email")
    @NotBlank
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Not a valid E-Mail.")
    private String email;

    @Column(name="username")
    @NotBlank
    @Size(min = 6)
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Atleast 6 character is expected.")
    private String username;

    @Column(name="password")
    @NotBlank
    @ValidPassword
    private String password;

    @Column(name = "profilepicture")
    private String profilePic;

    public Student() {
    }

    public Student(@NotBlank @Size(min = 3) @Pattern(regexp = "^[a-zA-Z]*$", message = "FirstName should not contain numeric character and at least 4 character long.") String fname, @NotBlank @Size(min = 3) @Pattern(regexp = "^[a-zA-Z]*$", message = "LastName should not contain numeric character and at least 4 character long.") String lname, @NotBlank @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Not a valid E-Mail.") String email, @Size(min = 6) @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Atleast 6 character is expected.") String username, @NotBlank String password, String profilePic) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.profilePic = profilePic;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "std_id=" + std_id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
