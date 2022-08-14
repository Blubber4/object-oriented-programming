public class Movie
{
  private String title;
  private double income;
  private double expense;

  public Movie(String title, Double income, Double expense)
  {
    this.title = title;
    this.income = income;
    this.expense = expense;
  }

  public Double getProfit()
  {
    return income - expense;
  }

  /* returns the title and the movie's profit separated by a tab */
  public String profitToRecord()
  {
    return title + "\t" + getProfit();
  }
}