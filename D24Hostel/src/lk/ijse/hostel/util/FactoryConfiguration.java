package lk.ijse.hostel.util;


import lk.ijse.hostel.entity.RoomEntity;
import lk.ijse.hostel.entity.StudentEntity;
import lk.ijse.hostel.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    public static FactoryConfiguration factoryConfiguration;

    private SessionFactory sessionFactory;
    private FactoryConfiguration(){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(UserEntity.class).addAnnotatedClass(StudentEntity.class).addAnnotatedClass(RoomEntity.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
        return (null==factoryConfiguration?factoryConfiguration=new FactoryConfiguration():factoryConfiguration);
    }

    public Session getSession(){
        return sessionFactory.openSession();//returns a hibernate Session
    }
}
