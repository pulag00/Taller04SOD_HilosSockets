package tallerThreads;

/**
 * Clase que representa a una cajera de supermercado.
 * 
 * La cajera se encarga de procesar la compra de un cliente,
 * producto por producto. Cada producto tarda una cantidad de
 * segundos determinada en ser procesado.
 */
public class Cajera {

	/**
	 * Nombre de la cajera.
	 */
	private String nombre;

	/**
	 * Constructor de la clase Cajera.
	 * 
	 * @param nombre nombre de la cajera
	 */
	public Cajera(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Procesa la compra de un cliente.
	 * 
	 * Recorre el carrito de compra del cliente y simula el tiempo
	 * de procesamiento de cada producto usando una espera en segundos.
	 * 
	 * @param cliente   cliente cuya compra será procesada
	 * @param timeStamp tiempo inicial del programa, usado para calcular
	 *                  el tiempo transcurrido
	 */
	public void procesarCompra(Cliente cliente, long timeStamp) {
		System.out.println("La cajera " + this.nombre +
				" comienza a procesar la compra del cliente " + cliente.getNombre() +
				" en el tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

		// Recorre cada producto del carrito de compra del cliente
		for (int i = 0; i < cliente.getCarroCompra().length; i++) {

			// Simula el tiempo que tarda en procesarse el producto
			this.esperarXsegundos(cliente.getCarroCompra()[i]);

			System.out.println("Procesado el producto " + (i + 1) +
					" del cliente " + cliente.getNombre() +
					" ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
		}

		System.out.println("La cajera " + this.nombre +
				" ha terminado de procesar " + cliente.getNombre() +
				" en el tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
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
			// Si el hilo es interrumpido, se vuelve a marcar como interrumpido
			Thread.currentThread().interrupt();
		}
	}
}