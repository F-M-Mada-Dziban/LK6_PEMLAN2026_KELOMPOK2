import java.util.Scanner;

public class Auth {
    static Scanner input = new Scanner(System.in);

    public static boolean login() {
        input.nextLine();
        System.out.print("Masukkan NIP: ");
        String nip = input.nextLine();

        if (FileUtil.cekData("pegawai.txt", nip)) {
            System.out.println("Login berhasil!");
            return true;
        } else {
            System.out.println("Login gagal!");
            return false;
        }
    }
}