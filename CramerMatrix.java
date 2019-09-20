/* Author : M. Mirza Fathan Al Arsyad
   Informatics Engineering of ITB - 13518111
   Linear Algebra */

import java.util.*;

public class CramerMatrix {
	
	private MatrixPersegi koefMat; // Matriks Koefisien
	private Matrix augmentedMat;
	private float[] result;  // Matriks Hasil
	private float[] solution; // Array Solusi x1,x2,x3,...,xneff
	private int neff;

	public CramerMatrix() {
		koefMat = new MatrixPersegi();
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
		return this.koefMat.getSize();
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
		int size = input.nextInt();
		getMatrix().setSize(size);

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
		Scanner input = new Scanner(System.in);
		getAug().filereadMatrix();

		for(int i=1; i<=getAug().getRow(); i++) {
			for(int j=1; j<=getAug().getColumn(); j++) {
				if(j==getAug().getColumn()) this.result[i] = input.nextFloat();
				else {
					float x = input.nextFloat();
					getMatrix().floatToMatrix(i,j,x);
				}
			}
		}
	}

	public void printMatrix() {
		this.koefMat.printMatrixP(getMatrix().getTab());
	}

	public void jthColumnToRes(MatrixPersegi mat, int j, float[] tab) {
		for(int i=1; i<=getMatrix().getSize(); i++) {
			mat.floatToMatrix(i, j, tab[i]);
		}
	}

	public void cramer() {
		MatrixPersegi temp = new MatrixPersegi();
		temp.setSize(getSize());
		this.neff = getSize();

		for(int i=1; i<=this.neff; i++) {
			copyMatrix(temp);
			jthColumnToRes(temp, i, this.result);
			this.solution[i] = temp.determinan(temp.getTab())/getMatrix().determinan(getMatrix().getTab());
		}
	}

	public void printCramer() {
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