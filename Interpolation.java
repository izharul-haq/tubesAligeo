/* Author : M. Mirza Fathan Al Arsyad
   Informatics Engineering of ITB - 13518111
   Linear Algebra

   Interpolation Class */

import java.util.*;
import java.io.*;

public class Interpolation {

	public static final int maxSize = 100;
	private Point ptIntrp;
	private Point[] ptArray;
	private int eff;
	private Matrix solveIntrp;
	private float xIntrp;

	public Interpolation() {
		this.eff = 0;
		this.ptIntrp = new Point(0, 0);
		this.ptArray = new Point[maxSize];
		this.solveIntrp = new Matrix();
		this.xIntrp = 0;
	}

	public Point getIntrPoint() {
		return this.ptIntrp;
	}

	public Point[] getIntrpArray() {
		return this.ptArray;
	}

	public Point getIntrpElmt(int i) {
		return this.ptArray[i-1];
	}

	public int getEffValue() {
		return this.eff;
	}

	public Matrix getMatrix() {
		return this.solveIntrp;
	}

	public float interpolateX() {
		return this.xIntrp;
	}

	public void readIntrp() {
		System.out.print("Masukkan jumlah titik yang akan diinterpolasi: ");
		Scanner input = new Scanner(System.in);
		this.eff = input.nextInt();
		System.out.println();

		for(int i=1; i<=getEffValue(); i++) {
			System.out.print("Masukkan titik ke-");
			System.out.print(i);
			System.out.print(": ");
			this.ptIntrp.readPoint();
			this.ptArray[i-1] = new Point(ptIntrp.abscissa(), ptIntrp.ordinate());
		}
		System.out.print("Masukkan nilai yang akan ditaksir: ");
		this.xIntrp = input.nextFloat();
		System.out.println();
	}

	public void filereadIntrp() {
		try {
			int i=0;
			System.out.print("Masukkan judul file yang ingin di input: ");
			Scanner inputString = new Scanner(System.in);
			String title = inputString.nextLine();
			File input = new File(title);
			Scanner fileInput = new Scanner(input);
			Scanner inputFloat = new Scanner(System.in);

			while(fileInput.hasNextFloat()) {
				float abscissa, ordinate;
				abscissa = fileInput.nextFloat();
				ordinate = fileInput.nextFloat();
				this.ptArray[i] = new Point(abscissa, ordinate);
				i++;
				this.eff++;
			}
			System.out.print("Masukkan nilai yang akan ditaksir: ");
			this.xIntrp = inputFloat.nextFloat();
			System.out.println();
		}
		catch (FileNotFoundException e) {
			System.out.println("no such file");
		}
	}

	public void interpolatePoints() {
		int row, column;
		getMatrix().setRow(getEffValue());
		getMatrix().setColumn(getEffValue()+1);
		row = getMatrix().getRow();
		column = getMatrix().getColumn();

		for(int i=1; i<= row; i++) {
			for(int j=1; j<= column; j++) {
				if(j== column) getMatrix().floatToMatrix(i, j, getIntrpElmt(i).ordinate());
				else {
					getMatrix().floatToMatrix(i, j, power((getIntrpElmt(i).abscissa()), row-j));	
				}
			}
		}
		getMatrix().jordanElimination();
	}
	private float power(float x, int n) {
		if (n==0) return 1;
		else {
			float temp = x;
			for(int i=1; i<n; i++) {
				x = temp*x;
			}
			return x;
		}
	}


	public void printIntrp() {
		System.out.print("f(x) = ");

		if(getMatrix().elmt(1, getMatrix().getColumn())==1) {
			System.out.print("");
		} else if(getMatrix().elmt(1, getMatrix().getColumn())==-1) {
			System.out.print("-");
		} else {
			System.out.print(getMatrix().elmt(1, getMatrix().getColumn()));	
		}

		if(getMatrix().getRow()!=1) {
			if(getEffValue()==2) {
				System.out.print("x");
			} else {
				System.out.print("x^");
				System.out.print(getEffValue()-1);
			}
		}

		for(int i=2; i<= getMatrix().getRow(); i++) {
			if(getMatrix().elmt(i, getMatrix().getColumn()) < 0) {
				System.out.print(" - ");
				System.out.print((-1)*getMatrix().elmt(i, getMatrix().getColumn()));
				if(i != getMatrix().getRow()) {
				if(i == getMatrix().getRow()-1) System.out.print("x");
				else {
					System.out.print("x^");
					System.out.print(getEffValue()-i);
				}
			}
			} else if(getMatrix().elmt(i, getMatrix().getColumn()) > 0) {
				System.out.print(" + ");
				System.out.print(getMatrix().elmt(i, getMatrix().getColumn()));
				if(i != getMatrix().getRow()) {
				if(i == getMatrix().getRow()-1) System.out.print("x");
				else {
					System.out.print("x^");
					System.out.print(getEffValue()-i);
				}
			}
			} 
		}
		System.out.println();
		System.out.print("f(");
		System.out.print(interpolateX());
		System.out.print(") = ");
		System.out.println(fX(interpolateX()));

		System.out.print("Apakah anda ingin menyimpan ke dalam file? (1/0): ");
		Scanner f = new Scanner(System.in);
		int o = f.nextInt();

		if(o==1) {
			fileprintIntrp();
		}
	}

	public float fX(float x) {
		float result = 0;
		int column = getMatrix().getColumn();
		int row = getMatrix().getRow();
		for (int i=1; i<= row; i++) {
			result += getMatrix().elmt(i, column)*power(x, row-i);
		}
		return result;
	}

	public void fileprintIntrp() {
		try {
			System.out.print("Beri judul pada file yang akan di output: ");
			Scanner inp = new Scanner(System.in);
			String fileName = inp.nextLine();
			FileOutputStream fileout = new FileOutputStream(fileName);

			PrintStream output = new PrintStream (fileout);

			output.print("f(x) = ");

			if(getMatrix().elmt(1, getMatrix().getColumn())==1) {
				output.print("");
			} else if(getMatrix().elmt(1, getMatrix().getColumn())==-1) {
				output.print("-");
			} else {
				output.print(getMatrix().elmt(1, getMatrix().getColumn()));	
			}

			if(getMatrix().getRow()!=1) {
				if(getEffValue()==2) {
					output.print("x");
				} else {
					output.print("x^");
					output.print(getEffValue()-1);
				}
			}

			for(int i=2; i<= getMatrix().getRow(); i++) {
				if(getMatrix().elmt(i, getMatrix().getColumn()) < 0) {
					output.print(" - ");
					output.print((-1)*getMatrix().elmt(i, getMatrix().getColumn()));
					if(i != getMatrix().getRow()) {
						if(i == getMatrix().getRow()-1) output.print("x");
						else {
							output.print("x^");
							output.print(getEffValue()-i);
						}
					}
				} else if(getMatrix().elmt(i, getMatrix().getColumn()) > 0) {
					output.print(" + ");
					output.print(getMatrix().elmt(i, getMatrix().getColumn()));
					if(i != getMatrix().getRow()) {
						if(i == getMatrix().getRow()-1) output.print("x");
						else {
							output.print("x^");
							output.print(getEffValue()-i);
						}
					}
				} 
			}
			output.println();
			output.print("f(");
			output.print(interpolateX());
			output.print(") = ");
			output.println(fX(interpolateX()));
			
		} catch (FileNotFoundException e) {}
	}
}