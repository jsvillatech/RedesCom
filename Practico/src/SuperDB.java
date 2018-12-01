import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SuperDB {

	private File file;

	public SuperDB() {

		file = new File("./src/Resources/DB.txt");

		if (!file.exists()) {

			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void registrar(String name, String horse) {

		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file.getAbsolutePath(), true);
			BufferedWriter buferrWriter = new BufferedWriter(fileWriter);
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line = reader.readLine();

			while (true) {

				if (line != null && line.equals("")) {

					buferrWriter.write(name + "||" + horse + "\n");
					System.out.println("ok");
					buferrWriter.close();
					line = reader.readLine();

					break;
				}
				
				line = reader.readLine();

				

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//			buferrWriter.close();
//			fileWriter.close();

	}

}
