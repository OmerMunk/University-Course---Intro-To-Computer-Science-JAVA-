/**
 * <h1><strong>RectList Class</strong></h1>
 * <strong>This class represent a linked list of rectangles</strong>
 * @author <em>Omer Munk</em>
 * @since 07/2021
 * @version 1
 */
public class RectList {

    // Class attributes
    private RectNode _head;

    // Class constructors
    /**
     * A constructor of the RectList class. Creates a new list, with it's head pointing to null.
     */
    public RectList() {
        this._head = null;
    }

    // Class methods
    /**
     * This method adds a new node to the end of the list, contains the rectangle given as a parameter.
     * <br/><strong>Space Complexity: </strong>This method uses no new variables at all, so the space complexity is O(1)
     * <br/><strong>Time Complexity: </strong>In the worst case, the length of the list is n, and it is needed to add a new rectangle in the end. So the
     * <br/>Time Complexity of this method is O(n), it is needed to iterate the whole list in a linear way.
     * @param r A RectangleA object to set as the rectangle value of the new node added.
     * @see also RectNode class
     */
    public void addRect(RectangleA r) {
        // If the list is empty, the head should point to the new RectNode.
        if (this._head == null) {
            this._head = new RectNode(r);
        } 
        else{
            // If the list is not empty, iterating it until the end, in order to append to it a new RectNode that contains the RectangleA that was given as a parameter.
            // If, at some point, a certain RectNode contain a rectangle that equals to the rectangle that was given as a parameter, the method stops, because the list should not contatin
            // two RectNodes with the same RectanbleA.
            RectNode current = this._head;
            while (current != null) {
                if (current.getRect().equals(r))
                    return;
                current = current.getNext();
            }
            current.setNext(new RectNode(r));
        }
    }

    /**
     * This method gets a Point object as a parameter and counts how many SW points of the list's rectangles are equal to that Point object.
     * <br/><strong>Space Complexity: </strong>There is two variables declared in this method, which is a constant amount. So the Space Complexity
     * <br/> of this method is O(1)
     * <br/><strong>Time Complexity: </strong>It is needed to iterate the whole list in a linear way in order to check all the rectangles.
     * <br/>So the Time Complexity of this method is O(n)
     * @param p A Point object to compare with the list's rectangle SW points.
     * @return The amount of SW points of the list's rectangles that equals to the point that was given as a parameter, or 0 if there are no such.
     * @see also RectNode class
     */
    public int howManyWithPoint(Point p) {
        int count = 0; // Counting the results.
        RectNode current = this._head;
        while (current != null) {
            if (current.getRect().getPointSW().equals(p)) // Found one
                count++; 
            current = current.getNext();
        }
        return count;
    }

    /**
     * This method returns the length of the longest diagonal among the list's rectangles.
     * <br/><strong>Space Complexity: </strong>There is 3 variables declared in this method, which is a constant amount. So the Space Complexity
     * <br/> of this method is O(1).
     * <br/><strong>Time Complexity: </strong>It is needed to iterate the whole list in a linear way in order to check all the rectangles. 
     * <br/>So the Time Complexity of this method is O(n).
     * @return The length of the longest diagonal among the list's rectangles.
     * @see also RectNode class, RectangleA class
     */
    public double longestDiagonal() {
        double maximumLength = 0; // Initial value, which will be returned if the list is empty.
        RectNode current = this._head;
        double potencialLonger;
        while (current != null) {
            potencialLonger = current.getRect().getDiagonalLength(); // Using getDiagonalLength method from the RectangleA class.
            if (potencialLonger > maximumLength) // Found new longest diagonal.
                maximumLength = potencialLonger;
            current = current.getNext();
        }
        return maximumLength;
    }

    /**
     * This method returns a copy of the SW Point of the rectangle that has the leftmost SW point among the list's rectanglest.
     * <br/><strong>Space Complexity: </strong>There is 3 variables declared in this method, which is a constant amount. So the Space Complexity
     * <br/> of this method is O(1).
     * <br/><strong>Time Complexity: </strong>It is needed to iterate the whole list in a linear way in order to check all the rectangles.
     * <br/>So the Time Complexity of this method is O(n).
     * @return A copy of the SW Point of the rectangle that has the leftmost SW point among the list's rectanglest.
     * @see also RectNode class, RectangleA class, Point class
     */
    public Point mostLeftRect() {
        if (this._head == null)
            return null;
        RectNode current = this._head;
        Point mostLeft = current.getRect().getPointSW(); // Using getPointSW method from the RectangleA class.
        Point potencialMostLeft;
        current = current.getNext();
        while (current != null) {
            potencialMostLeft = current.getRect().getPointSW();
            // Using isLeft from the Point class
            if (potencialMostLeft.isLeft(mostLeft)) // Found new most left.
                mostLeft = potencialMostLeft;
            current = current.getNext();
        }
        return new Point(mostLeft);
    }

