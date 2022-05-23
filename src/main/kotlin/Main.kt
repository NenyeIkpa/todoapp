
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
            Todo().addTodo(whatTodo)
        }else if (first == 2){
            Todo().listTodos()
            Todo().printLine()
        } else if (first == 3) {//to mark complete
        println("To mark as done, select todo by number")
             Todo().listTodos()
            Todo().printLine()
            val selection = scanner.nextInt()
            Todo().markCompleted(selection)
        }else if (first == 4) {
            println("Select the todo to delete")
            Todo().listTodos()
            Todo().printLine()
            val option = scanner.nextInt()
            Todo().deleteTodo(option)
        }else if (first == 5) {
            break
        }else{
            println("you can only select 1 , 2, 3, 4 or 5")
        }
    }

}