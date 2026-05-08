package tallerThreads;

/**
 * Clase que implementa la interfaz Runnable para procesar compras
 * usando hilos.
 * 
 * Esta clase permite ejecutar el procesamiento de una compra
 * de manera concurrente sin heredar directamente de Thread.
 */
public class MainRunnable implements Runnable {

	/**
	 * Cliente que será atendido.
	 */
	private Cliente cliente;

	/**
	 * Cajera que procesará la compra.
	 */
	private Cajera cajera;

	/**
	 * Tiempo inicial del programa.
	 */
	private long initialTime;

	/**
	 * Constructor de la clase MainRunnable.
	 * 
	 * @param cliente     cliente que será atendido
	 * @param cajera      cajera encargada de procesar la compra
	 * @param initialTime tiempo inicial del programa
	 */
	public MainRunnable(Cliente cliente, Cajera cajera, long initialTime) {
		this.cajera = cajera;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	/**
	 * Método principal del programa.
	 * 
	 * Crea clientes, cajeras y procesos Runnable.
	 * Luego inicia dos hilos para procesar las compras al mismo tiempo.
	 * 
	 * @param args argumentos de la línea de comandos
	 */
	public static void main(String[] args) {

		// Creación de los clientes
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

		// Creación de las cajeras
		Cajera cajera1 = new Cajera("Cajera 1");
		Cajera cajera2 = new Cajera("Cajera 2");

		// Tiempo inicial del programa
		long initialTime = System.currentTimeMillis();

		// Creación de objetos Runnable
		Runnable proceso1 = new MainRunnable(cliente1, cajera1, initialTime);
		Runnable proceso2 = new MainRunnable(cliente2, cajera2, initialTime);

		// Creación e inicio de los hilos
		new Thread(proceso1).start();
		new Thread(proceso2).start();
	}

	/**
	 * Método que se ejecuta al iniciar el hilo.
	 * 
	 * Llama al método procesarCompra de la cajera correspondiente.
	 */
	@Override
	public void run() {
		this.cajera.procesarCompra(this.cliente, this.initialTime);
	}
}