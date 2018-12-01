import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.net.ssl.SSLSocketFactory;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class SSLClient {
	public static final String TRUSTTORE_LOCATION = "./src/Resources/MyClient.jks";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("SSLClientSocket Started");
		// this an argument like -Djavax.net.ssl.trustStore="keystore"....
		System.setProperty("javax.net.ssl.trustStore", TRUSTTORE_LOCATION);
		SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
		int sec = 0;
		Socket socket;
		try {
			socket = sf.createSocket("localhost", 5000);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Scanner scanner = new Scanner(System.in);
			ClientAudio cli = new ClientAudio();
			cli.start();
			System.out.println("Enter name: ");
			String inputLine = scanner.nextLine();
			String name = inputLine;
			out.println(inputLine);
			System.out.println("Enter your horse number (from h1 to h6)");
			inputLine = scanner.nextLine();
			String horse = inputLine;
			out.println(inputLine);
			String h = inputLine;

			System.out.println("Server response: " + br.readLine());
			SuperDB spdb = new SuperDB();
			spdb.registrar(name, horse);
			while (true) {

				System.out.println(br.readLine());

				if ("quit".equalsIgnoreCase(inputLine)) {
					break;
				}

			}

			System.out.println("SSLServerSocket Terminated");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}