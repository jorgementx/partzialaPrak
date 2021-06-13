package partzialaPrak.controllers.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Md5DBKud {
    private static final Md5DBKud niremd5DBkud = new Md5DBKud();

    private Md5DBKud() {}

    public static Md5DBKud getMd5DBKud (){
        return niremd5DBkud;
    }

    public String getVersion (String pmd5) {
        String version="";
        String query = "select version from checksums where md5='"+pmd5+"'";
        ResultSet rs =DBKud.getDBKud().execSQL(query);
        try {
            if (rs.next()) {
                version= rs.getString("version");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return version;
    }
}
