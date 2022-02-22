package sample;

import java.sql.*;

public class DataBaseConnection extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
String connectionString = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser,dbPass);

        return dbConnection;
    }

public void signUpUser(User user){
        String insert = "INSERT INTO "+ Const.USERS_TABLE + "("+
                Const.USERS_FIRSTNAME+","+Const.USERS_LASTNAME+","+
                Const.USERS_EMAIL+","+Const.USERS_PASSWORD+","+"status"+")"+"VALUES(?,?,?,?,?)";

    try {
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, user.getFirstName());
        prSt.setString(2, user.getLastName());
        prSt.setString(3, user.getEmail());
        prSt.setString(4, user.getPassword());
        prSt.setString(5, user.getStatus());

        prSt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}

    public void signUpUser(Admin admin){
        String insert = "INSERT INTO "+ Const.ADMINS_TABLE + "("+
                Const.USERS_FIRSTNAME+","+Const.USERS_LASTNAME+","+
                Const.USERS_EMAIL+","+Const.USERS_PASSWORD+","+"status"+")"+"VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, admin.getFirstName());
            prSt.setString(2, admin.getLastName());
            prSt.setString(3, admin.getEmail());
            prSt.setString(4, admin.getPassword());
            prSt.setString(5, admin.getStatus());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void set_publication(Publication publication){
        String insert = "INSERT INTO "+ "publication" + "("+
                "name"+","+"date"+","+
                "place"+","+"status"+")"+"VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, publication.getName());
            prSt.setString(2, publication.getDate());
            prSt.setString(3, publication.getPlace());
            prSt.setString(4, publication.getStatus());


            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void set_representative(Representative representative){
        String insert = "INSERT INTO "+ "representative" + "("+
                "name"+","+"footing"+","+"status"+")"+"VALUES(?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, representative.getName());
            prSt.setString(2, representative.getFooting());
            prSt.setString(3, representative.getStatus());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_addition_jurnal(Addition_jurnal addition_jurnal){
        String insert = "INSERT INTO "+ "addition_jurnal" + "("+
                "idbook"+","+"date"+","+"idadmin"+","+"idrepresentative"+","+"status"+")"+"VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1, addition_jurnal.getIdbook());
            prSt.setString(2, addition_jurnal.getDate());
            prSt.setInt(3, addition_jurnal.getIdadmin());
            prSt.setString(5, addition_jurnal.getStatus());
            prSt.setInt(4, addition_jurnal.getIdrepresentative());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void add_book(Book book){
        String insert = "INSERT INTO "+ Const.BOOK_TABLE + "("+
                "name"+","+"author"+","+
                "idpublication"+","+"idrepresentative"+","+"purpose"+","+"type_of_content"+","+"status"+")"+"VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, book.getName());
            prSt.setString(2, book.getAuthor());
            prSt.setInt(3, book.getPublication());
            prSt.setInt(4, book.getRepresentative());
            prSt.setString(5, book.getPurpose());
            prSt.setString(6, book.getType_of_content());
            prSt.setString(7, book.getStatus());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


public  ResultSet getUser(User user){
      ResultSet resSet = null;

      String select = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " +
              Const.USERS_EMAIL + "=? AND " + Const.USERS_PASSWORD+"=?";
    try {
        PreparedStatement prSt = getDbConnection().prepareStatement(select);

        prSt.setString(1, user.getEmail());
        prSt.setString(2, user.getPassword());

        resSet = prSt.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return resSet;
}
    public  ResultSet getUser(Admin admin){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.ADMINS_TABLE + " WHERE " +
                Const.USERS_EMAIL + "=? AND " + Const.USERS_PASSWORD+"=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setString(1, admin.getEmail());
            prSt.setString(2, admin.getPassword());


            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  ResultSet getUser(){
        ResultSet resSet = null;

        String select = "SELECT * FROM users";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);


            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }


    public  ResultSet getPublication(Publication publication){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "publication" + " WHERE " +
                "name" + "=? AND " + "date"+"=? AND " + "place"+"=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setString(1, publication.getName());
            prSt.setString(2, publication.getDate());
            prSt.setString(3, publication.getPlace());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
    public  ResultSet getPublicationName(String str){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "publication" + " WHERE " +
                "name" + "='"+str+ "' OR " + "date"+"='"+str+ "' OR " + "place"+"='"+str+"'";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  ResultSet getRepresentativeName(String str){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "representative" + " WHERE " +
                "name" + "='"+str+ "' OR " + "footing"+"='"+str+ "'";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  ResultSet getRepresentative(Representative representative){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "representative" + " WHERE " +
                "name" + "=? AND " + "footing"+"=? AND "+ "status"+"=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setString(1, representative.getName());
            prSt.setString(2, representative.getFooting());
            prSt.setString(3, representative.getStatus());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  ResultSet getRepresentativeN(Representative representative){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "representative" + " WHERE " +
                "name" + "=? AND " + "footing"+"=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setString(1, representative.getName());
            prSt.setString(2, representative.getFooting());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  ResultSet getbookid(Book book){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "book" + " WHERE " +
                "name" + "=? AND " + "author"+"=? AND " +
                "idpublication" + "=? AND " +"idrepresentative"+"=? AND " +
                "purpose"+"=? AND " +"type_of_content"+"=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setString(1, book.getName());
            prSt.setString(2, book.getAuthor());
            prSt.setInt(3, book.getPublication());
            prSt.setInt(4, book.getRepresentative());
            prSt.setString(5, book.getPurpose());
            prSt.setString(6, book.getType_of_content());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  ResultSet getbookname(String str){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "book" + " WHERE " +
                "name" + "='"+ str+"'" + " OR " + "author"+"='"+ str+"'" + " OR " +
                "purpose"+"='"+ str+"'" + " OR " +"type_of_content"+"='"+ str+"'";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  ResultSet getbook_only_id(Integer id){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "book" + " WHERE " +
                "idbook="+id;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  ResultSet getbook(){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "book";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  ResultSet getbook_backupid(){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "book_backup";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  ResultSet getbook_backupidW(int num){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "book_backup"+" WHERE "+"idbook_backup"+">="+num;
        try {
            Connection con = getDbConnection();
            Statement stmt =  con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            resSet = stmt.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  ResultSet getbook_backup(){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "book_backup";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  void delete_book(Book book){

        String select = "DELETE FROM " + "book"+" WHERE "+
                "name" + "=? AND " + "author"+"=? AND " +
                "idpublication" + "=? AND " +"idrepresentative"+"=? AND " +
                "purpose"+"=? AND " +"type_of_content"+"=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, book.getName());
            prSt.setString(2, book.getAuthor());
            prSt.setInt(3, book.getPublication());
            prSt.setInt(4, book.getRepresentative());
            prSt.setString(5, book.getPurpose());
            prSt.setString(6, book.getType_of_content());



            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  void change_book(Book book){

        String select = "UPDATE " + "book"+" SET "+
                "name" + "=?"+ "," + "author"+"=?"+ ","+
                "idpublication" + "=?"+ "," +"idrepresentative"+"=?"+ "," +
                "purpose"+"=?"+ "," +"type_of_content"+"=?"+" WHERE "+"idbook"+"=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, book.getName());
            prSt.setString(2, book.getAuthor());
            prSt.setInt(3, book.getPublication());
            prSt.setInt(4, book.getRepresentative());
            prSt.setString(5, book.getPurpose());
            prSt.setString(6, book.getType_of_content());
            prSt.setInt(7, book.getIdbook());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  void call_backup(Integer num){
        String select = "CALL jurnal("+num+")";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public  void call_ad(Integer num){
        String select = "CALL addition_admin_jurnal_backup("+num+")";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void add_users_jurnal(Users_jurnal users_jurnal){
        String insert = "INSERT INTO "+ "users_jurnal" + "("+
                "iduser"+","+"idbook"+","+"date"+")"+"VALUES(?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1, users_jurnal.getIduser());
            prSt.setInt(2, users_jurnal.getIdbook());
            prSt.setString(3, users_jurnal.getDate());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public  ResultSet get_users_jurnal(Integer id_user){
        ResultSet resSet = null;

        String select = "SELECT idbook FROM " + "users_jurnal" + " WHERE " +
               "iduser"+"="+id_user;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);


            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  ResultSet get_admin_jurnal(Integer id_user){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "addition_jurnal_backup" + " WHERE " +
                "idadmin"+"="+id_user;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);


            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  ResultSet get_admin_jurnal1(Integer id_user){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "addition_jurnal" + " WHERE " +
                "idadmin"+"="+id_user;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);


            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  ResultSet get_publication(Integer id_pub){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "publication" + " WHERE " +
                "idpublication"+"="+id_pub;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);


            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
    public  ResultSet get_representative(Integer id_rep){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + "representative" + " WHERE " +
                "idrepresentative"+"="+id_rep;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);


            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

}
