def format_euro(amount):
    euros = amount / 100
    if euros.is_integer():
        return f"{int(euros)}"  # Convert to int to remove decimal
    else:
        return f"{euros}".replace(".", ",")
    
def change_calculator(due_amount=16.09, paid_amount=50):
    """ 
    Arg:
       due_amount(float): The amount that is due from the customer to be paid.
       paid_amount(float): The amount paid by the customer in cash.
   
    """
    bills = [500, 200, 100, 50, 20, 10, 5]
    coins = [2.0, 1.0, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01]
    
    denominations = {"bills": bills, "coins": coins}
    
    denom_cents = [a*100 for b in (bills,coins) for a in b]
    
    cash_topay = int(round((paid_amount - due_amount) * 100))
    
    # Split into bills and coins
    bills_dict = {}
    coins_dict = {}

    for val in denom_cents:
        if cash_topay >= val:
            count = cash_topay // val
            if val > 500:
                bills_dict[val] = count
            else:
                coins_dict[val] = count
            cash_topay %= val

    # Print output
    print("The cashier has to return to the customer:")
    if bills_dict:
        print("BILLS:")
        for d, c in bills_dict.items():
            bills_euro = format_euro(d)
            print(f"    {bills_euro} Euro bills: {int(c)}")

    if coins_dict:
        print("COINS:")
        for d, c in sorted(coins_dict.items(), reverse=True):
            coins_euro = format_euro(d)
            print(f"    {coins_euro} Euro coins: {int(c)}")


if __name__ == "__main__":    
    change_calculator(16.09,50)
