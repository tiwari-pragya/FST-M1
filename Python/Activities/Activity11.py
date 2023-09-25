fruit_shop = {
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peaches": 15,
    "guava": 20,
    "kiwi": 50
}

fruit = input("Which fruit are you looking for?").lower()

if fruit in fruit_shop:
    print("Yes, " + fruit + " is available")
else:
    print("No, " + fruit + " is not available")
