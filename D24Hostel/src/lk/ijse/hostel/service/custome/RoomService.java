package lk.ijse.hostel.service.custome;

import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.SuperSevice;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.exception.NotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface RoomService extends SuperSevice {
    boolean saveRoom(RoomDTO roomDTO) throws DuplicateException;
    RoomDTO searchRoom(String id) throws NotFoundException;
    boolean updateRoom(RoomDTO roomDTO) throws NotFoundException;
    boolean deleteRoom(String id) throws SQLException,ClassNotFoundException;
    List<RoomDTO> getAllRoom();
}
