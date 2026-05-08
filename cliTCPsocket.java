==================
/** CLIENTE TCP	**/
==================
public class cliTCPsocket {
   public static void main(String argv[]) {

      if (argv.length == 0) {
         System.err.println("JAVA cliTCPsocket <<SERVIDOR>>");
         System.exit(1);
      }

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("Prueba de sockets TCP (CLIENTE)");
      
      Socket socket;
      InetAddress address;
      byte[] mensaje_bytes = new byte[256];
      String mensaje="";

      try {
         System.out.print("Capturando direccion de host... ");
         address=InetAddress.getByName(argv[0]);
         System.out.println("ok");

         System.out.print("Creando socket... ");
         socket = new Socket(address,6001);
         System.out.println("ok");

         DataOutputStream out =
            new DataOutputStream(socket.getOutputStream());

         System.out.println("Introduce mensajes a enviar:");

         do {
            mensaje = in.readLine();
            out.writeUTF(mensaje);
         } while (!mensaje.startsWith("fin"));
      }
      catch (Exception e) {
         System.err.println(e.getMessage());
         System.exit(1);
      }
   }
}
