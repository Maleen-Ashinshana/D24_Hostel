package lk.ijse.hostel.dao.custome.IMPL;

import lk.ijse.hostel.dao.custome.UserDAO;
import lk.ijse.hostel.dao.exception.ConstraintViolationException;
import lk.ijse.hostel.entity.UserEntity;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOIMPL implements UserDAO {
    @Override
    public boolean existByPk(String pk) {
        return false;
    }

    @Override
    public boolean save(UserEntity entity) throws ConstraintViolationException {
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
    public boolean update(UserEntity entity) throws ConstraintViolationException {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public UserEntity search(String s) throws ConstraintViolationException {
        return null;
    }

    @Override
    public ArrayList<UserEntity> getAll()  {
        return null;
    }
}
