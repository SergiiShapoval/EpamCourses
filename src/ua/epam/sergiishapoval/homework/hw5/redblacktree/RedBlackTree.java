package ua.epam.sergiishapoval.homework.hw5.redblacktree;

/**
 * Created by Сергей on 04.11.2014.
 *
 *
 Important points:
 check root in insert-delete
 rotateLeft == make N = N.R.L
 replace == check if root, change parents
 insert: 1`) No parent N = black;
 2) check parent Black - nothing
 3) check Uncle red - recolor G, P, U and check grand
 4) uncle black N == make two RED in front of U prepare for 5
 5) uncle black N => P rot to G - recolor P & G
 delete:
 Hibbard delete - change key-value and continue delete Max
 if red - nothing
 1)if root - nothing
 2)check if S == red - rotate(P,S);
 3)if All black - S = red;
 4)if P = red, other black - P = black, S = red;
 5)if Mirror Sl and N == P.l rotate Sl to S;
 6)else (Mirror Sr == red and N == P.l) rotate S to P, Sr = black;

 */

public class RedBlackTree
{

    final static boolean RED = true;
    final static boolean BLACK = false;

    /**
     * storage class description
     * */
    
    class Entry
    {
        public Integer key;
        public Integer value;
        public Entry left;
        public Entry right;
        public Entry parent;
        public boolean color;

        public Entry(Integer key, Integer value, boolean entryColor, Entry left, Entry right) {
            this.key = key;
            this.value = value;
            this.color = entryColor;
            this.left = left;
            this.right = right;
            if (left != null) left.parent = this;
            if (right != null) right.parent = this;
            this.parent = null;
        }
        
        public Entry grandparent() {
            return parent.parent;
        }

        public Entry sibling() {
            if (this == parent.left)
                return parent.right;
            else
                return parent.left;
        }

        public Entry uncle() {
            return parent.sibling();
        }
    }
    
    public Entry root;

    public RedBlackTree() {
        root = null;
    }

    private static boolean entryColor(Entry entry) {
        return entry == null ? BLACK : entry.color;
    }
    
    private Entry lookupEntry(Integer key) {
        Entry n = root;
        while (n != null) {
            int compResult = key.compareTo(n.key);
            if (compResult == 0) {
                return n;
            } else if (compResult < 0) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return n;
    }

    public Integer lookup(Integer key) {
        Entry n = lookupEntry(key);
        return n == null ? null : n.value;
    }

    private void rotateLeft(Entry entry) {
        Entry rightChild = entry.right;
        replaceEntry(entry, rightChild);
        entry.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = entry;
        }
        rightChild.left = entry;
        entry.parent = rightChild;
    }

    private void rotateRight(Entry entry) {
        Entry leftChild = entry.left;
        replaceEntry(entry, leftChild);
        entry.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = entry;
        }
        leftChild.right = entry;
        entry.parent = leftChild;
    }


//    change parent links
    private void replaceEntry(Entry oldEntry,Entry newEntry) {
        if (oldEntry.parent == null) {
            root = newEntry;
        } else {
            if (oldEntry == oldEntry.parent.left)
                oldEntry.parent.left = newEntry;
            else
                oldEntry.parent.right = newEntry;
        }
        if (newEntry != null) {
            newEntry.parent = oldEntry.parent;
        }
    }

//    only distinct values can be inserted
    public void insert(Integer key, Integer value) {
        Entry insertedEntry = new Entry(key, value, RED, null, null);
        if (root == null) {
            root = insertedEntry;
        } else {
            Entry entry = root;
            while (true) {
                int comparison = key.compareTo(entry.key);
                if (comparison == 0) {
                    entry.value = value;
                    return;
                } else if (comparison < 0) {
                    if (entry.left == null) {
                        entry.left = insertedEntry;
                        break;
                    } else {
                        entry = entry.left;
                    }
                } else {
                    if (entry.right == null) {
                        entry.right = insertedEntry;
                        break;
                    } else {
                        entry = entry.right;
                    }
                }
            }
            insertedEntry.parent = entry;
        }
        insertCase1(insertedEntry);
    }
//1`) No parent N = black;
    private void insertCase1(Entry entry) {
        if (entry.parent == null)
            entry.color = BLACK;
        else
            insertCase2(entry);
    }
// 2) check parent Black - nothing
    private void insertCase2(Entry entry) {
        if (entryColor(entry.parent) == BLACK)
            return;
        else
            insertCase3(entry);
    }
