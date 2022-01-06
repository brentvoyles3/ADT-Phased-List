package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.adt.Node;

/**
 * This class represents an instance of a {@code LinkedStringList}.
 * Provides functions that allow the facilitation of items on the list.
 */
public class LinkedStringList extends BaseStringList implements StringList {

    private Node head;

    /**
     * Default constructor for a {@code LinkedStringList}. Creates
     * an empty list with no items assigned.
     */
    public LinkedStringList() {
        this.head = new Node(null, null);
    } //LinkedStringList

    /**
     * Adds an item to the specified position on a list. Returns
     * true if the item was successfully added, and false otherwise.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        if (item == null) {
            throw new NullPointerException("add: item is null");
        }        else if (item.length() == 0) {
            throw new IllegalArgumentException("add: item is empty");
        } else if ((index < 0) || (index > this.size())) {
            throw new IndexOutOfBoundsException("add: index is out of range (" + index + ")");
        }

        Node addedNode = new Node(item, null);
        //if no item exist in list. head -> first item.
        if (this.head.getItem() == null) {
            this.head = addedNode;
        }
        //if there is curr node at beginning of list
        if ((head.getItem() != null) && (index == 0)) {
            addedNode.setNext(this.head);
            this.head = addedNode;
            this.size++;
            //break from method
            return true;
        }
        Node currNode = head;
        Node prevNode = null;
        //if item added is > index 0
        for (int i = 0; i < index; i++) {
            prevNode = currNode;
            currNode = currNode.getNext();
            //if no item exists at index
            if (currNode == null) {
                break;
            }
        }
        //insert item, shift current item over
        addedNode.setNext(currNode);
        prevNode.setNext(addedNode);
        this.size++;
        return true;
    } //add

    /**
     * Removes all items from the list. Sets the list to empty.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        do {
            //head now points to no items
            head.setItem(null);
            head.setNext(null);
        } while (head.hasNext());
        this.size = 0;
    } //clear

    /**
     * Returns the item located at the specified position of the list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("get: index is out of range (" + index + ")");
        }
        Node getNode = head;
        for (int i = 0; i < index; i++) {
            getNode = getNode.getNext();
        }
        return getNode.getItem();
    } //get

    /**
     * Removes the item from the specified position of the list. Returns
     * the item that was successfully removed.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("remove: index is out of range (" + index +
                                                ")");
        }
        //If first item in the list...
        if (index == 0) {
            String removedItem;
            removedItem = head.getItem();
            head.setItem(null);
            head = head.getNext();
            this.size--;
            return removedItem;
        }
        Node prevNode = null;
        Node currNode = head;
        //find node to remove
        for (int i = 0; i < index; i++) {
            prevNode = currNode;
            currNode = currNode.getNext();
        }
        Node removeNode = currNode;
        prevNode.setNext(currNode.getNext());
        this.size--;
        return removeNode.getItem();
    } //remove

/**
 * Returns a new string list containing only the items from the list
 * located between the specified positions.
 *
 * <p>
 * {@inheritDoc}
 */
    @Override
    public StringList slice(int start, int stop) {
        if (start < 0 || stop > this.size() || start > stop) {
            throw new IndexOutOfBoundsException("slice: index is out of range");
        }
        StringList slicedList = new LinkedStringList();
        Node firstNode = head;
        //Get to starting node...
        if (start == stop) {
            return slicedList;
        }
        for (int i = 0; i < start; i++) {
            firstNode = firstNode.getNext();
        }
        //add first item to list
        slicedList.append(firstNode.getItem());
        //add remaining items before stop to list
        for (int j = start + 1; j < stop; j++) {
            firstNode = firstNode.getNext();
            slicedList.append(firstNode.getItem());
        }
        return slicedList;
    } //slice

} //LinkedStringList
