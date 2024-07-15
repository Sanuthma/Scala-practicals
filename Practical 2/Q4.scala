def attendees(ticketPrice:Double):Double={
    120 + (15-ticketPrice)*4
}
def cost(ticketPrice:Double):Double={
    var noOfShows=(attendees(ticketPrice)/120)
    if(noOfShows<=1){
        noOfShows=1
    }
    else{
        noOfShows=2
    }
    noOfShows * 500 + attendees(ticketPrice)*3
}
def income(ticketPrice:Double):Double={
    attendees(ticketPrice)*ticketPrice

}

def profit(ticketPrice:Double):Double={
    income(ticketPrice)-cost(ticketPrice)
}
@main def filmHall()={
    println(profit(15))
    println(profit(20))
    println(profit(25))
    println(profit(30))
}