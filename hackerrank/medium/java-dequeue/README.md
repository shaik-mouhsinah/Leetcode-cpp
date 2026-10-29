# java-dequeue

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, for which elements can be added  to or removed from either the front (head) or back (tail).

    
Deque interfaces can be implemented using various types of collections such as `LinkedList` or `ArrayDeque` classes. For example, deque can be declared as:

    Deque deque = new LinkedList<>();
    or
    Deque deque = new ArrayDeque<>();
    
You can find more details about Deque [here](http://docs.oracle.com/javase/7/docs/api/java/util/Deque.html).

In this problem, you are given $N$ integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size $M$.

*Note*: Time limit is $3$ second for this problem.


**Input Format**

The first line of input contains two integers $N$ and $M$: representing the total number of integers and the size of the subarray, respectively. The next line contains $N$ space separated integers. 

**Constraints**

$1 \le N \le 100000$<br>
$1 \le M \le 100000$<br>
$M\le N$<br>
The numbers in the array will range between $[0,10000000]$.


**Output Format**

Print the *maximum* number of unique integers among all possible contiguous subarrays of size $M$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T09:11:32.286Z  

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // total numbers
        int m = in.nextInt(); // subarray size

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();

        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            deque.addLast(num);
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            // Maintain window size m
            if (deque.size() > m) {
                int removed = deque.removeFirst();
                freq.put(removed, freq.get(removed) - 1);
                if (freq.get(removed) == 0) {
                    freq.remove(removed);
                }
            }

            // Update max unique count
            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, freq.size());
            }
        }

        System.out.println(maxUnique);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-dequeue/problem)