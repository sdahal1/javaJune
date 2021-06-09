class BankAccount:
    def __init__(self, firstNameInput, lastNameInput):
        self.firstName = firstNameInput
        self.lastName = lastNameInput
        self.accountBalance = 0

    def deposit(self, amount):
        self.accountBalance += amount




jeffBezosAccount = BankAccount("Jeff", "Bezos")
LilWayneAccount = BankAccount("Wayne", "Carter")
jcoleAccount = BankAccount("Jermaine", "Cole")

print(jeffBezosAccount.firstName)
print(LilWayneAccount.firstName)


jeffBezosAccount.deposit(1000000)
LilWayneAccount.deposit(5)

print(jeffBezosAccount.accountBalance)
print(LilWayneAccount.accountBalance)


