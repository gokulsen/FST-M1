fruits = {
    "apple": "100",
    "orange": "50",
    "mango": "50"
}

checkFruit = input("Which fruit are you looking for? ").lower()

if(checkFruit in fruits):
    print(checkFruit + " available - " + " Price is " + fruits.get(checkFruit))
else:
    print(checkFruit + " not available - " + fruits.get(checkFruit))