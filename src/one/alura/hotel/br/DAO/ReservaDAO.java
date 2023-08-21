package one.alura.hotel.br.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import one.alura.hotel.br.Modelo.Reserva;

public class ReservaDAO {
	
	private Connection connection;
	
	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Reserva reserva){
		String sql = "INSERT INTO RESERVA (dataEntrada, dataSaida, valor, formaPagamento) VALUES (?,?,?,?)";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				
				pstm.setString(1, reserva.getDataEntrada());
				pstm.setString(2, reserva.getDataSaida());
				pstm.setString(3, reserva.getValor());
				pstm.setString(4, reserva.getFormaPagamento());
				
				pstm.execute();
				
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while(rst.next()) {
						reserva.setId(rst.getInt(1));
					}
				}
				
			} catch (Exception e) {
				throw new RuntimeException();  
			}
			
		}
	
	public void alterar(Reserva reserva){
		String sql = "UPDATE RESERVA x SET x.dataEntrada = ?, x.dataSaida = ?, x.formaPagamento = ? where id = ?";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setString(1, reserva.getDataEntrada());
			pstm.setString(2, reserva.getDataSaida());
			pstm.setString(3, reserva.getFormaPagamento());
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Integer id) {
		try(PreparedStatement pstm = connection.prepareStatement("DELETE FROM RESERVA WHERE ID = ?")){
			pstm.setInt(1, id);
			pstm.execute();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	

}
