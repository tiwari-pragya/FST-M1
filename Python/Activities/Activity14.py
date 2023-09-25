def fibonacci(number):
    if number <= 1:
        return number
    else:
        return fibonacci(number - 1) + fibonacci(number - 2)


num = int(input("Enter the number of elements to print in fibonacci series: "))

if num <= 0:
    print("Please enter a positive number")
else:
    print("Fibonacci Sequence: ")
    for i in range(num):
        print(fibonacci(i))
