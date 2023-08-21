package one.alura.hotel.br;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection conexao = factory.criaConexao();
		
		PreparedStatement stm = conexao.prepareStatement("SELECT * FROM RESERVA");
		
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			Date dataEntrada = rst.getDate("DATAENTRADA");
			Date dataSaida = rst.getDate("DATASAIDA");
			String valor = rst.getString("VALOR");
			String formaPagamento = rst.getString("FORMAPAGAMENTO");
			
			System.out.println(id);
			System.out.println(dataEntrada);
			System.out.println(dataSaida);
			System.out.println(valor);
			System.out.println(formaPagamento);
		}
		
		
	}

}
