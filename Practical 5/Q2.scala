import scala.io.StdIn.readLine
class Book(val title:String, val author: String, val isbn:String)
var library: Set[Book] = Set()
def addBook(): Unit = {
    println("Enter the title of the book: ")
    val title = readLine()
    println("Enter the author of the book: ")
    val author = readLine()
    println("Enter the ISBN of the book: ")
    val isbn = readLine()

    val book = new Book(title, author, isbn)
    library += book
    println(s"Book '${book.title}' added to the library.")
}

def removeBook(): Unit = {
    println("Enter the ISBN of the book to remove:")
    val isbn = readLine()
    library.find(_.isbn == isbn) match {
        case Some(book) =>
            library -= book
            println(s"Book '${book.title}' removed from the library.")
        case None =>
            println(s"No book found with ISBN $isbn.")
    }
}

def isBookInLibrary(): Unit = {
    println("Enter the ISBN of the book to check:")
    val isbn = readLine()
    val exists = library.exists(_.isbn == isbn)
    println(s"Is book with ISBN $isbn in the library? $exists")
}

def displayLibrary(): Unit = {
    println("Current Library Collection:")
    library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
}

def searchByTitle(): Unit = {
    println("Enter the title of the book to search: ")
    val title = readLine()
    library.find(_.title.equalsIgnoreCase(title)) match {
        case Some(book) =>
            println(s"Book Found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
        case None =>
            println(s"No book found with title '$title'.")
    }
}

def displayBooksByAuthor(): Unit = {
    println("Enter the author to search for:")
    val author = readLine()
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
        println(s"Books by $author:")
        booksByAuthor.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    } else {
        println(s"No books found by author '$author'.")
    }
}

def mainMenu(): Unit = {
    var continue = true
    while (continue){
        println("Choose an option: ")
        println("   1. Add a book")
        println("   2. Remove a book")
        println("   3. Check if a book is in the library")
        println("   4. Display all books")
        println("   5. Search for a book by title")
        println("   6. Display books by author")
        println("   7. Exit")
    

        val choice = readLine().toInt
    
        choice match {
            case 1 => addBook()
            case 2 => removeBook()
            case 3 => isBookInLibrary()
            case 4 => displayLibrary()
            case 5 => searchByTitle()
            case 6 => displayBooksByAuthor()
            case 7 => continue = false
            case _ => println("Invalid choice. Please try again.")
        }
    }
}

@main def main(): Unit = {
    mainMenu()
}
