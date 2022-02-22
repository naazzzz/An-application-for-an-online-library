package sample;

public class Book {
    private Integer idbook;

    public Integer getIdbook() {
        return idbook;
    }

    public void setIdbook(Integer idbook) {
        this.idbook = idbook;
    }

    private String name;
    private String author;
    private Integer publication;
    private Integer representative;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;



    private String type_of_content;


    public Book() {
    }

    public Book(String name, String author, Integer publication, Integer representative, String purpose, String type_of_content, Integer price) {
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.representative = representative;
        this.purpose = purpose;
        this.type_of_content = type_of_content;

    }

    public Book(Integer idbook, String name, String author, Integer publication, Integer representative, String purpose, String status, String type_of_content, Integer price) {
        this.idbook = idbook;
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.representative = representative;
        this.purpose = purpose;
        this.status = status;
        this.type_of_content = type_of_content;

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

    public Integer getPublication() {
        return publication;
    }

    public void setPublication(Integer publication) {
        this.publication = publication;
    }

    public Integer getRepresentative() {
        return representative;
    }

    public void setRepresentative(Integer representative) {
        this.representative = representative;
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

}
