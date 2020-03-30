## 常规思路

链表或者数组 + 每轮删除第M个元素 + 剩下的最后一个元素就为所求元素。

- 链表:LinkedList

- 第M个元素:  
可以直接通过前一轮删除的元素下标idx得到这一轮的元素。考虑到长度变化(n是递减的),具体计算方法为:  
`idx = (idx + m - 1) % n`  
(其中n是递减的，它的值为n-i，i为轮数)

- 最后一个元素：  
list.get(0)

**代码**
```java
public class QInterview0062_Last_Circle_of_Figure {
    public int lastRemaining(int n, int m) {
        List<Integer> circle = new LinkedList<>();
        for(int i = 0; i < n; i++) circle.add(i);
        int idx = 0;
        for(; n > 1; n--){
            idx = (idx + m - 1) % n;
            circle.remove(idx);
        }
        return circle.get(0);
    }
}
```

**结果**

想法简单，但是结果很差。LinkedList直接超时，ArrayList数组勉强通过。

**分析**

- LinkedList 每次查找的效率为O(n),所以整体的时间复杂度达到了O(n*m)，在n和m都很大的时候就超时了。  
- ArrayList的下标访问是O(1)，所以访问很快，但是每次删除元素需要移动删除元素之后的所有元素，不过由于是采用的addAll整块复制，所以效率会高，但是内存开销会很大。

## 约瑟夫环

**介绍**

约瑟夫问题（有时也称为约瑟夫斯置换），是一个出现在计算机科学和数学中的问题。在计算机编程的算法中，类似问题又称为约瑟夫环。

人们站在一个等待被处决的圈子里。 计数从圆圈中的指定点开始，并沿指定方向围绕圆圈进行。 在跳过指定数量的人之后，执行下一个人。 对剩下的人重复该过程，从下一个人开始，朝同一方向跳过相同数量的人，直到只剩下一个人，并被释放。  

这里有一篇个人觉得解释的很不错的博客，供感兴趣的同学参考:  
[约瑟夫解释入口](https://blog.csdn.net/u011500062/article/details/72855826)

**解决**

我们套用约瑟夫环的公式：  
f(n, m) = (f(n-1, m) + m) % n.   
其中f(n, m)表示，n个人的时候，每次处决第m个人，最后剩下的人的坐标。  
并且已知f(1, m) = 0.  因为只剩下一个人的时候f(n, m)坐标必定为0。  

**代码**

```java
public class QInterview0062_Last_Circle_of_Figure {
    public int lastRemaining(int n, int m) {
        int idx = 0;
        for(int i = 2; i <= n; i++){
            idx = (idx + m) % i;
        }
        return idx;
    }
}
```