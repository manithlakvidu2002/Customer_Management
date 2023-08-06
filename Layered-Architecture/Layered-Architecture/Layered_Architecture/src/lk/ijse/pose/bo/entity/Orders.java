package lk.ijse.pose.bo.entity;

import java.time.LocalDate;

public class Orders {
    private String oid;
    private LocalDate date;
    private String coustomerID;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCoustomerID() {
        return coustomerID;
    }

    public void setCoustomerID(String coustomerID) {
        this.coustomerID = coustomerID;
    }

    public Orders(String oid, LocalDate date, String coustomerID) {
        this.oid = oid;
        this.date = date;
        this.coustomerID = coustomerID;
    }
    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", date=" + date +
                ", coustomerID='" + coustomerID + '\'' +
                '}';
    }
}
