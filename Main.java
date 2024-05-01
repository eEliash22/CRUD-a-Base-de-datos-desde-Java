package com.umg.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.umg.connection.MariaDBConnecction;
import com.umg.dao.TestDao;

public class Main {
public static int eliminarId;
public static int editarId;
public static String editarNombre;
public static String editarApellido;
public static String editarTelefono;
public static void main(String[] args) {
		
		System.out.println("llena para metros: ");
		Scanner scanner = new Scanner(System.in);
		TestDao.estudiante(scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine());
		leerEstudiantes();
		System.out.println("Elimina un Usuario");
		eliminarEstudiante(eliminarId = scanner.nextInt());
		System.out.println(eliminarId + " Alumno elminado");
		System.out.println("Actualizacion de datos");
		actualizarEstudiante(editarId = scanner.nextInt(), editarNombre = scanner.nextLine(), editarApellido = scanner.nextLine(), editarTelefono = scanner.nextLine());
		System.out.println(editarId + " Datos Actualizados");
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
		                    int idEstudiante = resultSet.getInt("idestudiante");
		                    String primerNombre = resultSet.getString("primernombre");
		                    String segundoNombre = resultSet.getString("segundonombre");
		                    String primerApellido = resultSet.getString("primerapellido");
		                    String segundoApellido = resultSet.getString("segundoapellido");
		                    String genero = resultSet.getString("genero");
		                    String fechaNacimiento = resultSet.getString("fecha_nacimiento");
		                    String telefono = resultSet.getString("telefono");
		                    String dpi = resultSet.getString("dpi");
		                    
		                    
		                    System.out.println("ID: " + idEstudiante + ", Primer Nombre: " + primerNombre + ", Segundo Nombre: " + segundoNombre + ", Primer Apellido: " + primerApellido + ", Segundo Apellido: " + segundoApellido + ", Genero: " + genero  + ", Fecha de Nacimiento: " + fechaNacimiento + ", Telefono: " + telefono + " DPI: " + dpi);
		                }
		                resultSet.close();
		                statement.close();
		                conn.close();
		            } catch (SQLException e) {
		                System.out.println("Error al leer estudiantes: " + e.getMessage());
		            }
		        } else {
		            System.out.println("No se pudo establecer la conexión.");
		        }
		    }
		    public static boolean eliminarEstudiante(int id) {

		        Connection conn = MariaDBConnecction.getConnection();

		        if (conn != null) {

		            try {

		                String consulta = "DELETE FROM estudiantes WHERE idestudiante = ?;";

		                PreparedStatement statement = conn.prepareStatement(consulta);

		                statement.setInt(1, eliminarId);

		                int filasEliminadas = statement.executeUpdate();

		                statement.close();

		                conn.close();

		                return filasEliminadas > 0;

		            } catch (SQLException e) {

		                System.out.println("Error al eliminar Estudiante: " + e.getMessage());

		                return false;

		            }

		        } else {

		            System.out.println("No se pudo establecer la conexión.");

		            return false;
		            }
		    }
		        public static boolean actualizarEstudiante(int id, String primerNombre, String primerApellido, String telefono) {
		            Connection conn = MariaDBConnecction.getConnection();
		            if (conn != null) {
		                try {
		                    String consulta = "UPDATE estudiantes SET primernombre = ?, primerapellido = ?, telefono = ? WHERE idestudiante = ?";
		                    PreparedStatement statement = conn.prepareStatement(consulta);
		                    statement.setString(1, editarNombre);
		                    statement.setString(2, editarApellido);
		                    statement.setString(3, editarTelefono);
		                    statement.setInt(4, editarId);
		                    int filasActualizadas = statement.executeUpdate();
		                    statement.close();
		                    conn.close();
		                    return filasActualizadas > 0;
		                } catch (SQLException e) {
		                    System.out.println("Error al actualizar cliente: " + e.getMessage());
		                    return false;
		                }
		            } else {
		                System.out.println("No se pudo establecer la conexión.");
		                return false;
		            }
		        


		    }
}
