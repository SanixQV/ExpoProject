import java.net.*; import java.io.*;
public class UDPServer2 { 
  public static void main(String[] args)
    throws SocketException, IOException,
                          UnknownHostException
  {
	  DatagramSocket sock;
	    byte[] tampon;
	    byte[] tampon2 = new byte[200];
	  if (args.length != 1) {
	        System.out.println("Mauvais nombre d'arguments.");
	        System.exit(1);
	    }
	  int port = Integer.parseInt(args[0]);
	  int taille = tampon2.length;
	  DatagramPacket paquet2 = new DatagramPacket(tampon2, taille);
	    sock = new DatagramSocket(port);
	    sock.receive(paquet2);
	    String message=new String(paquet2.getData());
        System.out.println(message);
	  
        message="reçu : "+ message;
	  tampon = message.getBytes();
	    
	    
	    DatagramPacket paquet = new DatagramPacket( tampon, tampon.length, paquet2.getAddress(), paquet2.getPort());
	    sock = new DatagramSocket();
	    sock.send(paquet);
	     
}
  }