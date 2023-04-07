package lk.ijse.hostel.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomTm {
    @Id
    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;
}
