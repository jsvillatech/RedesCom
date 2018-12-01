
public class Field {

	// Lanes for the horses
	private Horse lane1[];
	private Horse lane2[];
	private Horse lane3[];
	private Horse lane4[];
	private Horse lane5[];
	private Horse lane6[];

	// The horses
	private Horse h1;
	private Horse h2;
	private Horse h3;
	private Horse h4;
	private Horse h5;
	private Horse h6;

	// ttttt
	private int t;

	public Field() {

		// initialize lanes
		ini();

		t = 180;

		go();

	}

	public void ini() {

		lane1 = new Horse[10];
		lane2 = new Horse[10];
		lane3 = new Horse[10];
		lane4 = new Horse[10];
		lane5 = new Horse[10];
		lane6 = new Horse[10];

	}

	public void go() {

		h1 = new Horse("h1");
		h1.start();
		h2 = new Horse("h2");
		h2.start();
		h3 = new Horse("h3");
		h3.start();
		h4 = new Horse("h4");
		h4.start();
		h5 = new Horse("h5");
		h5.start();
		h6 = new Horse("h6");
		h6.start();

		System.out.println("Race started!");

	}

	public void refresh() {

		ini();
		lane1[h1.getCj()] = h1;
		lane2[h2.getCj()] = h2;
		lane3[h3.getCj()] = h3;
		lane4[h4.getCj()] = h4;
		lane5[h5.getCj()] = h5;
		lane6[h6.getCj()] = h6;

	}

	public Horse[] getLane1() {
		return lane1;
	}

	public void setLane1(Horse[] lane1) {
		this.lane1 = lane1;
	}

	public Horse[] getLane2() {
		return lane2;
	}

	public void setLane2(Horse[] lane2) {
		this.lane2 = lane2;
	}

	public Horse[] getLane3() {
		return lane3;
	}

	public void setLane3(Horse[] lane3) {
		this.lane3 = lane3;
	}

	public Horse[] getLane4() {
		return lane4;
	}

	public void setLane4(Horse[] lane4) {
		this.lane4 = lane4;
	}

	public Horse[] getLane5() {
		return lane5;
	}

	public void setLane5(Horse[] lane5) {
		this.lane5 = lane5;
	}

	public Horse[] getLane6() {
		return lane6;
	}

	public void setLane6(Horse[] lane6) {
		this.lane6 = lane6;
	}

	

}
