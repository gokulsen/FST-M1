
while True:
    print("Lets the game begins")

    p1 = input("Player 1 - Enter your choice: ").lower()
    p2 = input("Player 2 - Enter your choice: ").lower()

    if (p1==p2):
        print("Draw - Both Wins")
    elif (p1=="rock"):
        if (p2=="scissors"):
            print("Rock wins")
        else:
            print("Paper wins")
    elif (p1=="scissors"):
        if (p2=="paper"):
            print("Scissors Wins")
        else:
            print("Rock Wins")
    elif (p1=="paper"):
        if (p2=="rock"):
            print("Paper Wins")
        else:
            print("Scissors Wins")

    startAgain = input("Do you want to play again: ").lower()

    if (startAgain=="yes"):
        continue
    elif (startAgain=="no"):
        break
