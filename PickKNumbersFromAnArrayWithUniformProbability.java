/* 这一题的要求就是：给n个数，从里面拿出k个数，必须满足，n里的任何一个数被选中的机会都是相同的 ！！

方法：
用1/n的概率拿第一个数，那么所有数被拿的概率都是1/n；
然后在剩下的n-1个数里，用1/n-1的概率拿第二个数，那么剩下的所有数被拿的概率是 (1/(n-1)) * ((n-1)/n) = 1/n，
其中((n-1)/n)是这些数没有在第一轮被拿的概率，所以剩下的每个数被拿的概率还是 1/n；
然后在剩下的n-2个数里，用1/n-2的概率拿第三个数，剩下的这些数在前两轮里都没有被选中的概率都是 (n-1)/n * (n-2)/(n-1) = (n-2)/n，
它们中的每一个在第三轮中被选上的概率是 (n-2)/n * (1/(n-2)) = 1/n；
第四轮……
……
我们一共进行k轮。对于n个数里的每一个来说，在第1,2,3... k 轮被选中的概率分别是：1/n, 1/n, 1/n ... 1/n。所以
每一个数在k轮中被选中的概率都是 k/n。每一个数在k轮中都没有被选中的概率都是 (n-k)/n。它们被选中的机会是等概的 ！！！  */
