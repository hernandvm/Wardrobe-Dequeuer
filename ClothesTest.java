

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ClothTest.
 *
 * @author  Victor Hernandez Jr
 * @version November 11, 2022
 */
public class ClothesTest
{
    /**
     * Default constructor for test class ClothTest
     */
    public ClothesTest()
    {
    }

    /**
     * Tests to see if older dates are successfully compared to 
     * more recent dates, or if dates are equal, or if date is
     * more recent than date compared to; also checks for exception thrown
     * if date entered is not as integer MMDDYYYY.
     */
    @Test
    public void compareToTest1(){
        Clothes item1 = new Clothes("01012000", 800d, Clothes.Category.COAT);
        Clothes item2 = new Clothes("12142003", 700d, Clothes.Category.PANTS);
        Clothes item3 = new Clothes("01292000", 600d, Clothes.Category.SHOE);
        Clothes item4 = new Clothes("1203abcd", 200d, Clothes.Category.SHIRT);
        Clothes item5 = new Clothes("01012000", 500d, Clothes.Category.DENIM);
        assertTrue(item1.compareTo(item2) == -3);
        assertTrue(item1.compareTo(item3) == -28);
        assertTrue(item1.compareTo(item5) == 0);
        assertTrue(item2.compareTo(item1) == 3);
        assertTrue(item2.compareTo(item3) == 3);
        assertTrue(item3.compareTo(item1) == 28);
        assertTrue(item3.compareTo(item2) == -3);
        boolean exceptionThrown = false;
        try {
            assertTrue(item1.compareTo(item4) == 0);
        } catch (NumberFormatException e) {exceptionThrown = true;}
        assertTrue(exceptionThrown);
    }
    
    /**
     * Test compareTo method to return the proper value of comparing
     * dates by year, month, or day.
     */
    @Test
    public void compareToTest2(){
        Clothes item1 = new Clothes("01012001", 800d, Clothes.Category.COAT);
        Clothes item2 = new Clothes("05012001", 700d, Clothes.Category.PANTS);
        Clothes item3 = new Clothes("05142001", 600d, Clothes.Category.SHOE);
        Clothes item4 = new Clothes("06252005", 600d, Clothes.Category.SHOE);
        assertTrue(item1.compareTo(item2) == -4);
        assertEquals(-4, item1.compareTo(item3));
        assertTrue(item1.compareTo(item4) == -4);
        assertTrue(item2.compareTo(item3) == -13);
        assertTrue(item2.compareTo(item4) == -4);
        assertTrue(item2.compareTo(item1) == 4);
        assertTrue(item3.compareTo(item4) == -4);
        assertTrue(item3.compareTo(item1) == 4);
        assertTrue(item3.compareTo(item2) == 13);
        assertTrue(item4.compareTo(item1) == 4);
        assertTrue(item4.compareTo(item2) == 4);
        assertTrue(item4.compareTo(item3) == 4);
    }
    
    /**
     * Tests that clothes are successfully considered pricey if they
     * meet the treshold for their certain category.
     */
    @Test
    public void isPriceyTest1(){
        Clothes item1 = new Clothes("blank", 600d, Clothes.Category.COAT);
        assertTrue(item1.isPricey());
        Clothes item2 = new Clothes("blank", 499.99, Clothes.Category.COAT);
        assertFalse(item2.isPricey());
        Clothes item3 = new Clothes("blank", 135d, Clothes.Category.DENIM);
        assertTrue(item3.isPricey());
        Clothes item4 = new Clothes("blank", 50d, Clothes.Category.DENIM);
        assertFalse(item4.isPricey());
        Clothes item5 = new Clothes("blank", 201d, Clothes.Category.PANTS);
        assertTrue(item5.isPricey());
        Clothes item6 = new Clothes("blank", 20d, Clothes.Category.PANTS);
        assertFalse(item6.isPricey());
        Clothes item7 = new Clothes("blank", 120d, Clothes.Category.SHIRT);
        assertTrue(item7.isPricey());
        Clothes item8 = new Clothes("blank", 99.99, Clothes.Category.SHIRT);
        assertFalse(item8.isPricey());
        Clothes item9 = new Clothes("blank", 500d, Clothes.Category.SWEATER);
        assertTrue(item9.isPricey());
        Clothes item10 = new Clothes("blank", 100d, Clothes.Category.SWEATER);
        assertFalse(item10.isPricey());
        Clothes item11 = new Clothes("blank", 201d, Clothes.Category.SHOE);
        assertTrue(item11.isPricey());
        Clothes item12 = new Clothes("blank", 199.999, Clothes.Category.SHOE);
        assertFalse(item12.isPricey());
    }
    
    /**
     * Tests to see that toString returns the expected string for a
     * clothing item.
     */
    @Test
    public void toStringTest1(){
         Clothes newItem = new Clothes("blank", 800d, Clothes.Category.COAT);
         Clothes newItem2 = new Clothes("", 200.2558, Clothes.Category.SHOE);
         Clothes newItem3 = new Clothes("05142003", 100.25, Clothes.Category.SHIRT);
         assertEquals("Coat|$800.0|blank", newItem.toString());
         assertEquals("Shoe|$200.26|", newItem2.toString());
         assertEquals("Shirt|$100.25|05142003", newItem3.toString());
    }
}
