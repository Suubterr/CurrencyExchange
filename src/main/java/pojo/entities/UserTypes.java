package pojo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_types")
public class UserTypes {

    @Id
    @Column(name = "usrtype_id")
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
}
