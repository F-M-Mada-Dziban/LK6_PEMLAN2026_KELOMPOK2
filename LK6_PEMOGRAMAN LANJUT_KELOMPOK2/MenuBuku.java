import java.util.Scanner;

public class MenuBuku {
    static Scanner input = new Scanner(System.in);

    public static void menu() {
        System.out.println("\n=== DATA BUKU ===");
        System.out.println("1. Tambah");
        System.out.println("2. Lihat");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {
            case 1 -> tambah();
            case 2 -> FileUtil.tampilData("buku.txt");
        }
    }

    static void tambah() {
        System.out.print("Kode  : ");
        String kode = input.nextLine();
        System.out.print("Judul : ");
        String judul = input.nextLine();
        System.out.print("Jenis : ");
        String jenis = input.nextLine();

        FileUtil.tambahData("buku.txt", kode + "|" + judul + "|" + jenis);
    }
}