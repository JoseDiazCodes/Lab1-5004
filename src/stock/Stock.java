package stock;

/**
 * Represents a stock to be traded.
 * This class encapsulates information about a stock, including its symbol,
 * name, cost basis, and current price.
 */
public class Stock {
  private String name;
  private String symbol;
  private double currentPrice;
  private double costBasis;

  /**
   * Constructs a new Stock object.
   *
   * @param symbol    the stock symbol
   * @param name      the name of the company
   * @param costBasis the initial cost basis of the stock
   */
  public Stock(String symbol, String name, double costBasis) {
    this.symbol = symbol;
    this.name = name;
    this.costBasis = costBasis;
    this.currentPrice = costBasis;
  }

  /**
   * Gets the stock symbol.
   *
   * @return the stock symbol
   */
  public String getSymbol() {
    return symbol;
  }

  /**
   * Gets the name of the company.
   *
   * @return the name of the company
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the cost basis of the stock.
   *
   * @return the cost basis
   */
  public double getCostBasis() {
    return costBasis;
  }

  /**
   * Gets the current price of the stock.
   *
   * @return the current price
   */
  public double getCurrentPrice() {
    return currentPrice;
  }

  /**
   * Sets the cost basis of the stock.
   *
   * @param costBasis the new cost basis to set
   */
  public void setCostBasis(double costBasis) {
    this.costBasis = costBasis;
  }

  /**
   * Sets the current price of the stock.
   *
   * @param currentPrice the new current price to set
   */
  public void setCurrentPrice(double currentPrice) {
    this.currentPrice = currentPrice;
  }

  /**
   * Calculates the fractional change between the original cost basis and the current price.
   *
   * @return the fractional change as a decimal (e.g., 0.05 for a 5% increase)
   */
  public double getChangePercent() {
    return (currentPrice - costBasis) / costBasis;
  }

  /**
   * Returns a string representation of the Stock.
   * The string includes the company name, current price, and gain/loss percentage.
   *
   * @return a formatted string representation of the Stock
   */
  @Override
  public String toString() {
    double changePercent = getChangePercent() * 100;
    return String.format(
            "%s Current Price: $%.2f\n Gain/Loss: %.2f%%",
            name, currentPrice, changePercent
    );
  }
}