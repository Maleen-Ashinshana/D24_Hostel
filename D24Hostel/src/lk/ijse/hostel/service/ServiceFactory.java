package lk.ijse.hostel.service;


/*import lk.ijse.hostel.service.custome.impl.ReservationServiceIMPL;
import lk.ijse.hostel.service.custome.impl.RoomServiceIMPL;
import lk.ijse.hostel.service.custome.impl.StudentServiceIMPL;*/
import lk.ijse.hostel.service.custome.impl.RoomServiceimpl;
import lk.ijse.hostel.service.custome.impl.StudentServiceIMPL;
import lk.ijse.hostel.service.custome.impl.UserServiceIMPL;

import java.sql.SQLException;

public class ServiceFactory {
    private  static ServiceFactory serviceFactory;

    public ServiceFactory() {
    }
    public  static  ServiceFactory getInstance(){
        return serviceFactory==null?(serviceFactory=new ServiceFactory()):serviceFactory;

    }
    public   SuperSevice getService(ServiceTypes serviceTypes) throws SQLException, ClassNotFoundException {
        switch (serviceTypes){
            case USER:
                return new UserServiceIMPL();
            case STUDENT:
                return new StudentServiceIMPL();
            case ROOM:
                return new RoomServiceimpl();
            /*case STUDENT:
                return new StudentServiceIMPL();
            case ROOM:
                return new RoomServiceIMPL();
            case RESEVATION:
                return new ReservationServiceIMPL();*/
            default:
                return null;
        }
    }
}
