inputData = (input("Enter a sequence of comma separated values: "))
numList = list(inputData.split(","))

numSum = 0
i = 0

for number in numList:
    numSum += int(number)
    print("number at position " + str(i) + " is : " + number)
    i = i + 1

print(numSum)
