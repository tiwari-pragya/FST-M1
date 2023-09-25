def getSum(num):
    if num:
        # Recursive function call
        return num + getSum(num - 1)
    else:
        return 0


res = getSum(10)

print(res)
