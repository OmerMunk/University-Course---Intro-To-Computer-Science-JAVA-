/**
 * <h1>Class RectangleA</h1></br>
 * <strong>The RectangleA class represents a 2D axis aligned integral rectangles. Width and height are integers only.</strong></br>
 * @version 1
 * @since 06/2021
 * @author <em>Omer Munk</em>
 */
public class RectangleA
{
    // Declerations.
    // Class attributes.
    private int _width;
    private int _height;
    private Point _pointSW; //South west point of the retangle.

    // Declaring and setting default values.
    private final Point DEFAULT_SW_POINT = new Point (0,0);
    private final int DEFAULT_WIDTH = 1;
    private final int DEFAULT_HEIGHT = 1;

    // Constructors
    /**
     * First constructor for objects of class RectangleA.<br/> Constructs a new rectangle with the specified width, height and it's south west corner to be(0,0).
     * @param width The rectangle width
     * @param height The rectangle height
     */
    public RectangleA (int width, int height)
    {
        if (width > 0) // Validates that the widtdh is a positive value.
            this._width = width;
        else
            this._width = DEFAULT_WIDTH;
        if (height > 0) // Validates that the height is a positive value.
            this._height = height;
        else
            this._height = DEFAULT_HEIGHT;
        this._pointSW = DEFAULT_SW_POINT;
    }

    /**
     * Second constructor for objects of class RectangleA.</br>Construct a new rectangle with the specified width, height and south west vertex.
     * @param sw The south western vertex.
     * @param width The rectangle width.
     * @param height The rectangle height.
     * @see also Point
     */
    public RectangleA (Point p, int width, int height)
    {
        this._pointSW = new Point(p);
        this._width = DEFAULT_WIDTH;
        if (width > 0) // Validates that the width is a positive value.
            this._width = width;
        this._height = DEFAULT_HEIGHT;   
        if (height > 0) // Validates that the height is a positive value.
            this._height = height;
    }

    /**
     * Third constructor for objects of class RectangleA.<br/> Construct a new rectangle with the specified south west vertex and north east vertex
     * @param sw South western vertex.
     * @param ne North eastern vertex.
     * @see also Point
     */
    public RectangleA (Point sw, Point ne)
    {
        this._pointSW = new Point(sw);
        this._width = ne.getX() - sw.getX();
        this._height = ne.getY() - sw.getY();
    }

    /**
     * Copy constructor for objects of class RectangleA.<br/>Constructs a rectangle using another rectangle.
     * @param r The rectangle from which to construct the new object.
     */
    public RectangleA (RectangleA r)
    {
        this._pointSW = new Point(r._pointSW);
        this._width =r._width;
        this._height =r._height;
    }

    // Methods
    /**
     * Returns the width of the rectangle.
     * @return The width of the rectangle.
     */
    public int getWidth()
    {
        return this._width;
    }

    /**
     * Returns the height of the rectangle.
     * @return The height of the rectangle.
     */
    public int getHeight()
    {
        return this._height;
    }

    /**
     * Returns the South-West point of the rectangle.
     * @return A copy of the sw point of the rectangle.
     */
    public Point getPointSW()
    {
        return new Point(this._pointSW); // Using the copy constructor of the class 'Point'
    }

    /**
     * Sets the width of the rectangle.
     * @param width The width of the rectangle to set to.
     */
    public void setWidth(int width)
    {
        if (width>0) // Validates that the width is a positive value.
            this._width = width;
    }

    /**
     * Sets the height of the rectangle
     * @param height The height of the rectangle to set to.
     */
    public void setHeight(int height)
    {
        if (height>0) // Validates that the height is a positive value.
            this._height = height;
    }

    /**
     * Sets the South-West of the rectangle.
     * @param p The SW point of the rectangle to set to.
     */
    public void setPointSW(Point p)
    {
        this._pointSW = new Point (p);
    }

    /**
     * Returns A string representation of the rectangle.
     * @override toString in class java.lang.Object.
     * @return A string represent the rectangle, for example: Width = 4, Height = 6, PointSW = (1,2).
     */
    public String toString()
    {
        return "Width="+this._width+" Height="+this._height+" PointSW="+ this._pointSW.toString();
    }

