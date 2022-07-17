package Domain.Users;

public class user {
    private String ID;
    private String name;
    private Integer age;
    private Double ticketdebts;

    public user(String ID, String name, Integer age, Double ticketdebts) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.ticketdebts = ticketdebts;
    }

    public user(){
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getTicketdebts() {
        return ticketdebts;
    }

    public void setTicketdebts(Double ticketdebts) {
        this.ticketdebts = ticketdebts;
    }
}
