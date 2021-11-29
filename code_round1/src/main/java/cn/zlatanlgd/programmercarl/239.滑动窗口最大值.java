import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class MyDeque {
    // 单调队列，保证队里中只保存{滑动窗口最大值，最新添加的值}
    Deque<Integer> deque = new LinkedList<>();

    // pop ， 判断队首元素是否等于当前要弹出的元素。
    // 如果相等则弹出，否则不操作。
    void pop(int val) {
        if (!deque.isEmpty() && deque.peek() == val) {
            deque.poll();
        }
    }

    // push ，判断push的值，如果大于队尾的元素，则将队尾弹出
    // 直到push的值小于或等于队尾元素为止
    void push(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    // front，查询当前队列中最大值（即队首元素）
    int front() {
        return deque.peek();
    }
}

class Solution {
    public int[] maxSlidingWindow(final int[] nums, final int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int num = 0;
        // 自定单调队列
        MyDeque mydeque = new MyDeque();
        for (int i = 0; i < k; i++) {
            mydeque.push(nums[i]);
        }
        res[num++] = mydeque.front();
        for (int i = k; i < nums.length; i++) {
            // 滑动窗口移除最前面的元素
            mydeque.pop(nums[i - k]);
            // 滑动窗口添加最后面的元素;
            mydeque.push(nums[i]);
            // 记录当前最大值
            res[num++] = mydeque.front();
        }
        return res;
    }
}
// @lc code=end