    /**
     * Calculetes the perimeter of the rectangle.
     * @return The perimeter of the rectangle.
     */
    public int getPerimeter()
    {
        return this._height*2+this._width*2; // Geometric formula for calculating rectangle perimeter.
    }

    /**
     * Calculetes the area of the rectangle.
     * @return The area of the rectangle.
     */
    public int getArea()
    {
        return this._height*this._width; // Geometric formula for calculating rectangle Area.
    }

    /**
     * Returns true if the given rectangle is equal to this rectangle.
     * @param other The rectangle to check equality with.
     * @return True if other and this rectangle are equal.
     */
    public boolean equals (RectangleA other)
    {
        //Two rectangles are equal if and only if they have the same SW point and the same NE point.
        if (other._width == this._width && other._height == this._height && other._pointSW.equals(this._pointSW))
            return true;
        else
            return false;
    }

    /**
     * Returns the length of rectangle diagonal.
     * @return The length of the diagonal of the Rectangle.
     * @see also Point.distance
     */
    public double getDiagonalLength()
    {
        return this._pointSW.distance(this.getPointNE()); // Using the distance method from the class 'Point'
    }

    /**
     * Returns true if the crueent recrangle is larger then the parameter rectangle.
     * @param other Another Rectangle to compare with.
     * @return True if the current Rectangle's area is larger then the other rectangle which recieved as parameeter, false - otherwise.
     */
    public boolean isLarger (RectangleA other)
    {
        if (this.getArea() > other.getArea())
            return true;
        else
            return false;
    }

    /**
     * Returns the North-East point of the rectangle.
     * @return A copy of the North-East point of the rectangle.
     */
    public Point getPointNE()
    {
        Point ne = new Point (this._pointSW.getX()+this._width, this._pointSW.getY()+this._height); // Using the copy constructor of class 'Point'.
        return ne;
    }

    /**
     * Changes the width to height and vice versa.
     */
    public void changeSides()
    {
        int tempWidth = this._width;
        this._width = this._height;
        this._height = tempWidth;
    }

    /**
     * Returns true if the current rectangle is in the rectangle given as a parameter.
     * @param r Another Rectangle to check with.
     * @return True if the current Retangle is completely in the other Rectangle which recieved as parameter, false - otherwise.
     */
    public boolean isIn(RectangleA r)
    {
        // Checking if the borders of the rectangle are inside the other rectangle.
        if(!(this._pointSW.isRight(r.getPointSW())) && !(this._pointSW.isUnder(r._pointSW)) &&
        !(this.getPointNE().isRight(r.getPointNE())) && !(this.getPointNE().isAbove(r.getPointNE())))
            return true;
        else
            return false;
    }

    /**
     * Returns true if the current rectangle overlaps with the parameter rectangleץ
     * @param r Another Rectangle to check with.
     * @return If the current Rectangle overlaps with the other Rectangle which recieved as parameter, even by a single point, false - otherwise.
     */
    public boolean overlap(RectangleA r)
    {
        // If the north east point of the rectangle is both left and under the other rectangle's south west point,
        // or if the south west point of the rectangle is both right and above the other rectangle's north east point, then
        // they arent overlapping.
        if (this.getPointNE().isUnder(r._pointSW) || this.getPointNE().isLeft(r._pointSW) || 
        this._pointSW.isAbove(r.getPointNE()) || this._pointSW.isRight(r.getPointNE()))
            return false;
        else
            return true;
    }

    /**
     * Moves the retangle by deltaX in the x axis and deltaY in the y axis.
     * @param deltaX Translate the retangle deltaX in the x position.
     * @param deltaY Translate the retangle deltaY in the y position.
     */
    public void move (int deltaX, int deltaY)
    {
        this._pointSW.setX(this._pointSW.getX() + deltaX);
        this._pointSW.setY(this._pointSW.getY() + deltaY);
    }
}//End of class 'Rectangle A'
