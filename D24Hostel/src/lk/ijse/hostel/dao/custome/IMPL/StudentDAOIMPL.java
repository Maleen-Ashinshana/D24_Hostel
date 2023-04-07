package lk.ijse.hostel.dao.custome.IMPL;

import lk.ijse.hostel.dao.custome.StudentDAO;
import lk.ijse.hostel.dao.exception.ConstraintViolationException;
import lk.ijse.hostel.entity.StudentEntity;
import lk.ijse.hostel.util.FactoryConfiguration;
import lk.ijse.hostel.util.Navigation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOIMPL implements StudentDAO {
    @Override
    public boolean existByPk(String pk) {
        return false;
    }

    @Override
    public boolean save(StudentEntity entity) throws ConstraintViolationException {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;

        }
    }

    @Override
    public boolean update(StudentEntity entity) throws ConstraintViolationException {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(entity);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }

    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public StudentEntity search(String s) throws ConstraintViolationException {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            StudentEntity studentEntity=session.find(StudentEntity.class,s);
            transaction.commit();
            return new StudentEntity(s,studentEntity.getStudentName(),studentEntity.getAddress(),studentEntity.getContact_number(),studentEntity.getDate_of_birth(),studentEntity.getGender());
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return null;
        }

    }

    @Override
    public List<StudentEntity> getAll() {
        Session session2=FactoryConfiguration.getInstance().getSession();

        String hql="From StudentEntity";
        Query query= session2.createQuery(hql);
        List<StudentEntity> result=query.list();

        for (StudentEntity student:result) {
             student.getStudentId();
             student.getStudentName();
             student.getAddress();
             student.getContact_number();
             student.getDate_of_birth();
             student.getGender();
        }

        return result;
    }
}
