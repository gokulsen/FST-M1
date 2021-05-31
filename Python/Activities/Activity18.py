import pandas

dataframe = pandas.read_csv("credentials.csv")

print("Usernames: ")
print(dataframe["Usernames"])
print("==============================")

print("Username: ", dataframe["Usernames"][1], "and", "Password: ", dataframe["Passwords"][1])
print("==============================")

print("Usernames Sorted in ascending order: ")
print(dataframe.sort_values('Usernames', ascending=True))
print("==============================")

print("Passwords sorted in descending order: ")
print(dataframe.sort_values('Passwords', ascending=False))