inputData = (input("Enter a sequence of comma separated values for list: "))
numList = list(inputData.split(","))


def calculate_sum(numbers):
    total = 0
    for number in numbers:
        total += int(number)
    return total


result = calculate_sum(numList)

print("Sum of all the elements is: " + str(result))
