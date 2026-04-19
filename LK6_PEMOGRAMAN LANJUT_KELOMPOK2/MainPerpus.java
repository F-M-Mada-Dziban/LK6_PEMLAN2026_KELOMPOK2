import java.util.Scanner;

public class MainPerpus {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        if (!Auth.login()) return;

        int pilih;
        do {
            tampilMenu();
            pilih = input.nextInt();

            switch (pilih) {
                case 1 -> MenuSiswa.menu();
                case 2 -> MenuBuku.menu();
                case 3 -> Transaksi.menu();
                case 4 -> Laporan.menu();
                case 0 -> System.out.println("Terima kasih!");
                default -> System.out.println("Pilihan tidak valid!");
            }

        } while (pilih != 0);
    }

    static void tampilMenu() {
        System.out.println("\n=== SISTEM PERPUSTAKAAN ===");
        System.out.println("1. Data Siswa");
        System.out.println("2. Data Buku");
        System.out.println("3. Transaksi");
        System.out.println("4. Laporan");
        System.out.println("0. Keluar");
        System.out.print("Pilih: ");
    }
}