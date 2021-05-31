list = []
getNum = int(input('How many numbers: '))
for n in range(getNum):
    numbers = int(input('Enter number: '))
    list.append(numbers)

def addList(numbers):
    sum = 0
    for num in numbers:
        sum += num
    return sum

result = addList(list)
print(result)