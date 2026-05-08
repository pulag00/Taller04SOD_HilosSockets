package tallerThreads;

/**
 * Clase que representa a un cliente del supermercado.
 * 
 * Cada cliente tiene un nombre y un carrito de compra.
 * El carrito se representa con un arreglo de enteros, donde cada
 * número indica los segundos que tarda en procesarse un producto.
 */
public class Cliente {

	/**
	 * Nombre del cliente.
	 */
	private String nombre;

	/**
	 * Arreglo que representa el carrito de compra.
	 * Cada posición contiene el tiempo de procesamiento de un producto.
	 */
	private int[] carroCompra;

	/**
	 * Constructor de la clase Cliente.
	 * 
	 * @param nombre      nombre del cliente
	 * @param carroCompra arreglo con los tiempos de procesamiento
	 *                    de los productos
	 */
	public Cliente(String nombre, int[] carroCompra) {
		this.nombre = nombre;
		this.carroCompra = carroCompra;
	}

	/**
	 * Obtiene el nombre del cliente.
	 * 
	 * @return nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene el carrito de compra del cliente.
	 * 
	 * @return arreglo con los tiempos de procesamiento de los productos
	 */
	public int[] getCarroCompra() {
		return carroCompra;
	}
}