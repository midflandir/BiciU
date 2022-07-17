package Domain.Ticket;

import java.sql.Time;
import java.util.Date;

public class Ticket {

    private String code;
    private String bicycle;
    private String User;
    private Date date;
    private Time Starttime;
    private Time Endtime;
    private Boolean helmetDebt;
    private Boolean DamagedDebt;
    private Status status;
    private Double Amount;

    public Ticket() {
    }

    public Ticket(String code, String bicycle, String user, Date date,
                  Time starttime, Time endtime, Boolean helmetDebt,
                  Boolean damagedDebt, Status status, Double amount) {
        this.code = code;
        this.bicycle = bicycle;
        User = user;
        this.date = date;
        Starttime = starttime;
        Endtime = endtime;
        this.helmetDebt = helmetDebt;
        DamagedDebt = damagedDebt;
        this.status = status;
        Amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBicycle() {
        return bicycle;
    }

    public void setBicycle(String bicycle) {
        this.bicycle = bicycle;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStarttime() {
        return Starttime;
    }

    public void setStarttime(Time starttime) {
        Starttime = starttime;
    }

    public Time getEndtime() {
        return Endtime;
    }

    public void setEndtime(Time endtime) {
        Endtime = endtime;
    }

    public Boolean getHelmetDebt() {
        return helmetDebt;
    }

    public void setHelmetDebt(Boolean helmetDebt) {
        this.helmetDebt = helmetDebt;
    }

    public Boolean getDamagedDebt() {
        return DamagedDebt;
    }

    public void setDamagedDebt(Boolean damagedDebt) {
        DamagedDebt = damagedDebt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }
}
