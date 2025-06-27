import java.io.*;
import java.util.*;

public class NotesApp{
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("----- NOTES -----");

        do{
             System.out.println("\nChoose an option:\n");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 : addNote(sc); break;
                case 2 : viewNotes(); break;
                case 3 : System.out.println("Exiting..."); break;
                default : System.out.println("Invalid choice. Choose again.");
            }
        }while(choice != 3);
        sc.close();
    }
    
    private static void addNote(Scanner sc){
        System.out.print("Enter your note: ");
        String note = sc.nextLine();

        try(FileWriter fw = new FileWriter(FILE_NAME, true)){
            fw.write(note + System.lineSeparator());
            System.out.println("Note added!");
        }
        catch(IOException e){
            System.out.println("Error writing the file.");
            e.printStackTrace();
        }
    }
    private static void viewNotes() {
        System.out.println("\n--- Your Notes ---\n");

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int lineNo = 1;

            while ((line = br.readLine()) != null) {
                System.out.println(lineNo++ + ". " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes found.");
        } catch (IOException e) {
            System.out.println("Error reading from file.");
            e.printStackTrace();
        }
    }
}