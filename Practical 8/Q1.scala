def encrypt(text: String, shift: Int): String = {
    val adjustedShift = shift % 26
    text.map { char =>
        if (char.isLetter) {
            val base = if (char.isUpper) 'A' else 'a'
            ((char - base + adjustedShift) % 26 + base).toChar
        } else {
            char
        }
    }
}

def decrypt(text: String, shift: Int): String = {
    val adjustedShift = (26 - shift % 26) % 26
    text.map { char =>
        if (char.isLetter) {
            val base = if (char.isUpper) 'A' else 'a'
            ((char - base + adjustedShift) % 26 + base).toChar
        } else {
            char
        }
    }
}

def cipher(text: String, shift: Int, func: (String, Int) => String): String = {
    func(text, shift)
}

@main def main1 : Unit ={
    val plaintext = "Sanuthma Munasinghe"
    val shift = 3

    val encryptedText = cipher(plaintext, shift, encrypt)
    println(s"Encrypted: $encryptedText")

    val decryptedText = cipher(encryptedText, shift, decrypt)
    println(s"Decrypted: $decryptedText")
} 

