import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class MatrixPersegi
{

	/*Author of this Class:
	Izharulhaq - 13518092
	Informatics Engineering of ITB
	Linear Algebra */


	/* ***ATRIBUT GLOBAL*** */
		public float[][] mTab;
		private int size;
		private int nSwap;
		public static final int maxSize = 100;

	/* ***METODE*** */
	/* FUNGSI MATEMATIKA */
	public float pow(float a, float b)
	/* Menghitung hasil dari a pangkat b, b >= 0 */
	{
		// KAMUS LOKAL

		// ALGORITMA
			if (b == 0)
			{
				return 1;
			}
			else /* b > 0 */
			{
				return a * pow(a, b - 1);
			}
	}

	/* KONSTRUKTOR */
	public MatrixPersegi()
	/* Inisiasi nilai awal membentuk matriks kosong berukuran
		 maxSize x maxSize */
	/* I. S. Sembarang */
	/* F. S. Terbentuk matriks berukuran maxSize x maxSize */
	{
		// KAMUS LOKAL

		// ALGORITMA
			this.mTab = new float[maxSize][maxSize];
	}

	public void setSquare()
	/* Menerima masukan ukuran efektif matriks persegi dari pengguna */
	/* I. S. Sembarang */
	/* F. S. Ukuran efektif matriks terdifinisi */
	{
		// KAMUS LOKAL
			int n;
			Scanner input = new Scanner(System.in);

		// ALGORITMA
			n = input.nextInt();
			this.size = n;
	}

	public void setSize(int n)
	/* Set ukuran efektif matriks */
	/* I. S. Sembarang */
	/* F. S. Ukuran efektif matriks terdifinisi */
	{
		// KAMUS LOKAL

		// 	ALGORITMA
			this.size = n;
	}

	/* SELEKTOR */
	public float elmt(float[][] M, int m, int n)
	/* Untuk mengakses elemen baris ke m dan kolom ke n
	cukup masukkan nilai m dan n saja tanpa perlu dikurangi satu
	Contoh:
	Matriks
	1 4 5 6
	3 6 2 0
	10 9 3 7
	Maka
	elmt(3,1) = 10
	elmt(0,0) tidak valid */
	{
		// KAMUS LOKAL

		// ALGORITMA
			return M[m-1][n-1];
	}

	public int getSize(float[][] M)
	/* Mengakses ukuran matriks M. Apabila ukuran */
	/* matriks > ukuran efektif (size), mengembalikan */
	/* ukuran efektif (size) */
	{
		// KAMUS LOKAL

		// ALGORITMA
			if (M.length <= this.size)
			{
				return M.length;
			}
			else
			{
				return this.size;
			}
	}

	public float[] entireRow(float[][] M, int m)
	/* Mengakses seluruh elemen pada baris ke-m dari */
	/* matriks M dengan 1 <= m <= getSize(M) */
	{
		// KAMUS LOKAL
			float[] rowKe_m = new float[getSize(M)];
			int i;

		// ALGORITMA
			for (i = 0; i < getSize(M); i++)
			{
				rowKe_m[i] = M[m-1][i];
			}

		return rowKe_m;
	}

	/* OPERASI BARIS ELEMENTER */
	public void swapRow(float[][] M, int x, int y)
	/* Operasi Menukar baris ke x dengan baris ke y dari mTab */
	/* I. S. Matriks M terdefinisi */
	/* F. S. Elemen matriks M baris ke-x ditukar dengan elemen */
	/* 			 matriks M baris ke-y */
	{
		// KAMUS LOKAL
			float[] temp1 = new float[getSize(M)];
			float[] temp2 = new float[getSize(M)];
			int i;

		// ALGORITMA
			temp1 = entireRow(M, x);
			temp2 = entireRow(M, y);

			for(i = 0; i < getSize(M); i++)
			{
				M[x-1][i] = temp2[i];
				M[y-1][i] = temp1[i];
			}
	}

	public void multiplyRow(float[][] M, int m, float num)
	/* Operasi Perkalian Elemen Baris ke m dengan num  */
	{
		// KAMUS LOKAL
			int i;

		// ALGORITMA
			for(i = 0; i < getSize(M); i++)
			{
				M[m-1][i] *= num;
			}
	}

	public void divideRow(float[][] M, int m, float num)
	/* Operasi Pembagian Elemen Baris ke m dengan num */
	{
		// KAMUS LOKAL
			int i;

		// ALGORITMA
			for(i = 0; i < getSize(M); i++)
			{
				M[m-1][i] /= num;
			}
	}

	public void addRows(float[][] M, int x, int y)
	/* Operasi Pertambahan setiap Elemen pada baris ke-x dengan setiap
	Elemen pada baris ke-y */
	{
		// KAMUS LOKAL
			int i;
			float[] temp1 = new float[getSize(M)];
			float[] temp2 = new float[getSize(M)];

		// ALGORITMA
			temp1 = entireRow(M, x);
			temp2 = entireRow(M, y);

			for(i = 0; i < getSize(M); i++)
			{
				M[x-1][i] = temp1[i] + temp2[i];
			}
	}

	public void substractRows(float[][] M, int x, int y)
	/* Operasi Pengurangan setiap Elemen pada baris ke-x dengan setiap
	Elemen pada baris ke-y */
	{
		// KAMUS LOKAL
			int i;
			float[] temp1 = new float[getSize(M)];
			float[] temp2 = new float[getSize(M)];

		// ALGORITMA
			temp1 = entireRow(M, x);
			temp2 = entireRow(M, y);

			for(i = 0; i < getSize(M); i++)
			{
				M[x-1][i] = temp1[i] - temp2[i];
			}
	}

	/* OPERASI MATRIKS LAINNYA */
	public void copyMatrix(float[][] M, float[][] N)
	/* Menyalin elemen dari matriks M ke matriks N */
	/* I. S. Matriks M dan N terdefinisi dan berukuran sama */
	/* F. S. Matriks N memiliki elemen yang sama dengan matriks M */
	{
		// KAMUS LOKAL
			int i, j;

		// ALGORITMA
			for (i = 0; i < getSize(M); i++)
			{
				for (j = 0; j < getSize(M); j++)
				{
					N[i][j] = M[i][j];

				}
			}
	}

	public void transpose(float[][] M)
	/* Transpos matriks A m x n menjadi A n x m */
	{
		// KAMUS LOKAL
			float[][] temp = new float[getSize(M)][getSize(M)];
			int i, j;

		// ALGORITMA
			for(i = 0; i < getSize(M); i++)
			{
				for(j = 0; j < getSize(M); j++)
				{
					temp[i][j] = M[j][i];
				}
			}

			for(i = 0; i < getSize(M); i++)
			{
				for(j = 0; j < getSize(M);j++)
				{
					M[i][j] = temp[i][j];
				}
			}
	}

	public void stgAtas(float[][] M)
	/* Menghasilkan matriks segitiga atas dengan OBE */
	/* I.S. Matriks terdefinisi */
	/* F.S. Terbentuk matriks segitiga atas */
	{
		// KAMUS LOKAL
			int i, j, k;
			float konst;
			float[] temp;

		// ALGORITMA
			this.nSwap = 0;
			for(i = 1; i < getSize(M); i++)
			{
				for(j = 0; j < i; j++)
				{
					if (M[j][j] == 0)
					{
						k = j + 1;
						while(M[k][k] == 0 && k < getSize(M))
						{
							k++;
						}
						swapRow(M, j + 1, k + 1);
						this.nSwap += 1;
					}
					if (M[j][j] != 0)
					{
						konst = M[i][j] / M[j][j];
					}
					else
					{
						konst = 0;
					}

					temp = entireRow(M, j + 1);

					multiplyRow(M, j + 1, konst);
					substractRows(M, i + 1, j + 1);

					for (k = 0; k < getSize(M); k++)
					{
						M[j][k] = temp[k];
					}
				}
			}
	}

	

	public float determinan(float[][] M)
	/* Menghitung determinan dari matriks */
	{
		// KAMUS LOKAL
			int i, j;
			float d, k;
			float[][] mTemp;

		// ALGORITMA
			d = 1;
			mTemp = new float[getSize(M)][getSize(M)];

			copyMatrix(M, mTemp);

			stgAtas(mTemp);

			for (i = 0; i < getSize(M); i++)
			{
				d *= mTemp[i][i];
			}

			return d * pow(-1, this.nSwap);
	}

	public float[] elMinor(float[][] M, int i, int j)
	/* Menyimpan elemen-elemen dari minor matriks ke
		 dalam suatu array */
	/* I. S. Matriks terdefinisi dan i, j valid */
	/* F. S. Elemen-elemen minor tersimpan dalam suatu array*/
	{
		// KAMUS LOKAL
			int k, l, m;
			float[] minor;

		// ALGORITMA
			m = 0;
			k = 0;
			minor = new float[(getSize(M) - 1) * (getSize(M) - 1)];

			while (k < getSize(M))
			{
				l = 0;
				if (k != i)
				{
					while (l < getSize(M))
					{
						if (l != j)
						{
							minor[m] = M[k][l];
							m++;
						}

						l++;
					}
				}

				k++;
			}

			return minor;
	}

	public float[][] minorMatrix(float[][] M, int i, int j)
	/* Membentuk matriks minor dari elemen M[i][j] */
	/* I. S. Matriks terdefinisi dan i, j valid */
	/* F. S. Terbentuk matriks minor untuk elemen M[i][j] */
	{
		// KAMUS LOKAL
			int k, l, m;
			float[][] minMat;

		// ALGORITMA
			m = 0;
			minMat = new float[getSize(M) - 1][getSize(M) - 1];

			for (k = 0; k < getSize(M) - 1; k++)
			{
				for (l = 0; l < getSize(M) - 1; l++)
				{
					minMat[k][l] = elMinor(M, i, j)[m];
					m++;
				}
			}

			return minMat;
	}	

	public float[][] kofaktor(float[][] M)
	/* Membentuk matriks kofaktor dari matriks M */
	{
		// KAMUS LOKAL
			int i, j;
			float[][] kofMat;

		// ALGORITMA

			kofMat = new float[getSize(M)][getSize(M)];

			for (i = 0; i < getSize(M); i++)
			{
				for (j = 0; j < getSize(M); j++)
				{
					if ((i + j) % 2 == 0)
					{
						kofMat[i][j] = determinan(minorMatrix(M, i, j));
					}
					else
					{
						kofMat[i][j] = -1 * determinan(minorMatrix(M, i, j));
					}

				}
			}

			return kofMat;
	}

	public float ekspanKof(float[][] M)
	/* Menghasilkan determinan matriks M dengan */
	/* metode ekspansi kofaktor */
	{
		// KAMUS LOKAL
			int j;
			float det;

		// ALGORITMA
			det = 0;

			for (j = 0; j < getSize(M); j++)
			{
				det += M[0][j] * kofaktor(M)[0][j];
			}

			return det;
	}

	public float[][] adjoin(float[][] M)
	/* Menghasilkan adjoin dari matriks M */
	/* dengan transpose kofaktor matriks M */
	{
		// KAMUS LOKAL
			float[][] adj;

		// ALGORITMA
			adj = new float[getSize(M)][getSize(M)];
			copyMatrix(kofaktor(M), adj);
			transpose(adj);

			return adj;
	}




	public float[][] invers(float[][] M)
	/* Menghasilkan invers dari matriks M */
	/* Prekondisi : det(M) != 0 */
	{
		// KAMUS LOKAL
			int i, j;
			float det;
			float[][] inv;

		// ALGORITMA
			det = determinan(M);

			inv = new float[getSize(M)][getSize(M)];

			for (i = 0; i < getSize(M); i++)
			{
				for (j = 0; j < getSize(M); j++)
				{
					inv[i][j] = adjoin(M)[i][j] / det;
				}
			}

			return inv;
	}

	/* PROSEDUR INPUT/OUTPUT */
	/* Prosedur Input */
	public void readMatrixP(float[][] M)
	/* Menerima masukan elemen matriks dari layar */
	{
		// KAMUS LOKAL
			Scanner input = new Scanner(System.in);
			int i, j;

		// ALGORITMA
			setSquare();
			for(i = 0; i < getSize(M); i++)
			{
				for(j = 0; j < getSize(M); j++)
				{
					M[i][j] = input.nextFloat();
				}
			}
	}

	public void filereadMatrixP(float[][] M)
	/* Menerima masukan elemen matriks dari file .txt */
	{
		// KAMUS LOKAL
			int i, j;

		// ALGORITMA
			try
			{
				setSize(countFileSize());

				File input = new File("in.txt");
				Scanner fileInput = new Scanner(input);

				for(i = 0; i < getSize(M); i++)
				{
					for(j = 0; j < getSize(M); j++)
					{
						M[i][j] = fileInput.nextFloat();
					}
				}
			}
			catch (FileNotFoundException e)
			{
				System.out.println("no such file");
			}
	}

	public int countFileSize()
	/* Menghitung baris dalam file */
	{
		// KAMUS LOKAL
			int size;

		// ALGORITMA
			try {
				size = 0;
					File input = new File("in.txt");
					Scanner fileInput = new Scanner(input);

					while(fileInput.hasNextLine())
					{
						size++;
						fileInput.nextLine();
					}

					return size;
				}
				catch (FileNotFoundException e)
				{
					System.out.println("no such file");
					return 0;
				}
	}

	public void printMatrixP(float[][] M)
	/* Menuliskan matriks ke dalam layar */
	{
		// KAMUS LOKAL
			int i, j;

		// ALGORITMA
			System.out.println();
			for(i = 0; i < getSize(M); i++)
			{
				for(j = 0; j < getSize(M); j++)
				{
					System.out.print(elmt(M, i + 1, j + 1) + "  ");
					if(j == getSize(M) - 1)
					{
						System.out.println();
					}
				}
			}
	}

	/*Author of subprograms below this comment:
	Muhammad Mirza Fathan Al Arsyad - 13518111
	Informatics Engineering of ITB
	Linear Algebra */

	public void floatToMatrix(int m, int n, float f) {
		this.mTab[m-1][n-1] = f;
	}

	public float elmtP (int m, int n) {
		return this.mTab[m-1][n-1];
	}

	public float[][] getTab() {
		return this.mTab;
	}

	public float[] entireColumn(float[][] M, int m)
	/* m = {m | 1 <= m <= getSize(), m bilangan bulat}
	untuk akses kolom pertama gunakan entireColumn(1) */
	{
		// KAMUS LOKAL
			float[] colKe_m = new float[getSize(M)];
			int i;

		// ALGORITMA
			for (i = 0; i < getSize(M); i++)
			{
				colKe_m[i] = M[m-1][i];
			}

		return colKe_m;
	}

	public void stgAtasPrint(float[][] M) //Print Setiap step ke layar
	/* Menghasilkan matriks segitiga atas dengan OBE  dan ditampilkan ke layar*/
	{
		// KAMUS LOKAL
			int i, j, k;
			float konst;
			float[] temp;

		// ALGORITMA
			this.nSwap = 0;
			for(i = 1; i < getSize(M); i++)
			{
				for(j = 0; j < i; j++)
				{
					if (M[j][j] == 0)
					{
						k = j + 1;
						while(M[k][k] == 0 && k < getSize(M))
						{
							k++;
						}
						swapRow(M, j + 1, k + 1);
						printMatrixP(M);
						this.nSwap += 1;
						System.out.print("Jumlah pertukaran baris saat ini:");
						System.out.println(this.nSwap);
					}
					if (M[j][j] != 0)
					{
						konst = M[i][j] / M[j][j];
					}
					else
					{
						konst = 0;
					}

					temp = entireRow(M, j + 1);

					multiplyRow(M, j + 1, konst);
					printMatrixP(M);
					substractRows(M, i + 1, j + 1);
					printMatrixP(M);

					for (k = 0; k < getSize(M); k++)
					{
						M[j][k] = temp[k];
					}
				}
			}
	}

	public void determinanPrint(float[][] M) //Print setiap step ke layar
	/* Menampilkan langkah pencarian determinan dari matriks */
	{
		// KAMUS LOKAL
			int i, j;
			float d, k;
			float[][] mTemp;

		// ALGORITMA
			d = 1;
			mTemp = new float[getSize(M)][getSize(M)];

			copyMatrix(M, mTemp);

			stgAtasPrint(M);

			System.out.print("Nilai Determinan adalah perkalian diagonal\nDeterminan = ");
			for (i = 0; i < getSize(M); i++)
			{
				d *= mTemp[i][i];
				System.out.print(d);
				System.out.print(" * ");
			}
			System.out.print(-1);
			System.out.println("^(jumlah pertukaran barisan)");

			System.out.print("= ");
			for (i = 0; i < getSize(M); i++)
			{
				d *= mTemp[i][i];
				System.out.print(d);
				System.out.print(" * ");
			}
			System.out.print(-1);
			System.out.print("^");
			System.out.println(this.nSwap);

			System.out.print("= ");
			System.out.println(d * pow(-1, this.nSwap));
	}

	public void kofaktorPrint(float[][] M) 
	/* Menampilkan pencarian matriks kofaktor dari matriks M */
	{
		// KAMUS LOKAL
			int i, j;
			float[][] kofMat;

		// ALGORITMA

			kofMat = new float[getSize(M)][getSize(M)];

			for (i = 0; i < getSize(M); i++)
			{
				for (j = 0; j < getSize(M); j++)
				{
					if ((i + j) % 2 == 0)
					{	
						System.out.print("Elemen C");
						System.out.print(i+1);
						System.out.print(j+1);
						System.out.println(" =");
						kofMat[i][j] = determinan(minorMatrix(M, i, j));
						determinanPrint(minorMatrix(M,i,j));
					}
					else
					{
						System.out.print("Elemen C");
						System.out.print(i+1);
						System.out.print(j+1);
						System.out.println(" =");
						kofMat[i][j] = -1 * determinan(minorMatrix(M, i, j));
						determinanPrint(minorMatrix(M,i,j));
						System.out.println("dikalikan (-1)");
					}

				}
			}

			System.out.println("Matriks Kofaktor:");
			printMatrixP(kofMat);
	}

	public void adjoinPrint(float[][] M)
	/* Menampilkan penghitungan matriks adjoin dari matriks M */
	/* dengan transpose kofaktor matriks M */
	{
		// KAMUS LOKAL
			float[][] adj;

		// ALGORITMA
			adj = new float[getSize(M)][getSize(M)];
			copyMatrix(kofaktor(M), adj);
			kofaktorPrint(M);
			System.out.println("Matriks adjoin adalah transpos dari matriks kofaktor:");
			transpose(adj);
			printMatrixP(adj);
	}

	public void ekspanKofPrint(float[][] M)
	/* Menampilkan perhitungan determinan matriks M dengan */
	/* metode ekspansi kofaktor */
	{
		// KAMUS LOKAL
			int j;
			float det;

		// ALGORITMA
			det = 0;
			System.out.println("Determinan:");
			for (j = 0; j < getSize(M); j++)
			{
				System.out.print(M[0][j]);
				System.out.print("*");
				System.out.print(kofaktor(M)[0][j]);
				if(j!= getSize(M)-1) System.out.print(" + ");
				else System.out.println();
				det += M[0][j] * kofaktor(M)[0][j];
			}
			System.out.print("= ");
			System.out.println(det);
	}

	public void inversPrint(float[][] M)
	/* Menampilkan penghitungan invers dari matriks M */
	/* Prekondisi : det(M) != 0 */
	{
		// KAMUS LOKAL
			int i, j;
			float det;
			float[][] inv;

		// ALGORITMA
			det = determinan(M);

			inv = new float[getSize(M)][getSize(M)];

			System.out.println("Invers matriks adalah 1/determinan dikalikan matriks adjoin");
			System.out.print("1/");
			System.out.print(det);
			System.out.println("*");
			printMatrixP(adjoin(M));
			System.out.println("=");
			for (i = 0; i < getSize(M); i++)
			{
				for (j = 0; j < getSize(M); j++)
				{
					inv[i][j] = adjoin(M)[i][j] / det;
				}
			}

			printMatrixP(inv);
	}

}
