package lk.ijse.hostel.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentTm {
    private String studentId;
    private String StudentName;
    private String address;
    private int contact_number;
    private String date_of_birth;
    private String gender;

}
