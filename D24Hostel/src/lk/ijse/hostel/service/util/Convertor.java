package lk.ijse.hostel.service.util;

import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.entity.RoomEntity;
import lk.ijse.hostel.entity.StudentEntity;

public class Convertor {
    public StudentDTO fromStudent(StudentEntity studentEntity){
        return new StudentDTO(studentEntity.getStudentId(),studentEntity.getStudentName(),studentEntity.getAddress(),studentEntity.getContact_number(),studentEntity.getDate_of_birth(),studentEntity.getGender());

    }
    public StudentEntity toStudent(StudentDTO studentDTO){
        return new StudentEntity(studentDTO.getStudentId(),studentDTO.getStudentName(),studentDTO.getAddress(),studentDTO.getContact_number(),studentDTO.getDate_of_birth(),studentDTO.getGender());

    }
    public RoomDTO froRoomDTO(RoomEntity roomEntity){
        return new RoomDTO(roomEntity.getRoom_type_id(), roomEntity.getType(),roomEntity.getKey_money(), roomEntity.getQty());
    }
    public RoomEntity toRoom(RoomDTO roomDTO){
        return new RoomEntity(roomDTO.getRoom_type_id(),roomDTO.getType(),roomDTO.getKey_money(), roomDTO.getQty());
    }
}
