package collections.element;

/**
 * This particular element is ideal to test the structs
 * first because it has some wrong pattern implementations
 *
 * its equals method is not in respect with its compare
 * in compare only value is being comparedTo
 *
 * in equals and hashCode both value and name are taken into account
 *
 */
public class UncomparableElement {

    int value;
    String name;

    public UncomparableElement(int value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 15;
        hash = 31 * hash + value;
        hash = 31 * hash + name.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof UncomparableElement)) return false;
        UncomparableElement e = (UncomparableElement) obj;
        if (e.name.equals(this.name) && e.value == this.value) return true;
        return false;
    }

    @Override
    public String toString() {
        return "{" +
                + value + " , \""
                + name + '\"' +
                '}';
    }
}
