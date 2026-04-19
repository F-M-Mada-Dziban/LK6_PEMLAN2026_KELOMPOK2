import java.util.Scanner;

public class MenuSiswa {
    static Scanner input = new Scanner(System.in);

    public static void menu() {
        System.out.println("\n=== DATA SISWA ===");
        System.out.println("1. Tambah");
        System.out.println("2. Lihat");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {
            case 1 -> tambah();
            case 2 -> FileUtil.tampilData("siswa.txt");
        }
    }

    static void tambah() {
        System.out.print("NIS    : ");
        String nis = input.nextLine();
        System.out.print("Nama   : ");
        String nama = input.nextLine();
        System.out.print("Alamat : ");
        String alamat = input.nextLine();

        FileUtil.tambahData("siswa.txt", nis + "|" + nama + "|" + alamat);
    }
}