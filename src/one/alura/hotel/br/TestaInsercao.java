package one.alura.hotel.br;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import one.alura.hotel.br.DAO.ReservaDAO;
import one.alura.hotel.br.Modelo.Reserva;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
								
		Reserva felipe = new Reserva("2023-08-20", "2023-08-25", "456456", "money"); // criei o objeto reserva
		
		try(Connection connection = factory.criaConexao()){ //abri a conexão
			ReservaDAO reservaDao = new ReservaDAO(connection); // instanciei o objeto DAO para pegar seus métodos
			reservaDao.salvar(felipe); //utilizei o método salvar para salvaro o objeto felipe
			
		}
		
		
		
		
		
		//1 PreparedStatement
		//2 execute()
		//3 ResultSet
		
		/*PreparedStatement stm = conexao.prepareStatement
				("INSERT INTO RESERVA (dataentrada, datasaida, valor, formapagamento) values(?,?,?,? )", Statement.RETURN_GENERATED_KEYS);
		
		//Conversao do tipo Date do SQL para o java reconhecer
		Date dataentrada = Date.valueOf("2023-08-18");
		Date datasaida = Date.valueOf("2023-08-25");
		
		//setar dados
		
		stm.setDate(1, dataentrada);
		stm.setDate(2, datasaida);
		stm.setString(3, "1");
		stm.setNString(4, "moeda");
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi : " + id);
		}
		
		conexao.close();*/
		
		

	}

}
