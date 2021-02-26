import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;


public class HttpServer{ 
	

	public static void main(String[] args) throws IOException {
		int port;
		if (args.length != 0) {
			port = Integer.parseInt(args[0]);
		}else {
			port = 80;
		}
		
		ServerSocket serverConnect = new ServerSocket(port);
		System.out.println("Serveur lancé sur le port : " + port);
		

			while (true) {
				Socket connect;
				connect = serverConnect.accept();
				
				System.out.println("Client connecté au serveur");

				BufferedReader brIn = new BufferedReader(new InputStreamReader(connect.getInputStream()));
				BufferedWriter brOut = new BufferedWriter(new OutputStreamWriter(connect.getOutputStream()));
				BufferedOutputStream brOutImg = new BufferedOutputStream(connect.getOutputStream());
				
				
				String method = brIn.readLine();
				System.out.println(method);
				String [] m = method.split(" ");
				
				String file = m[1];
				if (m.length > 0) {
					if(m[0].equals("GET")) {
						String fichier = "";
						if (file.equals("/")) {
							fichier = "index.html";
						}else {
							fichier = file;
							fichier.substring(1);
						}try {
							if(fichier.endsWith(".jpg")) {
								fichier = file.replace("/", "\\\\");
								System.out.println("Le nom du fichier est : " + fichier);
								File f = new File("C:\\Users\\quentin\\Desktop\\"+ fichier);
								FileInputStream fIS = new FileInputStream(f);
								byte [] b = new byte [(int) f.length()];
								brOut.write("HTTP/1.1 200 OK\r\nContent-Type: images/jpeg\r\n\r\n");
								fIS.read(b);
								brOutImg.write(b);
								brOutImg.flush();	
							}else { 
								BufferedReader bR2 = new BufferedReader(new FileReader("C:\\Users\\quentin\\Desktop\\"+ fichier));
								String html;
								while((html=bR2.readLine())!= null) {
									brOut.write(html+"\r\n");
								}
								bR2.close();
							}
						}catch(FileNotFoundException e){
							String error = "HTTP/1.1 404 not found";
                            System.out.println("> " + error);	
						}
					}else {
						String error2 = "HTTP/1.1 501 Not Implemented";
                        System.out.println("> " + error2);
					}
					System.out.println("connexion terminée");
					brOut.close();
					brIn.close();
					connect.close();
				}
			}
		}
	
	}