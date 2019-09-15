import java.util.*;

public class Matrix {
	private int[][] mTab;
	private int row;
	private int column;
	public static final int maxSize = 100;

	public Matrix (int m, int n) {
		this.row = m;
		this.column = n;
		this.mTab = new int[maxSize][maxSize];
	}

	public int elmt(int m, int n) {
		return this.mTab[m-1][n-1];
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public void setSize() {
		int m, n;
		Scanner input = new Scanner(System.in);
		m = input.nextInt();
		n = input.nextInt();
		this.row = m;
		this.column = n;
	}

	public void readMatrix() {
		Scanner input = new Scanner(System.in);
		setSize();
		int m = getRow();
		int n = getColumn();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				this.mTab[i][j] = input.nextInt();
			}
		}
	}

	public void printMatrix() {
		int m = getRow();
		int n = getColumn();
		System.out.println();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(elmt(i+1,j+1) + " ");
				if(j==n-1) {
					System.out.println();
				}
			}
		}  
	}
}