import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class InstockTest {
    private Instock iterator;
    private Product product;
    private static final String LABEL = "Test";
    private static final double PRICE = 10.5;
    private static final int QUANTITY = 10;
    private static final List<Product> products = List.of(
            new Product("C", 1, 0),
            new Product("B", 2, 1),
            new Product("A", 3, 2)
    );

    @Before
    public void setUp() {
        iterator = new Instock();
        product = new Product(LABEL, PRICE, QUANTITY);
        iterator.add(product);
    }

    @Test
    public void getCount() {
        assertEquals(1, iterator.getCount());
        iterator.add(product);
        assertEquals(2, iterator.getCount());
    }

    @Test
    public void containsReturnsFalseForNotAddedProduct() {
        assertFalse(iterator.contains(new Product("Non-existing", PRICE, QUANTITY)));
    }

    @Test
    public void containsReturnsTrueForAddedProduct() {
        assertTrue(iterator.contains(product));
    }

    @Test
    public void changeQuantityForAddedProduct() {
        iterator.changeQuantity(LABEL, 9);
        assertEquals(9, iterator.findByLabel(LABEL).getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityThrowsForNonExistingProduct() {
        iterator.changeQuantity("Non-existing", 9);
    }

    @Test
    public void findProductOnExistingIndex() {
        assertEquals(product, iterator.find(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findThrowsForInvalidIndex() {
        iterator.find(1);
    }

    @Test
    public void findByLabelForExistingProduct() {
        assertEquals(iterator.findByLabel(LABEL), product);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabelThrowsForNonExistingProduct() {
        iterator.findByLabel("Non-existing");
    }

    @Test
    public void findFirstByAlphabeticalOrder() {
        for (Product pr : products) {
            iterator.add(pr);
        }
        int n = 2;
        for (Product pr : iterator.findFirstByAlphabeticalOrder(3)) {
            assertEquals(products.get(n--), pr);
        }
    }

    @Test
    public void findFirstByAlphabeticalOrderReturnsEmptyForOutOfRangeArg() {
        Iterable<Product> iter = iterator.findFirstByAlphabeticalOrder(2);
        int count = 0;
        for (Product pr : iter) {
            count++;
        }
        assertEquals(0, count);
    }

    @Test
    public void findAllInPriceRange() {
        for (Product pr : products) {
            iterator.add(pr);
        }
        Iterable<Product> matches = iterator
                .findAllInRange(products.get(0).getPrice(), products.get(products.size() - 1).getPrice());
        int n = products.size() - 1;
        for (Product match : matches) {
            assertEquals("matches are in descending order", match, products.get(n--));
        }
        assertEquals("lower end is exclusive", n, 0);

    }

    @Test
    public void findAllInPriceRangeReturnsEmptyCollectionWhenNoMatches() {
        Iterable<Product> matches = iterator
                .findAllInRange(products.get(0).getPrice(), products.get(products.size() - 1).getPrice());
        int n = 0;
        for (Product match : matches) {
            n++;
        }
        assertEquals(n, 0);

    }

    @Test
    public void findAllByPrice() {
        iterator.add(product);
        Iterable<Product> matches = iterator
                .findAllByPrice(PRICE);
        int n = 0;
        for (Product match : matches) {
            assertEquals(match.getPrice(), product.getPrice(), 0.00);
            n++;
        }
        assertEquals(n, 2);
    }

    @Test
    public void findAllByPriceReturnsEmptyCollectionWhenNoMatches() {
        Iterable<Product> matches = iterator
                .findAllByPrice(1);
        int n = 0;
        for (Product match : matches) {
            n++;
        }
        assertEquals(n, 0);

    }


    @Test
    public void findFirstMostExpensiveProducts() {
        for (Product pr : products) {
            iterator.add(pr);
        }
        Iterable<Product> matches = iterator.findFirstMostExpensiveProducts(2);
        int n = 0;
        for (Product match : matches) {
            if (n == 0) {
                assertEquals(product, match);
            }
            if (n == 1) {
                assertEquals(products.get(products.size() - 1), match);
            }
            n++;
        }
        assertEquals(2, n);

    }

    @Test(expected = IllegalArgumentException.class)
    public void findFirstMostExpensiveProductsThrowsForCountGreaterThanCollectionSize() {
        iterator.findFirstMostExpensiveProducts(2);
    }

    @Test
    public void findAllByQuantity() {
        iterator.add(product);
        Iterable<Product> matches = iterator
                .findAllByQuantity(QUANTITY);
        int n = 0;
        for (Product match : matches) {
            assertEquals(match.getQuantity(), product.getQuantity());
            n++;
        }
        assertEquals(n, 2);

    }

    @Test
    public void findAllByQuantityReturnsEmptyCollectionWhenNoMatches() {
        Iterable<Product> matches = iterator
                .findAllByQuantity(1);
        int n = 0;
        for (Product match : matches) {
            n++;
        }
        assertEquals(n, 0);

    }

    @Test
    public void iterator() {
        for (Product pr : products) {
            iterator.add(pr);
        }
        Iterator<Product> iter = this.iterator.iterator();
        int index = -1;
        while (iter.hasNext()) {
            Product next = iter.next();
            if (index == -1) {
                assertEquals(product, next);
                index++;
            } else {
                assertEquals(products.get(index++), next);
            }
        }

    }
}