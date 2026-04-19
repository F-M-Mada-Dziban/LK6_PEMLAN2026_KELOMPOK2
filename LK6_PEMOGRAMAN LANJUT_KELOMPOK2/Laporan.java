import java.io.*;

public class Laporan {

    public static void menu() {
        System.out.println("\n=== LAPORAN BELUM KEMBALI ===");

        try (BufferedReader br = new BufferedReader(new FileReader("transaksi.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data[5].equals("0")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error membaca laporan!");
        }
    }
}