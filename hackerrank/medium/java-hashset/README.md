# java-hashset

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In computer science, a set is an abstract data type that can store certain values, without any particular order, and no repeated values(Wikipedia). $\{1,2,3\}$ is an example of a set, but $\{1,2,2\}$ is not a set. Today you will learn how to use sets in java by solving this problem.<br>

You are given $n$ pairs of strings. Two pairs $(a,b)$ and $(c,d)$ are identical if $a=c$ and $b=d$. That also implies $(a,b)$ is *not* same as $(b,a)$. After taking each pair as input, you need to print number of unique pairs you currently have.

Complete the code in the editor to solve this problem.


**Input Format**

In the first line, there will be an integer $T$ denoting number of pairs. Each of the next $T$ lines will contain two strings seperated by a single space.

**Constraints:**

* $1 \le T \le 100000$
* Length of each string is atmost $5$ and will consist lower case letters only.


**Constraints**

 

**Output Format**

Print $T$ lines. In the $i_{th}$ line, print number of unique pairs you have after taking $i^{th}$ pair as input.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T09:10:13.097Z  

```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

//Write your code here
Set<String> uniquePairs = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String a = pair_left[i];
            String b = pair_right[i];

            // Canonicalize the pair so (a, b) and (b, a) map to the same key
            String pair;
            if (a.compareTo(b) < 0) {
                pair = a + " " + b;
            } else {
                pair = b + " " + a;
            }

            uniquePairs.add(pair);
            sb.append(uniquePairs.size()).append("\n");
        }

        System.out.print(sb);
   }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-hashset/problem)