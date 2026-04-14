 package Array;

// ================ English Version =============================================
/*
 * CORE PRINCIPLES OF ARRAY MANIPULATION (The "No-Gap" Rule)
 * --------------------------------------------------------
 *
 * 1. FIXED SIZE NATURE:
 * An array has a fixed size. This means that at runtime, its capacity
 * cannot be increased or decreased.
 *
 * 2. CONTIGUOUS STORAGE (No Gaps):
 * Array elements are always stored in a contiguous manner. There should
 * be no empty slots (gaps) in the logical structure to ensure smooth
 * traversal and consistent operations.
 *
 * 3. DELETION LOGIC (Left Shift):
 * When an element is deleted from a specific index, all subsequent
 * elements must be shifted to the left. This removes the gap and keeps
 * the array compact.
 *
 * 4. INSERTION AT SPECIFIC POSITION (Right Shift):
 * Before inserting a new element, all elements from the target index
 * onwards must be shifted to the right. This creates an empty space
 * where the new element can be safely inserted without overwriting data.
 *
 * 5. THE "LAST POSITION" CONFUSION:
 * Consider: int[] arr = new int[5]; (Capacity = 5)
 * Data: arr[0]=10, arr[1]=20, arr[4]=50 (Gaps at index 2 and 3)
 *
 * Confusion: Where should the "next insertion at end" happen?
 * - Index 5? No, this is out of bounds.
 * - Index 2? This might seem like the logical end, but it depends on tracking.
 *
 * This is why we follow the "No-Gap Rule", where the logical end of the array
 * is always tracked using a "size" variable. The next insertion always happens
 * at index 'size', ensuring correctness and avoiding ambiguity.
 */

//======================= Hindi Version =============================================
/*
 * CORE PRINCIPLES OF ARRAY MANIPULATION (The "No-Gap" Rule)
 * --------------------------------------------------------
 * 1. FIXED SIZE NATURE:
 * Array ka size static hota hai, iska matlab runtime pe hum capacity ko 
 * badha (increment) nahi sakte.
 *
 * 2. CONTINUOUS STORAGE (No Gaping):
 * Array mein data hamesha continuous hona chahiye. Beech mein koi bhi 
 * khali slot (gap) nahi hona chahiye taaki traversal aur logical operations 
 * hamesha smooth rahein.
 *
 * 3. DELETION LOGIC (Left Shift):
 * Agar hum kisi index se data delete karte hain, toh uske aage wale saare 
 * elements ko 'Left Shift' karna zaroori hai. Isse gap bhar jata hai aur 
 * array compact bana rehta hai.
 *
 * 4. INSERTION AT SPECIFIC POSITION (Right Shift):
 * Naya data insert karne se pehle, target index ke aage ke saare elements ko 
 * 'Right Shift' karna chahiye. Isse ek empty space create hoti hai jahan 
 * data safely insert ho sake bina purane data ko overwrite kiye.
 *
 * 5. THE "LAST POSITION" CONFUSION:
 * Maan lo: int[] arr = new int[5]; (Capacity = 5)
 * Data: arr[0]=10, arr[1]=20, arr[4]=50 (Gap at Index 2, 3)
 * * Confusion: "Last Position" insertion kahan hogi? 
 * - Index 5? Nahi, ye out of bounds hai.
 * - Index 2? Haan, technically yahi "Logical End" hona chahiye.
 * * Isi confusion se bachne ke liye hum "No-Gap Rule" follow karte hain, 
 * taaki 'last position' hamesha wahi ho jahan 'current_size' khatam ho raha hai.
 */
//----------------------------------------------------------------------------------------

class InsertAtBeginning {

    // insert at beginning in fixed-size array
    int insertAtStart(int[] arr, int size, int newElement) {
        int capacity = arr.length;
     
         if(arr == null || arr.length == 0) {
          return size;
         } 
        if (size >= capacity) {
            return size;
        }

        // shift elements right
        for (int i = size - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }

        // insert at first position
        arr[0] = newElement;

        return size + 1;
    }

    // print only valid elements
    void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        InsertAtBeginning obj = new InsertAtBeginning();
        int capacity = 5;
        int[] arr = new int[capacity];

        // initial valid size
        int size = 3;

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        System.out.println("Before insertion:");
        obj.printArray(arr, size);

        int newElement = 100;

        size = obj.insertAtStart(arr, size, newElement);

        System.out.println("After insertion:");
        obj.printArray(arr, size);
    }
}
