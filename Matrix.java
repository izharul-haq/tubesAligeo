import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Matrix {
	private float[][] mTab;
	private int row;
	private int column;
	public static final int maxSize = 100;

	/* Konstruktor */
	public Matrix () {
		this.mTab = new float[maxSize][maxSize];
	}

	public void setSize() {
		int m, n;
		Scanner input = new Scanner(System.in);
		m = input.nextInt();
		n = input.nextInt();
		this.row = m;
		this.column = n;
	}
	/* Set ukuran Matrix dari masukan pengguna */

	public void setRow(int n) {
		this.row = n;
	}

	public void setColumn(int n) {
		this.column = n;
	}

	/* Selektor */
	public float elmt(int m, int n) {
		return this.mTab[m-1][n-1];
	}
	/* Untuk mengakses elemen baris ke m dan kolom ke n
	cukup masukkan nilai m dan n saja tanpa perlu dikurangi satu
	Contoh:
	Matriks
	1 4 5 6
	3 6 2 0
	10 9 3 7
	Maka 
	elmt(3,1) = 10
	elmt(0,0) tidak valid 
	*/

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public float[] entireRow(int m) {
		float[] rowKe_m = new float[getColumn()];
		for(int i=0; i<getColumn(); i++) {
			rowKe_m[i] = this.mTab[m-1][i];
		}
		return rowKe_m;
	}
	/* m = {m | 1 <= m <= getRow(), m bilangan bulat}
	untuk akses baris pertama gunakan entireRow(1) */

	/* Operasi Baris Elementer */
	public void swapRow(int x, int y) {
		float[] temp1 = new float[getColumn()];
		float[] temp2 = new float[getColumn()];

		temp1 = entireRow(x);
		temp2 = entireRow(y);

		for(int i=0; i<getColumn(); i++) {
			this.mTab[x-1][i] = temp2[i];
			this.mTab[y-1][i] = temp1[i];
		}
	}
	/* Operasi Menukar baris ke x dengan baris ke y dari mTab */

	public void multiplyRow(int m, float num) {
		for(int i=0; i<getColumn(); i++) {
			this.mTab[m-1][i] *= num;
		}
	}
	/* Operasi Perkalian Elemen Baris ke m dengan num  */

	public void divideRow(int m, float num) {
		for(int i=0; i<getColumn(); i++) {
			this.mTab[m-1][i] /= num;
		}
	}
	/* Operasi Pembagian Elemen Baris ke m dengan num */

	public void addRows(int x, int y) {
		float[] temp1 = new float[getColumn()];
		float[] temp2 = new float[getColumn()];

		temp1 = entireRow(x);
		temp2 = entireRow(y);

		for(int i=0; i<getColumn(); i++) {
			this.mTab[x-1][i] = temp1[i] + temp2[i]; 
		}
	}
	/* Operasi Pertambahan setiap Elemen pada baris ke-x dengan setiap
	Elemen pada baris ke-y */

	public void substractRows(int x, int y) {
		float[] temp1 = new float[getColumn()];
		float[] temp2 = new float[getColumn()];

		temp1 = entireRow(x);
		temp2 = entireRow(y);

		for(int i=0; i<getColumn(); i++) {
			this.mTab[x-1][i] = temp1[i] - temp2[i]; 
		}
	}
	/* Operasi Pengurangan setiap Elemen pada baris ke-x dengan setiap
	Elemen pada baris ke-y */

	public void transpose() {
		float[][] temp = new float[getColumn()][getRow()];
		int tempInt;

		for(int i=0; i<getColumn(); i++) {
			for(int j=0; j<getRow(); j++) {
				temp[i][j] = this.mTab[j][i];
			}
		}

		tempInt = getRow();

		setRow(getColumn());
		setColumn(tempInt);

		System.out.println(getRow());
		System.out.println(getColumn());

		for(int i=0; i<getRow(); i++) {
			for(int j=0; j<getColumn();j++) {
				this.mTab[i][j] = temp[i][j];
			}
		}
	}
	/* Transpos matriks A mxn menjadi A nxm */

	/* Input dan Output */

	/* Prosedur Input */
	public void readMatrix() {
		Scanner input = new Scanner(System.in);
		setSize();
		for(int i=0; i<getRow(); i++) {
			for(int j=0; j<getColumn(); j++) {
				this.mTab[i][j] = input.nextFloat();
			}
		}
	}
	
	public void filereadMatrix() {
		try {
			setRow(countFileRow());
			setColumn(countFileColumn());

			File input = new File("in.txt");
			Scanner fileInput = new Scanner(input);

			for(int i=0; i<getRow(); i++) {
				for(int j=0; j<getColumn(); j++) {
					this.mTab[i][j] = fileInput.nextFloat();
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("no such file");
		}
	}
	/* Membaca input dari file.txt */

		

	public int countFileRow() {
		int row;
		row = 0;
		try {
			File input = new File("in.txt");
			Scanner fileInput = new Scanner(input);

			while(fileInput.hasNextLine()) {
				row++;
				fileInput.nextLine();
			}

			return row;
		}
		catch (FileNotFoundException e) {
			System.out.println("no such file");
			return 0;
		}
	}
	/* Hitung baris dalam File */

	public int countFileColumn() {
		int nbElmt, column;
		try {
			nbElmt = 0;
			File input = new File("in.txt");
			Scanner fileInput = new Scanner(input);

			while(fileInput.hasNextFloat()) {
				nbElmt++;
				fileInput.nextFloat();
			}

			column = nbElmt/ countFileRow();
			return column;
		}
		catch (FileNotFoundException e) {
			System.out.println("no such file");
			return 0;
		}
	}

	public void printMatrix() {
		System.out.println();
		for(int i=0; i<getRow(); i++) {
			for(int j=0; j<getColumn(); j++) {
				System.out.print(elmt(i+1,j+1) + "  ");
				if(j==getColumn()-1) {
					System.out.println();
				}
			}
		}  
	}
}