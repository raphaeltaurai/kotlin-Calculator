import java.util.ArrayDeque

class ExpressionCalculator {

    private val operators = setOf('+', '-', '*', '/')
    private val precedence = mapOf('+' to 1, '-' to 1, '*' to 2, '/' to 2)

    fun evaluate(expression: String): Double {
        val tokens = tokenize(expression)
        val postfix = infixToPostfix(tokens)
        return evalPostfix(postfix)
    }

    private fun tokenize(expr: String): List<String> {
        val result = mutableListOf<String>()
        val current = StringBuilder()

        for (ch in expr.replace(" ", "")) {
            if (ch.isDigit() || ch == '.') {
                current.append(ch)
            } else if (ch in operators || ch == '(' || ch == ')') {
                if (current.isNotEmpty()) {
                    result.add(current.toString())
                    current.clear()
                }
                result.add(ch.toString())
            } else {
                throw IllegalArgumentException("Invalid character: $ch")
            }
        }

        if (current.isNotEmpty()) {
            result.add(current.toString())
        }

        return result
    }

    // Shunting-yard: infix -> postfix (RPN)
    private fun infixToPostfix(tokens: List<String>): List<String> {
        val output = mutableListOf<String>()
        val stack = ArrayDeque<String>()

        for (token in tokens) {
            when {
                token.toDoubleOrNull() != null -> {
                    output.add(token)
                }
                token.length == 1 && token[0] in operators -> {
                    while (
                        stack.isNotEmpty() &&
                        stack.peek() != "(" &&
                        hasHigherOrEqualPrecedence(stack.peek()[0], token[0])
                    ) {
                        output.add(stack.pop())
                    }
                    stack.push(token)
                }
                token == "(" -> {
                    stack.push(token)
                }
                token == ")" -> {
                    while (stack.isNotEmpty() && stack.peek() != "(") {
                        output.add(stack.pop())
                    }
                    if (stack.isEmpty() || stack.peek() != "(") {
                        throw IllegalArgumentException("Mismatched parentheses")
                    }
                    stack.pop() // remove "("
                }
                else -> throw IllegalArgumentException("Invalid token: $token")
            }
        }

        while (stack.isNotEmpty()) {
            val op = stack.pop()
            if (op == "(" || op == ")") {
                throw IllegalArgumentException("Mismatched parentheses")
            }
            output.add(op)
        }

        return output
    }

    private fun hasHigherOrEqualPrecedence(op1: Char, op2: Char): Boolean {
        val p1 = precedence[op1] ?: 0
        val p2 = precedence[op2] ?: 0
        return p1 >= p2
    }

    // Evaluate postfix (RPN)
    private fun evalPostfix(postfix: List<String>): Double {
        val stack = ArrayDeque<Double>()

        for (token in postfix) {
            val number = token.toDoubleOrNull()
            if (number != null) {
                stack.push(number)
            } else if (token.length == 1 && token[0] in operators) {
                if (stack.size < 2) {
                    throw IllegalArgumentException("Invalid expression")
                }
                val b = stack.pop()
                val a = stack.pop()
                val result = when (token[0]) {
                    '+' -> a + b
                    '-' -> a - b
                    '*' -> a * b
                    '/' -> {
                        if (b == 0.0) throw IllegalArgumentException("Division by zero")
                        a / b
                    }
                    else -> throw IllegalArgumentException("Unknown operator: ${token[0]}")
                }
                stack.push(result)
            } else {
                throw IllegalArgumentException("Invalid token in postfix: $token")
            }
        }

        if (stack.size != 1) {
            throw IllegalArgumentException("Invalid expression")
        }

        return stack.pop()
    }
}

fun main() {
    val calculator = ExpressionCalculator()

    println("=== Kotlin Expression Calculator ===")
    println("You can type expressions like: 2+3*4, (1+2)*3, 10/2+5")

    while (true) {
        print("Enter an expression (or 'quit' to exit): ")
        val line = readLine()?.trim()

        if (line == null || line.lowercase() == "quit") {
            println("Goodbye!")
            break
        }

        if (line.isBlank()) {
            println("Please enter a non-empty expression.")
            continue
        }

        try {
            val result = calculator.evaluate(line)
            println("Result: $result")
        } catch (ex: IllegalArgumentException) {
            println("Error: ${ex.message}")
        }
    }
}
