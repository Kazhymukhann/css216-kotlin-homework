package hw1.task07

fun main() {
    println(displayAlertMessage("Chrome OS", "sample@gmail.com"))
    println()
    println(displayAlertMessage(emailId = "user_one@gmail.com"))
    println()
    println(displayAlertMessage("Windows", "user_two@gmail.com"))
    println()
    println(displayAlertMessage("Mac OS", "user_three@gmail.com"))
}

fun displayAlertMessage(operatingSystem: String = "Unknown OS", emailId: String): String {
    return "There's a new sign-in request on $operatingSystem for your Google Account $emailId."
}
