package lk.ijse.hostel.service.custome.impl;


import lk.ijse.hostel.dao.custome.UserDAO;
import lk.ijse.hostel.dao.util.DAOFactory;
import lk.ijse.hostel.dao.util.DaoTypes;
import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.entity.UserEntity;
import lk.ijse.hostel.service.custome.UserService;
import lk.ijse.hostel.service.exception.DuplicateException;
/*import lk.ijse.hostel.service.util.Convertor;*/


public class UserServiceIMPL implements UserService {
    private final UserDAO userDAO;
    /*private final Convertor convertor;*/
    public UserServiceIMPL(){
        userDAO= (UserDAO) DAOFactory.getInstance().getDAO(DaoTypes.USER);
    }

    @Override
    public boolean saveUser(UserDTO userDTO) throws DuplicateException {
        //userDAO.save(convertor.toUser(userDTO));
        return userDAO.save(new UserEntity(userDTO.getId(), userDTO.getName(), userDTO.getPassword()));
    }

}
