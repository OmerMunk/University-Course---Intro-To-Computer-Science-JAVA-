/**
 * <h1>Class Sudoku</h1>
 * <strong>The Sudoku class represents a Sudoku game board as a 2-dimensional 3x3 array of Square3x3 objects</strong>
 * @version 1
 * @since 07/2021
 * @author <em>Omer Munk</em>
 */
public class Sudoku
{
    // Class attribute.
    private Square3x3[][] _board;

    // Final variables with default values for easier use and readability.
    private final int ROWS = 3;
    private final int COLUMNS = 3;
    private final int BOOLEAN_ARRAY_SIZE = 10;

    /**
     * First constructor for objects of class Sudoku.
     * Constructs a new Sudoku board, represented by 2 dimnesional 3x3 array, each cell is a Square3x3 with its default values.
     */
    public Sudoku()
    {
        this._board = new Square3x3[ROWS][COLUMNS];
        for (int i = 0 ; i < ROWS ; i++)
            for (int j = 0 ; j < COLUMNS ; j++)
                this._board[i][j] = new Square3x3(); // Initializing each one of the Sudoko cells, to a default Square3x3.
    }

    /**
     * Second constructor for objects of class Sudoku.
     * Constructs a new Sudoku board, using and coping the values of the input,
     * which is a 2 dimensional 3x3 array of Square3x3 object.
     * @param square3x3Array 2 dimensional 3x3 array of Square3x3 object.
     */
    public Sudoku(Square3x3[][] square3x3Array)
    {
        this._board = new Square3x3[ROWS][COLUMNS];
        for (int i = 0 ; i < ROWS ; i++)
            for (int j = 0 ; j < COLUMNS ; j++)
                this._board[i][j] = new Square3x3(square3x3Array[i][j]); // Coping the values of the array given as a parameter.

    }

    // A private method that validate a boolean array, and return true only if all of the 1-9 values are true.
    private boolean boolArrayValidator(boolean[]values)
    {
        for (int i = 1; i < BOOLEAN_ARRAY_SIZE ; i++)
        {
            if (values[i] == false)
                return false; // Returns false immidietly if one of the array values is false. no need to continue checking.
        }
        return true;
    }

    // A private method that returns true only if all the rows of the Sudoku board is valid (containing all the values between 1-9).
    private boolean checkAllRows()
    {
        for (int k = 0 ; k < ROWS ; k++) // Iterating the inner rows of the Sudoku board cells - Square3x3 objects.
        {
            for (int i = 0 ; i < ROWS ; i++) // Iterating the rows of the sudoku board.
            {
                boolean [] rowChecker = new boolean[BOOLEAN_ARRAY_SIZE];
                for (int j = 0 ; j < COLUMNS ; j++) // Iterating the columns of the sudoku board.
                {
                    this._board[i][j].whosThereRow(k, rowChecker);
                }
                if (boolArrayValidator(rowChecker) == false) //  Will continue to interate only if the last row was valid, otherwise-
                    return false;                            //  necessarily it means that the Sudoku isn't valid.
            }
        }
        return true;
    }

    // A private method that returns true only if all the columns of the Sudoku board is valid (containing all the values between 1-9)
    private boolean checkAllColumns()
    {
        for (int k = 0 ; k < ROWS ; k++) //iterating the inner columns of the Sudoku board cells - Square3x3 objects.
        {
            boolean [] colChecker = new boolean[BOOLEAN_ARRAY_SIZE];
            for (int j = 0 ; j < COLUMNS ; j++) // Iteratin the columns of the sudoku board
            {
                for (int i = 0 ; i < ROWS ; i++) // Iterating the rows of the sudoku board
                {
                    this._board[i][j].whosThereCol(k, colChecker);
                }
                if (boolArrayValidator(colChecker) == false)  //  Will continue to interate only if the last column was valid, otherwise-
                    return false;                             //  necessarily it meatns that the Sudoku isn't valid.
            }
        }
        return true;
    }

    /// A private method that returns true only if all the values between 1-9 are found in any of the sudoku board objects (3x3 squares)
    private boolean checkAllSquares()
    {
        for (int i = 0 ; i < ROWS ; i++)
        {
            for (int j = 0 ; j < COLUMNS ; j++)
            {
                if (this._board[i][j].allThere() == false) // Iterating all the squars, and using the allThere() method of the  Square3x3 class.
                    return false;
            }
        }
        return true;
    }

    /**
     * Checks if the Sudoku object, which represent a Sudoku board, is valid according to the sudoku rules.
     * @return True if the Sudoku board is valid according to the rules of Sudoku, otherwise, returns false.
     */
    public boolean isValid()
    {
        // Using private methods to make the code more simple, organized , and readable,
        if(this.checkAllSquares() == false || checkAllColumns() == false || checkAllRows() == false)
            return false;
        return true;
    }
}