package lk.ijse.hostel.dao.util;

import lk.ijse.hostel.dao.exception.ConstraintViolationException;
import lk.ijse.hostel.entity.SuperEntity;
/*
import lk.ijse.hostel.service.exception.NotFoundException;
*/

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T extends SuperEntity,ID extends Serializable> extends  SuperDAO {
/*    T save(T entity) throws  ConstraintViolationException;
    T update(T entity) throws ConstraintViolationException;
    void delete (String id) throws NotFoundException;
    T search(ID pk)throws ConstraintViolationException;
    List<T> findAll();
    long count();*/

    boolean existByPk(ID pk);
    public boolean save(T  entity) throws ConstraintViolationException;
    public boolean update(T entity)throws ConstraintViolationException;
     public boolean delete(String id) ;
             /*NotFoundException*/;
     public T search(ID id) throws ConstraintViolationException;
     public List<T> getAll();
}
