package sample;

public class book_backup {
    private Integer id;
    private Integer id_book;
    private String name;
    private String author;
    private Integer idpublication;
    private Integer idrepresentative;
    public String getViewpublication() {
        return viewpublication;
    }

    public void setViewpublication(String viewpublication) {
        this.viewpublication = viewpublication;
    }

    public String getViewrepresentative() {
        return viewrepresentative;
    }

    public void setViewrepresentative(String viewrepresentative) {
        this.viewrepresentative = viewrepresentative;
    }

    private String viewpublication;
    private String viewrepresentative;
    private String purpose;
    private String type_of_content;
    private Integer price;
    private String action;

    public book_backup(Integer id, Integer id_book, String name, String author, Integer idpublication, Integer idrepresentative, String purpose, String type_of_content, Integer price, String action, String status) {
        this.id = id;
        this.id_book = id_book;
        this.name = name;
        this.author = author;
        this.idpublication = idpublication;
        this.idrepresentative = idrepresentative;
        this.purpose = purpose;
        this.type_of_content = type_of_content;
        this.price = price;
        this.action = action;
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    private String status;

    public book_backup() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_book() {
        return id_book;
    }

    public void setId_book(Integer id_book) {
        this.id_book = id_book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getIdpublication() {
        return idpublication;
    }

    public void setIdpublication(Integer idpublication) {
        this.idpublication = idpublication;
    }

    public Integer getIdrepresentative() {
        return idrepresentative;
    }

    public void setIdrepresentative(Integer idrepresentative) {
        this.idrepresentative = idrepresentative;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getType_of_content() {
        return type_of_content;
    }

    public void setType_of_content(String type_of_content) {
        this.type_of_content = type_of_content;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
