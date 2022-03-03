import Objects.TreeNode;
import Questions.*;

import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println(ImplStrStr.strStr("aaablabla", "bla"));
        TreeNode treeNode = new TreeNode(1);
        // PartitionArrayII.partition2(new int[]{4, 3, 4, 1, 2, 3, 1, 2}, 2, 3);
        // MaximumNumberInMountainSequence.mountainSequence(new int[]{1, 2, 4, 8, 6, 3});
        // MergeSortedArray.mergeSortedArray(new int[]{1, 2, 3, 0, 0}, 3, new int[]{4, 5}, 2);
        // RemoveDuplicatesFromSortedArrayII.removeDuplicates(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4});
        // FindWords.findWords("nmownhiterer", Arrays.asList("nowhere", "monitor", "moniter"));
        // LongestCommonPrefix.longestCommonPrefixTwo(new String[]{"a"});
        LongestIncreasingSubsequence.longestIncreasingSubsequenceThree(new int[]{4, 2, 4, 5, 3, 7});
    }
}
