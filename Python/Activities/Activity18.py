import pandas

csvData = pandas.read_csv("Activity17_Output.csv")

print("Data present in csv file: ")
print(csvData)

print("")
print("Usernames present in csv file:")
print(csvData["Usernames"])

print("Data present in second row")
print("Username: ", csvData["Usernames"][1], " and ", "Password: ", csvData["Passwords"][1])

print("")
print("Data sorted in ascending order for Usernames:")
print(csvData.sort_values('Usernames', ascending=True))

print("")
print("Data sorted in descending order for Passwords:")
print(csvData.sort_values('Passwords', ascending=False))
