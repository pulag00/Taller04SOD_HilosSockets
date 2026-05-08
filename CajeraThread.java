package tallerThreads;

/**
 * Clase que representa una cajera ejecutándose como hilo.
 * 
 * Esta clase hereda de Thread, por lo tanto permite procesar
 * la compra de un cliente de forma concurrente.
 */
public class CajeraThread extends Thread {

	/**
	 * Nombre de la cajera.
	 */
	private String nombre;

	/**
	 * Cliente que será atendido por la cajera.
	 */
	private Cliente cliente;

	/**
	 * Tiempo inicial del programa.
	 */
	private long initialTime;

	/**
	 * Constructor de la clase CajeraThread.
	 * 
	 * @param nombre      nombre de la cajera
	 * @param cliente     cliente que será atendido
	 * @param initialTime tiempo inicial del programa
	 */
	public CajeraThread(String nombre, Cliente cliente, long initialTime) {
		this.nombre = nombre;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	/**
	 * Método que se ejecuta cuando se inicia el hilo.
	 * 
	 * Procesa la compra del cliente producto por producto.
	 */
	@Override
	public void run() {
		System.out.println("La cajera " + this.nombre +
				" comienza a procesar la compra del cliente " + cliente.getNombre() +
				" en el tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

		// Recorre los productos del carrito del cliente
		for (int i = 0; i < cliente.getCarroCompra().length; i++) {

			// Simula el tiempo de procesamiento de cada producto
			this.esperarXsegundos(cliente.getCarroCompra()[i]);

			System.out.println("Procesado el producto " + (i + 1) +
					" del cliente " + cliente.getNombre() +
					" ->Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
		}

		System.out.println("La cajera " + this.nombre +
				" ha terminado de procesar " + cliente.getNombre() +
				" en el tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
	}

	/**
	 * Detiene la ejecución del hilo actual durante una cantidad
	 * determinada de segundos.
	 * 
	 * @param segundos cantidad de segundos que se desea esperar
	 */
	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			// Mantiene el estado de interrupción del hilo
			Thread.currentThread().interrupt();
		}
	}
}