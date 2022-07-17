package Domain.Ticket;

import java.time.LocalDate;
import java.time.LocalTime;


public class Ticket {

    private String code;
    private String bicycle;
    private String User;
    private LocalDate date;
    private LocalTime Starttime;
    private LocalTime Endtime;
    private Boolean hashelmet;
    private Boolean goodcondition;
    private Status status;
    private Double Amount;

    public Ticket() {
    }

    public Ticket(String code, String bicycle, String user, LocalDate date,
                  LocalTime starttime, LocalTime endtime, Boolean helmetDebt,
                  Boolean damagedDebt, Status status, Double amount) {
        this.code = code;
        this.bicycle = bicycle;
        User = user;
        this.date = date;
        Starttime = starttime;
        Endtime = endtime;
        this.hashelmet = helmetDebt;
        goodcondition = damagedDebt;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStarttime() {
        return Starttime;
    }

    public void setStarttime(LocalTime starttime) {
        Starttime = starttime;
    }

    public LocalTime getEndtime() {
        return Endtime;
    }

    public void setEndtime(LocalTime endtime) {
        Endtime = endtime;
    }

    public Boolean getHashelmet() {
        return hashelmet;
    }

    public void setHashelmet(Boolean hashelmet) {
        this.hashelmet = hashelmet;
    }

    public Boolean getGoodcondition() {
        return goodcondition;
    }

    public void setGoodcondition(Boolean goodcondition) {
        this.goodcondition = goodcondition;
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
