public class Directory {
    String name;
    Directory[] children;
    
    public Directory(String name) {
        this.name = name;
        this.children = new Directory[0];
    }
    
    public void setChildren(Directory... dirs) {
        this.children = dirs;
    }
    
    public void printTree(int depth) {
        String indent = "";
        for (int i = 0; i < depth; i++) {
            indent += "  ";
        }
        System.out.println(indent + name);
        
        for (Directory child : children) {
            child.printTree(depth + 1);
        }
    }
}
