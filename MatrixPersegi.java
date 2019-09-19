import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class MatrixPersegi
{
	public float[][] mTab;
	private int size;
	private int nSwap;
	public static final int maxSize = 100;

	private float pow(float a, float b)
	{
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
	/* Inisiasi nilai awal */
	{
		// KAMUS LOKAL
			int i, j;

		// ALGORITMA
			this.mTab = new float[maxSize][maxSize];
	}

	private void setSquare()
	/* Menerima masukan ukuran matriks persegi dari pengguna */
	{
		// KAMUS LOKAL
			int n;
			Scanner input = new Scanner(System.in);

		// ALGORITMA
			n = input.nextInt();
			this.size = n;
	}

	private void setSize(int n)
	/* Set nilai baris */
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

	private int getSize()
	/* Mengakses nilai baris */
	{
		// KAMUS LOKAL

		// ALGORITMA
			return this.size;
	}

	private float[] entireRow(float[][] M, int m)
	/* m = {m | 1 <= m <= getSize(), m bilangan bulat}
	untuk akses baris pertama gunakan entireRow(1) */
	{
		// KAMUS LOKAL
			float[] rowKe_m = new float[getSize()];
			int i;

		// ALGORITMA
			for (i = 0; i < getSize(); i++)
			{
				rowKe_m[i] = M[m-1][i];
			}

		return rowKe_m;
	}

	private void copyMatrix(float[][] M, float[][] N)
	/* Menyalin elemen dari matriks M ke matriks N */
	/* I.S. Matriks M berukuran sama dengan matriks N */
	{
		// KAMUS LOKAL
			int i, j;

		// ALGORITMA
			for (i = 0; i < getSize(); i++)
			{
				for (j = 0; j < getSize(); j++)
				{
					N[i][j] = M[i][j];

				}
			}
	}
	/* OPERASI BARIS ELEMENTER */
	private void swapRow(float[][] M, int x, int y)
	/* Operasi Menukar baris ke x dengan baris ke y dari mTab */
	{
		// KAMUS LOKAL
			float[] temp1 = new float[getSize()];
			float[] temp2 = new float[getSize()];
			int i;

		// ALGORITMA
			temp1 = entireRow(M, x);
			temp2 = entireRow(M, y);

			for(i = 0; i < getSize(); i++)
			{
				M[x-1][i] = temp2[i];
				M[y-1][i] = temp1[i];
			}
	}

	private void multiplyRow(float[][] M, int m, float num)
	/* Operasi Perkalian Elemen Baris ke m dengan num  */
	{
		// KAMUS LOKAL
			int i;

		// ALGORITMA
			for(i = 0; i < getSize(); i++)
			{
				M[m-1][i] *= num;
			}
	}

	private void divideRow(float[][] M, int m, float num)
	/* Operasi Pembagian Elemen Baris ke m dengan num */
	{
		// KAMUS LOKAL
			int i;

		// ALGORITMA
			for(i = 0; i < getSize(); i++)
			{
				M[m-1][i] /= num;
			}
	}

	private void addRows(float[][] M, int x, int y)
	/* Operasi Pertambahan setiap Elemen pada baris ke-x dengan setiap
	Elemen pada baris ke-y */
	{
		// KAMUS LOKAL
			int i;
			float[] temp1 = new float[getSize()];
			float[] temp2 = new float[getSize()];

		// ALGORITMA
			temp1 = entireRow(M, x);
			temp2 = entireRow(M, y);

			for(i = 0; i < getSize(); i++)
			{
				M[x-1][i] = temp1[i] + temp2[i];
			}
	}

	private void substractRows(float[][] M, int x, int y)
	/* Operasi Pengurangan setiap Elemen pada baris ke-x dengan setiap
	Elemen pada baris ke-y */
	{
		// KAMUS LOKAL
			int i;
			float[] temp1 = new float[getSize()];
			float[] temp2 = new float[getSize()];

		// ALGORITMA
			temp1 = entireRow(M, x);
			temp2 = entireRow(M, y);

			for(i = 0; i < getSize(); i++)
			{
				M[x-1][i] = temp1[i] - temp2[i];
			}
	}

	public void transpose(float[][] M)
	/* Transpos matriks A m x n menjadi A n x m */
	{
		// KAMUS LOKAL
			float[][] temp = new float[getSize()][getSize()];
			int i, j;

		// ALGORITMA
			for(i = 0; i < getSize(); i++)
			{
				for(j = 0; j < getSize(); j++)
				{
					temp[i][j] = M[j][i];
				}
			}

			for(i = 0; i < getSize(); i++)
			{
				for(j = 0; j < getSize();j++)
				{
					M[i][j] = temp[i][j];
				}
			}
	}

	/* OPERASI LAINNYA */
	private void stgAtas(float[][] M)
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
			for(i = 1; i < getSize(); i++)
			{
				for(j = 0; j < i; j++)
				{
					if (M[j][j] == 0)
					{
						k = j + 1;
						while(M[k][k] == 0 && k < getSize())
						{
							k++;
						}
						swapRow(M, j + 1, k + 1);
						this.nSwap += 1;
					}

					konst = M[i][j] / M[j][j];

					temp = entireRow(M, j + 1);

					multiplyRow(M, j + 1, konst);
					substractRows(M, i + 1, j + 1);

					for (k = 0; k < getSize(); k++)
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
			mTemp = new float[getSize()][getSize()];

			copyMatrix(this.mTab, mTemp);

			stgAtas(mTemp);

			for (i = 0; i < getSize(); i++)
			{
				d *= mTemp[i][i];
			}

			return d * pow(-1, this.nSwap);
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
			for(i = 0; i < getSize(); i++)
			{
				for(j = 0; j < getSize(); j++)
				{
					M[i][j] = input.nextFloat();
				}
			}
	}

	public void filereadMatrix(float[][] M)
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

				for(i = 0; i < getSize(); i++)
				{
					for(j = 0; j < getSize(); j++)
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
			for(i = 0; i < getSize(); i++)
			{
				for(j = 0; j < getSize(); j++)
				{
					System.out.print(elmt(M, i + 1, j + 1) + "  ");
					if(j == getSize()-1)
					{
						System.out.println();
					}
				}
			}
	}
}
