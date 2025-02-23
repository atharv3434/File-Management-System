import java.util.Scanner;

public class Main4 {
    private static FileOperations fileOperations = new FileOperations();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🗂️ Welcome to File Management System 🗂️");

        while (true) {
            System.out.println("\n1. Create File\n2. Write to File\n3. Read File\n4. Rename File\n5. Delete File\n6. Search for File\n7. Encrypt File\n8. Decrypt File\n9. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    fileOperations.createFile();
                    break;
                case 2:
                    fileOperations.writeFile();
                    break;
                case 3:
                    fileOperations.readFile();
                    break;
                case 4:
                    fileOperations.renameFile();
                    break;
                case 5:
                    fileOperations.deleteFile();
                    break;
                case 6:
                    fileOperations.searchFile();
                    break;
                case 7:
                    fileOperations.encryptFile();
                    break;
                case 8:
                    fileOperations.decryptFile();
                    break;
                case 9:
                    System.out.println("Exiting... Thank you! 📂");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
