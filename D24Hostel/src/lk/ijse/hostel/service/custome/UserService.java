package lk.ijse.hostel.service.custome;

import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.service.SuperSevice;
import lk.ijse.hostel.service.exception.DuplicateException;

public interface UserService extends SuperSevice {
/*    public boolean saveUser(UserDTO userDTO)throws SQLException,ClassNotFoundException;*/


      boolean saveUser(UserDTO userDTO) throws DuplicateException;
}
