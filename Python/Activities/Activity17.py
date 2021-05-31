import pandas

data = {
  "Usernames": ["admin", "Charles", "Deku"],
  "Passwords": ["password", "Charl13", "AllMight"]
}

dataframe = pandas.DataFrame(data)
dataframe.to_csv("credentials.csv")