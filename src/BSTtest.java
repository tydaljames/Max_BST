
/*
 * BST Test Class
 * Created by Tyler D'Alessandro
 */
public class BSTtest
{
    public static void main(String[] args)
    {
        BST<String> tree = new BST<String>();

        int L = 0;
        int R = 18;

        for(int i=0; i < args.length; i++)
        {
            tree.insert(Integer.parseInt(args[i]));

        }

        tree.delete(Integer.parseInt(args[3]));
        System.out.println(tree.find(Integer.parseInt(args[4])));
        tree.print();

        System.out.println(tree.rangeSum(L, R));
    }
}