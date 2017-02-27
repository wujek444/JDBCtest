package pollub.jakubwojcik;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	static String daneZBazy;
	
	public static void main(String[] args) {
		String polaczenieURL = "jdbc:mysql://127.0.0.1/laboratorium_baz_danych?user=root&password=";
		String query = "SELECT * FROM studenci";
		
		Connection conn = null;
		
		try{
			//ustawiamy dane dotyczące połączenia
			conn = DriverManager.getConnection(polaczenieURL);
			
			//ustawiamy sterownik mySQL
			Class.forName("com.mysql.jdbc.Driver");
			
			//uruchamiamy zapytanie do bazy danych
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
		}

	}

}
