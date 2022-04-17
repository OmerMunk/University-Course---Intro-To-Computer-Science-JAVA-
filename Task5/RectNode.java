/**
     * <h1><strong>Class RectNode</strong></h1>
     * <strong>This class represents a node that contains a value of a RectangleA object and a pointer to another node.</strong>
     * @author <em>Omer Munk</em>
     * @version 1
     * @since 07/2021
     */
public class RectNode {
    // Declaring class attributes.
    private RectangleA _rect;
    private RectNode _next;
    
    // Class contrurctors.
    /**
     * A constructor for the RectNode Class, that creates a new RectNode with a given rectangle as a parameter, <br>
     * and sets the next pointer to null.
     * @param r A RectangleA object to set the current rectangle value of the new created RectNode.
     */
    public RectNode(RectangleA r) {
        RectangleA r2 = new RectangleA(r); // The creation of a new RectangleA object is meant to prevent aliasing.
        this._rect = r2;
        this._next = null;
    }

    /**
     * A constructor for the RectNodeClass, that creates a new RectNode with a given rectangle as a parameter <br>
     * and sets the next pointer to a given RectNode object.
     * @param r A RectangleA object, given to set the current rectangle value of the new created RectNode.
     * @param n A RectNode object, given to set the pointer of the new created RectNode to the given object.
     */
    public RectNode(RectangleA r, RectNode n) {
        RectangleA r2 = new RectangleA(r); // The creation of a new RectangleA object is meant to prevent aliasing.
        this._rect = r2;
        this._next = n;
    }

    /**
     * A copy constructor for the RectNodeClass, that creates a new RectNode that duplicates the given RectNode
     * @param n A Rectangle object, to copy using the constructor.
     */
    public RectNode(RectNode n) {
        RectangleA r2 = new RectangleA(n.getRect()); //The creation of a new RectangleA object is meant to prevent aliasing.
        this._rect = r2;
        this._next = n.getNext();
    }

    // Class methods
    /**
     * This method returns a copy of the rectangle that the RectNode contains. The copy is to prevent aliasing.
     * @return A copy of the rectangle that the RectNode contains
     */
    public RectangleA getRect() {
        RectangleA r = new RectangleA(this._rect); // The creation of a new RectangleA object is meant to prevent aliasing.
        return r;
    }

    /**
     * This method returns the pointer to the next Node.
     * @return The pointer to the next Node.
     */
    public RectNode getNext() {
        return this._next; // Returns a pointer to a RectNode object as it is, in this case we actually want aliasing.
    }

    /**
     * This method sets the current rectangle value of the RectNode to the given RectangleA parameter
     * @param r A RectangleA ojbect to set the current RectNode reectangle to.
     */
    public void setRect(RectangleA r) {
        RectangleA r2 = new RectangleA(r); //The creation of a new RectangleA object is meant to prevent aliasing.
        this._rect = r2;
    }

    /**
     * This method sets the pointer to the next node, to the node that given as a parameter.
     * @param next A RectNode object to set the a pointer to it, from the curretn RectNode object.
     */
    public void setNext(RectNode next) {
        this._next = next;
    }
} 
