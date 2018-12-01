
public class Horse extends Thread {

	private String nombre;
	private int vel;
	private int cj;

	public Horse(String nom) {

		nombre = nom;
		vel = (int) (Math.random()*10)+1;
		cj = 0;

	}

	public void run() {

		
		while (cj<10) {

			try {
				Thread.sleep(30000);
				
				cj = cj + vel;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		if(cj>=10) {
			cj=9;
		}
		System.out.println(nombre+" WINS!");
		// Run little horse, please run

	}



	public int getCj() {
		return cj;
	}

	public void setCj(int cj) {
		this.cj = cj;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

}
