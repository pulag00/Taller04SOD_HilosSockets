package tallerThreads;

/**
 * Clase principal que ejecuta el programa de forma secuencial.
 * 
 * En esta clase, primero se procesa completamente la compra
 * del cliente 1 y después la compra del cliente 2.
 */
public class Main {

	/**
	 * Método principal del programa.
	 * 
	 * @param args argumentos de la línea de comandos
	 */
	public static void main(String[] args) {

		// Creación de clientes con sus respectivos tiempos por producto
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

		// Creación de las cajeras
		Cajera cajera1 = new Cajera("Cajera 1");
		Cajera cajera2 = new Cajera("Cajera 2");

		// Tiempo inicial del programa
		long initialTime = System.currentTimeMillis();

		// Procesamiento secuencial de las compras
		cajera1.procesarCompra(cliente1, initialTime);
		cajera2.procesarCompra(cliente2, initialTime);
	}
}