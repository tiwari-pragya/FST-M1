import pandas

data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
}

csvData = pandas.DataFrame(data)

print(csvData)

# csvData.to_csv("Activity17_Output.csv")
csvData.to_csv("Activity17_Output.csv", index=False)
