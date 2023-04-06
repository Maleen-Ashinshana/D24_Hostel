package lk.ijse.hostel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
public class RoomEntity implements SuperEntity {
    @Id
    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;
}