    /**
     * This method returns a copy of the NE point of the rectangle that has the highest NE point among the list's rectangles.
     * <br/><strong>Space Complexity: </strong>There is 3 variables declared in this method, which is a constant amount. So the Space Complexity
     * <br/> of this method is O(1).
     * <br/><strong>Time Complexity: </strong>It is needed to iterate the whole list in a linear way in order to check all the rectangles.
     * <br/>So the Time Complexity of this method is O(n).
     * @return A copy of the NE point of the rectangle that has the highest NE point among the list's rectangles.
     * @see also RectNode class, RectangleA class, Point class
     */
    public Point highestRect() {
        if (this._head == null)
            return null;
        RectNode current = this._head;
        Point highest = current.getRect().getPointNE(); // Using getPointNE method from the RectangleA class.
        Point potencialHighest;
        current = current.getNext();
        while (current != null) {
            potencialHighest = current.getRect().getPointNE();
            // Using isAbove from the Point class
            if (potencialHighest.isAbove(highest)) // Found new highest.
                highest = potencialHighest;
            current = current.getNext();
        }
        return new Point(highest);
    }

    /**
     * This method returns the minimum sized RectangleA object that contains all the rectangles in the list.
     * <br/><strong>Space Complexity: </strong>There is 11 variables declared in begeining of this method, and in the worse case, 
     * <br/>if the length of the list is n, there will be n more variables (points) that will be declared.
     * <br/>So the Space Complexity of this method is O(n).
     * <br/><strong>Time Complexity: </strong>It is needed to iterate the whole list in a linear way in order to check all the rectangles.
     * <br/>So the Time Complexity of this method is O(n).
     * @return The minimum sized RectangleA object that contains all the rectangles in the list.
     * @see also RectNode class, RectangleA class, Point class
     */
    public RectangleA minimalContainer() {
        if (this._head == null)
            return null;
        RectangleA container = new RectangleA(this._head.getRect()); // Initializing the container to contain the first Rectangle in the list.
        RectNode current = this._head;
        current = current.getNext();
        // Decalring variables for the function logic
        int mostLeftX;
        int mostRightX;
        int mostTopY;
        int mostBottomY;
        int potencialLeftX;
        int potenciaRightX;
        int potencialTopY;
        int potencialBottomY;
        int addDifference;
        while (current != null) {
            if (current.getRect().isIn(container)){
                current = current.getNext();
                continue; // If the container already contains the current rectangle, no changes need to be made, continue to the next.
            }
            //setting the 4 corners of the container, and the next rectangle, to variables.
            //This is necessary because the container might change, and the next rectangle might be different then the former.
            mostLeftX = container.getPointSW().getX();
            mostRightX = container.getPointNE().getX();
            mostTopY = container.getPointNE().getY();
            mostBottomY = container.getPointSW().getY();
            potencialLeftX = current.getRect().getPointSW().getX();
            potenciaRightX = current.getRect().getPointNE().getX();
            potencialTopY = current.getRect().getPointNE().getY();
            potencialBottomY = current.getRect().getPointSW().getY();
            if (potencialLeftX < mostLeftX) { //The new rectangle to check is more left then the container.
                addDifference = mostLeftX - potencialLeftX;
                container.setWidth(container.getWidth() + addDifference);
                Point p = new Point(potencialLeftX, container.getPointSW().getY());
                container.setPointSW(p);
            }
            if (potencialBottomY < mostBottomY) { //The new rectangle to check is lower then the container.
                addDifference = mostBottomY - potencialBottomY;
                container.setHeight(container.getHeight()+addDifference);
                Point p = new Point(container.getPointSW().getX(), potencialBottomY);
                container.setPointSW(p);
            }
            if (potenciaRightX > mostRightX) { // The new rectangle to check is more right then the container.
                addDifference = potenciaRightX - mostRightX;
                container.setWidth(container.getWidth()+addDifference);

            }
            if (potencialTopY > mostTopY) { // The new rectangle to check is higher then the container.
                addDifference = potencialTopY - mostTopY;
                container.setHeight(container.getHeight()+addDifference);
            }
            current = current.getNext();
        }
        return container;
    }

    /**
     * This method returns a string representing the RectList.
     * <br/><strong>Space Complexity: </strong>There is 3 variables declared in this method, which is a constant amount. So the Space Complexity
     * <br/> of this method is O(1).
     * <br/><strong>Time Complexity: </strong>It is needed to iterate the whole list in a linear way in order to check all the rectangles.
     * <br/>So the Time Complexity of this method is O(n).
     * @return A string representing the RectList.
     * @see also RectNode class
     */
    public String toString(){
        int count = 0;
        String output = "";
        RectNode current = this._head;
        while(current!= null){
            count++;
            output += ("\n" +count+". "+ current.getRect().toString()); //using the toString method of RectangleA.
            current = current.getNext();
        }
        return ("The list has "+count+" rectangles." + output);      
    }
}
