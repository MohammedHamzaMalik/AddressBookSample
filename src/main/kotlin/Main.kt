interface Contact {
    val firstName: String
    val lastName: String
    val email: String
    val address: String
    fun getName(): String
}
interface AddContact {
    fun addContact(contact: Contact)
}
interface DeleteContact {
    fun deleteContact()
}
interface ContactGroup {
    val groupName: String
    fun getContacts(): List<Contact>
}
fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}