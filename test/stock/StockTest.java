package stock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * Test class for the Stock class.
 * This class contains unit tests to verify the functionality of the Stock class methods.
 */
public class StockTest {
  private Stock stock;

  /**
   * Sets up the test environment before each test.
   * Creates a new Stock object with predefined values.
   */
  @BeforeEach
  public void setUp() {
    stock = new Stock("AAPL", "Apple Computer", 150.00);
  }

  /**
   * Tests if the Stock constructor creates a non-null object.
   */
  @Test
  public void testConstructor() {
    assertNotNull(stock, "Stock object should be created");
  }

  /**
   * Tests the getSymbol method.
   */
  @Test
  public void testGetSymbol() {
    assertEquals(
            "AAPL", stock.getSymbol(), "Symbol should be correctly returned");
  }

  /**
   * Tests the getName method.
   */
  @Test
  public void testGetName() {
    assertEquals(
            "Apple Computer",
            stock.getName(), "Name should be correctly returned");
  }

  /**
   * Tests the getCostBasis method.
   */
  @Test
  public void testGetCostBasis() {
    assertEquals(
            150.00,
            stock.getCostBasis(),
            0.001, "Cost basis should be correctly returned");
  }

  /**
   * Tests the getCurrentPrice method after setting a new price.
   */
  @Test
  public void testGetCurrentPrice() {
    stock.setCurrentPrice(160.00);
    assertEquals(
            160.00,
            stock.getCurrentPrice(),
            0.001, "Current price should be correctly returned");
  }

  /**
   * Tests the setCostBasis method.
   */
  @Test
  public void testSetCostBasis() {
    stock.setCostBasis(155.00);
    assertEquals(155.00,
            stock.getCostBasis(),
            0.001,
            "Cost basis should be set correctly");
  }

  /**
   * Tests the setCurrentPrice method.
   */
  @Test
  public void testSetCurrentPrice() {
    stock.setCurrentPrice(165.00);
    assertEquals(165.00,
            stock.getCurrentPrice(),
            0.001, "Current price should be set correctly");
  }

  /**
   * Tests the getChangePercent method for a positive change.
   */
  @Test
  public void testGetChangePercent() {
    stock.setCurrentPrice(165.00);
    assertEquals(0.10,
            stock.getChangePercent(),
            0.001,
            "Change percent should be calculated correctly");
  }

  /**
   * Tests the getChangePercent method for a negative change.
   */
  @Test
  public void testGetChangePercentNegative() {
    stock.setCurrentPrice(135.00);
    assertEquals(-0.10,
            stock.getChangePercent(),
            0.001,
            "Negative change percent should be calculated correctly");
  }

  /**
   * Tests the toString method for a stock with a positive change.
   */
  @Test
  public void testToString() {
    stock.setCurrentPrice(157.80);
    String expected = "Apple Computer Current Price: $157.80\n Gain/Loss: 5.20%";
    assertEquals(
            expected, stock.toString(), "toString should format the output correctly");
  }

  /**
   * Tests the toString method for a stock with a negative change.
   */
  @Test
  public void testToStringNegativeChange() {
    stock.setCurrentPrice(142.50);
    String expected = "Apple Computer Current Price: $142.50\n Gain/Loss: -5.00%";
    assertEquals(
            expected, stock.toString(),
            "toString should format negative change correctly");
  }

  /**
   * Tests the constructor with a negative cost basis.
   * Verifies that the Stock object is created correctly even with a negative initial cost.
   */
  @Test
  public void testConstructorNegativeCostBasis() {
    Stock negativeStock = new Stock("TSLA", "Tesla Inc", -100.00);
    assertEquals(
            -100.00,
            negativeStock.getCostBasis(),
            0.001, "Negative cost basis should be allowed");
  }

  /**
   * Tests the setCurrentPrice method with a negative price.
   * Verifies that a negative current price can be set and retrieved correctly.
   */
  @Test
  public void testSetNegativeCurrentPrice() {
    stock.setCurrentPrice(-50.00);
    assertEquals(-50.00,
            stock.getCurrentPrice(),
            0.001,
            "Negative current price should be set correctly");
  }

  /**
   * Tests the getChangePercent method when the current price is zero.
   * Verifies that the method handles division by zero gracefully.
   */
  @Test
  public void testGetChangePercentZeroCurrentPrice() {
    stock.setCurrentPrice(0.00);
    assertEquals(-1.0,
            stock.getChangePercent(),
            0.001,
            "Change percent should handle zero current price");
  }

  /**
   * Tests the getChangePercent method when the cost basis is zero.
   * Verifies that the method handles division by zero gracefully.
   */
  @Test
  public void testGetChangePercentZeroCostBasis() {
    Stock zeroStock = new Stock("ZERO", "Zero Corp", 0.00);
    zeroStock.setCurrentPrice(100.00);
    assertTrue(
            Double.isInfinite(zeroStock.getChangePercent()),
            "Change percent should be infinite for zero cost basis");
  }

  /**
   * Tests the toString method when the current price is equal to the cost basis.
   * Verifies that the string representation shows 0% change correctly.
   */
  @Test
  public void testToStringNoChange() {
    stock.setCurrentPrice(150.00);
    String expected = "Apple Computer Current Price: $150.00\n Gain/Loss: 0.00%";
    assertEquals(expected,
            stock.toString(), "toString should format zero change correctly");
  }

  /**
   * Tests the toString method with very large numbers.
   * Verifies that the string representation handles large numbers correctly.
   */
  @Test
  public void testToStringLargeNumbers() {
    Stock largeStock = new Stock(
            "BRK.A",
            "Berkshire Hathaway",
            100000.00);
    largeStock.setCurrentPrice(500000.00);
    String expected = "Berkshire Hathaway Current Price: $500000.00\n Gain/Loss: 400.00%";
    assertEquals(
            expected,
            largeStock.toString(),
            "toString should format large numbers correctly");
  }

  /**
   * Tests setting and getting a very small (near-zero) current price.
   * Verifies that the Stock class can handle very small numbers accurately.
   */
  @Test
  public void testVerySmallCurrentPrice() {
    stock.setCurrentPrice(0.000001);
    assertEquals(0.000001,
            stock.getCurrentPrice(),
            0.0000000001,
            "Very small current price should be set and retrieved accurately");
  }

  /**
   * Tests the getChangePercent method for a very large positive change.
   * Verifies that the percentage change is calculated correctly for a large price increase.
   */
  @Test
  public void testGetChangePercentLargePositive() {
    stock.setCurrentPrice(15000.00);
    assertEquals(
            99.0,
            stock.getChangePercent(),
            0.001,
            "Large positive change percent should be calculated correctly");
  }
}