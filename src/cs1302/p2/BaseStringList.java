package cs1302.p2;

import cs1302.adt.StringList;

/**
 * This class represents an instance of a BaseStringList Object and
 * implements {@code Stringlist}. Provides methods that aid in the
 * facilitation of adding and removing items to/from a list.
 */
public abstract class BaseStringList implements StringList {

    protected int size;

    /**
     * Default constructor for a {@code BaseStringList}. Creates
     * an empty list, that is a list with {@code size} 0.
     */
    public BaseStringList() {
        this.size = 0;
    } //BaseStringList

    /**
     * Adds an item to the end of a list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean append(String item) {
        add(size,item);
        return true;
    } //append

/**
 * Returns true if the calling list object is empty, and false otherwise.
 *
 * <p>
 * {@inheritDoc}
 */
    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }        else {
            return false;
        }
    } //isEmpty

    /**
     * Creates and returns a String containing all of the
     * objects in the list, equally separated.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String makeString(String start, String sep, String end) {
        String result = "";
        result += start;
        for (int i = 0; i < this.size(); i++) {
            result += this.get(i);
            if (i < this.size - 1) {
                result += sep;
            }
        }
        result += end;
        return result;
    } //makeString

    /**
     * Adds an item to beginning of the list. If the item
     * was successfully added, returns true. Otherwise, returns
     * false.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean prepend(String item) {
        add(0,item);
        return true;
    } //prepend

    /**
     * Returns the number of items in the list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    } //size

/**
 * Returns the each item in the list, separated by commas.
 *
 * <p>
 * {@inheritDoc}
 */
    @Override
    public String toString() {
        String result = "";
        result = this. makeString("[",", ","]");
        return result;
    } //toString

} //BaseStringList
