data class Todo(
    var task: String = "",
    var isComplete: Boolean = false
) {
   companion object{
        var listOfTodo : MutableList<Todo> = mutableListOf(
           Todo("Record screen cast"),
           Todo("Check the kids"),
           Todo("**Go to the store", true),
           Todo("Reply emails"))
   }
    fun addTodo(task : String) {
        this.task = task
        listOfTodo.add(this)
    }

    fun listTodos() {
        for (i in listOfTodo.indices){
            println("(${i+1}) ${listOfTodo[i].task}")
        }
    }

    fun markCompleted(selection : Int) {
        for (i in listOfTodo.indices) {
            if (selection == i + 1) {
                if (!listOfTodo[i].isComplete) {
                    listOfTodo[i].task = "**${listOfTodo[i].task}"
                    listOfTodo[i].isComplete = true
                } else {
                    println("This task is already done")
                }
            }
        }
    }

    fun deleteTodo(option : Int) {
        for (i in listOfTodo.indices) {
            if (option == i+1) {
                listOfTodo.remove(listOfTodo[i])
            }
        }
    }
    fun printLine() {
        println("---------------------------------------------")
    }
}