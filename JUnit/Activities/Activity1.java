package activity;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {
    // Test fixtures
    static ArrayList<String> list;

    // Initialize test fixtures before each test method
    @BeforeEach
    void setup() throws Exception {
    	
	    // Initialize a new ArrayList
	    list = new ArrayList<String>();
	
	    // Add values to the list
	    list.add("alpha"); // at index 0
	    list.add("beta"); // at index 1
    }

    // Test method to test the insert operation
    @Test
    public void insertTest() {
        // Assertion for size
        assertEquals(2, list.size(), "Wrong size");
        // Add new element
        list.add(2, "charlie");
        // Assert with new elements
        assertEquals(3, list.size(), "Wrong size");   
        
        // Assert individual elements
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("beta", list.get(1), "Wrong element");
        assertEquals("charlie", list.get(2), "Wrong element");
    }

    // Test method to test the replace operation
    @Test
    public void replaceTest() {
    	assertEquals(2, list.size(), "Wrong size");
        //Add new element
    	list.add(2,"mega"); //at index 2
    	//Assert new element
    	assertEquals(3, list.size(), "Wrong size");
    	// Replace new element
        list.set(1, "giga");

        // Assert individual elements
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("giga", list.get(1), "Wrong element");
        assertEquals("mega", list.get(2), "Wrong element");
    }
}
