# Java Abstract Class

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

A Java abstract class is a class that can't be instantiated. That means you cannot create new instances of an abstract class. It works as a base for subclasses. You should learn about Java Inheritance before attempting this challenge. 

Following is an example of abstract class:

```java
abstract class Book{
    String title;
    abstract void setTitle(String s);
    String getTitle(){
        return title;
    }
}
```

If you try to create an instance of this class like the following line you will get an error:

```java
Book new_novel=new Book(); 
```
    
You have to create another class that extends the abstract class. Then you can create an instance of the new class. 

Notice that *setTitle* method is abstract too and has no body. That means you must implement the body of that method in the child class.

In the editor, we have provided the abstract *Book* class and a *Main* class. In the Main class, we created an instance of a class called *MyBook*. Your task is to write just the *MyBook* class. 

Your class mustn't be public.

**Sample Input**

    A tale of two cities

**Sample Output**

    The title is: A tale of two cities


**Input Format**

 

**Constraints**

 

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T08:57:23.855Z  

```java
import java.util.*; 
 
abstract class Book {     String title; 
    abstract void setTitle(String s); 
    String getTitle() {         return title; 
    } 
} 
 
class MyBook extends Book { 
    @Override 
    void setTitle(String s) { 
        this.title = s; 
    } 
} 
 
public class Main {     public static void main(String[] args) {         Scanner sc = new Scanner(System.in); 
        String title = sc.nextLine(); 
        MyBook new_novel = new MyBook();         new_novel.setTitle(title); 
        System.out.println("The title is: " + new_novel.getTitle());         sc.close(); 
    } 
} 

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-abstract-class/problem)