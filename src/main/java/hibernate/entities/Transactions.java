package hibernate.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @Column(name = "tr_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int trId;

    @Column(name = "currency_id")
    private int currencyId;

    @Column(name = "tr_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trDate;

    @Column(name = "amount")
    private float amount;

    @Column(name = "type")
    private int type;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "client_id")
    private int clientId;

    @Column(name = "info")
    private String info;

    public int getTrId() { return trId; }

    public void setTrId(int trId) {
        this.trId = trId;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public Date getTrDate() {
        return trDate;
    }

    public void setTrDate(Date trDate) {
        this.trDate = trDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
