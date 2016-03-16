import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;

public class JudgeServer {

    public static final int MaxThreadCount = 1;
    public static final String mysql_dbUsername = "judgehost";
    public static final String mysql_dbPassword = "bssojPASSWORD123456";

    public static Queue<UserSubmission> submissions;


    public static void main(String[] args) {
        submissions = new LinkedList<UserSubmission>();

        while(true){
            if (submissions.size() < MaxThreadCount){
                try {
                    /*
                        Get new submission from database
                     */

                    Connection conn = DriverManager.getConnection("jdbc:mysql://bssoj-dev.ddns.net:3306/bssoj-sample-database",
                            mysql_dbUsername, mysql_dbPassword);

                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM problems;");

                    while(rs.next()){
                        System.out.println(rs.getString("ProblemName"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}