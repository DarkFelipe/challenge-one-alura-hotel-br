package one.alura.hotel.br;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import one.alura.hotel.br.DAO.ReservaDAO;

public class TesteDelecao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.criaConexao();
		
		ReservaDAO reservaDao = new ReservaDAO(connection);
		reservaDao.deletar(2);
		
		/*PreparedStatement pstm = connection.prepareStatement("DELETE FROM RESERVA WHERE id > 4");
		pstm.execute();*/
		
		//Integer linhasModificadas = pstm.getUpdateCount();
		
		//System.out.println(linhasModificadas);
	}

}
