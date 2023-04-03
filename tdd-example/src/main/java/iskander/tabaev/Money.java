package iskander.tabaev;

public  class Money implements Expression
{
    protected int amount;

    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;

    }

    protected String currency() {
        return this.currency;
    }



    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public Expression plus(Money added){
         return new Sum(this, added);
    }

    @Override
    public Money reduce(Bank bank, String to){
//        int rate = (currency.equals("CHF") && to.equals("USD")?2:1);
        return new Money(amount/bank.rate(this.currency, to), to);
    }

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;
        return this.amount == money.amount &&
                this.currency.equals(money.currency);
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }
}
