package lk.ijse.hostel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Data
@AllArgsConstructor

@ToString
@Table(name = "student")
public class StudentEntity implements SuperEntity{
    @Id
    private String studentId;
    private String StudentName;
    private String address;
    private int contact_number;
    private String date_of_birth;
    private String gender;
    public StudentEntity(){

    }
}
