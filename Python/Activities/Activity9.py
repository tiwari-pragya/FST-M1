inputData = (input("Enter a sequence of comma separated values for 1st list: "))
listOne = list(inputData.split(","))
inputData = (input("Enter a sequence of comma separated values for 2nd list: "))
listTwo = list(inputData.split(","))
listThree = []

# Print the lists
print("1st List: ", listOne)
print("2nd List: ", listTwo)

for num in listOne:
    if int(num) == 0:
        pass
    else:
        if int(num) % 2 != 0:
            listThree.append(num)

for num in listTwo:
    if int(num) == 0:
        pass
    else:
        if int(num) % 2 == 0:
            listThree.append(num)

print("Final list is: ")
print(listThree)
