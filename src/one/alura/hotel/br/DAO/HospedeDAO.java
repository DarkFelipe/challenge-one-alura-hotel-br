package one.alura.hotel.br.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import one.alura.hotel.br.Modelo.Hospede;

public class HospedeDAO {
	
	private Connection connection;
	
	public HospedeDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Hospede hospede) {
		String sql = "INSERT INTO HOSPEDES(nome, sobrenome, dataNascimento, nacionalidade, telefone,id_reserva) VALUES (?,?,?,?,?,?)";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			pstm.setString(1, hospede.getNome());
			pstm.setString(2, hospede.getSobrenome());
			pstm.setDate(3, hospede.getDataNascimento());
			pstm.setString(4, hospede.getNacionalidade());
			pstm.setString(5, hospede.getTelefone());
			pstm.setInt(6, hospede.getIdReserva());
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getGeneratedKeys()){
				while(rst.next()) {
					hospede.setIdReserva(rst.getInt(1));
				}
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Integer id) {
		try(PreparedStatement pstm = connection.prepareStatement("DELETE FROM HOSPEDES WHERE ID = ?")){
			pstm.setInt(1, id);
			pstm.execute();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Hospede hospede) {
		String sql = "UPDATE HOSPEDES x SET x.nome, x.sobrenome, x.dataNascimento,  x.nacionalidade, x.telefone WHERE id = ?";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.setString(1, hospede.getNome());
				pstm.setString(2, hospede.getSobrenome());
				pstm.setDate(3, hospede.getDataNascimento());
				pstm.setString(4, hospede.getNacionalidade());
				pstm.setString(5, hospede.getTelefone());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
