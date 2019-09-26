import java.util.*;
import java.io.*;

public class InvEq {
	private Matrix tab;
	private int size;

	public InvEq() {
		this.tab = new Matrix();
	}

	public void readIv() {
		System.out.print("Silahkan tentukan ukuran matriks: ");
		Scanner y = new Scanner(System.in);
		this.size = y.nextInt();

		System.out.println("Masukkan elemen-elemen matriks. Untuk setiap elemen, pisahkan dengan spasi. Untuk setiap baris, dengan enter.");
		for(int i=1; i<=size; i++) {
			for(int j=1; j<=2*size; j++) {
				if(j<=size) tab.getTab()[i-1][j-1] = y.nextFloat();
				else {
					if(j-i == size) tab.getTab()[i-1][j-1] = 1;
					else tab.getTab()[i-1][j-1] = 0;
				}
			}
		}
	}

	public void filereadIv() {
		tab.filereadMatrix();
	}

	public void printMat() {
		for(int i=1; i<= this.size; i++) {
			for(int j=1; j<= 2*this.size; j++) {
				System.out.print(tab.elmt(i,j));
				if(j<2*size) System.out.print(" ");
				else System.out.println();
			
			}
		}
	}

	public void doInv() {
		boolean b;
		System.out.print("Apakah anda akan menyimpan file output?(1/0) ");
		Scanner r = new Scanner(System.in);
		int o = r.nextInt();
		if(o==1) b =true;
		else b = false;

		tab.setRow(this.size);
		tab.setColumn(2*this.size);
		printMat();
		tab.jordanElimination();

		System.out.println();
		printMat();
		if(b) tab.fileprintMatrix();
	}
}