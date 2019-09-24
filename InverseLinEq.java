import java.util.*;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;

/*Author of this Class:
	Muhammad Mirza Fathan Al Arsyad - 13518111
	Informatics Engineering of ITB
	Linear Algebra */
 
public class InverseLinEq {

	private float[][] koef;
	private float[][] result;
	private float[] solution;
	private int effKoe;
	private int effKol;
	private int effRow;
	private MatrixPersegi m;

	public InverseLinEq() {
		koef = new float[100][100];
		result = new float[100][1];
		solution = new float[100];
		effKoe = 0;
		effKol = 0;
		effRow = 0;
		m = new MatrixPersegi();

	}

	public void setNeff(int s) {
		this.effKoe = s;
	}

	public void setKol(int s) {
		this.effKol = s;
	}

	public void setRow(int s) {
		this.effRow = s;
	}

	public float koElmt(int i,int j) {
		return this.koef[i][j];
	}

	public void readInverseLinEq() {
		System.out.print("Masukkan jumlah persamaan linear: ");
		Scanner input = new Scanner(System.in);
		setNeff(input.nextInt());
		System.out.println("Masukkan koefisien-koefisien dalam SPL diikuti dengan hasil");
		setKol(1);
		setRow(this.effKoe);

		for (int i=0; i<this.effKoe; i++) {
			for(int j=0; j<this.effKoe+1; j++) {
				if(j<this.effKoe) this.koef[i][j] = input.nextFloat();
				else this.result[i][0] = input.nextFloat();
			}
		}

	}

	public void filereadInverseLinEq() {
		String s;
		try {
			Scanner instring = new Scanner(System.in);
			System.out.print("Masukkan judul file yang akan di input: ");
			s = instring.nextLine();

			setNeff(countFileRow(s));
			setKol(1);
			setRow(countFileRow(s));

			File input = new File(s);
			Scanner fileInput = new Scanner(input);

			for(int i=0; i<this.effKoe; i++) {
				for(int j=0; j<this.effKoe+1; j++) {
					if(j!= this.effKoe) this.koef[i][j] = fileInput.nextFloat();
					else this.result[i][0]= fileInput.nextFloat();
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("file yang dimaksud tidak ada");
		}

	}

	public int countFileRow(String s) {
		int row;
		row = 0;
		try {
			File input = new File(s);
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

	public int countFileColumn(String s) {
		int nbElmt, column;
		try {
			nbElmt = 0;
			File input = new File(s);
			Scanner fileInput = new Scanner(input);

			while(fileInput.hasNextFloat()) {
				nbElmt++;
				fileInput.nextFloat();
			}

			column = nbElmt/ countFileRow(s);
			return column;
		}
		catch (FileNotFoundException e) {
			System.out.println("no such file");
			return 0;
		}
	}

	public void doInverse() {
		float[][] tabInverse = new float[this.effKoe][this.effKoe];
		float[][] identity = new float[this.effKoe][this.effKoe];
		m.setSize(this.effKoe);

		try {

			if(m.determinan(this.koef) == 0) 
				System.out.println("Determinan Matriks koefisien bernilai nol, sehingga matriks koefisien tidak memiliki invers.");
			else {
				for(int i=0; i<this.effKoe; i++) {
				for(int j=0; j<this.effKoe; j++) {
					tabInverse[i][j] = m.invers(this.koef)[i][j];		
				}
			}
			
			for(int i=0; i<this.effKoe; i++) {
				for(int j=0; j<this.effKoe; j++) {
					identity[i][j]=0;
					solution[i]=0;
				}
			}

			for(int i=0; i<this.effKoe; i++) {
				for(int j=0; j<this.effKoe; j++) {
					for(int k=0; k<this.effKoe; k++) {
						identity[i][j] += (tabInverse[i][k] * this.koef[k][j]);
					}
				}
			}

			System.out.println();
			System.out.println("Kalikan matriks koefisien:");

			for(int i=0; i<this.effKoe; i++) {
				for(int j=0; j<this.effKoe; j++){
					if(j!= this.effKoe-1) {
						System.out.print((float)Math.round((this.koef[i][j])*100)/100);
						System.out.print(" ");
					} else {
						System.out.println((float)Math.round((this.koef[i][j])*100)/100);
					}
				}
			}

			System.out.println("dengan matriks inversnya, yaitu:");

			for(int i=0; i<this.effKoe; i++) {
				for(int j=0; j<this.effKoe; j++){
					if(j!= this.effKoe-1) {
						System.out.print((float)Math.round((tabInverse[i][j])*100)/100);
						System.out.print(" ");
					} else {
						System.out.println((float)Math.round((tabInverse[i][j])*100)/100);
					}
				}
			}

			System.out.println();
			System.out.println("Juga kalikan matriks hasil:");

			for(int i=0; i<this.effRow; i++) {
				for(int j=0; j<this.effKol; j++) {
					if(j!= this.effKol-1) {
						System.out.print((float)Math.round((this.result[i][j])*100)/100);
						System.out.print(" ");
					} else {
						System.out.println((float)Math.round((this.result[i][j])*100)/100);
					}
				}
			}

			System.out.println("dengan invers dari matriks koefisien:");

			for(int i=0; i<this.effKoe; i++) {
				for(int j=0; j<this.effKoe; j++){
					tabInverse[i][j] = m.invers(this.koef)[i][j];
					if(j!= this.effKoe-1) {
						System.out.print((float)Math.round((tabInverse[i][j])*100)/100);
						System.out.print(" ");
					} else {
						System.out.println((float)Math.round((tabInverse[i][j])*100)/100);
					}
				}
			}

			System.out.println();
			System.out.println("setelah matriks hasil dan koefisien yang sudah dikalikan dengan matriks invers dari koefisien digabungkan menjadi bentuk augmented matrix, akan menghasilkan:");

			for(int i=0; i<this.effKoe; i++) {
				for(int j=0; j<this.effKol; j++) {
					for(int k=0; k<this.effRow; k++) {
						this.solution[i] += (tabInverse[i][k] * this.result[k][j]);
					}
				}
			}

			for(int i=0; i<this.effKoe; i++) {
				for(int j=0; j<this.effKoe+1; j++) {
					if(j< this.effKoe) {
						System.out.print((float)Math.round((identity[i][j])*100)/100);
						System.out.print(" ");
					} else {
						System.out.println((float)Math.round((solution[i])*100)/100);
					}
				}
			}

			System.out.println();
			System.out.println("Maka bisa disimpulkan, solusinya adalah: ");

			for(int i=0; i<this.effKoe; i++) {
				System.out.print("x");
				System.out.print(i+1);
				System.out.print(" = ");
				System.out.print((float)Math.round((solution[i])*100)/100);
				if(i==this.effKoe-1) System.out.println();
				else System.out.print(", ");
			}

		}
			}

		catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index");
		}
	}
}