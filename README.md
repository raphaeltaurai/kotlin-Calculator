# Overview

This project is a console-based calculator written in Kotlin that evaluates full arithmetic expressions such as 2 + 3 * 4,
using standard math rules so multiplication and division are performed before addition and subtraction. It demonstrates 
how to read an entire expression from the user, tokenize it, convert it to a form that is easy to compute, and then safely
 evaluate the result while handling invalid input and division-by-zero cases.

The goal of this software is to grow skills as a software engineer by applying core Kotlin language features in a small 
ut non‑trivial program. It uses variables, expressions, conditionals, loops, functions, classes, and collections, and 
implements a simple expression parser so that the focus is on understanding Kotlin syntax, control flow, and standard 
library usage rather than using an external math engine.

[Software Demo Video](https://youtu.be/zMgCqfutAIo)

# Development Environment

{Describe the tools that you used to develop the software}

{Describe the programming language that you used and any libraries.}The calculator was developed in IntelliJ IDEA Community 
Edition using a Kotlin/JVM project and a locally installed Java Development Kit (JDK). The program runs as a command‑line 
application, so it can be built and executed directly from the IDE’s run configuration without any additional tooling.

The programming language used is Kotlin, targeting the JVM for easy interoperability with Java. The implementation relies 
on the Kotlin standard library and basic Java collections (for example, stacks/queues such as ArrayDeque) to store tokens 
and operators while parsing and evaluating expressions, without bringing in any third‑party libraries.

# Useful Websites


- [W3Schools](https://www.w3schools.com/kotlin/)
- [developer.android.com](https://developer.android.com/courses/pathways/android-development-with-kotlin-1)
- https://kotlinlang.org/docs/read-standard-input.html
- https://en.wikipedia.org/wiki/Shunting_yard_algorithm

# Future Work

{Make a list of things that you need to fix, improve, and add in the future.}

Add more operators and functions, such as exponentiation, unary minus, and common math functions (for example, square root).

Improve error messages to be more descriptive and, if possible, indicate where in the expression the error occurred.

Create a graphical or Android user interface so the calculator can be used with buttons and a display instead of only a console.