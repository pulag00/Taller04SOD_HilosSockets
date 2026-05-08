package tallerThreads;

/**
 * Clase principal que ejecuta el programa usando hilos
 * mediante la clase CajeraThread.
 * 
 * En este caso, cada cajera es un hilo independiente.
 */
public class MainThread {

	/**
	 * Método principal del programa.
	 * 
	 * Crea dos clientes y dos cajeras tipo Thread.
	 * Luego inicia ambos hilos para que las compras se procesen
	 * de forma concurrente.
	 * 
	 * @param args argumentos de la línea de comandos
	 */
	public static void main(String[] args) {

		// Creación de los clientes con sus carritos de compra
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

		// Tiempo inicial del programa
		long initialTime = System.currentTimeMillis();

		// Creación de las cajeras como hilos
		CajeraThread cajera1 = new CajeraThread("Cajera 1", cliente1, initialTime);
		CajeraThread cajera2 = new CajeraThread("Cajera 2", cliente2, initialTime);

		// Inicio de los hilos
		cajera1.start();
		cajera2.start();
	}
}