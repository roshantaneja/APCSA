## AP Computer Science Math-Strings-IfStatements
### What you should know about Math in Java

Mathematical expressions in Java follow usual order of operations rules

If you mix an int and a double, the result is a double

You can typecast a double to an int: `int x = (int)(2.7);`

`Math.sqrt`, `Math.abs`, `Math.pow`, `Math.random` `Math.round`, `Math.ceil`, `Math.floor` 

Math.random() can be used to get any random number

Doubles are somewhat inexact

Understand integer division and mod, using / and %

---

### What you should know about Strings in Java
There are four String methods you should know:
* `.length()` returns the length of the String
* `.substring` returns a substring of the String
* `.indexOf` returns the index of the first occurrence of a character in the String
* `.equals` returns true if the String is equal to another String

You should be very familiar with how these methods work.  In particular, If the length of a string is 10, then the individual letters are indexed 0 to 9.  The index of the last letter is one less than the length.  This is easy to mix up!

Recall that there are two versions of .substring, and you should know how they work.

There are a few subtleties with .indexOf.  You should know that 
1. it returns the index of the first occurrence
2. if the parameter is longer than one letter, it returns the index of where the parameter starts
3. it returns -1 if the parameter is not there.

We did some “clever-problem-solving” with these methods.  
You can use `if (x.indexOf(y) > -1)` to test if x contains y.  And, to find the second or third occurrence of something using indexOf, you can “chop off” everything using substring.  We did this “chopping” technique in multiple examples, perhaps most straightforwardly in DomainSuffix.

---

### What you should know about if-statements and booleans in Java

The comparison operators are `<`, `>`, `==`, `<=`, `>=`, and `!=`.

The boolean operators are `&&` (and),`||` (or), and `!` (not).  In terms of order of operations, and has higher precedence than or.

When the body of an if-statement is only one line, the {} can be omitted.

Because Java considers an if-statement to be “one line”, the rule above can be used to create a “cascading if-statement”.  Such a pattern should begin with if, contain multiple else if statements, and end with a single else.

A return statement immediately ends the entire method and returns the value.  This can impact the need for else.

We discussed the coding philosophy of “boolean zen”.  While we did several examples, here are some guiding principles.

You can always eliminate `== true`.    That is, `if (isWorking == true)` is equivalent to if `if (isWorking)`.

Multiple nested if-statements can often be condensed using && and ||.

The pattern if (whatever) return true; else return false; can be condensed into return whatever;
