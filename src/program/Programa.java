package program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Elimina registro da base

import db.DB;
import db.DbIntegrityException;

public class Programa {

	public static void main(String[] args) {

		Connection conn = null;

		PreparedStatement st = null;

		try {

			conn = DB.getConnection();

			st = conn.prepareStatement("DELETE from department " + "WHERE " + "Id = ? ");

			st.setInt(1, 5);

			int linhasAfetadas = st.executeUpdate();

			System.out.println(" Feito ! Linhas afetadas: " + linhasAfetadas);

		} catch (SQLException e) {

			throw new DbIntegrityException(e.getMessage());
		}

		finally {
			DB.closeStatemant(st);
			try {
				DB.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
