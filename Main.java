import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int in;
		do {
			int op;
			for(int i=0; i<40;i++) {
    			write("_");
   			}
   			write("\n");
			writeln("MENU");
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
	    		for(int i=0; i<40;i++) {
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
	    	} else if(in==2) {
	    		for(int i=0; i<40;i++) {
    				write("_");
   				}
   				write("\n");
	    		writeln("Silahkan pilih metode pencarian determinan:");
    			writeln("1. Operasi Baris Elementer");
    			writeln("2. Ekspansi kofaktor");
   				writeln("3. Kembali ke menu sebelumnya");
  				write("Pilih 1-3: ");
    			op = input.nextInt();

	    	} else if(in==3) {

	    	} else if(in==4) {

	    	} else if(in==5) {

	    	} else if(in==6) {
	    		do {
    					for(int i=0; i<40;i++) {
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

	    	} else {

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