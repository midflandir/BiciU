package Domain.bicycle;

public class Bicycle {

    private String Code;
    private String Color;
    private EnumType Type;
    private boolean isavalible;

    public Bicycle() {
    }

    public Bicycle(String code, String color, EnumType type, boolean isavalible) {
        Code = code;
        Color = color;
        Type = type;
        this.isavalible = isavalible;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public EnumType getType() {
        return Type;
    }

    public void setType(EnumType type) {
        Type = type;
    }

    public boolean isIsavalible() {
        return isavalible;
    }

    public void setIsavalible(boolean isavalible) {
        this.isavalible = isavalible;
    }
}
