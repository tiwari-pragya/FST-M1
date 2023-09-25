inputData = (input("Enter a sequence of comma separated values: "))
numList = list(inputData.split(","))

first = numList[0]
last = numList[-1]

print("First element in the list: " + first)
print("Last element in the list: " + last)

if first == last:
    print(True)
else:
    print(False)