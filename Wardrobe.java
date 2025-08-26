import java.util.Scanner;
import java.util.Iterator;

/**
 * A linked deque that serves as a wardrobe and stores all your clothes
 * depending on its purchase date. Implements methods that update your
 * wardrobe after a new item is appended.
 *
 * @author Victor Hernandez Jr
 * @version November 11, 2022
 */
public class Wardrobe extends LinkedDeque<Clothes>
{
    /** Max possible year entered for clothing item */
    public static int currentYear = 2022;
    /** Max amount of items allowed for a category */
    public static final int MAX = 10;
    /** Scanner for user input */
    public static Scanner sc = new Scanner(System.in);
    /** Wardrobe to store clothes in */
    public static Wardrobe closet = new Wardrobe();
    private static int numCoat = 0;
    private static int numDenim = 0;
    private static int numPants = 0;
    private static int numShirt = 0;
    private static int numSweater = 0;
    private static int numShoe = 0;
    private static final int DATE_LENGTH = 8;

    public static void main(String[] args)
    {
        System.out.println("Welcome to your wardrobe!");
        displayMainMenu();
        int menuSelection = mainMenuSelection();
        while (menuSelection != 3){
            if (menuSelection == 0){
                System.out.println("Invalid selection. Please try again.");
            } else if (menuSelection == 1) {
                wardrobeSelection();
            } else if (menuSelection == 2) {
                System.out.println(closet.toString());
            }
            displayMainMenu();
            menuSelection = mainMenuSelection();
        }
        System.out.println("Goodbye! Exiting system.");
    }

    /**
     * Displays options to manage wardrobe
     */
    public static void displayMainMenu()
    {
        System.out.println("\nMAIN MENU");
        System.out.println("1.) Enter new clothing item");
        System.out.println("2.) Display wardrobe");
        System.out.println("3.) Exit the system");
    }

    /**
     * Displays categories for clothing
     */
    public static void displayCategory(){
        System.out.print("(1. COAT | 2. DENIM | 3. PANTS ");
        System.out.println("| 4. SHIRT | 5. SWEATER | 6. SHOE)");
    }

    /**
     * Seeks user input for menu selection and returns 0 indicating
     * an invalid input or an integer 1-3 which corresponding
     * to the menu options
     * 
     * @return integer indicating main menu selection
     */
    public static int mainMenuSelection() 
    {
        System.out.print("Please enter your selection: ");
        String input = sc.nextLine();
        switch (input) 
        {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                input = "0";
                break;
        }
        return Integer.parseInt(input);
    } 

    /**
     * Seeks user input for clothing item which determines whether a new
     * clothing item is added to wardrobe
     */
    public static void wardrobeSelection()
    {
        String purchaseDate;
        double price;
        Clothes.Category category;

        System.out.println("\nEnter the purchase date of clothing item (MMDDYYYY):");
        String dateInput = sc.nextLine();
        System.out.println("Enter the price of clothing item:");
        String priceInput = sc.nextLine();
        displayCategory();
        System.out.println("Enter the category of clothing item:");
        String categoryInput = sc.nextLine();
        if (verifiedDate(dateInput) && (verifiedPrice(priceInput)) && (verifiedCategory(categoryInput))){
            purchaseDate = dateInput;
            price = Math.round(Double.parseDouble(priceInput) * 100d) / 100d;
            category = clothCategory(categoryInput);
            Clothes newItem = new Clothes(purchaseDate, price, category);
            System.out.println("\n" + newItem.toString());
            if (appended(newItem, category)){System.out.println("Your item has been successfully added to your wardrobe!");}
        } else {System.out.println("One or more of your entries is invalid. Try again.");}
    }

