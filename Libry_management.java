import java.util.Scanner;

public class Libry_management {

    static final int maxBooks=100;
    static final int maxMembers= 100;
    static int bookCount=0;
    static int memberCount = 0;
    public static Scanner scanner = new Scanner(System.in);
    public static String[][] users = {{"@adithya", "2006"}};
    public static String[][] books = new String[maxBooks][5];
    public static String[][] members = new String[maxMembers][4];

    //colours
    public static final String RESET = "\033[0m";// Text Reset
    public static final String RED_BOLD = "\033[1;31m";// RED
    public static final String GREEN_BOLD = "\033[1;32m";// GREEN
    public static final String BLUE_BOLD = "\033[1;34m";// BLUE
    public static final String PURPLE_BOLD = "\033[1;35m";// PURPLE

    public static void main(String[]args){
        logIn();
    }

    public static void equals(){
        System.out.println(PURPLE_BOLD+"+"+"=".repeat(80)+"+"+RESET);
    }

    public static void logIn(){
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD+"|\t\t\t\t===LOGIN===\t\t\t\t\t |"+RESET);
        equals();
        System.out.println();
        while (true){
            System.out.print("Enter username"+GREEN_BOLD+" >> "+RESET);
            String username = scanner.next();

            if (username.equals(users[0][0])){
                while (true){
                    System.out.println();
                    System.out.print("Enter password"+GREEN_BOLD+" >> "+RESET);
                    String password = scanner.next();
                    if (password.equals(users[0][1])){
                        System.out.println(GREEN_BOLD+"Login successfully..."+RESET);
                        mainMenu();
                    }else {
                        System.out.println(RED_BOLD+"password is invalid. please try again!"+RESET);
                    }
                }
            }else {
                System.out.println(RED_BOLD+"Username is invalid. please try again!"+RESET);
                System.out.println();
            }
        }
    }

    public static void mainMenu(){
        while (true){
            System.out.println();
            equals();
            System.out.println(BLUE_BOLD+"|\t\t\t\t===WELCOME===\t\t\t\t\t |"+RESET);
            equals();
            System.out.println();
            System.out.println(BLUE_BOLD+"\t\t[1] Manage books.\t\t\t[2] Manage members."+RESET);
            System.out.println(BLUE_BOLD+"\t\t[3] Issue books.\t\t\t[4] Return books."+RESET);
            System.out.println(BLUE_BOLD+"\t\t[5] View reports.\t\t\t[6] Exit and logout."+RESET);
            System.out.println();
            System.out.print("Enter your choice "+GREEN_BOLD+" >> "+RESET);
            int input = getValidInt();
            switch (input){
                case 1:
                    manageBooks();
                    break;
                case 2:
                    manageMembers();
                    break;
                case 3:
                    issueBooks();
                    break;
                case 4:
                    returnBooks();
                    break;
                case 5:
                    viewReport();
                    break;
                case 6:
                    while (true) {
                        System.out.println();
                        System.out.println(BLUE_BOLD+"\t\t[1] Logout.\t\t\t[2] Exit."+RESET);
                        System.out.println();
                        System.out.print("What do you want to do ? "+GREEN_BOLD+" >> "+RESET);
                        int yesNo=getValidInt();
                        switch (yesNo){
                            case 1:
                                System.out.println(GREEN_BOLD+"Login out..."+RESET);
                                logIn();
                                break;
                            case 2:
                                System.out.println(GREEN_BOLD+"Exiting from system..."+RESET);
                                System.out.println();
                                equals();
                                System.out.println();
                                System.exit(0);
                                break;
                            default:
                                System.out.println(RED_BOLD+"Invalid option try again..."+RESET);
                                break;
                        }
                    }
                default:
                    System.out.println(RED_BOLD+"Invalid option try again..."+RESET);
                    break;
            }
        }
    }

    //mainMenu
    public static void manageBooks(){
        while (true){
            System.out.println();
            equals();
            System.out.println(BLUE_BOLD+"|\t\t\t\t===MANAGE BOOKS===\t\t\t\t |"+RESET);
            equals();
            System.out.println();
            System.out.println(BLUE_BOLD+"\t\t[1] Add book.\t\t\t\t[2] Update book."+RESET);
            System.out.println(BLUE_BOLD+"\t\t[3] Delete book.\t\t\t[4] Search book."+RESET);
            System.out.println(BLUE_BOLD+"\t\t[5] View all books.\t\t\t[6] Back to main menu."+RESET);
            System.out.println();
            System.out.print("Enter your choice "+GREEN_BOLD+">> "+RESET);
            int input=getValidInt();
            switch (input){
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    viewAllBooks();
                    break;
                case 6:
                    System.out.println(GREEN_BOLD+"Back to main menu..."+RESET);
                    mainMenu();
                    break;
                default:
                    System.out.println(RED_BOLD+"Invalid option try again..."+RESET);
                    break;
            }
        }
    }

    public static void manageMembers(){
        while (true){
            System.out.println();
            equals();
            System.out.println(BLUE_BOLD+"|\t\t\t\t===MANAGE MEMBERS===\t\t\t\t |"+RESET);
            equals();
            System.out.println();
            System.out.println(BLUE_BOLD+"\t\t[1] Add member.\t\t\t\t[2] Update member."+RESET);
            System.out.println(BLUE_BOLD+"\t\t[3] Delete member.\t\t\t[4] Search member."+RESET);
            System.out.println(BLUE_BOLD+"\t\t[5] View all members.\t\t\t[6] Back to main menu."+RESET);
            System.out.println();
            System.out.print("Enter your choice "+GREEN_BOLD+">> "+RESET);
            int input=getValidInt();
            switch (input){
                case 1:
                    addMember();
                    break;
                case 2:
                    updateMember();
                    break;
                case 3:
                    deleteMember();
                    break;
                case 4:
                    searchMember();
                    break;
                case 5:
                    viewAllMembers();
                    break;
                case 6:
                    System.out.println(GREEN_BOLD+"Back to main menu..."+RESET);
                    mainMenu();
                    break;
                default:
                    System.out.println(RED_BOLD+"Invalid option try again..."+RESET);
                    break;
            }
        }
    }

    public static void issueBooks(){
        System.out.println("issuebooks");
    }

    public static void returnBooks(){
        System.out.println("returnbooks");
    }

    public static void viewReport(){
        System.out.println("viewreport");
    }

    //manageBooks
    public  static void addBook(){
            System.out.println();
            equals();
            System.out.println(BLUE_BOLD+"\t\t\t\t===ADD BOOK===\t\t\t\t\t |"+RESET);
            equals();
            System.out.println();
            System.out.print("Book id"+GREEN_BOLD+" >> "+RESET);
            books[bookCount][0]= scanner.next();
            System.out.print("Book title"+GREEN_BOLD+" >> "+RESET);
            books[bookCount][1]= scanner.next();
            System.out.print("Book author"+GREEN_BOLD+" >> "+RESET);
            books[bookCount][2]= scanner.next();
            System.out.print("Book genre"+GREEN_BOLD+" >> "+RESET);
            books[bookCount][3]= scanner.next();
            System.out.print("Book quantity"+GREEN_BOLD+" >> "+RESET);
            books[bookCount][4] = scanner.next();
            System.out.println(GREEN_BOLD+"Book added successfully..."+RESET);
            bookCount++;
            while (true){
                System.out.println();
                System.out.print("Do you want to add another book ? (y?n)"+GREEN_BOLD+" >> "+RESET);
                String yesNo =scanner.next();
                switch (yesNo){
                    case "y","Y":
                        addBook();
                        break;
                    case "n","N":
                        System.out.println(GREEN_BOLD+"Back to menu..."+RESET);
                        manageBooks();
                        break;
                    default:
                        System.out.println(RED_BOLD+"Invalid option try again..."+RESET);
                        break;
                }
            }
    }

    public static void updateBook() {
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD + "|\t\t\t\t=== UPDATE BOOK ===\t\t\t\t |" + RESET);
        equals();

        if (bookCount == 0) {
            System.out.println();
            System.out.println(RED_BOLD + "No books available to update..." + RESET);
            return;
        }
        System.out.println();
        System.out.print("Enter book id to update" + GREEN_BOLD + " >> " + RESET);
        String bookId = scanner.next();
        boolean bookFound =false;

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null){
                if(books[i][0] != null){
                    if(books[i][0].equals(bookId)) {
                        bookFound=true;
                        System.out.println(GREEN_BOLD + "Book found..." + RESET);
                        System.out.println();

                        System.out.print("Enter new title" + GREEN_BOLD + " >> " + RESET);
                        String newTitle = scanner.next();
                        books[i][1] = newTitle;

                        System.out.print("Enter new author" + GREEN_BOLD + " >> " + RESET);
                        String newAuthor = scanner.next();
                        books[i][2] = newAuthor;

                        System.out.print("Enter new genre" + GREEN_BOLD + " >> " + RESET);
                        String newGenre = scanner.next();
                        books[i][3] = newGenre;

                        System.out.print("Enter new quantity" + GREEN_BOLD + " >> " + RESET);
                        String newQuantity = scanner.next();
                        books[i][4] = newQuantity;

                        System.out.println(GREEN_BOLD + "Book updated successfully..." + RESET);
                        break;
                    }
                }
            }
        }
        if (!bookFound){
            System.out.println(RED_BOLD + "Book not found try again..." + RESET);
        }
        manageBooks();
    }

    public static void deleteBook() {
        System.out.println();
        System.out.println(BLUE_BOLD + "=== DELETE BOOK ===" + RESET);

        if (bookCount == 0) {
            System.out.println(RED_BOLD + "No books available to delete." + RESET);
            return;
        }

        System.out.print("Enter book ID to delete" + GREEN_BOLD + " >> " + RESET);
        String bookId = scanner.next();
        boolean bookFound = false;

        // Create a new array for updated books
        String[][] updatedBooks = new String[books.length][5];
        int updatedIndex = 0;

        // Copy books to the new array except the one to delete
        for (int i = 0; i < bookCount; i++) {
            if (books[i][0].equals(bookId)) {
                bookFound = true; // Found the book to delete
                continue; // Skip this book
            }
            updatedBooks[updatedIndex++] = books[i]; // Copy the book to updated array
        }

        if (bookFound) {
            books = updatedBooks; // Replace the original array
            bookCount--; // Decrement book count
            System.out.println(GREEN_BOLD + "Book deleted successfully!" + RESET);
        } else {
            System.out.println(RED_BOLD + "Book ID not found!" + RESET);
        }
    }


