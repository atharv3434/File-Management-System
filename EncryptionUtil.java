import java.io.*;
import java.util.Base64;

public class EncryptionUtil {
    public static byte[] encrypt(byte[] data) {
        return Base64.getEncoder().encode(data);
    }

    public static byte[] decrypt(byte[] encryptedData) {
        return Base64.getDecoder().decode(encryptedData);
    }

    public static byte[] readFile(String filePath) throws IOException {
        return new FileInputStream(filePath).readAllBytes();
    }

    public static void writeFile(String filePath, byte[] content) throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        fos.write(content);
        fos.close();
    }
}
