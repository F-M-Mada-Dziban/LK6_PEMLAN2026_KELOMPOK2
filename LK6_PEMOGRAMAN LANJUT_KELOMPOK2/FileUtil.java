import java.io.*;

public class FileUtil {

    public static void tambahData(String file, String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error menulis file!");
        }
    }

    public static void tampilData(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error membaca file!");
        }
    }

    public static boolean cekData(String file, String key) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(key)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error cek data!");
        }
        return false;
    }
}