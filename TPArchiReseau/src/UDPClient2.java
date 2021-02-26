import java.net.*; import java.io.*;
public class UDPClient2 { 
  public static void main(String[] args)
    throws SocketException, IOException,
                          UnknownHostException
  {
    InetAddress adr;
    DatagramSocket sock;
    byte[] tampon;
    byte[] tampon2 = new byte[200];
    if (args.length != 3) {
        System.out.println("Mauvais nombre d'arguments.");
        System.exit(1);
    }

    adr= InetAddress.getByName(args[0]);
    int port = Integer.parseInt(args[1]);
    String message = args[2];

    /* envoi du message */
    tampon = message.getBytes();
    DatagramPacket paquet = new DatagramPacket(tampon,tampon.length,adr, port);
    sock = new DatagramSocket();
    sock.send(paquet);

    /* attente réponse */
    DatagramPacket paquet2 = new DatagramPacket(tampon2,tampon2.length);
    sock.receive(paquet2);
    System.out.println("Recu de " + paquet2.getAddress());
    System.out.println(new String(paquet2.getData()));
  }
}