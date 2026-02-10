public class DirectoryTree {
    public static void main(String[] args) {
        Directory dir1 = new Directory("Directory1");
        Directory dir2 = new Directory("Directory2");
        Directory dir3 = new Directory("Directory3");
        Directory dir4 = new Directory("Directory4");
        Directory dir5 = new Directory("Directory5");
        
        dir1.setChildren(dir4, dir2);
        dir2.setChildren(dir5, dir3);
        
        System.out.println("Directory Tree Structure:");
        dir1.printTree(0);
    }
}
