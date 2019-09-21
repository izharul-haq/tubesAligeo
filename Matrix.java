/* Author : M. Mirza Fathan Al Arsyad
   Informatics Engineering of ITB - 13518111
   Linear Algebra */


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

	public void floatToMatrix(int m, int n, float f) {
		this.mTab[m-1][n-1] = f;
	}
	/* Mengisi Matriks baris ke-m dan baris ke-n dengan nilai f */

	public void setSize() {
		int m, n;
		Scanner input = new Scanner(System.in);
		m = input.nextInt();
		n = input.nextInt();
		this.row = m;
		this.column = n;
	}
	/* Set ukuran Matrix dari masukan pengguna */

	public void setSquare() {
		int n;
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		this.row = n;
		this.column = n;
	}
	/* Set ukuran Matrix persegi dari masukan pengguna */
	
	public void setRow(int n) {
		this.row = n;
	}

	public void setColumn(int n) {
		this.column = n;
	}

	/* Selektor */
	public float[][] getTab() {
		return this.mTab;
	}

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

	/* ELIMINASI GAUSS */
	public void gaussElimination() {
		for(int i=1; i<= getRow(); i++) {
			/* cek apakah elmt(i,i) nol. jika iya maka akan dilakukan penukaran barisan */
			int k = i+1;
			while(elmt(i,i)==0 && k<= getRow()){ 
				swapRow(i, k);
				k++;
			}
			/* buat elmt(i,i) menjadi leading 1 dari row ke-i */
			divideRow(i, elmt(i,i));

			for(int j=i+1; j<= getRow(); j++) {
				float temp = elmt(j,i);
				if(temp != 0) {
					multiplyRow(i, temp);
					substractRows(j, i); 
					divideRow(i, temp);
				}
			}
		}
	}
	/* Eliminasi dengan asumsi tidak ada satu kolom pun yang berisi angka nol semua */
	/* I.S. Matriks M, F.S. Matriks M menjadi Echelon */
	
	/* ELIMINASI JORDAN */
	public void jordanElimination() {
		gaussElimination();
		for(int i=2; i<= getColumn()-1; i++) { // kolom terakhir tidak diproses karena berisi b
			for(int j=1; j< i; j++) {
				float temp = elmt(j,i);
				if(temp != 0) {
					multiplyRow(i, temp);
					substractRows(j, i);
					divideRow(i, temp);
				}
			}
		}
	}
	/* F.S. REF */

	/* INPUT DAN OUTPUT */

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
	/* Hitung jumlah kolom dalam file */

	public void printMatrix() {
		System.out.println();
		for(int i=0; i<getRow(); i++) {
			for(int j=0; j<getColumn(); j++) {
				System.out.print(elmt(i+1,j+1));
				if(j==getColumn()-1) {
					System.out.println();
				} else {
					System.out.print("  ");
				}
			}
		}  
	}

/*
	public void fileprintMatrix() {
		//Input nama file

		//cetak ke file
		File output = new File(fileName);


		}
	public void makefileOutput() {
		System.out.print("Simpan file sebagai (<nama>.txt): ");
		String fileName;
		Scanner input = new Scanner(System.in);
		fileName = input.nextLine();

		PrintStream outputFile = new PrintStream(new FileOutputStream(fileName));
	}

	public String outputFileName() {
		
	}
	*/
}
