package lk.ijse.hostel.service.custome.impl;

import lk.ijse.hostel.dao.custome.StudentDAO;
import lk.ijse.hostel.dao.util.DAOFactory;
import lk.ijse.hostel.dao.util.DaoTypes;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.entity.StudentEntity;
import lk.ijse.hostel.service.custome.StudentService;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.exception.NotFoundException;
import lk.ijse.hostel.service.util.Convertor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceIMPL implements StudentService {
    private final StudentDAO studentDAO;
    private final Convertor convertor;
    public StudentServiceIMPL(){
        studentDAO= (StudentDAO) DAOFactory.getInstance().getDAO(DaoTypes.STUDENT);
        convertor=new Convertor();
    }
    @Override
    public boolean saveStudent(StudentDTO studentDTO) throws DuplicateException {
        System.out.println(studentDTO+"");
        return studentDAO.save(new StudentEntity(studentDTO.getStudentId(),studentDTO.getStudentName(),studentDTO.getAddress(),studentDTO.getContact_number(),studentDTO.getDate_of_birth(),studentDTO.getGender()));

    }

    @Override
    public StudentDTO searchStudent(String id) throws NotFoundException {
        StudentEntity se=studentDAO.search(id);
        return new StudentDTO(se.getStudentId(),se.getStudentName(),se.getAddress(),se.getContact_number(),se.getDate_of_birth(),se.getGender());
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws NotFoundException {
        return studentDAO.update(new StudentEntity(studentDTO.getStudentId(),studentDTO.getStudentName(),studentDTO.getAddress(),studentDTO.getContact_number(),studentDTO.getDate_of_birth(),studentDTO.getGender()));
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<StudentDTO> getAllStudent() throws SQLException {

        return studentDAO.getAll().stream().map(ss -> convertor.fromStudent(ss)).collect(Collectors.toList());

    }
}
