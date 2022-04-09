/**
 * <h1>Class Square3x3</h1>
 * <strong>The Square3x3 class represents a 2D 3x3 array that contains integers</strong>
 * @version 1
 * @since 07/2021
 * @author <em>Omer Munk</em>
 */

public class Square3x3
{
    // Class attributes.
    private int[][] _square;

    // Final variables with default values for easier use and readability.
    private final int ROWS = 3;
    private final int COLUMNS = 3;
    private final int DEFAULT_CELL_VALUE = -1;
    private final int ALL_THERE_ARRAY_SIZE = 9;
    private final int MINIMUM_3X3_1TO9_VALUE = 1;
    private final int MAXIMUM_3X3_1TO9_VALUE = 9;

    //Constructors.
    /**
     * First constructor for objects of class Square3x3. 
     * constructs and initializes a 2-dimensional array of the size 3x3, with the deafult values of -1 in each cell.
     */
    public Square3x3()
    {
        this._square = new int[ROWS][COLUMNS];
        for (int i = 0 ; i < ROWS ; i++)
            for (int j = 0 ; j < COLUMNS ; j++)
                this._square[i][j] = DEFAULT_CELL_VALUE; // Iterating the 2 dimensional array and setting it to the default value.
    }

    /**
     * Second constructor for objects of class Square3x3.
     * Constructs a 2-dimensional array of the size 3X3, whose values are taken from a given array as a parameter.
     * If the given array's size is bigger then 3X3, only the first 3X3 cells are taken.
     * If the given array, or one of its sub arrays are smaller,the rest of the cells are initialized to -1.
     * @param array A given 2-dimensional array which the consturctor uses it's values to construct a a new Square3x3 object.
     */
    public Square3x3(int[][]array)
    {
        // initializing all the cells to the default values using the first constructor.
        this._square = new Square3x3()._square;
        // Checking conditions for the cases that the length of the array or one of its columns or rows are more or less then 3.
        // Iterating by the correct conditions.
        if (array.length< ROWS)
        {
            for (int i = 0 ; i<array.length ; i++)
            {
                if (array[i].length < COLUMNS)
                {
                    for (int j = 0 ; j < array[i].length ; j++)
                    {
                        this._square[i][j] = array[i][j];
                    }
                }
                else
                {
                    for (int j = 0 ; j < COLUMNS ; j++)
                    {
                        this._square[i][j] = array[i][j];
                    } 
                }
            }
        }
        else
        {
            for (int i = 0 ; i<ROWS ; i++)
            {
                if (array[i].length < COLUMNS)
                {
                    for (int j = 0 ; j<array[i].length ; j++)
                    {
                        this._square[i][j] = array[i][j];
                    }
                }
                else
                {
                    for (int j = 0 ; j<COLUMNS ; j++)
                    {
                        this._square[i][j] = array[i][j];
                    } 
                }
            } 
        }
    }

    /**
     * Copy constructor for objects of class Square3x3.
     * Constructs a 2-dimensional array of the size 3X3, whose values are taken from the array of the given Square3x3 object.
     * @param other A given 2-dimensional array which the consturctor uses to copy it's values to construct a a new Square3x3 object.
     */
    public Square3x3(Square3x3 other)
    {
        if (other == null)
        // Using the first constructor to set default values.
            this._square = new Square3x3()._square;
        else
        // Using the second constructor, no need to write a code again, just using the former code.
            this._square = new Square3x3(other._square)._square;
    }

    /**
     * Returns the value in the (row,col) cell. If the row and/or col arew out of the array bounds, returns -1.
     * Legal values for row/col are 0,1,2.
     * @return The value in the (row,col) cell, or -1 if the row and/or col are out of the array bounds.
     */
    public int getCell(int row, int col)
    {
        if (row>= 0 && row<ROWS && col>= 0 && col<COLUMNS)
            return this._square[row][col];
        else
            return -1;
    }