//3) check Uncle red - recolor G, P, U and check grand
    void insertCase3(Entry entry) {
        if (entryColor(entry.uncle()) == RED) {
            entry.parent.color = BLACK;
            entry.uncle().color = BLACK;
            entry.grandparent().color = RED;
            insertCase1(entry.grandparent());
        } else {
            insertCase4(entry);
        }
    }
//4) uncle black N == make two RED in front of U prepare for 5
    void insertCase4(Entry entry) {
        if (entry == entry.parent.right && entry.parent == entry.grandparent().left) {
            rotateLeft(entry.parent);
            entry = entry.left;
        } else if (entry == entry.parent.left && entry.parent == entry.grandparent().right) {
            rotateRight(entry.parent);
            entry = entry.right;
        }
        insertCase5(entry);
    }
//5) uncle black N => P rot to G - recolor P & G
    void insertCase5(Entry entry) {
        entry.parent.color = BLACK;
        entry.grandparent().color = RED;
        if (entry == entry.parent.left && entry.parent == entry.grandparent().left) {
            rotateRight(entry.grandparent());
        } else {
            rotateLeft(entry.grandparent());
        }
    }

    public void delete(Integer key) {
        Entry entry = lookupEntry(key);
// Key not found
        if (entry == null)
            return;
        if (entry.left != null && entry.right != null) {
// Copy key/value from predecessor and then delete predecessor
            Entry predecessor = maximumEntry(entry.left);
            entry.key = predecessor.key;
            entry.value = predecessor.value;
            entry = predecessor;
        }

        Entry child = (entry.right == null) ? entry.left : entry.right;

//if red - nothing
        if (entryColor(entry) == BLACK) {
            entry.color = entryColor(child);
            deleteCase1(entry);
        }
        replaceEntry(entry, child);

    }

// methods helps to find Entry to delete according to Hibbard deletion
    private static Entry maximumEntry(Entry n) {
        assert n != null;
        while (n.right != null) {
            n = n.right;
        }
        return n;
    }

//1)if root - nothing
    private void deleteCase1(Entry entry) {
        if (entry.parent == null)
            return;
        else
            deleteCase2(entry);
    }

//2)check if S == red - rotate S to P;
    private void deleteCase2(Entry entry) {
        if (entryColor(entry.sibling()) == RED) {
            entry.parent.color = RED;
            entry.sibling().color = BLACK;
            if (entry == entry.parent.left)
                rotateLeft(entry.parent);
            else
                rotateRight(entry.parent);
        }
        deleteCase3(entry);
    }

// 3)if All black - S = red;
    private void deleteCase3(Entry entry    ) {
        if (entryColor(entry.parent) == BLACK &&
                entryColor(entry.sibling()) == BLACK &&
                entryColor(entry.sibling().left) == BLACK &&
                entryColor(entry.sibling().right) == BLACK)
        {
            entry.sibling().color = RED;
            deleteCase1(entry.parent);
        }
        else
            deleteCase4(entry);
    }
//4)if P = red, other black - P = black, S = red;
    private void deleteCase4(Entry n) {
        if (entryColor(n.parent) == RED &&
                entryColor(n.sibling()) == BLACK &&
                entryColor(n.sibling().left) == BLACK &&
                entryColor(n.sibling().right) == BLACK)
        {
            n.sibling().color = RED;
            n.parent.color = BLACK;
        }
        else
            deleteCase5(n);
    }
//5)if Mirror Sl and N == P.l rotate Sl to S;
    private void deleteCase5(Entry n) {
        if (n == n.parent.left &&
                entryColor(n.sibling()) == BLACK &&
                entryColor(n.sibling().left) == RED &&
                entryColor(n.sibling().right) == BLACK)
        {
            n.sibling().color = RED;
            n.sibling().left.color = BLACK;
            rotateRight(n.sibling());
        }
        else if (n == n.parent.right &&
                entryColor(n.sibling()) == BLACK &&
                entryColor(n.sibling().right) == RED &&
                entryColor(n.sibling().left) == BLACK)
        {
            n.sibling().color = RED;
            n.sibling().right.color = BLACK;
            rotateLeft(n.sibling());
        }
        deleteCase6(n);
    }
//6)else (Mirror Sr == red and N == P.l) rotate S to P, Sr = black;
    private void deleteCase6(Entry n) {
        n.sibling().color = entryColor(n.parent);
        n.parent.color = BLACK;
        if (n == n.parent.left) {
            n.sibling().right.color = BLACK;
            rotateLeft(n.parent);
        }
        else
        {
            n.sibling().left.color = BLACK;
            rotateRight(n.parent);
        }
    }
}

