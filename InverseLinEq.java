import java.util.*;


/*Author of this Class:
	Muhammad Mirza Fathan Al Arsyad - 13518111
	Informatics Engineering of ITB
	Linear Algebra */

public class InverseLinEq {
	private MatrixPersegi koef;
	private Matrix augMat;
	private Matrix result;
	private float[] solution;
	private int neff;

	public InverseLinEq() {
		this.koef = new MatrixPersegi();
		this.augMat = new Matrix();
		this.result = new Matrix();
		this.solution = new float[101];
		neff = 0;
	}

	public MatrixPersegi getKoef() {
		return this.koef;
	}

	public int getSize() {
		return this.koef.getSize(getKoef().getTab());
	}

	public Matrix getAug() {
		return this.augMat;
	}

	public Matrix getRes() {
		return this.result;
	}

	public void setRes(int i) {
		getRes().setColumn(1);
		getRes().setRow(i);
	}

	public void setSize(int s) {
		getKoef().setSize(s);
	}
	public void readInverseLinEq() {
		System.out.print("Masukkan jumlah persamaan yang akan diselesaikan: ");
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		this.neff = size;
		setSize(size);
		setRes(size);
		System.out.println("Masukkan koefisien persamaan linear diikuti dengan hasil dari setiap persamaan: ");
		for(int i=1; i<=getSize(); i++) {
			for(int j=1; j<=getSize(); j++) {
				if(j!=getSize()) {
					float f = input.nextFloat();
					getKoef().floatToMatrix(i,j,f);					
				} else {
					float f = input.nextFloat();
					getRes().floatToMatrix(i,1,f);
				}
			}
		}
	}

	public float[][] mulMat(float [][] tab1, float[][] tab2) {
		float[][] tab = new float[getSize()+1][getSize()+1];

		for(int i=1; i<= getSize(); i++) {
			for(int j= 1; j<= getSize(); j++) {
				tab[1][1]=0;
			}
		}

		for(int i= 1; i<= getSize(); i++) {
			for(int j= 1; j<= getSize(); j++) {
				for(int k = 1; k<= getSize(); k++) {
					tab[i][j] += (tab1[i][k] * tab[k][j]);
				}
			}
		}	

		return tab;
	}

	public void solveInverse() {
		MatrixPersegi inversed = new MatrixPersegi();
		inversed.setSize(getSize());
		float[][] inv = inversed.invers(inversed.getTab());


		if(this.koef.determinan(this.koef.getTab())<= 0.000000001 && this.koef.determinan(this.koef.getTab())>= 0.000000001) {
			System.out.println("Matriks koefisien tidak memiliki invers");
		} else {

			for(int i=1; i<=getSize(); i++) {
				for(int j=1; j<=getSize(); j++) {
					getKoef().floatToMatrix(i,j, inv[i][j]);
				}
			}

			float[][] tabKoefRes = mulMat(inversed.getTab(), getKoef().getTab());
			float[][] tabHasilRes = mulMat(inversed.getTab(), getRes().getTab());

			for(int i=1; i<=getSize(); i++) {
				result.floatToMatrix(i,1,tabHasilRes[1][i]);
			}

			for(int i=1; i<=getSize(); i++) {
				System.out.println(result.elmt(1,i));
			}

		}
	}
}