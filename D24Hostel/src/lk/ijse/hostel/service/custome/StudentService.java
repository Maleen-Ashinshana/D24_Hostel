package lk.ijse.hostel.service.custome;

import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.service.SuperSevice;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.exception.NotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface StudentService extends SuperSevice {
    boolean saveStudent(StudentDTO studentDTO) throws DuplicateException;
    StudentDTO searchStudent(String id) throws NotFoundException;
    boolean updateStudent(StudentDTO studentDTO) throws NotFoundException;
    boolean deleteStudent(String id) throws SQLException,ClassNotFoundException;
    List<StudentDTO> getAllStudent();
}
