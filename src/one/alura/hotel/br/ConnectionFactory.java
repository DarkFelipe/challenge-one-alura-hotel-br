package one.alura.hotel.br;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {  //FábricaDeConexão
	
	public Connection criaConexao() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_alura?useTimezone=true&serverTimezone=UTC", "root", "Corey2608***");
		//System.out.println("Testando Conexão");
		
		return connection;
		
	}
}
