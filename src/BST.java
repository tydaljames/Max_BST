/*
 * Binary search tree data structure
 * Created by Tyler D'Alessandro
 */

public class BST<T extends Comparable<T>> {
    Node<T> root; //Data Member for root of the BST
    private int sum;

    /*
     * Node Class used to created Node objects
     */
    private class Node<T>
    {
        int data;
        Node<T> left;
        Node<T> right;
        int instance;

        Node(int item)
        {
            data = item;
            instance = 1;
        }
    }

    public BST()
    {
        root = null;
    }

    /*
     * Find function that finds an item in the BST
     * @param item to be found
     * @return boolean if the item was found
     */
    public boolean find(int item) {
        return find(item, root);
    }

    /*
     * Function override of the find function
     * @param item to be found
     * @param node the current node you are at
     * @return boolean if the item was found
     */
    private boolean find(int item, Node<T> node) {
        //TODO FILL IN

        if(node == null){
            return false;
        }

        if(node != null){
            if(item == node.data){
                return true;
            }
            else if(item < node.data){
                return(find(item, node.left));
            }
            else{
                return(find(item,node.right));
            }
        }

        return false;
    }

    /*
     * Insert an item to the tree
     * @param item to insert
     */
    public void insert(int item) {
        root = insert(item, root);

    }

    /*
     * Helper function for insert
     * @param item to add
     * @param node you are at
     * @return node you traverse to
     */
    private Node<T> insert(int item, Node<T> node){

    if(node == null){
        System.out.println("new node: " + item);
        return new Node(item);
    }

        System.out.println(item + "," + node.data);

    if(item < node.data){
        System.out.println("Going left");
        node.left = insert(item, node.left);
    }
    else{
        System.out.println("Going right");
        node.right = insert(item, node.right);
    }

    return node;
    }

    /*
     * Function for deletion of a node
     * @param item to delete
     */
    public void delete(int item)
    {
        root = delete(item, root);
    }

    /*
     * Helper function for deletion of a node
     * @param item to delete
     * @param node you are at
     * @return node you traverse to
     */
    private Node<T> delete(int item, Node<T> node) {

        if(node == null){
            return null;
        }
        if(item < node.data){
            node.left = delete(item, node.left);
            return node;
        }
        else if(item > node.data){
            node.right = delete(item, node.right);
            return node;
        }
        else{ //item == node.data
            if(node.left == null){
                return node.right;
            }
            else if(node.right == null){
                return node.left;
            }
            else{ //2 children to promote from
                if(node.right.left == null){
                    node.data = node.right.data;
                    node.right = node.right.right;
                }
                else{
                    node.data = smallest(node.right);
                }
                return node;
            }
        }
    }

    /* Helper function for delete.
    * Used for finding which node will be promoted.
    */

    int smallest(Node<T> node){
        if(node.left.left == null){
            int smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        }
        else{
            return smallest(node.left);
        }
    }

    /*
     * Function to find the range sum of the binary tree
     * @param L the left bound
     * @param R the right bound
     * @return The sum of the range in the binary tree
     */

    public int rangeSum(int L, int R) {

        return rangeSum(L,R,root);
    }

    /*
    * Helper function to find range sum of the binary tree
    * @param node is the current node being checked for its value
    *
    */

    private int rangeSum(int L, int R, Node<T> node){

        if(node != null){
            if(node.data >= L && node.data <= R){
                sum += node.data;
            }

            if(node.data > L){
                rangeSum(L,R,node.left);
            }
            if(node.data < R){
                rangeSum(L,R, node.right);
            }
        }
        return sum;
    }




    /*
     * Function to print the Binary tree
     */
    public void print()
    {
        print(root);
    }

    /*
     * Helper Function to print the Binary tree
     * @param root the root of the tree
     */
    private void print(Node<T> root) {
        if (root == null) return;
        System.out.println(root.data);
        print(root.left);
        print(root.right);
    }
}