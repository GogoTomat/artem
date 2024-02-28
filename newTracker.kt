import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var balance = 0.0
    val history = mutableListOf<String>()

    while (true) {
        println("Menu:")
        println("1. Show current balance")
        println("2. Add expense")
        println("3. Add income")
        println("4. Cancel last operation")
        println("5. Show all operations")
        println("0. Quit")
        print("Choose command: ")
        if (scanner.hasNextInt()) {
            val choice = scanner.nextInt()
            when (choice) {
                1 -> println("Current balance: $balance")
                2 -> {
                    print("Enter Expense: ")
                    if (scanner.hasNextDouble()) {
                        val expense = scanner.nextDouble()
                        if (expense < 0) {
                            println("Error: Expense can't be less than 0.")
                        } else {
                            balance -= expense
                            history.add("Expense: -$expense")
                            println("Expense successfully added.")
                        }
                    } else {
                        println("Error: input a number")
                    }
                    scanner.nextLine() 
                }
                3 -> {
                    print("Enter income: ")
                    if (scanner.hasNextDouble()) {
                        val income = scanner.nextDouble()
                        if (income < 0) {
                            println("Error: Income can't be less than 0.")
                        } else {
                            balance += income
                            history.add("Income: +$income")
                            println("Income successfully added.")
                        }
                    } else {
                        println("Error: input a number")
                    }
                    scanner.nextLine() 
                }
                4 -> {
                    if (history.isEmpty()) {
                        println("Error: History is empty.")
                    } else {
                        val lastOperation = history.removeAt(history.size - 1)
                        if (lastOperation.startsWith("Expense")) {
                            balance += lastOperation.substringAfter("-").toDouble()
                        } else {
                            balance -= lastOperation.substringAfter("+").toDouble()
                        }
                        println("Last operation successfully canceled.")
                    }
                    scanner.nextLine() 
                }
                5 -> {
                    if (history.isEmpty()) {
                        println("History is empty.")
                    } else {
                        println("History:")
                        for (operation in history) {
                            println(operation)
                        }
                    }
                    scanner.nextLine() 
                }
                0 -> {
                    println("Quit.")
                    return
                }
                else -> {
                    println("Error: unknown command.")
                    scanner.nextLine() 
                }
            }
        } else {
            println("Error: input a number")
            scanner.nextLine() 
        }
    }
}