package cv5;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Buduji binární vyhledávací strom...");

        bst.insert(7);
        bst.insert(5);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(10);
        bst.insert(16);
        bst.insert(42);
        bst.insert(42);

        System.out.println("Všech 8 prvků bylo úspěšně vloženo.");
        bst.printTree();
        bst.printTreeStructure();

        bst.searchWithTime(60);
        bst.searchWithTime(42);
        System.out.println(bst.printTreeLeaves());

        System.out.println(" ");
        
    }
}
