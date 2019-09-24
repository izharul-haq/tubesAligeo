/*Author of this Class:
	Muhammad Mirza Fathan Al Arsyad - 13518111
	Informatics Engineering of ITB
	Linear Algebra

	Main Program */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int in;
		do {
			int op, op1;
			MatrixPersegi tab = new MatrixPersegi();
    		CramerMatrix cTab = new CramerMatrix();
			InverseLinEq iTab = new InverseLinEq();
			
			for(int i=0; i<120;i++) {
    			write("_");
   			}
   			write("\n");
			writeln("MENU");
			for(int i=0; i<120;i++) {
    			write("_");
   			}
   			write("\n");
    		writeln("1. Sistem persamaan linear");
 		   	writeln("2. Hitung determinan matriks")  ;
	    	writeln("3. Matriks invers");
    		writeln("4. Matriks kofaktor");
    		writeln("5. Matriks adjoin");
	    	writeln("6. Interpolasi polinom f(x)");
    		writeln("7. Akhiri Program");
    		write("Silahkan pilih menu: ");
    		in = input.nextInt();

	    	if(in==1) {
	    		do {
	    			for(int i=0; i<120;i++) {
    					write("_");
   					}
  	 				write("\n");
		    		writeln("Silahkan pilih metode penyelesaian sistem persamaan linear:");
    				writeln("1. Eliminasi Gauss");
    				writeln("2. Eliminasi Gauss-Jordan");
	   				writeln("3. Metode Cramer");
  					writeln("4. Matriks invers");
    				writeln("5. Kembali ke menu sebelumnya");
  					write("Pilih 1-5: ");
    				op = input.nextInt();

	    			switch(op) {
    					case 1:

    						break;
    					case 2:

    						break;
    					case 3:
    						do {
	    						for(int i=0; i<120;i++) {
    								write("_");
			   					}
	  		 					write("\n");
				    			writeln("Silahkan pilih metode input SPL:");
    							writeln("1. Input dari Layar");
    							writeln("2. Input dari file");
	   							writeln("3. Kembali ke menu sebelumnya");
  								write("Pilih 1-3: ");
    							op1 = input.nextInt();
    							switch(op1) {
    								case 1:
    									cTab.readCramer();
    									if(cTab.getMatrix().determinan(cTab.getMatrix().getTab()) == 0)
    										writeln("Determinan matriks bernilai nol. Kaidah cramer tidak bisa dipakai untuk pencarian solusi sistem.");
    									else
    										cTab.cramer();
    									break;
    								case 2:
    									cTab.filereadCramer();
    									if(cTab.getMatrix().determinan(cTab.getMatrix().getTab())== 0)
    										writeln("Determinan matriks bernilai nol. Kaidah cramer tidak bisa dipakai untuk pencarian solusi sistem.");
    									else
    										cTab.cramer();
    									break;
    								case 3:
    									break;
    								default:
    									writeln("Pilihan anda tidak valid. Silahkan coba lagi.");
    									break;
    							}
    						} while(op1!=3);
    						break;
    					case 4:
    						do {
	    						for(int i=0; i<120;i++) {
    								write("_");
			   					}
	  		 					write("\n");
				    			writeln("Silahkan pilih metode input SPL:");
    							writeln("1. Input dari Layar");
    							writeln("2. Input dari file");
	   							writeln("3. Kembali ke menu sebelumnya");
  								write("Pilih 1-3: ");
    							op1 = input.nextInt();
    							switch(op1) {
    								case 1:
    									iTab.readInverseLinEq();
    									iTab.doInverse();
    									break;
    								case 2:
    									iTab.filereadInverseLinEq();
    									iTab.doInverse();
    									break;
    								case 3:
    									break;
    								default:
    									writeln("Pilihan anda tidak valid. Silahkan coba lagi.");
    									break;
    							}
    						} while(op1!=3);
    						break;
    					case 5:

    						break;
    					default:
    						writeln("Pilihan tidak valid, silhkan diulang.");
    						break;
    					}
	    		} while(op!=5);
	    	} else if(in==2) {
	    		do {
	    			for(int i=0; i<120;i++) {
    					write("_");
   					}
   					write("\n");
		    		writeln("Silahkan pilih metode pencarian determinan:");
    				writeln("1. Operasi Baris Elementer");
    				writeln("2. Ekspansi kofaktor");
   					writeln("3. Kembali ke menu sebelumnya");
  					write("Pilih 1-3: ");
    				op = input.nextInt();

    				switch(op) {
    					case 1:
    						do{
    							write("\n");
    							writeln("Silahkan pilih metode input matriks");
    							writeln("1. Input dari layar");
    							writeln("2. Input dari file");
    							writeln("3. Kembali ke menu sebelumhya");
    							write("Pilih 1-3: ");
    							op1 = input.nextInt();

    							switch(op1) {
    								case 1:
    									tab.readMatrixP(tab.getTab());
    									tab.determinanPrint(tab.getTab());
    									break;
    								case 2:
    									tab.filereadMatrixP(tab.getTab());
    									tab.determinanPrint(tab.getTab());
    									break;
    								case 3:
    									break;
    								default:
    									writeln("Pilihan anda tidak valid");
    									break;
    							}
    						} while(op1!=3);
    						break;
    					case 2:
    						do{
    							write("\n");
    							writeln("Silahkan pilih metode input matriks");
    							writeln("1. Input dari layar");
    							writeln("2. Input dari file");
    							writeln("3. Kembali ke menu sebelumhya");
    							write("Pilih 1-3: ");
    							op1 = input.nextInt();

    							switch(op1) {
    								case 1:
    									tab.readMatrixP(tab.getTab());
    									tab.ekspanKofPrint(tab.getTab());
    									break;
    								case 2:
    									tab.filereadMatrixP(tab.getTab());
    									tab.ekspanKofPrint(tab.getTab());
    									break;
    								case 3:
    									break;
    								default:
    									writeln("Pilihan anda tidak valid.");
    									break;
    							}
    						} while(op1!=3);
    						break;
    					case 3:
    						break;
    					default:
    						writeln("Pilihan anda tidak valid");
    						break;
    				}
	    		} while(op!=3);

	    	} else if(in==3) {
	    		do {
	    			for(int i=0; i<120;i++) {
    					write("_");
   					}
	    			write("\n");
		    		writeln("Silahkan pilih metode pencarian matriks invers:");
	    			writeln("1. Eliminasi Gauss-Jordan");
	    			writeln("2. Melalui matriks adjoin");
	    			writeln("3. Kembali ke menu sebelumnya");
	    			write("Pilih 1-3");
	    			op = input.nextInt();

	    			switch(op) {
	    				case 1:
	    					do{
	    						write("\n");
    							writeln("Silahkan pilih metode input matriks");
    							writeln("1. Input dari layar");
    							writeln("2. Input dari file");
    							writeln("3. Kembali ke menu sebelumhya");
    							write("Pilih 1-3: ");
    							op1 = input.nextInt();

    							switch(op1) {
    								case 1:
    									break;
    								case 2:
    									break;
    								case 3:
    									break;
    								default:
    									System.out.println("Pilihan anda tidak valid");
    									break;
    							}
	    					} while(op1!=3);
	    					break;
	    				case 2:
	    					do{
	    						write("\n");
    							writeln("Silahkan pilih metode input matriks");
    							writeln("1. Input dari layar");
    							writeln("2. Input dari file");
    							writeln("3. Kembali ke menu sebelumhya");
    							write("Pilih 1-3: ");
    							op1 = input.nextInt();

    							switch(op1) {
    								case 1:
    									tab.readMatrixP(tab.getTab());
    									if(tab.determinan(tab.getTab()) == 0)
    										writeln("Determinan matriks bernilai nol sehingga tidak ada invers untuk matriks.");
    									else
    										tab.inversPrint(tab.getTab());
    									break;
    								case 2:
    									tab.filereadMatrixP(tab.getTab());
    									if(tab.determinan(tab.getTab()) == 0)
    										writeln("Determinan matriks bernilai nol sehingga tidak ada invers untuk matriks.");
    									else
    										tab.inversPrint(tab.getTab());
    									break;
    								case 3:
    									break;
    								default:
    									System.out.println("Pilihan anda tidak valid");
    									break;
    							}
	    					} while(op1!=3);
	    					break;
	    			}
	    		} while(op!=3);

	    	} else if(in==4) {
	    		for(int i=0; i<120;i++) {
    				write("_");
   				}
    			do{
    				write("\n");
    				writeln("Silahkan pilih metode input matriks");
    				writeln("1. Input dari layar");
    				writeln("2. Input dari file");
    				writeln("3. Kembali ke menu sebelumhya");
    				write("Pilih 1-3: ");
    				op1 = input.nextInt();

    				switch(op1) {
    					case 1:
    						tab.readMatrixP(tab.getTab());
    						tab.kofaktorPrint(tab.getTab());
    						break;
    					case 2:
    						tab.filereadMatrixP(tab.getTab());
    						tab.kofaktorPrint(tab.getTab());
    						break;
    					case 3:
    						break;
    					default:
    						writeln("Pilihan anda tidak valid");
    						break;
    				}
    			} while(op1!=3);

	    	} else if(in==5) {
	    		for(int i=0; i<120;i++) {
    				write("_");
   				}
    			do{
    				write("\n");
    				writeln("Silahkan pilih metode input matriks");
    				writeln("1. Input dari layar");
    				writeln("2. Input dari file");
    				writeln("3. Kembali ke menu sebelumhya");
    				write("Pilih 1-3: ");
    				op1 = input.nextInt();

    				switch(op1) {
    					case 1:
    						tab.readMatrixP(tab.getTab());
    						tab.adjoinPrint(tab.getTab());
    						break;
    					case 2:
    						tab.filereadMatrixP(tab.getTab());
    						tab.adjoinPrint(tab.getTab());
    						break;
    					case 3:
    						break;
    					default:
    						writeln("Pilihan anda tidak valid");
    						break;
    				}
    			} while(op1!=3);
	    	} else if(in==6) {
	    		do {
    					for(int i=0; i<120;i++) {
    						write("_");
    					}
    					writeln("");
   						writeln("Silahkan pilih metode input");
   						writeln("1. Input dari layar");
   						writeln("2. Input dari file");
   						writeln("3. Kembali");
       					write("Pilih 1-3: ");
    					op = input.nextInt();
    					Interpolation intrp = new Interpolation();
    					switch(op) {
    						case 1:
    							intrp.readIntrp();
    							intrp.interpolatePoints();
    							intrp.printIntrp();
    							break;
    						case 2:
    							intrp.filereadIntrp();
    							intrp.interpolatePoints();
    							intrp.printIntrp();
    							break;
    						case 3:
    							break;
    						default:
    							writeln("Tidak valid. Silahkan diulang.");
    							break;
    					}
    				} while(op!= 3);
	    	} else if(in==7) {
	    		for(int i=0; i<120;i++) {
    						write("_");
    			}
    			write("\n");
	    		writeln("Terima kasih telah menggunakan program ini, sampai jumpa!");
	    	} else {
	    		for(int i=0; i<120;i++) {
    						write("_");
    			}
    			write("\n");
	    		writeln("Mohon maaf, input anda belum tersedia di dalam menu. Silahkan coba lagi!");
	    	}
   		} while(in!=7);
   	}

   	private static void write(String s) {
   		System.out.print(s);
   	}

   	private static void writeln(String s) {
   		System.out.println(s);
   	}
}