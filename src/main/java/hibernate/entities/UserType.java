package hibernate.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_types")
public class UserType implements Serializable {

    @Id
    @Column(name = "usrtype_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int usrTypeId;

    @Column(name = "type_name")
    private String typeName;

    public int getUsrTypeId() {
        return usrTypeId;
    }

    public void setUsrTypeId(int usrTypeId) {
        this.usrTypeId = usrTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "usrTypeId=" + usrTypeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}