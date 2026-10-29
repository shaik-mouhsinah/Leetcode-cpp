# java-singleton

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

> "The singleton pattern is a design pattern that restricts the instantiation of a class to one object. This is useful when exactly one object is needed to coordinate actions across the system."	
> - [Wikipedia: Singleton Pattern](https://en.wikipedia.org/wiki/Singleton_pattern)
***

Complete the *Singleton* class in your editor which contains the following components:  


1. A *private Singleton* non parameterized constructor.
2. A *public* String instance variable named $str$. 
3. Write a *static* method named *getSingleInstance* that returns the single instance of the *Singleton* class.

Once submitted, our hidden *Solution* class will check your code by taking a String as input and then using your *Singleton* class to print a line.

**Input Format**

You will not be handling any input in this challenge. 

**Constraints**

 

**Output Format**

You will not be producing any output in this challenge.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T09:05:47.257Z  

```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;
class Singleton{
    public String str;
    private static Singleton instance = null;
    
    private Singleton() {}
    
    public static Singleton getSingleInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
public class Main {

 public static void main(String args[])throws Exception{
    
    Scanner sc=new Scanner(System.in);
    Singleton s1 = Singleton.getSingleInstance(); //retrive the single instance
    Singleton s2=Singleton.getSingleInstance();
    assert(s1==s2);
    
    //verify that the constructor is private
    Class c=s1.getClass();
    Constructor[] allConstructors = c.getDeclaredConstructors();
    assert allConstructors.length==1;
    for (Constructor ctor : allConstructors) 
    {
        if(ctor.getModifiers()!=2 || !ctor.toString().equals("private Singleton()")) //The constructor must be private
        {
            System.out.println("Wrong class!");
        }
    }
    String str=sc.nextLine();
    s1.str=str;
    s2.str=str;
    System.out.println("Hello I am a singleton! Let me say "+str+" to you");
 }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-singleton/problem)