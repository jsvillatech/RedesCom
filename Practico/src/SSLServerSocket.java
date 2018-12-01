import java.io.*;
import java.net.*;
import java.util.HashMap;

import javax.net.ssl.SSLServerSocketFactory;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

public class SSLServerSocket extends Thread {

	Socket client;
	private String horse;
	private String name;
	private Field field;
	private PrintWriter out;
	private BufferedReader br;

	public SSLServerSocket(Socket request) {

		super();
		client = request;
		horse = "";
		name = "";
		field = SSLServerSocketThread.fieldp();
		

	}

	public void run() {
		// TODO Auto-generated method stub

		try {
			out = new PrintWriter(client.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			System.out.println("Client socket created");
			System.out.println("Welcome to professor Christian's turf system");

			// horse=br.readLine();
			name = br.readLine();
			horse = br.readLine();
			out.println("Thanks " + name + " you betted for horse " + horse);

			for (String key : SSLServerSocketThread.getBets().keySet()) {
				if (key.equals(horse)) {

					SSLServerSocketThread.getBets().put(horse, SSLServerSocketThread.getBets().get(key) + 1);
				}

			}

			SSLServerSocketThread.printbets();
			int i = 0;
			while (i < 180) {
				SSLServerSocketThread.refresh();
				paintHorses(horse);
				try {
					Thread.sleep(30000);

					i = i + 1;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			br.close();
			out.close();
			client.close();
			this.interrupt();
			System.out.println("SSLServerSocket Teminated");
			// serverSocket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getHorse() {
		return horse;
	}

	public void setHorse(String horse) {
		this.horse = horse;
	}

	public void paintHorses(String highlight) {

		int i = 0;
		while (i < 10) {
			if (field.getLane1()[i] != null) {
				out.print(field.getLane1()[i].getNombre());
			} else {

				if (highlight.equals("h1")) {
					out.print("*");
				}

				else {
					out.print("=");
				}
			}
			i++;
		}
		out.println();
		int j = 0;
		while (j < 10) {
			if (field.getLane2()[j] != null) {
				out.print(field.getLane2()[j].getNombre());
			} else {
				if (highlight.equals("h2")) {
					out.print("*");
				}

				else {
					out.print("=");
				}
			}
			j++;
		}
		out.println();
		int k = 0;
		while (k < 10) {
			if (field.getLane3()[k] != null) {
				out.print(field.getLane3()[k].getNombre());
			} else {
				if (highlight.equals("h3")) {
					out.print("*");
				}

				else {
					out.print("=");
				}
			}
			k++;
		}
		out.println();
		int l = 0;
		while (l < 10) {
			if (field.getLane4()[l] != null) {
				out.print(field.getLane4()[l].getNombre());
			} else {
				if (highlight.equals("h4")) {
					out.print("*");
				}

				else {
					out.print("=");
				}
			}
			l++;
		}
		out.println();
		int m = 0;
		while (m < 10) {
			if (field.getLane5()[m] != null) {
				out.print(field.getLane5()[m].getNombre());
			} else {
				if (highlight.equals("h5")) {
					out.print("*");
				}

				else {
					out.print("=");
				}
			}
			m++;
		}
		out.println();
		int n = 0;
		while (n < 10) {
			if (field.getLane6()[n] != null) {
				out.print(field.getLane6()[n].getNombre());
			} else {
				if (highlight.equals("h6")) {
					out.print("*");
				}

				else {
					out.print("=");
				}
			}
			n++;
		}
		out.println("\n");
	}

	public String getNameClie() {
		return name;
	}

	public void setNameClie(String name) {
		this.name = name;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

}