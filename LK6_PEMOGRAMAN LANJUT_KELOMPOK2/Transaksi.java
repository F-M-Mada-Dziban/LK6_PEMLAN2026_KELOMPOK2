import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Transaksi {
    static Scanner input = new Scanner(System.in);

    public static void menu() {
        System.out.println("\n=== TRANSAKSI ===");
        System.out.println("1. Pinjam");
        System.out.println("2. Kembalikan");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();
        input.nextLine();

        if (pilih == 1) pinjam();
        else kembali();
    }

    static void pinjam() {
        System.out.print("Kode Transaksi : ");
        String kode = input.nextLine();
        System.out.print("NIS            : ");
        String nis = input.nextLine();
        System.out.print("Kode Buku      : ");
        String buku = input.nextLine();

        String data = kode + "|" + nis + "|" + buku + "|2026-04-20|-|0";
        FileUtil.tambahData("transaksi.txt", data);
    }

    static void kembali() {
        try {
            System.out.print("Masukkan Kode Transaksi: ");
            String kode = input.nextLine();

            File inputFile = new File("transaksi.txt");
            File tempFile = new File("temp.txt");

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data[0].equals(kode)) {
                    data[4] = "2026-04-20"; // tanggal kembali
                    data[5] = "1";          // status dikembalikan

                    line = String.join("|", data);
                }

                bw.write(line);
                bw.newLine();
            }

            br.close();
            bw.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            System.out.println("Buku berhasil dikembalikan!");

        } catch (Exception e) {
            System.out.println("Error saat pengembalian!");
        }
    }
}