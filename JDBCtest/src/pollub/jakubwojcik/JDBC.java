package pollub.jakubwojcik;
import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class JDBC {

	//static String daneZBazy;
	
	public static void main(String[] args) {
		//jdbc:mysql://ADRES_URL/NAZWA_BAZY_DANYCH?user=NAZWA_UŻYTKOWNIKA&password=HASŁO
		String polaczenieURL = "jdbc:mysql://127.0.0.1/laboratorium_baz_danych?user=root&password=";//brak hasła
		String query = "SELECT * FROM studenci";
		
		Connection conn = null;
		
		try{
			//ustawiamy dane dotyczące połączenia
			conn = DriverManager.getConnection(polaczenieURL);
			
			//ustawiamy sterownik mySQL
			Class.forName("com.mysql.jdbc.Driver");
			
			//uruchamiamy zapytanie do bazy danych -> statement to SELECT/INSERT INTO/DELETE FROM itp.
			Statement stmt = conn.createStatement();
			//zbiór wyników zapytania -> tutaj zapisywane są dane po wykonaniu zapytania na BD
			ResultSet rs = stmt.executeQuery(query);
			
			//pobieramy kolejne wiersze z wyniku zapytania (ze zbioru wierszy)
			while(rs.next()){
				wyswietlDaneZBazy(rs);
			}
			//zamykamy połączenie z bazą
			conn.close();
		}
		catch(ClassNotFoundException wyjatek){//jeżeli baza danych nie istnieje/zapytanie jest niepoprawne
			System.out.println("Problem ze sterownikiem");
		}
		
		catch (SQLException wyjatek) { 
			//e.printStackTrace();
			//System.out.println("Problem z logowaniem!\nProszę sprawdzić:\nnazwę użytkownika, hasło, nazwę bazy lub adres IP serwera");
			System.out.println("SQLException: " + wyjatek.getMessage());
			System.out.println("SQLState: " + wyjatek.getSQLState());
			//kod błędu - bardzo użyteczny (można wyszukać kod błędu na stronie mySQLa i sprawdzić jego znaczenie)
			System.out.println("VendorError: " + wyjatek.getErrorCode());
			
		}

	}
	static void wyswietlDaneZBazy(ResultSet rs){
		
        try{
        ResultSetMetaData rsmd = rs.getMetaData();
        int resultSetColumnCount = rsmd.getColumnCount();
        for(int i=1; i<=resultSetColumnCount; i++){
        	 System.out.println(rs.getString(i) + " "); //drukuj kolumnę
        }
        	
//        daneZBazy = rs.getString(1); //pobierz 1. kolumnę z wiersza
//        System.out.println("\n" + daneZBazy + " "); //drukuj kolumnę
//        daneZBazy = rs.getString(2);//pobierz 2. kolumnę z wiersza
//        System.out.println(daneZBazy + " ");//drukuj kolumnę
//        daneZBazy = rs.getString(3);//pobierz 3. kolumnę z wiersza
//        System.out.println(daneZBazy);//drukuj kolumnę
        }catch(SQLException e) {
                //e.printStackTrace();
        	System.out.println("Null or incorrect value!");
        }
}

}
