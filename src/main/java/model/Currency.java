package model;

public class Currency {
    private String code;     // pl. "USD"
    private String name;     // pl. "US Dollar"
    private double rate;     // az alapvalutához viszonyított arány (pl. 1.0, 0.93, stb.)

    public Currency() {
    }

    public Currency(String code, String name, double rate) {
        this.code = code;
        this.name = name;
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return name + " (" + code + ")";
    }
}
