## Task 1. ListyIterator

Create a class ListyIterator, it should receive the collection of Strings which it will iterate, through its constructor. You should store the elements in a List. The class should have three main functions:
- Move - should move an internal index position to the next index in the list, the method should return true if it successfully moved and false if there is no next index.
- HasNext - should return true if there is a next index and false if the index is already at the last element of the list.
- Print - should print the element at the current internal index, calling Print on a collection without elements should throw an appropriate exception with the message "Invalid Operation!".

By default, the internal index should be pointing to the 0th index of the List. Your program should support the following commands:



## Task 2. Collection

Using the ListyIterator from the last problem, extend it by implementing the Iterable interface, and implement all methods desired by the interface manually. Add a new method to the class PrintAll(), the method should foreach the collection and print all elements on a single line separated by a space.



## Task 3. Stack Iterator

Since you have passed the basics algorithms course, now you have a task to create your custom stack. You are aware of the Stack structure. There is a collection to store the elements and two functions (not from the functional programming) - to push an element and to pop it. Keep in mind that the first element, which is popped, is the last in the collection. The push method adds an element to the top of the collection, and the pop method returns the top element and removes it.

Write your custom implementation of Stack<Integer> and implement your custom iterator. There is a way that IntelliJ could help you, your Stack class should implement the Iterable<Integer> interface, and your Iterator Class should implement the Iterator<Integer> interface. Your Custom Iterator should follow the rules of the Abstract Data Type - Stack. As we said, the first element is the element at the top and so on. Iterators are used only for iterating through the collection, they should not remove or mutate the elements.



## Task 4. Froggy

Let's play a game. You have a tiny little Frog and a Lake with numbers. The Lake and its numbers, you will get by an input from the console. Imagine, your Frog belongs to the Lake. The Frog jumps only when the "END" command is received. When the Frog starts jumping, print on the console each number the Frog has stepped over. To calculate the jumps, use the guidelines:

The jumps start from the 0th index. And follows the pattern - first, all even indexes in ascending order(0->2->4->6 and so on) and then all odd indexes in ascending order (1->3->5->7 and so on). Consider the 0th index as even.

Long story short: Create a Class Lake, it should implement the interface - Iterable. Inside the Lake, create a Class - Frog and implement the interface Iterator. Keep in mind that you will be given integers only.



## Task 5. Comparing Objects

There is a Comparable interface, but probably you already know. Your task is simple. Create a Class Person. Each person should have a name, age, and town. You should implement the interface - Comparable and try to override the compareTo method. When you compare two people, first you should compare their names, after that - their age and last but not least - compare their town.



## Task 6. Strategy Pattern

An interesting pattern you may have heard of is the Strategy Pattern, if we have multiple ways to do a task (let's say sort a collection) it allows the client to choose the way that most fits his needs. A famous implementation of the pattern in Java is the Collections.sort() method that takes a Comparator.

Create a class Person that holds name and age. Create 2 Comparators for Person (classes that implement the Comparator<Person> interface). The first comparator should compare people based on the length of their name as a first parameter, if 2 people have a name with the same length, perform a case-insensitive compare based on the first letter of their name instead. The second comparator should compare them based on their age. Create 2 TreeSets of type Person, the first should implement the name comparator, and the second should implement the age comparator.



## Task 7. *Equality Logic

Create a class Person holding name and age. A person with the same name and age should be considered the same, override any methods needed to enforce this logic. Your class should work with both standards and hashed collections. Create a TreeSet and a HashSet of type Person.



## Task 8. *Pet Clinics

You are a young and ambitious owner of Pet Clinics Holding. You ask your employees to create a program that will store all information about the pets in the database. Each pet should have a name, age, and kind.

Your application should support a few basic operations such as creating a pet, creating a clinic, adding a pet to a clinic, releasing a pet from a clinic, printing information about a specific room in a clinic, or printing information about all rooms in a clinic.

Clinics should have an odd number of rooms, attempting to create a clinic with an even number should fail and throw an appropriate exception.



## Task 9. ***Linked List Traversal

You need to write your simplified implementation of a generic Linked List that has an Iterator. The list should support the Add and Remove operations, should reveal the amount of elements it has with a getSize function and should have an implemented iterator (should be foreachable). The add method should add the new element at the end of the collection. The remove method should remove the first occurrence of the item starting at the beginning of the collection, if the element is successfully removed, the method returns true, alternatively, if the element passed is not in the collection, the method should return false. The getSize method should return the number of elements currently in the list. The iterator should iterate over the collection starting from the first entered element.