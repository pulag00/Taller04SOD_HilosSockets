 ==================
 /** SERVIDOR TCP **/
 ==================

public class serTCPsocket {
    public static void main(String argv[]) {
      
      System.out.println("\n\n\t=**SOCKETS TCP <<SERVIDOR>>");
      
      ServerSocket socket;
      boolean fin = false;

      try {
         socket = new ServerSocket(6001);
         
         Socket socket_cli = socket.accept();
         
         DataInputStream in =
            new DataInputStream(socket_cli.getInputStream());
         
         do {
            String mensaje ="";
            
            mensaje = in.readUTF();
            
            System.out.println(mensaje);
         } while (1>0);
      }
      catch (Exception e) {
         System.err.println(e.getMessage());
         System.exit(1);
      }
   }
}