//    public static void deleteBook() {
//        System.out.println();
//        equals();
//        System.out.println(BLUE_BOLD + "|\t\t\t\t===DELETE BOOK===\t\t\t\t   |" + RESET);
//        equals();
//
//        if (bookCount == 0) {
//            System.out.println(RED_BOLD + "No books available to delete..." + RESET);
//            return;
//        }
//
//        System.out.println();
//        System.out.print("Enter book ID to delete" + GREEN_BOLD + " >> " + RESET);
//        String bookId = scanner.next();
//        boolean bookFound = false;
//
//        for (int i = 0; i < books.length; i++) {
//            if (books[i] != null){
//                if(books[i][0] != null){
//                    if(books[i][0].equals(bookId)){
//                        bookFound = true;
//
//                // Shift all subsequent entries to maintain data integrity
//                        for (int j = i; j < books.length - 1; j++) {
//                        books[j] = books[j + 1];
//                        }
//
//                // Nullify the last entry (since it was shifted up)
//                        books[books.length - 1] = null;
//                        bookCount--;
//
//                        System.out.println(GREEN_BOLD + "Book successfully deleted..." + RESET);
//                        break;
//                    }
//                }
//            }
//        }
//
//        if (!bookFound) {
//            System.out.println(RED_BOLD + "Book ID not found. Please try again." + RESET);
//        }
//
//        System.out.println(GREEN_BOLD + "Returning to manage books menu..." + RESET);
//        manageBooks();
//    }


