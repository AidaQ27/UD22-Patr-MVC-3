package Modelo;

public class Config {

	// direccion
		private String direccion = "jdbc:mysql://192.168.1.145:3306";
		private String user = "remote";
		private String pass = "Reus_2022";
		
		public Config() {
		}

		/**
		 * @return the direccion
		 */
		public String getDireccion() {
			return direccion;
		}

		/**
		 * @return the user
		 */
		public String getUser() {
			return user;
		}

		/**
		 * @return the pass
		 */
		public String getPass() {
			return pass;
		}
}
