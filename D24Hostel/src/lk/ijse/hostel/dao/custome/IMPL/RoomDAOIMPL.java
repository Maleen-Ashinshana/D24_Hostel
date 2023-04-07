package lk.ijse.hostel.dao.custome.IMPL;

import lk.ijse.hostel.dao.custome.RoomDAO;
import lk.ijse.hostel.dao.exception.ConstraintViolationException;
import lk.ijse.hostel.entity.RoomEntity;
import lk.ijse.hostel.entity.StudentEntity;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RoomDAOIMPL implements RoomDAO {
    @Override
    public boolean existByPk(String pk) {
        return false;
    }

    @Override
    public boolean save(RoomEntity entity) throws ConstraintViolationException {
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
    public boolean update(RoomEntity entity) throws ConstraintViolationException {Session session=FactoryConfiguration.getInstance().getSession();
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
    public RoomEntity search(String s) throws ConstraintViolationException {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            RoomEntity roomEntity=session.find(RoomEntity.class,s);
            transaction.commit();
            return new RoomEntity(s,roomEntity.getType(),roomEntity.getKey_money(), roomEntity.getQty());
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
    }

    @Override
    public List<RoomEntity> getAll() {
        Session session2=FactoryConfiguration.getInstance().getSession();
        String hql="From RoomEntity ";
        Query query= session2.createQuery(hql);
        List<RoomEntity> result=query.list();

        for (RoomEntity roomEntity:result) {
            roomEntity.getRoom_type_id();
            roomEntity.getType();
            roomEntity.getKey_money();
            roomEntity.getQty();

        }

        return result;
    }
    }

