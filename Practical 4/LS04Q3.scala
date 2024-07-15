def toUpper(s: String): String = {
    s.map { char => 
        if char >= 'a' && char <= 'z' then
            (char - 32).toChar    
        else
            char
    }
}

def toLower(s: String): String = {
    s.map { char =>
        if char >= 'A' && char <= 'Z' then
            (char + 32).toChar
        else
            char    
    }
}

def formatNames(name: String)(formatFunc: String => String): String = {
    formatFunc(name)
}

@main def main(): Unit = {
    val names = List("Benny","Niroshan","Saman","Kumara")

    println(formatNames(names(0))(toUpper))
    println(formatNames(names(1)) { name =>
        val fPart = toUpper(name.substring(0,2))
        val sPart = toLower(name.substring(2))
        fPart + sPart
    })

    println(formatNames(names(2))(toLower))
    println(formatNames(names(3)) { name => 
        val fPart = toUpper(name.substring(0, 1))
        val sPart = toLower(name.substring(1, 5))
        val lPart = toUpper(name.substring(5))
        fPart + sPart + lPart
    })
}