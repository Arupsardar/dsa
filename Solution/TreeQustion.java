package Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import strucher.TreeNode;

public class TreeQustion {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levelSums = new ArrayList<>();
        levelWiseSum(root, 0, levelSums);

        // Sort the level sums in descending order
        Collections.sort(levelSums, Collections.reverseOrder());

        // If k is greater than the number of levels, return -1
        if (k > levelSums.size()) {
            return -1;
        }

        // Return the k-th largest sum
        return levelSums.get(k - 1);

        
    }

    public void levelWiseSum(TreeNode root, int level, List<Long> levelSums) {
        if (root == null) {
            return;
        }

        // Expand the list if the current level does not exist in the list
        if (level == levelSums.size()) {
            levelSums.add(0L);
        }

        // Update the sum for the current level
        levelSums.set(level, levelSums.get(level) + root.val);

        // Recur for left and right subtrees
        levelWiseSum(root.left, level + 1, levelSums);
        levelWiseSum(root.right, level + 1, levelSums);
    }
}
