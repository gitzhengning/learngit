package ATM;

public class Account {
    private String cardid;
    private String name;
    private char gender;
    private String code;
    private double limi;
    private double money;

    public Account() {
    }

    public Account(String cardid, String name, char gender, String code, double limi, double money) {
        this.cardid = cardid;
        this.name = name;
        this.gender = gender;
        this.code = code;
        this.limi = limi;
        this.money = money;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getLimi() {
        return limi;
    }

    public void setLimi(double limi) {
        this.limi = limi;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
