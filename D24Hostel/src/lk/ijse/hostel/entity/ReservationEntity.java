package lk.ijse.hostel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "reservation")
public class ReservationEntity implements SuperEntity {
    @Id
    String id;
    Date Date;
    String status;
}
