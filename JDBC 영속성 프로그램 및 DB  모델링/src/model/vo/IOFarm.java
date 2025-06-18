package model.vo;

import java.sql.Date;
import java.util.Objects;

public class IOFarm {
    private int ioNum;
    private String name;
    private Date date;
    private int amount;
    private String status;

    private int amountSum;

    public IOFarm() {
    }

    public IOFarm(int ioNum, String name, Date date, int amount, String status, int amountSum) {
        this.ioNum = ioNum;
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.status = status;
        this.amountSum = amountSum;
    }

    public IOFarm(String name, Date date, int amount, String status) {
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.status = status;
    }

    public int getIoNum() {
        return ioNum;
    }

    public void setIoNum(int ioNum) {
        this.ioNum = ioNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getAmountSum() {
        return amountSum;
    }

    public void setAmountSum(int amountSum) {
        this.amountSum = amountSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IOFarm ioFarm = (IOFarm) o;
        return ioNum == ioFarm.ioNum && amount == ioFarm.amount && amountSum == ioFarm.amountSum && Objects.equals(name, ioFarm.name) && Objects.equals(date, ioFarm.date) && Objects.equals(status, ioFarm.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ioNum, name, date, amount, status, amountSum);
    }

    @Override
    public String toString() {
        return "["+ ioNum +
                " | "+ name +  " | " + date +" | "
                 + amount +" | " + status +  " ]";
    }
}
