/**
 * Creates an object representing a cloth containing its purchase date,
 * price, and category (type of clothing). This class implements 
 * Comparable interface for its type and provides a method to 
 * compare an object with another of the same class.
 *
 * @author Victor Hernandez Jr
 * @version November 11, 2022
 */
public class Clothes implements Comparable<Clothes>
{
    /** Purchase date of clothing item */
    public String purchaseDate;
    private double price;
    private Category category;

    /**
     * Enumeration for Clothes object; category of cloth
     */
    public enum Category
    {
        COAT,
        DENIM,
        PANTS,
        SHIRT,
        SWEATER,
        SHOE
    }

    /**
     * Constructor for objects of class Clothes
     */
    public Clothes(String pDate, double price, Category category)
    {
        purchaseDate = pDate;
        this.price = price;
        this.category = category;
    }

    /**
     * Compares purchase date to that of another specified cloth
     * 
     * @param cloth2 element to compare to
     * @return integer value representing whether cloth is greater than,
     * less than, or equal to specified cloth.
     */
    public int compareTo(Clothes cloth2)
    {
        int firstDate = Integer.parseInt(purchaseDate);
        int secondDate = Integer.parseInt(cloth2.purchaseDate);
        int firstYear = firstDate % 10000;
        int secondYear = secondDate % 10000;
        int firstDay = (firstDate % 1000000) / 10000;
        int secondDay = (secondDate % 1000000) / 10000;
        int firstMonth = firstDate / 1000000;
        int secondMonth = secondDate / 1000000;
        if (firstDate != secondDate)
        {
            if (firstYear != secondYear){
                return firstYear - secondYear;
            } else if (firstMonth != secondMonth){
                return firstMonth - secondMonth;
            } else {
                return firstDay - secondDay;
            }
        }
        return 0;
    }

    /**
     * Verifies if cloth is considered pricey or not
     * 
     * @return whether cloth meets the threshold for price based on
     * its category of clothing
     */
    public boolean isPricey()
    {
        if (category == Category.COAT && price >= 500d) {return true;}
        if (category == Category.DENIM && price >= 125d){return true;}
        if (category == Category.PANTS && price >= 200d){return true;}
        if (category == Category.SHIRT && price >= 100d){return true;}
        if (category == Category.SWEATER && price >= 150){return true;}
        if (category == Category.SHOE && price >= 200d){return true;}
        return false;
    }

    /**
     * Returns string representation of object
     * 
     * @return representation of object
     */
    public String toString(){
        String string, type, value;
        if (category == Category.COAT) {type = "Coat";}
        else if (category == Category.DENIM){type = "Denim";}
        else if (category == Category.PANTS){type = "Pants";}
        else if (category == Category.SHIRT){type = "Shirt";}
        else if (category == Category.SWEATER){type = "Sweater";}
        else {type = "Shoe";}
        value = "" + Math.round(price * 100d) / 100d;
        string = type + "|$" + value + "|" + purchaseDate;
        return string;
    }
}
