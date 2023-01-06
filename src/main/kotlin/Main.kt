interface AddressBook{
    fun addContact(contact: Contact)
    fun deleteContact(contact: Contact)
    fun searchContact(name: String): List<Contact>
    fun updateContact(contact: Contact)
    fun createGroup(group: Group)
    fun deleteGroup(group: Group)
    fun searchGroup(groupName: String): List<Group>
//    fun addContactToGroup(contact: Contact, groupName: String)
//    fun delContactFromGroup(contact: Contact, groupName: String)
//    fun searchContactInGroup(groupName: String): List<Contact>
}

data class Contact(val name:String,val phoneNumber: Int, val email: String, val address: String)

data class Group(val name: String, val contacts: List<Contact>)

class AddressBookMain: AddressBook {
    val contacts = mutableListOf<Contact>()
    val groups = mutableListOf<Group>()

    override fun addContact(contact: Contact) {
        contacts.add(contact)
    }
    override fun deleteContact(contact: Contact){
        contacts.remove(contact)
    }
    override fun searchContact(name: String): List<Contact> {
        return contacts.filter { it.name == name }
    }

    override fun updateContact(contact: Contact) {
        contacts[contacts.indexOf(contact)]=contact
    }
    override fun createGroup(group: Group){
        groups.add(group)
    }

    override fun deleteGroup(group: Group) {
        groups.remove(group)
    }

    override fun searchGroup(groupName: String): List<Group> {
        return groups.filter{it.name==groupName}
    }
}


fun main() {
    val addressBookObj = AddressBookMain()
    val c1 = Contact("Hamza",1,"hamza@g.com","ST")
    val c2 = Contact("Shivam",2,"shivam@g.com","BR")
    val c3 = Contact("Parth",3,"parth@g.com","BNG")
    val c4 = Contact("Lakhu sir",4,"lakhu@g.com","BRC")

    addressBookObj.addContact(c1)
    addressBookObj.addContact(c2)
    addressBookObj.deleteContact(c3)
    addressBookObj.addContact(c4)

    val searchC = addressBookObj.searchContact("Lakhu sir")
    println(searchC)

    val g1 = Group("Interns", listOf(c1,c2))
    val g2 = Group("Leaders", listOf(c4))

    addressBookObj.createGroup(g1)
    addressBookObj.createGroup(g2)

    val searchG = addressBookObj.searchGroup("Interns")
    println(searchG)

}