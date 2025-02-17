import day05_java_regex.junit.ListManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListManagerTest {
    private ListManager listManager;
    private List<Integer> testList;

    @BeforeEach
    void setUp(){
        // Initialize ListManager instance
        listManager = new ListManager();
        // Create an empty list for testing
        testList = new ArrayList<>();
    }

    @Test
    void testAddElement(){
        listManager.addElement(testList,10);
        assertTrue(testList.contains(10), "Element should be added to the list");
    }

    @Test
    void testRemoveELement(){ //Consider renaming this method to testRemoveElement to maintain consistent naming conventions.
        listManager.addElement(testList, 20);
        // Attempt to remove an element from the list
        boolean removed = listManager.removeElement(testList, 20);
        assertTrue(removed, "Element should be removed from the list");
        assertFalse(testList.contains(20), "List should not contain the removed element");
    }

    @Test
    void testRemovedElement_NotPresent(){
        // Attempt to remove a non-existing element
        boolean removed = listManager.removeElement(testList, 30);
        assertFalse(removed, "Removing a non-existing element should return false");
    }

    @Test
    void testGetSize(){
        listManager.addElement(testList, 5);
        listManager.addElement(testList, 15);
        assertEquals(2, listManager.getSize(testList), "List size should be updated correctly");
    }
}
