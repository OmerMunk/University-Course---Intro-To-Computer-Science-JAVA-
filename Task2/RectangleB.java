/**
 * <h1>Class RectangleB</h1></br>
 * <strong>The RectangleB class represents a 2D axis aligned integral rectangles.</strong></br>
 * @version 1
 * @since 06/2021
 * @author <em>Omer Munk</em>
 */
public class RectangleB
{
    // Declerations.
    // Class attributes.
    private Point _pointSW;
    private Point _pointNE;

    // Setting default values.
    private final Point DEFAULT_SW_POINT = new Point(0,0);
    private final Point DEAFAULT_NE_POINT = new Point(1,1);
    private final int DEFAULT_WIDTH = 1;
    private final int DEFAULT_HEIGHT = 1;

    //constructors
    /**
     * First constructor for objects of class RectangleB.<br/>Constructs a new rectangle with the specified width, height and it's south west corner to (0,0)
     * @param width The rectangle width 
     * @param height The rectangle height 
     */
    public RectangleB (int width, int height)
    {
        this._pointSW = new Point (DEFAULT_SW_POINT);
        this._pointNE = new Point(DEAFAULT_NE_POINT);
        if (width > 0) // Validates that the widtdh is a positive value.
            this._pointNE.setX(width);
        if (height > 0) // Validates that the height is a positive value.
            this._pointNE.setY(height);
    }

    /**
     * Second constructor for objects of class RectangleB.<br/>Constructs a new rectangle with the specified vertices.
     * @param p South western vertex.
     * @param width The rectangle width.
     * @param height The rectangle height.
     * @see also Class 'Point'
     */
    public RectangleB (Point p, int width, int height)
    {
        this._pointSW = new Point(p);
        this._pointNE = new Point(this._pointSW.getX()+DEFAULT_WIDTH, this._pointSW.getY()+DEFAULT_HEIGHT);
        if (width > 0) // Validates that the widtdh is a positive value.
            this._pointNE.setX(this._pointSW.getX()+width);
        if (height > 0) // Validates that the height is a positive value.
            this._pointNE.setY(this._pointSW.getY()+height);
    }

    /**
     * Third constructor for objects of class RectangleB.<br/>Constructs a new rectangle with the specified vertices.
     * @param sw South western vertex
     * @param ne North eastern vertex
     * @see also Class 'Point'
     */
    public RectangleB(Point sw, Point ne)
    {
        this._pointSW = new Point(sw);
        this._pointNE = new Point(ne);

    }

    /**
     * Copy constructor for objects of class RectangleB.<br/>Constructs a rectangle using another rectangle.
     * @param r The rectangle from which to construct the new object.
     */
    public RectangleB (RectangleB r)
    {
        this._pointSW = new Point(r._pointSW);
        this._pointNE = new Point(r._pointNE);
    }

    // Methods
    /**
     * Returns the width of the rectangle.
     * @return The width of the rectangle.
     */
    public int getWidth()
    {
        return this._pointNE.getX()-this._pointSW.getX();
    }

    /**
     * Returns the height of the rectangle.
     * @return The height of the rectangle.
     */
    public int getHeight()
    {
        return this._pointNE.getY()-this._pointSW.getY();
    }

    /**
     * Returns the South-West point of the rectangle.
     * @return A copy of the s-w point of the rectangle.
     */
    public Point getPointSW()
    {
        return new Point(this._pointSW);
    }

    /**
     * Sets the width of the rectangle.
     * @param width The width of the rectangle to set to.
     */
    public void setWidth(int width) 
    {
        if (width>0) // Validates that the widtdh is a positive value.
            this._pointNE.setX(this._pointSW.getX()+width);
    }

    /**
     * Sets the height of the rectangle
     * @param height the height of the rectangle to set to
     */
    public void setHeight(int height)
    {
        if (height>0) // Validates that the height is a positive value.
            this._pointNE.setY(this._pointSW.getY()+height);
    }

    /**
     * Sets the South-West of the rectangle.
     * @param p The SW point of the rectangle to set to.
     */
    public void setPointSW(Point p)
    {
        int width = this.getWidth();
        int height = this.getHeight();
        this._pointSW = new Point(p);
        this._pointNE.setX(this._pointSW.getX()+ width);
        this._pointNE.setY(this._pointSW.getY()+ height);
    }

