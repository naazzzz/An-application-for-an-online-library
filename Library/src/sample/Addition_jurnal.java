package sample;

import java.util.Date;

public class Addition_jurnal {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer idbook;
   private String date;
   private Integer idadmin;
   private Integer idrepresentative;
    private String status;

    public void setDate() {
        Date date = new Date();
        this.date=date.toString();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Addition_jurnal() {
    }

    public Addition_jurnal(Integer id, Integer idbook, String date, Integer idadmin, Integer idrepresentative, String status) {
        this.id = id;
        this.idbook = idbook;
        this.date = date;
        this.idadmin = idadmin;
        this.idrepresentative = idrepresentative;
        this.status = status;
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

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Integer idadmin) {
        this.idadmin = idadmin;
    }

    public Integer getIdrepresentative() {
        return idrepresentative;
    }

    public void setIdrepresentative(Integer idprepresentative) {
        this.idrepresentative = idprepresentative;
    }
}
