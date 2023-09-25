# Use while loop for continuous execution
while True:
    # user input
    user1_input = input("What does Player 1 choose- rock, paper or scissor? ").lower()
    user2_input = input("What does Player 2 choose- rock, paper or scissor? ").lower()

    # write logic
    if user1_input == user2_input:
        print("It's a tie!")
    elif user1_input == 'rock':
        if user2_input == 'scissor':
            print("Rock wins!")
        else:
            print("Paper wins!")
    elif user1_input == 'scissor':
        if user2_input == 'paper':
            print("Scissor wins!")
        else:
            print("Rock wins!")
    elif user1_input == 'paper':
        if user2_input == 'rock':
            print("Paper wins!")
        else:
            print("Scissor wins!")
    else:
        print("Invalid input! You have not entered rock, paper or scissor, please try again.")

    # Ask them if they want to play again
    repeat = input("Do you want to play another round? Yes/No: ").lower()

    if repeat == "yes":
        pass
    elif repeat == "no":
        raise SystemExit
    else:
        print("Invalid option entered. Exiting now.")
        raise SystemExit
