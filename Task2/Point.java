/**
 * <h1>Class Point</h1><br/>
 * <strong>The class 'Point' represents a point in the plain, according to Cartesian System (integer values only). </strong><br/>
 * @version 1
 * @since 06/2021
 * @author <em>Omer Munk</em>
 */
public class Point
{
    //Declerations
    //Class attributes
    private int _x;
    private int _y;

    //Constructors
    /**
     * Constructor for objects of class Point Constructs a new point with the specified x y coordinates.
     * @param x The X coordinate.
     * @param y The Y coordinate.
     */
    public Point (int x, int y)
    {
        this._x = x;
        this._y = y;
    }

    /**
     * Copy constructor, constructs and initializes a point using another point.
     * @param other The point from which to construct the new object.
     */
    public Point (Point other)
    {
        this._x = other._x;
        this._y = other._y;
    }

    //Methods.
    /**
     * Returns the X coordinate of the point.
     * @return The X coordinate of the point.
     */
    public int getX()
    {
        return this._x;
    }

    /**
     * Returns the Y coordinate of the point.
     * @return The Y coordinate of the point.
     */
    public int getY()
    {
        return this._y;
    }

    /**
     * Sets the X coordinate of the point.
     * @param num a new value for the X coordinate
     */
    public void setX(int num)
    {
        this._x = num;
    }

    /**
     * Sets the Y coordinate of the point
     * @param num a new value for the Y coordinate.
     */
    public void setY(int num)
    {
        this._y = num;
    }

    /**
     * String representation of the Point object.
     * @override toString in class java.lang.Object.
     * @return The coordinates of a point as a string; for example : (1,2).
     */
    public String toString()
    {
        return "("+this._x+","+this._y+")";
    }

    /**
     * Checks if two points are equal.
     * @param other The point to be compared with the current point.
     * @return True if the point to be compared is equal to the current point.
     */
    public boolean equals (Point other)
    {
        // Two points are equal if and only if their coordinates are equal.
        return other._x == this._x && other._y == this._y;
    }

    /**
     * Checks if the current point is above the point it is to be compared with.
     * @param other - the point to be compared with the current point.
     * @return true if the current point is above the pointit is to be compared with.
     */
    public boolean isAbove (Point other)
    {
        if (this._y > other._y)
            return true;
        else
            return false;
    }

    /**
     * Checks if the current point is beneath the point it is to be compared with.
     * @param other The point to be compared with the current point.
     * @return True if the current point is beneath the point it is to be compared with.
     */
    // Using isAbove method, to avoid code duplication.
    public boolean isUnder (Point other)
    {
        return other.isAbove(this);
    }

    /**
     * Checks if the current point is left of the point it is to be compared with.
     * @param other The point to be compared with the current point.
     * @return True if the current point is left of the point it is to be compared with.
     */
    public boolean isLeft (Point other)
    {
        if (this._x < other._x)
            return true;
        else
            return false;
    }

    /**
     * Checks if the current point is right of the point it is to be compared with.
     * @param other The point to be compared with the current point.
     * @return True if the current point is right of the point it is to be compared with.
     */
    // Using isLeft method, to avoid code duplication.
    public boolean isRight (Point other)
    {
        return other.isLeft(this);
    }

    /**
     * Moves the current point, at coordinates (x,y), to new coordinates.
     * @param deltaX The distance to move the current point along the X axis.
     * @param deltaY The distance to move the current point along the Y axis.
     */
    public void move (int deltaX, int deltaY)
    {
        this.setX(this._x + deltaX);
        this.setY(this._y + deltaY);
    }

    /**
     * Calculates the distance between two points
     * @param p The second point whose distance from the current point is to be calculated
     * @return The distance between the current point and the point passed as a parameter.
     */
    public double distance (Point p)
    {
        // Using a geometric formula of distance between to points in a Cartesian system.
        // Based on Pythagorean theorem.
        double xDistPowerd = Math.pow(this._x - p._x,2); // The distance between the X's, to the power of 2.
        double yDistPowerd = Math.pow(this._y - p._y,2); // The distance between the Y's, to the power of 2.
        return Math.sqrt(xDistPowerd+yDistPowerd); // The square root of the two distances sum.
    }
} // End of the class 'Point'
