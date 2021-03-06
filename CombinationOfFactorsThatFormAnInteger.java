/* 比如12，有3种分解方式：6*2, 4*3, 3*2*2

做法：12的话，先不断地除以2，直到无法整除；然后不断地除以3，直到无法整除；然后不断地除以4... 不断地除以5... 6... 7... ... ...
就是从2开始，int i = 2; i <= n / 2; i++，不断地除尽每一个 i。
这种方法确实会碰到一些非质数，比如4, 6 等等，但之前已经除尽了所有的2和3，所以按 i++ 这样每次都不断地除尽每一个i的话，
遇到非质数的时候，是一定一上来就已经除尽了的。

然后，看12一共有哪些因数。这些因数不一定要是质数。需要的是所有的不重复的因数（也必须 > 1）。
我们取得这些数的过程，可以是上面所说的过程中，不断地用一个 hashset 来记录所有不重复的数。
比如12的所有的不重复的因数只有4个：6，4，3，2。所以，我们的recursion tree就有4层：

第一层：最后的组合里有多少个 6
第二层：有多少个 4
第三层：有多少个 3
第四层：有多少个 2
这个思路，和用面值为1，2，5，10的硬币凑99是一样的 ！！！   */
