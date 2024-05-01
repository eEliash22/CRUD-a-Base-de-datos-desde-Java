package com.umg.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.umg.connection.MariaDBConnecction;
import com.umg.dao.TestDao;

public class Main {
public static void main(String[] args) {
		
		System.out.println("llena para metros: ");
		Scanner scanner = new Scanner(System.in);
		TestDao.estudiante(scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine());
		leerEstudiantes();
}
		    public static void leerEstudiantes() {
		        Connection conn = MariaDBConnecction.getConnection();
		        if (conn != null) {
		            try {
		                String consulta = "SELECT * FROM estudiantes";
		                PreparedStatement statement = conn.prepareStatement(consulta);
		                ResultSet resultSet = statement.executeQuery();
		                while (resultSet.next()) {
		                    int idGraduando = resultSet.getInt("idestudiante");
		                    String primerNombre = resultSet.getString("primernombre");
		                    String primerApellido = resultSet.getString("primerapellido");
		                    String email = resultSet.getString("genero");
		                    System.out.println("ID: " + idGraduando+ ", Nombre: " + primerNombre + ", Apellido: " + primerApellido + ", Email: " + email);
		                }
		                resultSet.close();
		                statement.close();
		                conn.close();
		            } catch (SQLException e) {
		                System.out.println("Error al leer clientes: " + e.getMessage());
		            }
		        } else {
		            System.out.println("No se pudo establecer la conexión.");
		        }
		    
		}

}