//    public static void deleteBook(){
//        System.out.println("deletebook");
//    }

    public static void searchBook(){
        System.out.println("searchbook");
    }

    public static void viewAllBooks(){
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD+"|\t\t\t\t===VIEW ALL BOOKS===\t\t\t\t |"+RESET);
        equals();
        if (bookCount==0){
            System.out.println();
            System.out.println(RED_BOLD+"No books available..."+RESET);
        }else {
            for (int i = 0; i < bookCount; i++) {
                System.out.printf(BLUE_BOLD+"\nBook id : "+RESET+books[i][0]+"\n"+BLUE_BOLD+"Book title : "+RESET+books[i][1]+"\n"+BLUE_BOLD+"Book author : "+RESET+ books[i][2]+"\n"+BLUE_BOLD+"Book genre : "+RESET+ books[i][3]+"\n"+BLUE_BOLD+"Book quantity : "+RESET+ books[i][4]+"\n");
            }
        }
    }

    //manageMembers
    public  static void addMember(){
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD+"\t\t\t\t===ADD MEMBER===\t\t\t\t |"+RESET);
        equals();
        System.out.println();
        System.out.print("Member id"+GREEN_BOLD+" >> "+RESET);
        members[memberCount][0]= scanner.next();
        System.out.print("Name"+GREEN_BOLD+" >> "+RESET);
        members[memberCount][1]= scanner.next();
        System.out.print("Contact number"+GREEN_BOLD+" >> "+RESET);
        members[memberCount][2]= scanner.next();
        System.out.print("Email"+GREEN_BOLD+" >> "+RESET);
        members[memberCount][3]= scanner.next();
        System.out.println(GREEN_BOLD+"Member added successfully..."+RESET);
        memberCount++;
        while (true){
            System.out.println();
            System.out.print("Do you want to add another member ? (y?n)"+GREEN_BOLD+" >> "+RESET);
            String yesNo =scanner.next();
            switch (yesNo){
                case "y","Y":
                    addMember();
                    break;
                case "n","N":
                    System.out.println(GREEN_BOLD+"Back to menu..."+RESET);
                    manageMembers();
                    break;
                default:
                    System.out.println(RED_BOLD+"Invalid option try again..."+RESET);
                    break;
            }
        }
    }

    public static void updateMember(){
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD + "|\t\t\t\t=== UPDATE MEMBER ===\t\t\t\t |" + RESET);
        equals();

        if (memberCount == 0) {
            System.out.println();
            System.out.println(RED_BOLD + "No members available to update..." + RESET);
            return;
        }
        System.out.println();
        System.out.print("Enter member id to update" + GREEN_BOLD + " >> " + RESET);
        String memberId = scanner.next();
        boolean memberFound =false;

        for (int i = 0; i < members.length; i++) {
            if (members[i] != null){
                if(members[i][0] != null){
                    if(members[i][0].equals(memberId)) {
                        memberFound=true;
                        System.out.println(GREEN_BOLD + "Member found..." + RESET);
                        System.out.println();

                        System.out.print("Enter new name" + GREEN_BOLD + " >> " + RESET);
                        String newName = scanner.next();
                        members[i][1] = newName;

                        System.out.print("Enter new contact number" + GREEN_BOLD + " >> " + RESET);
                        String newContact = scanner.next();
                        members[i][2] = newContact;

                        System.out.print("Enter new email" + GREEN_BOLD + " >> " + RESET);
                        String newEmail = scanner.next();
                        members[i][3] = newEmail;

                        System.out.println(GREEN_BOLD + "Member updated successfully..." + RESET);
                        break;
                    }
                }
            }
        }
        if (!memberFound){
            System.out.println(RED_BOLD + "Member not found try again..." + RESET);
        }
        manageMembers();
    }

    public static void deleteMember(){
        System.out.println("deletebook");
    }

    public static void searchMember(){
        System.out.println("searchbook");
    }

    public static void viewAllMembers(){
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD+"|\t\t\t\t===VIEW ALL MEMBERS===\t\t\t\t |"+RESET);
        equals();
        if (memberCount==0){
            System.out.println();
            System.out.println(RED_BOLD+"No members available..."+RESET);
        }else {
            for (int i = 0; i < memberCount; i++) {
                System.out.printf(BLUE_BOLD+"\nMember id : "+RESET+members[i][0]+"\n"+BLUE_BOLD+"Name : "+RESET+members[i][1]+"\n"+BLUE_BOLD+"Contact number : "+RESET+ members[i][2]+"\n"+BLUE_BOLD+"Email : "+RESET+ members[i][3]+"\n");
            }
        }
    }

    //getValidInteger
    public static int getValidInt() {
        while (!scanner.hasNextInt()) {
            System.out.println();
            System.out.print(RED_BOLD+"Invalid input. Please enter a number"+GREEN_BOLD+" >> "+RESET);
            scanner.next();
        }
        return scanner.nextInt();
    }
}
