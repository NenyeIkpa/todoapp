import java.util.*

fun main() {
    val scanner  = Scanner(System.`in`)
    println("---------------------------------------------")
    println("Todo Application")
    println("---------------------------------------------")
    println()
    println("please enter your name ")
    val name = scanner.nextLine()
    println("Good day $name, you can enter your todo below")
    val listOfTodo = mutableListOf<Todo>()

    val listOfTask = mutableListOf(
        Todo("Record screen cast"),
        Todo("Check the kids"),
        Todo("Go to the store", true),
        Todo("Reply emails")

    )
    listOfTodo.addAll(listOfTask)

    while (true){
        println("what will you like to do ... \n -> enter 1 to add todo \n -> enter 2 to view list \n -> enter 3 to mark todo as complete \n -> enter 4 to delete todo \n -> enter 5 to close")
        val first = try {
            scanner.nextInt()
        }catch (e:InputMismatchException){
            println("the value entered must be an integer or number, please try again")
        }
        scanner.nextLine()
        if (first == 1){
            println("enter todo below")
            val whatTodo = scanner.nextLine()
            listOfTodo.add(Todo(whatTodo))
        }else if (first == 2){
            for (i in listOfTodo.indices){
                println("(${i+1}) ${listOfTodo[i].task}")
            }
            println("---------------------------------------------")
        } else if (first == 3) {//to mark complete
        println("To mark as done, select todo by number")
        for (i in listOfTodo.indices) {
            println("(${i + 1}) ${listOfTodo[i].task}")
        }
            val selection = scanner.nextInt()

            for (i in listOfTodo.indices) {
                if (selection == i + 1) {
                    if (!listOfTodo[i].isComplete) {
                        listOfTodo[i].task = "Completed -> ${listOfTodo[i].task}"
                        listOfTodo[i].isComplete = true
                    } else {
                        println("This task is already done")
                    }
                }
            }
            println("---------------------------------------------")
            for (i in listOfTodo.indices) {
                println("(${i + 1}) ${listOfTodo[i].task}")
            }
            println("---------------------------------------------")
        }else if (first == 4) {
            println("Select the todo to delete")
            for (i in listOfTodo.indices) {
                println("(${i + 1}) ${listOfTodo[i].task}")
            }
            val option = scanner.nextInt()
            for (i in listOfTodo.indices) {
                if (option == i+1) {
                    listOfTodo.remove(listOfTodo[i])
                }
            }
            println("---------------------------------------------")
            for (i in listOfTodo.indices) {
                println("(${i + 1}) ${listOfTodo[i].task}")
            }
            println("---------------------------------------------")
        }else if (first == 5) {
            break
        }else{
            println("you can only select 1 , 2, 3, 4 or 5")
        }
    }

}