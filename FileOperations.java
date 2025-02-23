import java.io.*;
import java.util.Scanner;

public class FileOperations {
    private Scanner sc = new Scanner(System.in);

    public void createFile() {
        System.out.print("Enter file name to create: ");
        String fileName = sc.nextLine();
        File file = new File(fileName);

        try {
            if (file.createNewFile()) {
                System.out.println("✅ File Created: " + file.getName());
            } else {
                System.out.println("⚠️ File already exists.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error creating file.");
        }
    }

    public void writeFile() {
        System.out.print("Enter file name to write to: ");
        String fileName = sc.nextLine();

        try (FileWriter writer = new FileWriter(fileName, true)) {
            System.out.print("Enter text to write: ");
            String content = sc.nextLine();
            writer.write(content + "\n");
            System.out.println("✅ Content written to file.");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file.");
        }
    }

    public void readFile() {
        System.out.print("Enter file name to read: ");
        String fileName = sc.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\n📄 File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file.");
        }
    }

    public void renameFile() {
        System.out.print("Enter current file name: ");
        String oldName = sc.nextLine();
        System.out.print("Enter new file name: ");
        String newName = sc.nextLine();

        File oldFile = new File(oldName);
        File newFile = new File(newName);

        if (oldFile.renameTo(newFile)) {
            System.out.println("✅ File renamed successfully.");
        } else {
            System.out.println("❌ Error renaming file.");
        }
    }

    public void deleteFile() {
        System.out.print("Enter file name to delete: ");
        String fileName = sc.nextLine();

        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("✅ File deleted successfully.");
        } else {
            System.out.println("❌ Error deleting file.");
        }
    }

    public void searchFile() {
        System.out.print("Enter directory path to search: ");
        String directoryPath = sc.nextLine();
        System.out.print("Enter file name to search: ");
        String fileName = sc.nextLine();

        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.equalsIgnoreCase(fileName));

            if (files != null && files.length > 0) {
                System.out.println("✅ File found: " + files[0].getAbsolutePath());
            } else {
                System.out.println("❌ File not found.");
            }
        } else {
            System.out.println("❌ Invalid directory.");
        }
    }

    public void encryptFile() {
        System.out.print("Enter file name to encrypt: ");
        String fileName = sc.nextLine();

        try {
            byte[] content = EncryptionUtil.readFile(fileName);
            byte[] encryptedContent = EncryptionUtil.encrypt(content);
            EncryptionUtil.writeFile(fileName, encryptedContent);
            System.out.println("🔒 File encrypted successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error encrypting file.");
        }
    }

    public void decryptFile() {
        System.out.print("Enter file name to decrypt: ");
        String fileName = sc.nextLine();

        try {
            byte[] encryptedContent = EncryptionUtil.readFile(fileName);
            byte[] decryptedContent = EncryptionUtil.decrypt(encryptedContent);
            EncryptionUtil.writeFile(fileName, decryptedContent);
            System.out.println("🔓 File decrypted successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error decrypting file.");
        }
    }
}
