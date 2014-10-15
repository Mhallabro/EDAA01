package set;

import java.util.NoSuchElementException;

public class MaxSet<E extends Comparable<E>> extends ArraySet<E> {
    private E maxElement;

    /**
     * Constructs a new empty set.
     */
    public MaxSet() {
        super();
    }

    /**
     * Returns the currently largest element in this set. pre: the set is not
     * empty post: the set is unchanged
     *
     * @return the currently largest element in this set
     * @throws NoSuchElementException
     *             if this set is empty
     */
    public E getMax() {
        if (super.isEmpty()) {
            throw new NoSuchElementException();
        }
        return maxElement;
    }

    /**
     * Adds the specified element to this set, if it is not already present.
     * post: x is added to the set if it is not already present
     *
     * @param x
     *            the element to be added
     * @return true if the specified element was added
     */
    @Override
    public boolean add(E x) {
        if (super.add(x)) {
            if (maxElement != null) {
                if (x.compareTo(getMax()) > 0) {
                    maxElement = x;
                }
            } else {
                maxElement = x;
            }
            return true;
        }
        return false;
    }

    /**
     * Removes the specified element from this set if it is present. post: x is
     * removed if it was present
     *
     * @param x
     *            the element to remove - if present
     * @return true if the set contained the specified element
     */
    @Override
    public boolean remove(Object x) {
        if (super.remove(x)) {
            if (x.equals(maxElement)) {
                maxElement = null;
                for (E e : this)
                    if (maxElement == null || e.compareTo(maxElement) > 0)
                        maxElement = e;
            }
            return true;
        }
        return false;
    }

    /**
     * Adds all of the elements in the specified set, for which it is possible,
     * to this set. post: all elements, for which it is possible, in the
     * specified set are added to this set.
     *
     * @return true if this set changed as a result of the call
     */
    @Override
    public boolean addAll(SimpleSet<? extends E> c) {
        boolean changed = false;
        for (E e : c) {
            if (add(e)) {
                changed = true;
            }
        }
        return changed;
    }

}