    /**
     * Verifies whether purchase date for cloth is valid 
     * 
     * @param input date given for verification
     * @return whether entered date is valid
     */
    public static boolean verifiedDate(String input)
    {
        if (input.length() != DATE_LENGTH){return false;}
        try {
            int date = Integer.parseInt(input);
            int year = date % 10000;
            int day = (date % 1000000) / 10000;
            int month = date / 1000000;
            if (year > currentYear || year < 0){return false;}
            if (month > 12 || month < 1){return false;}
            if (day > 31 || day < 1){return false;}
            if ((year % 4 != 0) && (month == 2) && (day > 28)){return false;}
            if ((year % 4 == 0) && (month == 2) && (day > 29)){return false;}
            if ((month % 2 == 0 && month < 8) && (day > 30)){return false;}
            if ((month % 2 != 0 && month > 8) && (day > 30)){return false;}
        } catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    /** 
     * Verifies whether price for cloth is valid 
     * 
     * @param input date given for verification
     * @return whether entered price is valid
     */
    public static boolean verifiedPrice(String input)
    {
        try {
            double entry = Double.parseDouble(input);
            if (entry < 0d){return false;}
        } catch(Exception e){return false;}
        return true;
    }

    /**
     * Verifies whether selection for cloth category is valid 
     * 
     * @param input date given for verification
     * @return whether selection is valid
     */
    public static boolean verifiedCategory(String input)
    {
        try {
            int num = Integer.parseInt(input);
            if (num < 1 || num > 6){return false;}
        } catch (Exception e) {return false;}
        return true;
    }

    /** 
     * Returns enumeration for clothing type depending on input
     * 
     * @param input integer representing selection of clothing category
     * @return clothing category
     */
    public static Clothes.Category clothCategory(String input)
    {
        if (input.equals("1")){return Clothes.Category.COAT;}
        else if (input.equals("2")){return Clothes.Category.DENIM;}
        else if (input.equals("3")){return Clothes.Category.PANTS;}
        else if (input.equals("4")){return Clothes.Category.SHIRT;}
        else if (input.equals("5")){return Clothes.Category.SWEATER;}
        else {return Clothes.Category.SHOE;}
    }

    /**
     * Returns whether cloth item is donatable
     * 
     * @param currentItem item pending donatability
     * @return whether cloth item is donatable (10+ years old and not pricey)
     */
    public static boolean donatable(Clothes currentItem)
    {
        Clothes lastItem = closet.peekBack();
        int currentItemYear = Integer.parseInt(currentItem.purchaseDate) % 10000;
        int lastItemYear = Integer.parseInt(lastItem.purchaseDate) % 10000;
        return (!currentItem.isPricey() && lastItemYear - currentItemYear >= 10);
    }
    
    /**
     * Returns whether clothing item must be moved to back of wardrobe
     * 
     * @param currentItem item pending evaluation
     * @return whether clothing item is to be moved to the back of wardrobe or not
     */
    public static boolean moveToBack(Clothes currentItem)
    {
        Clothes lastItem = closet.peekBack();
        int currentItemYear = Integer.parseInt(currentItem.purchaseDate) % 10000;
        int lastItemYear = Integer.parseInt(lastItem.purchaseDate) % 10000;
        return (currentItem.isPricey() && lastItemYear - currentItemYear >= 10);
    }

    /** 
     * Determines whether argument is eligible to add to wardrobe, donated or not added. Updates
     * number of items in a category if a clothing item is added.  
     * 
     * @param item clothing item pending donation, wardrobe placement, or no action
     * @param type category of said clothing item
     * @return whether argument is appended to the wardrobe or not
     */
    public static boolean appended(Clothes item, Clothes.Category type)
    {
        if (!closet.isEmpty()){
            Clothes lastItem = closet.peekBack();
            if (item.compareTo(lastItem) < 0){
                System.out.println("Your clothing item could not be added due to its purchase date.");
                return false;
            }
            if (type == Clothes.Category.COAT && numCoat == MAX || type == Clothes.Category.DENIM && numDenim == MAX
            || type == Clothes.Category.PANTS && numPants == MAX || type == Clothes.Category.SHIRT && numShirt == MAX
            || type == Clothes.Category.SWEATER && numSweater == MAX ||type == Clothes.Category.SHOE && numShoe == MAX){
                System.out.println("You have reached the max for this category, your item was not added."); 
                return false;
            }
        }
        closet.pushBack(item);
        if (type == Clothes.Category.COAT) {numCoat++;}
        else if (type == Clothes.Category.DENIM){numDenim++;}
        else if (type == Clothes.Category.PANTS){numPants++;}
        else if (type == Clothes.Category.SHIRT){numShirt++;}
        else if (type == Clothes.Category.SWEATER){numSweater++;}
        else {numShoe++;}
        updateWardrobe();
        return true;
    }

    /**
     * Checks to see if items in wardrobe need to be donated or moved to the end
     * of the wardrobe after the addition of a new item.
     */
    public static void updateWardrobe()
    {
        Clothes lastItem = closet.peekBack();
        Iterator<Clothes> itr = closet.iterator();
        Clothes curr = itr.next();
        while (curr != lastItem)
        {
            if (donatable(curr)){closet.popFront();}
            if (moveToBack(curr)){
                curr.purchaseDate = lastItem.purchaseDate;
                closet.pushBack(curr);
                closet.popFront();
            }
            curr = itr.next();
        }
    }
}