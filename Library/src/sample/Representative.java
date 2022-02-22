package sample;

public class Representative {
    private String name;
    private String footing;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Representative() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFooting() {
        return footing;
    }

    public void setFooting(String footing) {
        this.footing = footing;
    }

    public Representative(String name, String footing,String status) {
        this.name = name;
        this.footing = footing;
        this.status = status;
    }
}
