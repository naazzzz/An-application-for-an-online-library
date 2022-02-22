package sample;

public class Publication {
    private String name;
    private String date;
    private String place;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Publication() {
    }

    public Publication(String name, String date, String place) {
        this.name = name;
        this.date = date;
        this.place = place;
    }
}
