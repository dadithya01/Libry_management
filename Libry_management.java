import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Libry_management {

    static final int maxBooks = 100;
    static final int maxMembers = 100;
    static int bookCount = 0;
    static int memberCount = 0;
    static int issueCount = 0;
    static Scanner scanner = new Scanner(System.in);
    static String[][] users = {{"adithya", "2006"}};
    static String[][] books = new String[maxBooks][5];
    static String[][] members = new String[maxMembers][4];
    static String[][] issueBooks = new String[0][0];

    //colours
    public static final String RESET = "\033[0m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String PURPLE_BOLD = "\033[1;35m";

    public static void main(String[] args) {
        logIn();
    }

    public static void equals() {
        System.out.println(PURPLE_BOLD + "+" + "=".repeat(80) + "+" + RESET);
    }

    public static void logIn() {
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD + "|\t\t\t\t===LOGIN===\t\t\t\t\t |" + RESET);
        equals();
        System.out.println();
        while (true) {
            System.out.print("Enter username" + GREEN_BOLD + " >> " + RESET);
            String username = scanner.next();

            if (username.equals(users[0][0])) {
                while (true) {
                    System.out.println();
                    System.out.print("Enter password" + GREEN_BOLD + " >> " + RESET);
                    String password = scanner.next();
                    if (password.equals(users[0][1])) {
                        clearConsole();
                        System.out.println(GREEN_BOLD + "Login successfully..." + RESET);
                        mainMenu();
                    } else {
                        System.out.println(RED_BOLD + "password is invalid. please try again!" + RESET);
                    }
                }
            } else {
                System.out.println(RED_BOLD + "Username is invalid. please try again!" + RESET);
                System.out.println();
            }
        }
    }

    public static void mainMenu() {
        while (true) {
            System.out.println();
            equals();
            System.out.println(BLUE_BOLD + "|\t\t\t\t===WELCOME===\t\t\t\t\t |" + RESET);
            equals();
            System.out.println();
            System.out.println(BLUE_BOLD + "\t\t[1] Manage books.\t\t\t[2] Manage members." + RESET);
            System.out.println(BLUE_BOLD + "\t\t[3] Issue books.\t\t\t[4] Return books." + RESET);
            System.out.println(BLUE_BOLD + "\t\t[5] View reports.\t\t\t[6] Exit and logout." + RESET);
            System.out.println();
            System.out.print("Enter your choice " + GREEN_BOLD + " >> " + RESET);
            int input = getValidInt();
            switch (input) {
                case 1:
                    clearConsole();
                    manageBooks();
                    break;
                case 2:
                    clearConsole();
                    manageMembers();
                    break;
                case 3:
                    clearConsole();
                    issueBooks();
                    break;
                case 4:
                    clearConsole();
                    returnBooks();
                    break;
                case 5:
                    clearConsole();
                    viewReport();
                    break;
                case 6:
                    while (true) {
                        System.out.println();
                        System.out.println(BLUE_BOLD + "\t\t[1] Logout.\t\t\t[2] Exit." + RESET);
                        System.out.println();
                        System.out.print("What do you want to do ? " + GREEN_BOLD + " >> " + RESET);
                        int yesNo = getValidInt();
                        switch (yesNo) {
                            case 1:
                                clearConsole();
                                System.out.println(GREEN_BOLD + "Login out..." + RESET);
                                logIn();
                                break;
                            case 2:
                                clearConsole();
                                System.out.println();
                                System.out.println(GREEN_BOLD + "Exiting from system..." + RESET);
                                System.out.println();
                                equals();
                                System.out.println();
                                System.exit(0);
                                break;
                            default:
                                clearConsole();
                                System.out.println(RED_BOLD + "Invalid option try again..." + RESET);
                                break;
                        }
                    }
                default:
                    clearConsole();
                    System.out.println(RED_BOLD + "Invalid option try again..." + RESET);
                    break;
            }
        }
    }

    //mainMenu
    public static void manageBooks() {
        while (true) {
            System.out.println();
            equals();
            System.out.println(BLUE_BOLD + "|\t\t\t\t===MANAGE BOOKS===\t\t\t\t |" + RESET);
            equals();
            System.out.println();
            System.out.println(BLUE_BOLD + "\t\t[1] Add book.\t\t\t\t[2] Update book." + RESET);
            System.out.println(BLUE_BOLD + "\t\t[3] Delete book.\t\t\t[4] Search book." + RESET);
            System.out.println(BLUE_BOLD + "\t\t[5] View all books.\t\t\t[6] Back to main menu." + RESET);
            System.out.println();
            System.out.print("Enter your choice " + GREEN_BOLD + " >> " + RESET);
            int input = getValidInt();
            switch (input) {
                case 1:
                    clearConsole();
                    addBook();
                    break;
                case 2:
                    clearConsole();
                    updateBook();
                    break;
                case 3:
                    clearConsole();
                    deleteBook();
                    break;
                case 4:
                    clearConsole();
                    searchBook();
                    break;
                case 5:
                    clearConsole();
                    viewAllBooks();
                    break;
                case 6:
                    clearConsole();
                    System.out.println(GREEN_BOLD + "Back to main menu..." + RESET);
                    mainMenu();
                    break;
                default:
                    clearConsole();
                    System.out.println(RED_BOLD + "Invalid option try again..." + RESET);
                    break;
            }
        }
    }

    public static void manageMembers() {
        while (true) {
            System.out.println();
            equals();
            System.out.println(BLUE_BOLD + "|\t\t\t\t===MANAGE MEMBERS===\t\t\t\t |" + RESET);
            equals();
            System.out.println();
            System.out.println(BLUE_BOLD + "\t\t[1] Add member.\t\t\t\t[2] Update member." + RESET);
            System.out.println(BLUE_BOLD + "\t\t[3] Delete member.\t\t\t[4] Search member." + RESET);
            System.out.println(BLUE_BOLD + "\t\t[5] View all members.\t\t\t[6] Back to main menu." + RESET);
            System.out.println();
            System.out.print("Enter your choice " + GREEN_BOLD + " >> " + RESET);
            int input = getValidInt();
            switch (input) {
                case 1:
                    clearConsole();
                    addMember();
                    break;
                case 2:
                    clearConsole();
                    updateMember();
                    break;
                case 3:
                    clearConsole();
                    deleteMember();
                    break;
                case 4:
                    clearConsole();
                    searchMember();
                    break;
                case 5:
                    clearConsole();
                    viewAllMembers();
                    break;
                case 6:
                    clearConsole();
                    System.out.println(GREEN_BOLD + "Back to main menu..." + RESET);
                    mainMenu();
                    break;
                default:
                    clearConsole();
                    System.out.println(RED_BOLD + "Invalid option try again..." + RESET);
                    break;
            }
        }
    }

    public static void issueBooks() {
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD + "|\t\t\t\t===ISSUE BOOKS===\t\t\t\t |" + RESET);
        equals();
        System.out.println();

        if (memberCount == 0) {
            System.out.println(RED_BOLD + "No members available to issue books..." + RESET);
            return;
        }
        System.out.print("Enter member id" + GREEN_BOLD + " >> " + RESET);
        String memberId = scanner.next();
        boolean memberFound = false;
        for (int i = 0; i < memberCount; i++) {
            if (members[i][0].equals(memberId)) {
                memberFound = true;
                break;
            }
        }
        if (!memberFound) {
            System.out.println(RED_BOLD + "Member not found try again..." + RESET);
            return;
        } else {
            System.out.print("Enter book id" + GREEN_BOLD + " >> " + RESET);
            String bookId = scanner.next();
            boolean bookFound = false;
            for (int i = 0; i < bookCount; i++) {
                if (books[i][0].equals(bookId)) {
                    bookFound = true;
                    break;
                }
            }
            if (!bookFound) {
                System.out.println(RED_BOLD + "Book not found try again..." + RESET);
                return;
            } else {
                System.out.print("Enter due date" + GREEN_BOLD + " >> " + RESET);
                String dueDate = scanner.next();

                issueCount++;

                grow(issueBooks);
                issueBooks[issueBooks.length - 1][0] = bookId;
                issueBooks[issueBooks.length - 1][1] = memberId;
                issueBooks[issueBooks.length - 1][2] = dueDate;

//                for (int i = 0; i < issueCount; i++) {
//                    System.out.println("Book id " + issueBooks[issueBooks.length - 1][0]);
//                    System.out.println("Member id " + issueBooks[issueBooks.length - 1][1]);
//                    System.out.println("Date " + issueBooks[issueBooks.length - 1][2]);
//                }
                for(int i = 0; i < bookCount;i++) {
                    int bookindex = i ;
                    books[bookindex][4] = String.valueOf(Integer.parseInt(books[bookindex][4]) - 1);
                }

                clearConsole();
                System.out.println();
                System.out.println(GREEN_BOLD+"Book issued successfully..."+RESET );
                mainMenu();
                return;
            }
        }
    }

    public static void grow(String[][] arr) {
        String[][] temp = new String[arr.length + 1][3];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        issueBooks = temp;
    }


    public static void returnBooks() {
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD + "|\t\t\t\t===RETURN BOOKS===\t\t\t\t |" + RESET);
        equals();
        System.out.println();

        System.out.print("Enter the Member ID to search"+GREEN_BOLD+" >> "+RESET);
        String searchMemberId = scanner.next();
        boolean memberFound = false;

        for (int i = 0; i < issueCount; i++) {
            if (issueBooks[i][1].equals(searchMemberId)) {
                memberFound = true;
                System.out.println();
                System.out.println(GREEN_BOLD+"Valid Member ID..."+RESET);

                System.out.print("Enter book ID"+GREEN_BOLD+" >> "+RESET);
                String bookId = scanner.next();
                boolean bookFound = false;

                for (int j = 0; j < issueCount; j++) {
                    if (issueBooks[j][0].equals(bookId) && issueBooks[j][1].equals(searchMemberId)) {
                        bookFound = true;
                        System.out.println();
                        System.out.println(GREEN_BOLD+"Valid Book ID..."+RESET);

                        System.out.print("Enter today's date (yyyy-MM-dd)"+GREEN_BOLD+" >> "+RESET);
                        String todayDateInput = scanner.next();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate todayLocalDate = LocalDate.parse(todayDateInput, formatter);

                        if (issueBooks[j].length > 3 && issueBooks[j][3] != null) {
                            LocalDate dueDate = LocalDate.parse(issueBooks[j][3], formatter);

                            if (todayLocalDate.isAfter(dueDate)) {
                                long overdueDays = ChronoUnit.DAYS.between(dueDate, todayLocalDate);
                                double fine = overdueDays * 0.50;
                                System.out.println(RED_BOLD+"The return date is overdue..."+RESET);
                                System.out.println(BLUE_BOLD+"Fine : "+RESET + fine);
                                System.out.println(BLUE_BOLD+"Overdue days : "+RESET + overdueDays);
                            } else {
                                System.out.println(GREEN_BOLD+"The return date is not overdue..."+RESET);
                            }
                        } else {
                            System.out.println(RED_BOLD+"Invalid or missing due date..."+RESET);
                        }

                        books[i][4] = String.valueOf(Integer.parseInt(books[i][4]) + 1);
                        for (int k = j; k < issueCount - 1; k++) {
                            issueBooks[k] = issueBooks[k + 1];
                        }
                        issueBooks[issueCount - 1] = new String[4];
                        issueCount--;

                        System.out.println();
                        System.out.println(GREEN_BOLD+"Book returned successfully..."+RESET);
                        return;
                    }
                }

                if (!bookFound) {
                    System.out.println();
                    System.out.println(RED_BOLD+"Invalid Book ID..."+RESET);
                }
            }
        }

        if (!memberFound) {
            System.out.println();
            System.out.println(RED_BOLD+"Member ID not found..."+RESET);
        }
        mainMenu();
    }

    public static void viewReport() {
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD + "|\t\t\t\t===VIEW REPORT===\t\t\t\t |" + RESET);
        equals();
        System.out.println();
        System.out.println(BLUE_BOLD+"\t\t[1] Overdue Book.\t\t\t[2] Book Issued to Members."+RESET);
        System.out.println(BLUE_BOLD+"\t\t[3] Back to main menu."+RESET);
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Today's date (yyyy-MM-dd)"+GREEN_BOLD+" >> "+RESET);
        String todayDate = input.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate todayLocalDate = LocalDate.parse(todayDate, formatter);

        System.out.print("Enter your choice"+GREEN_BOLD+" >> "+RESET);
        int returnChoice = input.nextInt();

        switch (returnChoice) {
            case 1:
                clearConsole();
                System.out.println();
                equals();
                System.out.println(BLUE_BOLD + "|\t\t\t\t===OVERDUE BOOK===\t\t\t\t |" + RESET);
                equals();
                System.out.println();
                System.out.println(BLUE_BOLD+"Book Id\t\tMember Id\tDue Date\tDays Overdue\tFine"+RESET);

                for (int i = 0; i < issueCount; i++) {
                    if (issueBooks[i].length > 3 && issueBooks[i][3] != null && !issueBooks[i][3].isEmpty()) {
                        LocalDate returnLocalDate = LocalDate.parse(issueBooks[i][3], formatter);
                        long numberOfDaysExpired = ChronoUnit.DAYS.between(returnLocalDate, todayLocalDate);

                        if (numberOfDaysExpired > 0) {
                            long fine = numberOfDaysExpired * 50;
                            System.out.println(issueBooks[i][0] + "\t\t" + issueBooks[i][1] + "\t\t" + issueBooks[i][3] + "\t"
                                    + numberOfDaysExpired + "\t\t" + fine);
                        }
                    }
                }
                break;

            case 2:
                clearConsole();
                System.out.println();
                equals();
                System.out.println(BLUE_BOLD + "|\t\t\t\t===BOOK ISSUED TO MEMBERS===\t\t\t |" + RESET);
                equals();
                System.out.println();
                System.out.println(BLUE_BOLD+"Member Id\tTotal Books Issued"+RESET);

                for (int i = 0; i < memberCount; i++) {
                    String memberId = members[i][0];
                    int count = 0;

                    for (int j = 0; j < issueCount; j++) {
                        if (issueBooks[j].length > 1 && issueBooks[j][1] != null && issueBooks[j][1].equals(memberId)) {
                            count++;
                        }
                    }

                    if (count > 0) {
                        System.out.println(memberId + "\t\t" + count);
                    }
                }
                break;
            case 3:
                clearConsole();
                System.out.println();
                System.out.println(GREEN_BOLD+"Back to main menu..."+RESET);
                mainMenu();
                break;

            default:
                clearConsole();
                System.out.println();
                System.out.println(RED_BOLD+"Invalid choice. Try again..."+RESET);
                mainMenu();
        }
    }

    //manageBooks
    public  static void addBook(){
            System.out.println();
            equals();
            System.out.println(BLUE_BOLD+"|\t\t\t\t===ADD BOOK===\t\t\t\t\t|"+RESET);
            equals();
            System.out.println();
            System.out.print("Book id"+GREEN_BOLD+" >> "+RESET);
            String id= scanner.next();
            boolean idExist =false;
            for (int i = 0; i < bookCount; i++) {
                if (id.equals(books[i][0])){
                    idExist=true;
                    break;
                }
            }
            if (idExist){
                clearConsole();
                System.out.print(RED_BOLD+"Id is already exist try again..."+RESET);
                System.out.println();
            }
            else {
                books[bookCount][0] = id;
                System.out.print("Book title" + GREEN_BOLD + " >> " + RESET);
                books[bookCount][1] = scanner.next();
                System.out.print("Book author" + GREEN_BOLD + " >> " + RESET);
                books[bookCount][2] = scanner.next();
                System.out.print("Book genre" + GREEN_BOLD + " >> " + RESET);
                books[bookCount][3] = scanner.next();
                System.out.print("Book quantity"+GREEN_BOLD+" >> "+RESET);
                books[bookCount][4] = scanner.next();
                System.out.println();
                System.out.println(GREEN_BOLD+"Book added successfully..."+RESET);
                bookCount++;
            }
            while (true){
                System.out.println();
                System.out.print("Do you want to add another book ? (y?n)"+GREEN_BOLD+" >> "+RESET);
                String yesNo =scanner.next();
                switch (yesNo){
                    case "y","Y":
                        addBook();
                        break;
                    case "n","N":
                        clearConsole();
                        System.out.println(GREEN_BOLD+"Back to menu..."+RESET);
                        manageBooks();
                        break;
                    default:
                        clearConsole();
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
        equals();
        System.out.println(BLUE_BOLD + "|\t\t\t\t=== DELETE BOOK ===\t\t\t\t |" + RESET);
        equals();
        System.out.println();

        if (bookCount == 0) {
            System.out.println(RED_BOLD + "No books available to delete..." + RESET);
            return;
        }
        System.out.print("Enter book ID to delete" + GREEN_BOLD + " >> " + RESET);
        String bookId = scanner.next();
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i][0].equals(bookId)) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                bookCount--;
                System.out.println(GREEN_BOLD + "Book deleted successfully..." + RESET);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(RED_BOLD + "Book not found..." + RESET);
        }
        manageBooks();
    }

    public static void searchBook(){
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD+"|\t\t\t\t===SEARCH BOOK===\t\t\t\t |"+RESET);
        equals();
        System.out.println();

        if (bookCount == 0) {
            System.out.println(RED_BOLD + "No books available to search..." + RESET);
            return;
        }
        System.out.print("Enter book id"+GREEN_BOLD+" >> "+RESET);
        String id = scanner.next();

        boolean bookFound = false;
        for (int i = 0; i < bookCount; i++) {
            if (id.equals(books[i][0])){
                System.out.printf(BLUE_BOLD+"\nBook id : "+RESET+books[i][0]+"\n"+BLUE_BOLD+"Book title : "+RESET+books[i][1]+"\n"+BLUE_BOLD+"Book author : "+RESET+ books[i][2]+"\n"+BLUE_BOLD+"Book genre : "+RESET+ books[i][3]+"\n"+BLUE_BOLD+"Book quantity : "+RESET+ books[i][4]+"\n");
                bookFound=true;
                break;
            }
        }
        if (!bookFound){
            System.out.println(RED_BOLD+"Book not found try again..."+RESET);
        }
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
            System.out.println();
            System.out.println(GREEN_BOLD+"Back to menu..."+RESET);
        }
    }

    //manageMembers
    public  static void addMember(){
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD+"|\t\t\t\t===ADD MEMBERS===\t\t\t\t|"+RESET);
        equals();
        System.out.println();
        System.out.print("Member id"+GREEN_BOLD+" >> "+RESET);
        String id= scanner.next();
        boolean idExist =false;
        for (int i = 0; i < memberCount; i++) {
            if (id.equals(members[i][0])){
                idExist=true;
                break;
            }
        }
        if (idExist){
            clearConsole();
            System.out.print(RED_BOLD+"Id is already exist try again..."+RESET);
            System.out.println();
        }
        else {
            members[memberCount][0] = id;
            System.out.print("Name" + GREEN_BOLD + " >> " + RESET);
            members[memberCount][1] = scanner.next();
            while (true){
                System.out.print("Contact number" + GREEN_BOLD + " >> " + RESET);
                String cNumber = scanner.next();
                if (cNumber.length() == 10){
                    members[memberCount][2] = cNumber;
                    break;
                }else {
                    System.out.println(RED_BOLD+"Invalid contact number try again..."+RESET);
                }
            }
            while (true){
                System.out.print("Email" + GREEN_BOLD + " >> " + RESET);
                String email = scanner.next();
                if (email.endsWith("@gmail.com") || email.endsWith("@yahoo.com")){
                    members[memberCount][3] = email;
                    System.out.println();
                    System.out.println(GREEN_BOLD+"Member added successfully..."+RESET);
                    memberCount++;
                    break;
                }else {
                    System.out.println(RED_BOLD+"Invalid email try again..."+RESET);
                }
            }
        }
        while (true){
            System.out.println();
            System.out.print("Do you want to add another member ? (y?n)"+GREEN_BOLD+" >> "+RESET);
            String yesNo =scanner.next();
            switch (yesNo){
                case "y","Y":
                    addMember();
                    break;
                case "n","N":
                    clearConsole();
                    System.out.println(GREEN_BOLD+"Back to menu..."+RESET);
                    manageMembers();
                    break;
                default:
                    clearConsole();
                    System.out.println(RED_BOLD+"Invalid option try again..."+RESET);
                    break;
            }
        }
    }

    public static void updateMember(){
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD + "|\t\t\t\t===UPDATE MEMBER===\t\t\t\t |" + RESET);
        equals();

        if (memberCount == 0) {
            System.out.println();
            System.out.println(RED_BOLD + "No members available to update..." + RESET);
            return;
        }
        System.out.println();
        System.out.print("Enter member id to update" + GREEN_BOLD + " >> " + RESET);
        String bookId = scanner.next();
        boolean memberFound =false;

        for (int i = 0; i < members.length; i++) {
            if (members[i] != null){
                if(members[i][0] != null){
                    if(members[i][0].equals(bookId)) {
                        memberFound=true;
                        System.out.println(GREEN_BOLD + "Member found..." + RESET);
                        System.out.println();

                        System.out.print("Enter new name" + GREEN_BOLD + " >> " + RESET);
                        String newName = scanner.next();
                        members[i][1] = newName;

                        System.out.print("Enter new contact number" + GREEN_BOLD + " >> " + RESET);
                        String newCNumber = scanner.next();
                        members[i][2] = newCNumber;

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
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD + "|\t\t\t\t=== DELETE MEMBER===\t\t\t\t |" + RESET);
        equals();
        System.out.println();

        if (memberCount == 0) {
            System.out.println(RED_BOLD + "No members available to delete..." + RESET);
            return;
        }
        System.out.print("Enter member ID to delete" + GREEN_BOLD + " >> " + RESET);
        String memberId = scanner.next();
        boolean idFound = false;
        for (int i = 0; i < memberCount; i++) {
            if (members[i][0].equals(memberId)) {
                for (int j = i; j < memberCount - 1; j++) {
                    members[j] = members[j + 1];
                }
                memberCount--;
                System.out.println(GREEN_BOLD + "Member deleted successfully..." + RESET);
                idFound = true;
                break;
            }
        }
        if (!idFound) {
            System.out.println(RED_BOLD + "Member not found..." + RESET);
        }
        manageMembers();
    }

    public static void searchMember(){
        System.out.println();
        equals();
        System.out.println(BLUE_BOLD+"|\t\t\t\t===SEARCH MEMBER===\t\t\t\t |"+RESET);
        equals();
        System.out.println();

        if (memberCount == 0) {
            System.out.println(RED_BOLD + "No members available to search..." + RESET);
            return;
        }
        System.out.print("Enter member id"+GREEN_BOLD+" >> "+RESET);
        String id = scanner.next();

        boolean memberFound = false;
        for (int i = 0; i < memberCount; i++) {
            if (id.equals(members[i][0])){
                System.out.printf(BLUE_BOLD+"\nMember id : "+RESET+members[i][0]+"\n"+BLUE_BOLD+"Name : "+RESET+members[i][1]+"\n"+BLUE_BOLD+"Contact number : "+RESET+ members[i][2]+"\n"+BLUE_BOLD+"Email : "+RESET+ members[i][3]+"\n");
                memberFound=true;
                break;
            }
        }
        if (!memberFound){
            System.out.println(RED_BOLD+"Member not found try again..."+RESET);
        }
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
            System.out.println();
            System.out.println(GREEN_BOLD+"Back to menu..."+RESET);
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

    //clearConsole
    public final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Linux")) {
                System.out.print("\033\143");
            } else if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (final Exception e) {
// Handle the exception
            System.err.println(e.getMessage());
        }
    }
}
