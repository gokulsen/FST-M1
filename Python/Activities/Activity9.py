list1s = [1,2,3,4,5]
list2s = [6,7,8,9,10]

newList1 = []
newList2 = []

for list1 in list1s:
    if (list1 % 2 == 0):
        newList1.append(list1)
    else:
        newList2.append(list1)

for list2 in list2s:
    if (list2 % 2 == 0):
        newList1.append(list2)
    else:
        newList2.append(list2)

print(newList1)
print(newList2)

        
    



