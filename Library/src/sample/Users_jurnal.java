package sample;

import java.util.Date;

public class Users_jurnal {
    private Integer iduser;
    private Integer idbook;
    private String date;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Users_jurnal(Integer iduser, Integer idbook, String date) {
        this.iduser = iduser;
        this.idbook = idbook;
        this.date = date;
    }

    public Users_jurnal() {
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getIdbook() {
        return idbook;
    }

    public void setIdbook(Integer idbook) {
        this.idbook = idbook;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        Date date = new Date();
        this.date=date.toString();
    }

    public void setDate(String date) {
        this.date = date;
    }
}
