/* Author : M. Mirza Fathan Al Arsyad
   Informatics Engineering of ITB - 13518111
   Linear Algebra */

import java.util.*;
import java.io.*;

public class CramerMatrix {
	
	private MatrixPersegi koefMat; // Matriks Koefisien
	private Matrix augmentedMat;
	private float[] result;  // Matriks Hasil
	private float[] solution; // Array Solusi x1,x2,x3,...,xneff
	private int neff;

	public CramerMatrix() {
		koefMat = new MatrixPersegi();
		augmentedMat = new Matrix();
		result = new float[101];
		solution = new float[101];
		neff = 0;
	}

	public MatrixPersegi getMatrix() {
		return this.koefMat;
	}

	public Matrix getAug() {
		return this.augmentedMat;
	}

	public int getSize() {
		return this.neff;
	}

	public void copyMatrix(MatrixPersegi tab) {
		for(int i=1; i<=getSize(); i++) {
			for(int j=1; j<=getSize(); j++) {
				tab.floatToMatrix(i, j, getMatrix().elmtP(i, j));
			}
		}
	}


	public void readCramer() {
		Scanner input = new Scanner(System.in);
		System.out.print("Tentukan banyak SPL: ");
		int size = input.nextInt();
		getMatrix().setSize(size);

		System.out.println("Input koefisien-koefisen dan diikuti dengan hasil, dipisahkan dengan spasi:");
		for(int i=1; i<=getSize(); i++) {
			for(int j=1; j<=getSize()+1; j++) {
				if(j==getSize()+1) this.result[i]= input.nextFloat();
				else {
					float x = input.nextFloat();
					getMatrix().floatToMatrix(i,j,x);
				}
			}
		}
	}	

	public void filereadCramer() {
		try {
			System.out.print("Masukkan judul file yang ingin di input: ");
			String title;

			Scanner instring = new Scanner(System.in);
			title = instring.nextLine();

			this.neff = countFileRow(title);
						
			File input = new File(title);
			Scanner fileInput = new Scanner(input);

			for(int i=0; i<this.neff; i++) {
				for(int j=0; j<this.neff+1; j++) {
					this.augmentedMat.getTab()[i][j] = fileInput.nextFloat();
				}
			}

			getAug().setRow(countFileRow(title));
			getAug().setColumn(countFileColumn(title));
		
			for(int i=1; i<=getAug().getRow(); i++) {
				for(int j=1; j<=getAug().getColumn(); j++) {
					if(j == getAug().getColumn()) this.result[i-1] = getAug().elmt(i,j);
					else this.koefMat.mTab[i-1][j-1] = getAug().elmt(i,j);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File tersebut tidak ada.");
		}
	}

	public int countFileRow(String title) {
		int row;
		row = 0;
		try {
			File input = new File(title);
			Scanner fileInput = new Scanner(input);

			while(fileInput.hasNextLine()) {
				row++;
				fileInput.nextLine();
			}

			return row;
		}
		catch (FileNotFoundException e) {
			System.out.println("File tersebut tidak ada.");
			return 0;
		}
	}
	/* Hitung baris dalam File */

	public int countFileColumn(String title) {
		int nbElmt, column;
		try {
			nbElmt = 0;
			File input = new File(title);
			Scanner fileInput = new Scanner(input);

			while(fileInput.hasNextFloat()) {
				nbElmt++;
				fileInput.nextFloat();
			}

			column = nbElmt/ countFileRow(title);
			return column;
		}
		catch (FileNotFoundException e) {
			System.out.println("File tersebut tidak ada.");
			return 0;
		}
	}

	public void printMatrix() {
		this.koefMat.printMatrixP(getMatrix().getTab());
	}

	public void printDet(MatrixPersegi tab) {
		for(int i=1; i<=tab.getSize(tab.getTab()); i++) {
			for(int j=1; j<=tab.getSize(tab.getTab()); j++) {
				System.out.print(tab.elmtP(i,j));
				if(j!=tab.getSize(tab.getTab())) {
					System.out.print(" ");
				} else {
					System.out.println();
				}
			}
		}

	}

	public void jthColumnToRes(MatrixPersegi mat, int j, float[] tab) {
		for(int i=1; i<=getSize(); i++) {
			mat.floatToMatrix(i, j, tab[i]);
		}
	}

	public void cramer() {
		MatrixPersegi temp = new MatrixPersegi();
		temp.setSize(getSize());
		this.neff = getSize();
		boolean a = true;

		for(int i=1; i<=this.neff; i++) {
			copyMatrix(temp);
			jthColumnToRes(temp, i, this.result);
			System.out.println();
			System.out.print("x");
			System.out.print(i);
			System.out.println(" adalah pembagian antara determinan matriks:");
			printDet(temp);
			System.out.print("yang bernilai: ");
			System.out.println(temp.determinan(temp.getTab()));
			System.out.println("dengan determinan matriks:");
			printDet(getMatrix());
			System.out.print("yang bernilai: ");
			System.out.println(getMatrix().determinan(getMatrix().getTab()));

			if(getMatrix().determinan(getMatrix().getTab())<= 0.0000000001 && getMatrix().determinan(getMatrix().getTab()) >= -0.0000000001) {
				System.out.println("Dikarenakan determinan matriks koefisien bernilai nol");
				System.out.println("solusi untuk SPL ini tidak bisa diselesaikan dengan kaidah cramer.");
				a= false;
			} else {
				this.solution[i] = temp.determinan(temp.getTab())/getMatrix().determinan(getMatrix().getTab());

			}
		}
		if(a) printCramer();
	}

	public void printCramer() {
		System.out.println();
		System.out.println("Maka, solusinya adalah:");
		for(int i=1; i<=this.neff; i++) {
			System.out.print("x");
			System.out.print(i);
			System.out.print(" = ");
			System.out.print(this.solution[i]);
			if(i!=this.neff) System.out.print(", ");
		}
		System.out.println();
	}
}