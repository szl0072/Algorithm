/* Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.
Assumptions: K >= 1

Examples:
the smallest is 3 * 5 * 7 = 105
the 2nd smallest is 3 ^ 2 * 5 * 7 = 315
the 3rd smallest is 3 * 5 ^ 2 * 7 = 525
the 5th smallest is 3 ^ 3 * 5 * 7 = 945  */


/* 思路：min heap
initial state: x = 1, y = 1, z = 1
expansion / generation rule: expand <x, y, z>
    1. generate <x+1, y, z>
    2. generate <x, y+1, z>
    3. generate <x, y, z+1>
termination condition: pop the smallest elements, when the (k-1)-th smallest element is popped our of the heap, 
    then peek heap to get the k-th smallest element

去重：比如，<2, 2, 1> can be generated by <1, 2, 1> or <2, 1, 1>. 但是注意一点：因为3,5,7都是质数，所以
对于任何一个三元组xyz，只要xyz中有任何一个或者两个或者三个发生变化，那么得到的乘积一定是不同的！！！
不可能出现 xyz 三个数里，一个变大，一个变小，然后最后乘积不变的情况 ！！！

所以这样的话，无论是 heap 里放元素，还是set里去重，都简单了 ！！！
直接把这个最终乘积放进去就可以了 ！！！ 不用放什么三元组了 ！！！

时间：O(k logk)
因为要从heap里pop k次，每一次需要时间 logk。  */

public class Solution {
  
  public long kth(int k) {
    PriorityQueue<Long> minHeap = new PriorityQueue<>(k);
    Set<Long> visited = new HashSet<>();
    
    Long smallest = 3 * 5 * 7L; //  如果少了这个 L 就会报错 ！ 这里不能仰仗java自动从int转为long ！
    minHeap.offer(smallest);
    visited.add(smallest);
    
    int remain = k;
    while (remain > 1) { // 注意这里应该是 1 ！ 不是 0 ！
      long cur = minHeap.poll();
      
      // 很巧妙！下一个数直接乘以3或5或7就行了！不必记录 x，y，z 当前分别是多大 ！！！
      if (visited.add(cur * 3)) {
        minHeap.offer(cur * 3);
      }
      if (visited.add(cur * 5)) {
        minHeap.offer(cur * 5);
      }
      if (visited.add(cur * 7)) {
        minHeap.offer(cur * 7);
      }
      
      remain --;
    }
    
    return minHeap.peek(); // the k-th smallest
  }
}