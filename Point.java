import java.util.*;

public class Point {
	private float x, y;

	/*KONSTRUKTOR*/
	public Point(float a, float b) {
		this.x = a;
		this.y = b;
	}

	/*SELEKTOR*/
	public float abscissa() {
		return this.x;
	}

	public float ordinate() {
		return this.y;
	}

	/* INPUT */
	public void readPoint() {
		Scanner input = new Scanner(System.in);
		this.x = input.nextFloat();
		this.y = input.nextFloat();
	}
}