    /**
     * Sets the cell (row,col) in the array to the given value. If the row and/or col are out of the array bounds - does nothing.
     * Legal values for row/col are 0,1,2.
     * @param row The row of the disered cell to set.
     * @param col The col of the disered cell to set.
     * @param value The value to set in the disired set.
     */
    public void setXY(int row, int col,int value)
    {
        if (row>= 0 && row<ROWS && col>= 0 && col<COLUMNS)
            this._square[row][col] = value;
    }

    /**
     * Returns a String representation of the array.
     * @override toString in class java.lang.Object.
     * @return A String representation of the array.
     */
    public String toString()
    {
        String string = "";
        int j;
        for (int i = 0 ; i < ROWS ; i++)
        {
            for (j = 0 ; j < COLUMNS-1 ; j++ )
            {
                string = string+ this._square[i][j]+"\t"; //Space of a tab between each value.
            }
            string = string + this._square[i][j] + "\n"; //New line after the last value of a row.
        }
        return string;
    }

    /**
     * Return true if the Square3x3 has all the values from 1 - 9 (included), otherwise false.
     * @return true if the Square3x3 has all the values from 1 - 9 (included), otherwise false.
     */
    public boolean allThere()
    {
        int [] allThereHelper = new int[ALL_THERE_ARRAY_SIZE];
        int value;
        for (int i = 0 ; i<ROWS ; i++)
        {
            for (int j = 0 ; j<COLUMNS ; j++)
            {
                value = this._square[i][j];
                // Checks if the value is between 1-9 or, if not, necessarily it means
                // that the square is not containing all the values from 1 to 9, and returns false immidiedly. or:
                // Checks if the value is valid, but repeated, which nessecerly means that the square is not containing all the values
                // from 1 to 9, and returns false immidiedly.
                if (value < MINIMUM_3X3_1TO9_VALUE || value > MAXIMUM_3X3_1TO9_VALUE || value == allThereHelper[value-1])
                    return false;
                allThereHelper[value-1] = value; //A helper array, which helps to check if a value between 1-9 has been seen already.
            }
        }
        // If the code reached here, its a sign that all the values were between 1-9 and none of the values was repeated.
        return true;
    }

    /**
     * Gets a 10 cells boolean array, and a row, and if the row has a values between 1-9, sets the matching cell to true.
     * @param row The row to check.
     * @param values A 10 cells boolean array to set the boolean values of the matching 1-9 values in the row.
     */
    public void whosThereRow (int row, boolean[]values)
    {
        if (row >= 0 && row<ROWS) //checking if the row given as a paremter is valid (0 / 1 / 2).
        {
            int value;
            for (int j = 0 ; j < COLUMNS ; j++)
            {
                value = this._square[row][j];
                // If the value is valid, setting the boolean value to true in the matching array index.
                if (value >= MINIMUM_3X3_1TO9_VALUE && value <= MAXIMUM_3X3_1TO9_VALUE)
                {
                    values[value] = true;  
                } 
                // Otherwise, does nothing.
            }
        }
    }

    /**
     * Gets a 10 cells boolean array, and a columns, and if the row has a values between 1-9, sets the matching cell to true.
     * @param col The columns to check.
     * @param values A 10 cells boolean array to set the boolean values of the matching 1-9 values in the columns.
     */
    public void whosThereCol (int col, boolean[]values)
    {
        if (col >= 0 && col<COLUMNS) //checking if the column given as a paremter is valid (0 / 1 / 2).
        {
            int value;
            for (int i = 0 ; i < ROWS ; i++)
            {
                value = this._square[i][col];
                // If the value is valid, replacing the boolean value to true in the matching array index.
                if (value >= MINIMUM_3X3_1TO9_VALUE && value <= MAXIMUM_3X3_1TO9_VALUE)
                    values[value] = true;
                // Otherwise, does nothing.
            }
        }
    }

}