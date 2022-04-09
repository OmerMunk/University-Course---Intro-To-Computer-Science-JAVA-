/**
 * <h1>Task 4, Java course, The Open University - Israel</h1>
 * @author Omer Munk
 * @since 07/2021
 * @version 1
 */
public class Task4
{
    //Exercise 1
    /**
     * <h1>Exercise 1: Find Minimum Difference</h1>
     * <strong>This method gets an array of integers, and 2 integers and returns the minimum differnce between the two indexes that contains <br>
     * the given 2 integers. if at least one doesn't exist in the array, the method returns integer max value.</strong>
     * @param a An integer array to look for minimum difference between indexes of the given two integers.
     * @param x The first integer to look for the minimum difference between it and the second integer.
     * @param y The second integer to look for the minimum difference between it and the first integer.
     * @return The minimum distance between the two integers, or integer max value if at least one of the itegers doesn't exist in the array.<br/><br/>
     * <strong><em>Time complexity</em></strong> of this method is O(n). The array is not Sorted, so it is needed to iterate to whole array in order to determine the <br>
     * minimum difference between the two given values. If the array size is n, then the method does a constant amount of actions multiplied by n, <br>
     * which means - time complexity O(n).<br/><br/>
     * <strong><em>Space complexity</em></strong> of this method is O(1). the method initializes 7 variables, which means space complexity of O(7), which equals to O(1).
     */
    public static int findMinDiff (int[] a, int x, int y) {
        // Variable declerations
        boolean boolX = false; // A boolean flag for the first integer, which will changed to true if the first integer is in the array
        boolean boolY = false; // A boolean flag for the second integer, which will changed to true if the second integer is in the array
        int indX = 0; // A variable that represents the index of x, the first given integer
        int indY = 0; // A variable that represents the index of y, the second given integer
        int distance = Integer.MAX_VALUE ; // a variable to remember the smallest difference that was found so far, initialzed to integer max value because this is the return value if at least on of the integers hasnt been found
        int newDistance; 
        if(a==null) // If the array is null, return integer max value.
            return distance;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                indX = i;
                boolX = true; // Marks that the first value has been found.
                if (boolY) { // it is possible to calculate the distance from the first integer only if the second integer has already been found
                    newDistance = Math.abs(indX - indY); // Using abouslute value beacse the difference is a positive size
                    if (newDistance < distance) // we are looking for the minimum difference, so if we find smaller one them the former, we need to keep the new one.
                        distance = newDistance;
                }
            } else if (a[i] == y) {
                indY = i;
                boolY = true; // Marks that the second value has been found.
                if (boolX) { // it is possible to calculate the distance from the second integer only if the first integer has already been found
                    newDistance = Math.abs(indX - indY); // Using abouslute value beacse the difference is a positive size.
                    if (newDistance < distance) // we are looking for the minimum difference, so if we find smaller one them the former, we need to keep the new one
                        distance = newDistance; // assigning the new minimum distance
                }
            }
        }
        return distance;
    }

    //Exercise 2
    // A private method to calculate the log of a number according to the base of 2.
    // N is the dimension of the given matrix.
    // This method is essential because the time complexity of the method is  O(log n), and this is the number of times that the for loop wil run.
    private static int log2(int N)
    {
        // Using the Math.log() method that was learned in class.
        int result = (int)(Math.log(N) / Math.log(2)); //converting the log base from 10 to 2.
        return result;
    }

    /**
     * <h1>Exercise 2: Search In Circle Sorted Matrix</h1>
     * <strong>This methods gets a circle sorted two dimensional</strong>
     * @param mat A circle sorted matrix with a dimension of powers of 2, to search the given value in.
     * @param num The integer value to search in the given matrix.
     * @return True if the number is in the matrix, or false otherwise.
     * <br/><br/>
     * <strong><em>Time complexity</em></strong> of this method is O(LOG N), because after each time the method does the search, <br>
     * and determines in which quarter to keep looking, it divides the dimension by 2.<br>
     * Therfore, the dimension is decreasing in a binary search way, and the amount of actions in each search is constant.<br/><br/>
     * <strong><em>Space complexity</em></strong> O(1). I used constant number of variables: 7, which means O(7), that equals to space complexity of O(1)
     */
    public static boolean search(int[][] mat, int num) {
        int dimension = mat.length; // The current dimension of the matrix or sub quarter matrix we are looking in.
        int topLeftX = 0; // The row of the first cell in the matrix or sub quarter matrix we are looking in,
        int topLeftY = 0; // The column of the first cell in the matrix or sub quarter matrix we are looking in,
        int iteratesAmount = log2(dimension); // As mentioned above, the time complexity of this method is O(LOG N).
        // Therefore, this is the amount of iterates needed.
        for (int i = 0 ; i <= iteratesAmount ; i++){
            if (mat[topLeftX][topLeftY] == num) // The method's exit condition , if the current cell contains the given value to search, return true.
                return true; 

            // Check if the given value to search is in the top left sub quarter matrix.
            if (num >= mat[topLeftX][topLeftY] && num < mat[topLeftX][topLeftY+dimension/2]){ 
                // Do nothing, because the current top left value stays the same after we divide the dimension.
            }

            // Check if the given value to search is in the top right sub quarter matrix.
            else if (num >= mat[topLeftX][topLeftY+dimension/2] && num < mat[topLeftX+dimension/2][topLeftY+dimension/2]){ 
                topLeftY = topLeftY+dimension/2; // Changing the top left value index to the top right quarter.
            }

            // Check if the given value to search is in the bottom right sub quarter matrix.  
            else if (num >= mat[topLeftX+dimension/2][topLeftY+dimension/2] && num < mat[topLeftX+dimension/2][topLeftY]){ 
                topLeftX = topLeftX+dimension/2; // Changing the top left value index to the bottom right quarter.
                topLeftY = topLeftY+dimension/2;
            }

            // Check if the given value to search is in the bottom left sub quarter matrix.
            else if (num >= mat[topLeftX+dimension/2][topLeftY] && num <= mat[topLeftX+dimension-1][topLeftY]){ 
                topLeftX = topLeftX+dimension/2; // Changing the top left value index to the bottom left quarter.
            }
            dimension = dimension/2; // After we know in which sub quarter matrix the given value is in, we need to narrow the borders of the search by dividing the dimension by 2, in order to look only in the relavant sub quarter matrix.
        }
        return false; // If the script got here, it means that the value is not in the matrix.
    }

    //Exercise 3
    /**
     * <h1>Exercise 3: equal split (Recursion)</h1>
     * <strong>This method gets an array, and return true if its possible to divide the array to two equal groups,<br>
     * which equals by the amount of elements and by the sum of each group.</strong>
     * @param arr An integer array to check and perform the method on.
     * @return True if its possible to divide the given array according to the requirements, false otherwise.
     */
    public static boolean equalSplit (int []arr){
        // variable declerations
        int sum1 = 0; // A variable which will be used to accumulate the sum of the first group.
        int sum2 = 0; // A variable which will be used to accumulate the sum of the second group.
        int count1 = 0; // A variable which will be used to accumulate the number of elements in the first group.
        int count2 = 0; // A variable which will be used to accumulate the number of elements in the second group.
        int values = arr.length; // A variable which will be used to check how many values of the array are still not associated with one of the groups. 
        int i = 0; // A variable that represents the current index in the array.
        return equalSplit(arr, sum1 ,sum2, count1, count2, values, i); // Calling a recursion method.
    }

    // This method is a private method that overloads the public method equalSplit.
    // This method using back-tracking recursion in order to determine if it is possible to divide the given array into two equal groups by their sum and by their number of elements.
    private static boolean equalSplit(int [] arr, int sum1, int sum2, int count1, int count2, int values, int i){
        if(values==0){ // The recursion exit condition, which means that if the values equals to 0, there are no more values left to divide.
            return sum1 == sum2 && count1 == count2; // Returns true only if the two sums of the groups and the two amount of elemets are equal.
        }
        // The first option is to put the current value by index in the first group, and the second option is to put it in the second group.
        // Then it is needed to: accumulate the sum of the group, promote the index and lower by 1 the values left to check for the next recursion call.
        return equalSplit(arr, sum1+arr[i], sum2, count1+1, count2, values-1, i+1)||equalSplit(arr, sum1, sum2+arr[i], count1, count2+1, values-1, i+1);
    }

    //Exercise 4
    /**
     * <h1>Exercise 4: Special Numbers (Recursion)</h1>
     * <strong>This method gets an integer, and checks if it is a "Special Number" according to the rules:
     * The rules: formula is executed on all the natural numbers, at first, starting from 1, each 2 indexes is to be removed, then each 3, then each 4 and so on.
     * if a number is not removed, it means that it is a "Special Number"</strong>
     * @param n A given integer to check if it is a "Special Number".
     * @return True if the number given as a parameter is indeed a "Special Number", false otherwise.
     */
    public static boolean isSpecial(int n){
        int index = n; // The first index of the number is it's value, because no there were not any removals.
        int removeEvery = 2; // The first removal is the remove a number every 2 indexes.
        return isSpecial(index, removeEvery); // Calling a recursion method.
    }

    // This method is a private method that overloads the isSpecial public method
    private static boolean isSpecial(int index, int removeEvery){
        // If the number is 0 or negative, automatically it cant be a special number.
        // If the reminder of the nubmer's index divided by the current removal  formula is 0, it means that nubmer will be deleted, which means
        // that it is not a "Special Number".
        if(index%removeEvery == 0 || index <= 0) // Exit condition if the number is not a "Special Number"
            return false;

        // If the index of the number is smaller then the current removal formula, it means that he will not be removed,
        // which means that it is a "Special Number".
        if (index<removeEvery)  //Exit condition if the number has been found as a "Special Number"
            return true;

        // A recurssion call to check the next removal formula. The index of the number is to be changed to a smaller index,
        // because of the indexes before it that will be removed. and the removal formula needs to increase by 1, according to the rules of the removal.
        return isSpecial(index - index/removeEvery, removeEvery+1);
    }
}
