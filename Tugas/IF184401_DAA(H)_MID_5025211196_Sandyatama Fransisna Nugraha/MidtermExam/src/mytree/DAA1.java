package mytree;

public class DAA1 extends MyTree {

    // Binary Search Tree (BST)
    // 1. isBST() [20 points]
    public static boolean isBST(MyTree t) {
    	// Write your codes in here
    	return isBST(t, Integer.MIN_VALUE, Integer.MAX_VALUE);
        // Write your codes in here
    }

    // Helper function for isBST
    // Get a boolean value to know whether 't' is BST (Binary Search Tree)
    // whose values are within the range between lowerBound and upperBound
    private static boolean isBST(MyTree t, int lowerBound, int upperBound) {
    	// Write your codes in here
    	if (t == null) {
            return true;
        }
        int value = t.getValue();
        if (value < lowerBound || value > upperBound) {
            return false;
        }
        return isBST(t.getLeft(), lowerBound, value - 1) && isBST(t.getRight(), value + 1, upperBound);
        // Write your codes in here    }

    }
    
    // 2. printDescending() [10 points]
    public static void printDescending(MyTree t) {
    	// Write your codes in here
    	if (t.getEmpty() == false) {
    	  printDescending(t.getRight());
    	  System.out.print(t.getValue() + " ");
    	  printDescending(t.getLeft());
    	
    	}
        
        // Write your codes in here
    }

    // 3. max() [10 points]   
    /**
     * You have to:
     * - handle empty trees
     * - never look at left
     * - never compares values, i.e., the value of t and the right,
     *   because it's not necessary if it's BST.
     * - returns the right value as soon as found
     *
     * @param t is the tree being searched for the max value
     * @return the max value of tree t
     */
    public static int max(MyTree t) {
    	// Write your codes in here
    	 if (t.getEmpty()) {
             return Integer.MIN_VALUE;
         }
    	 int maxLeft = max(t.getLeft());
         int maxRight = max(t.getRight());
         return Math.max(t.getValue(), Math.max(maxLeft, maxRight));
    	
        // Write your codes in here
    }

}