    /**
     * Returns a string representation of the rectangle.
     * @override toString in class java.lang.Object.
     * @return A string represent the rectangle, for example: Width = 4, Height = 6, PointSW = (1,2).
     */
    public String toString()
    {
        return "Width="+this.getWidth()+" Height="+this.getHeight()+" PointSW="+ this._pointSW.toString();
    }

    /**
     * Calculetes the perimeter of the rectangle.
     * @return The perimeter of the rectangle.
     */
    public int getPerimeter()
    {
        return this.getWidth()*2+this.getHeight()*2; // Geometric formula for calculating rectangle perimeter.
    }

    /**
     * Calculetes the area of the rectangle
     * @return The area of the rectangle.
     */
    public int getArea()
    {
        return this.getWidth()*getHeight(); // Geometric formula for calculating rectangle area.
    }

    /**
     * Returns true if the given rectangle is equal to this rectangle.
     * @param other the rectangle to check equality with.
     * @return true if other and this rectangle are equal.
     * @see also Class Point.equals
     */
    public boolean equals (RectangleB other)
    {
        //Two rectangles are equal if and only if they have the same SW point and the same NE point.
        if (other._pointSW.equals(this._pointSW) && other._pointNE.equals(this._pointNE))
            return true;
        else
            return false;
    }

    /**
     * Returns the length of rectangle diagonal.
     * @return the length of the diagonal of the Rectangle.
     * @see also Class Point.distance.
     */
    public double getDiagonalLength()
    {
        return this._pointSW.distance(this._pointNE); // Using the distance method from the class 'Point'
    }

    /**
     * Returns true if the crueent recrangle is larger then the parameter rectangle.
     * @param other Another Rectangle to compare with.
     * @return True if the current Rectangle's area is larger then the other rectangle which recieved as parameeter, false - otherwise.
     */
    public boolean isLarger (RectangleB other)
    {
        if (this.getArea() > other.getArea())
            return true;
        else
            return false;
    }

    /**
     * Returns the North-East point of the rectangle.
     * @return a copy of the North-East point of the rectangle.
     * @see also class Point.
     */
    public Point getPointNE()
    {
        return new Point(this._pointNE); // Using the copy constructor of class 'Point'.
    }

    /**
     * Changes the width to height and vice versa.
     */
    public void changeSides()
    {
        int tempWidth = this.getWidth();
        this.setWidth(this.getHeight());
        this.setHeight(tempWidth);
    }

    /**
     * Returns true if the current rectangle is in the parameter retangle.
     * @param r Another Rectangle to check with.
     * @return True if the current Retangle's completly in the other Rectangle which recieved as parameter, false - otherwise.
     */
    public boolean isIn(RectangleB r)
    {
        // Checking if the borders of the rectangle are inside the other rectangle.
        if(!(this._pointSW.isRight(r._pointSW)) && !(this._pointSW.isUnder(r._pointSW)) &&
        !(this._pointNE.isRight(r._pointNE)) && !(this._pointNE.isAbove(r._pointNE)))
            return true;
        else
            return false;
    }

    /**
     * Returns true if the current rectangle overlaps with the parameter rectangle.
     * @param r another Rectangle to check with.
     * @return if the current Rectangle's overlaps with the other Rectangle which recieved as parameter even by a single point, false - otherwise.
     */
    public boolean overlap(RectangleB r)
    {
        // If the north east point of the rectangle is both left and under the other rectangle's south west point,
        // or if the south west point of the rectangle is both right and above the other rectangle's north east point, then
        // they arent overlapping.
        if (this.getPointNE().isUnder(r._pointSW) && this.getPointNE().isLeft(r._pointSW) || 
        this._pointSW.isAbove(r.getPointNE()) && this._pointSW.isRight(r.getPointNE()))
            return false;
        else
            return true;
    }

    /**
     * Move the retangle by deltaX in x direction and deltaY in y direction.
     * @param deltaX translate the retangle deltaX in the x position.
     * @param deltaY translate the retangle deltaY in the y position.
     * @see also Class 'Point'.
     */
    public void move (int deltaX, int deltaY)
    {
        // Using the move method from class 'Point'.
        this._pointSW.move(deltaX, deltaY);
        this._pointNE.move(deltaX, deltaY);
    }
}// End of class RectangleB.