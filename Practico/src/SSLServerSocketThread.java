import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import javax.net.ssl.SSLServerSocketFactory;

public class SSLServerSocketThread {

	public static final String KEYSTORE_LOCATION = "./src/Resources/MyServer.jks";
	public static final String KEYSTORE_PASSWORD = "123456";
	static HashMap<String, Integer> bets = new HashMap<String, Integer>();
	static Field field;
	static int port;

	public static void main(String[] args) {

		try {

			System.setProperty("javax.net.ssl.keyStore", KEYSTORE_LOCATION);
			System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASSWORD);
			SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
			ServerSocket serverSocket = ssf.createServerSocket(5000);

			bets.put("h1", 0);
			bets.put("h2", 0);
			bets.put("h3", 0);
			bets.put("h4", 0);
			bets.put("h5", 0);
			bets.put("h6", 0);

			field = new Field();
			ServerAudio ser = new ServerAudio();
			ser.start();
			int count = 0;

			while (true && count < 10) {

				Socket socket = serverSocket.accept();
				System.out.println("Connection Established");
				SSLServerSocket thread = new SSLServerSocket(socket);
				thread.start();
				count++;

				System.out.println("Número total de clientes hasta el momento: " + count);

			}

			System.out.println("Has excedido el número máximo de clientes :(");
			serverSocket.close();
			System.exit(0);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static HashMap<String, Integer> getBets() {
		return bets;
	}

	public static void setBets(HashMap<String, Integer> bets) {
		SSLServerSocketThread.bets = bets;
	}

	public static void printbets() {

		for (String key : bets.keySet()) {
			Integer value = bets.get(key);
			System.out.println("Horse = " + key + ", # of bets = " + value);
		}
	}

	public static void refresh() {

		field.refresh();

	}

	public static Field fieldp() {
		return field;
	}

}
