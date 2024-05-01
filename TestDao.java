package com.umg.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.umg.connection.MariaDBConnecction; 

public class TestDao {
			
			public static boolean estudiante( String primernombre, String segundonombre, String otronombre, String primerapellido, String segundoapellido, String otroapellido, String genero, String fecha_nacimiento, String telefono, String dpi, String colegiatura, String usuario_creacion) {
					
		        Connection conn = MariaDBConnecction.getConnection();

		        if (conn != null) {

		            try {

		                String consulta = "INSERT INTO estudiantes (primernombre, segundonombre, otronombre, primerapellido, segundoapellido, otroapellido, genero, fecha_nacimiento, telefono, dpi, colegiatura, usuario_creacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		                PreparedStatement statement = conn.prepareStatement(consulta);


		                statement.setString(1, primernombre);
		                statement.setString(2, segundonombre);
		                statement.setString(3, otronombre);
		                statement.setString(4, primerapellido );
		                statement.setString(5, segundoapellido );
		                statement.setString(6, otroapellido );
		                statement.setString(7, genero );
		                statement.setString(8, fecha_nacimiento);
		                statement.setString(9, telefono);
		                statement.setString(10, dpi);
		                statement.setString(11, colegiatura);
		                statement.setString(12, usuario_creacion);
		                int filasInsertadas = statement.executeUpdate();
		                System.out.println("Registro creado: " + filasInsertadas);
		 
		 
		                statement.close();

		                conn.close();

		                return filasInsertadas > 0;

		            } catch (SQLException e) {

		                System.out.println("Error al crear cliente: " + e.getMessage());

		                return false;

		            }

		        } else {

		            System.out.println("No se pudo establecer la conexión.");

		            return false;

		        }
			
				
			}

			public static void estudiante(String nextLine, String nextLine2, String nextLine3, String nextLine4) {
				// TODO Auto-generated method stub
				
			}
	}
