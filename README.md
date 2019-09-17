# tubesAligeo

Cara akses class Matrix:

1. Deklarasi Variabel
Matrix tab = new Matrix()

2. Berbagai fungsi untuk manipulasi matrix dengan nama tab:

tab.setSize() //mengatur ukuran matriks lewat masukan user
tab.setrow(int n) dan tab.setColumn(int n) //mengatur ukur kolom/baris sebesar n
tab.getRow() dan tab.getColumn() // akses jumlah baris/kolom dalam matriks

// OBE
tab.swapRow (int x, int y) // tukar baris ke x dengan baris ke y
tab.multiplyRow(int n, float num) // kali baris ke n dengan num, ada juga tab.divideRow
tab.addRows(int x, int y) // tambahkan dua baris x dan y. untuk kurang bisa pakai substractRows()
tab.transpose() // transpos matriks tab

// Gauss dan Jordan
tab.gaussElimination()
tab.jordanElimination
// Menghasilkan Echelon form/ REF. Masih butuh pengembangan untuk elemen 0.

// I/O
tab.readMatrix() // baca matriks tab dari masukan pengguna melalui command-line
tab.filereadMatrix() //baca matriks tab dari file berformat .txt
tab.printMatrix() //cetak matriks tab ke layar


untuk mencetak ke file masih dalam proses...
