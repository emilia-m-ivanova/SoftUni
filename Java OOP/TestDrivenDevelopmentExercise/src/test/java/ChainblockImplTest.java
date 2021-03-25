import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private Chainblock chainBlock;
    private final Transaction[] transactions = {
            new TransactionImpl(4, TransactionStatus.ABORTED, "C", "H", 10.5),
            new TransactionImpl(3, TransactionStatus.FAILED, "C", "H", 10.5),
            new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "C", "H", 20.5),
            new TransactionImpl(1, TransactionStatus.UNAUTHORIZED, "B", "G", 30.5),
            new TransactionImpl(0, TransactionStatus.UNAUTHORIZED, "A", "F", 40.5)
    };


    @Before
    public void setUp() {
        this.chainBlock = new ChainblockImpl();
    }

    @Test
    public void getCount() {
        assertEquals("Empty collection", 0, this.chainBlock.getCount());
        addTransactions();
        assertEquals("Method returns correct value.", transactions.length, this.chainBlock.getCount());

    }

    @Test
    public void testContainsByTransaction() {
        boolean containsFalse = this.chainBlock.contains(transactions[0]);
        assertFalse("Empty collection does not contain transaction", containsFalse);
        addTransactions();
        for (int i = 0; i < transactions.length; i++) {
            boolean containsTrue = this.chainBlock.contains(transactions[i]);
            assertTrue("Collection contains transaction at index" + i, containsTrue);
        }
    }

    @Test
    public void testContainsById() {
        boolean containsFalse = this.chainBlock.contains(transactions[0].getId());
        assertFalse("Empty collection does not contain transaction", containsFalse);
        addTransactions();
        for (int i = 0; i < transactions.length; i++) {
            boolean containsTrue = this.chainBlock.contains(transactions[i].getId());
            assertTrue("Collection contains transaction at index" + i, containsTrue);
        }
    }

    @Test
    public void changeTransactionStatus() {
        addTransactions();
        chainBlock.changeTransactionStatus(1, TransactionStatus.SUCCESSFUL);
        Transaction transaction = chainBlock.getById(1);
        assertEquals(TransactionStatus.SUCCESSFUL, transaction.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionStatusThrowsForNonExistingTransaction() {
        addTransactions();
        chainBlock.changeTransactionStatus(5, TransactionStatus.ABORTED);
    }

    @Test
    public void removeTransactionById() {
        addTransactions();
        chainBlock.removeTransactionById(1);
        assertFalse(chainBlock.contains(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeTransactionByIdThrowsForNonExistingTransaction() {
        chainBlock.removeTransactionById(1);
    }

    @Test
    public void getById() {
        addTransactions();
        Transaction transaction = chainBlock.getById(transactions[0].getId());
        assertEquals(transactions[0], transaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByIdThrowsForNonExistingTransaction() {
        chainBlock.getById(transactions[0].getId());
    }

    @Test
    public void getByTransactionStatus() {
        addTransactions();
        Iterable<Transaction> results = chainBlock.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
        int index = transactions.length - 1;
        for (Transaction result : results) {
            assertEquals(transactions[index--], result);
        }
        assertEquals(transactions.length - 3, index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByTransactionStatusThrowsForNoResultsFound() {
        chainBlock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void getAllSendersWithTransactionStatus() {
        addTransactions();
        Iterable<String> results = chainBlock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
        int index = transactions.length - 1;
        for (String result : results) {
            assertEquals(transactions[index--].getFrom(), result);
        }
        assertEquals(transactions.length - 3, index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllSendersWithTransactionStatusThrowsForNoResultsFound() {
        chainBlock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void getAllReceiversWithTransactionStatus() {
        addTransactions();
        Iterable<String> results = chainBlock.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
        int index = transactions.length - 1;
        for (String result : results) {
            assertEquals(transactions[index--].getTo(), result);
        }
        assertEquals(transactions.length - 3, index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllReceiversWithTransactionStatusThrowsForNoResultsFound() {
        chainBlock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }


    @Test
    public void getAllOrderedByAmountDescendingThenById() {
        addTransactions();
        Iterable<Transaction> results = chainBlock.getAllOrderedByAmountDescendingThenById();
        int index = transactions.length - 1;
        for (Transaction tr : results) {
            assertEquals(transactions[index--], tr);
        }
        assertEquals(-1, index);
    }

    @Test
    public void getBySenderOrderedByAmountDescending() {
        addTransactions();
        Iterable<Transaction> results = chainBlock.getBySenderOrderedByAmountDescending("C");
        int index = 2;
        for (Transaction transaction : results) {
            assertEquals(transactions[index--], transaction);
        }
        assertEquals(-1, index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderOrderedByAmountDescendingThrowsForNoResultsFound() {
        chainBlock.getBySenderOrderedByAmountDescending("C");
    }

    @Test
    public void getByReceiverOrderedByAmountThenById() {
        addTransactions();
        Iterable<Transaction> results = chainBlock.getByReceiverOrderedByAmountThenById("H");
        int index = 2;
        for (Transaction transaction : results) {
            assertEquals(transactions[index--], transaction);
        }
        assertEquals(-1, index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverOrderedByAmountThenByIdThrowsForNoResultsFound() {
        chainBlock.getByReceiverOrderedByAmountThenById("H");
    }

    @Test
    public void getByTransactionStatusAndMaximumAmount() {
        addTransactions();
        Iterable<Transaction> emptyResult = chainBlock.getByTransactionStatusAndMaximumAmount(TransactionStatus.UNAUTHORIZED, 10.5);
        int indexEmpty = 0;
        for (Transaction transaction : emptyResult) {
            indexEmpty++;
        }
        assertEquals("Returns empty collection when no results found",0,indexEmpty);
        Iterable<Transaction> results = chainBlock.getByTransactionStatusAndMaximumAmount(TransactionStatus.UNAUTHORIZED, 40.5);
        int index = 0;
        for (Transaction transaction : results) {
            assertEquals(transactions[transactions.length-1-index],transaction);
            index++;
        }
        assertEquals("Returns correct amount of results",2,index);
    }

    @Test
    public void getBySenderAndMinimumAmountDescending() {
        addTransactions();
        Iterable<Transaction> results = chainBlock.getBySenderAndMinimumAmountDescending("C", 10.4);
        int index = 2;
        for (Transaction result : results) {
            assertEquals(transactions[index--],result);
        }
        assertEquals(-1,index);

    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescendingThrowsWhenNoResultsFound() {
        addTransactions();
        chainBlock.getBySenderAndMinimumAmountDescending("C",20.5);
    }

    @Test
    public void getByReceiverAndAmountRange() {
        addTransactions();
        Iterable<Transaction> results = chainBlock.getByReceiverAndAmountRange("H", 10.5, 20.6);
        int index = 2;
        for (Transaction result : results) {
            assertEquals(transactions[index--],result);
        }
        assertEquals("Correct amount of results",-1,index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeThrowsWhenLowOutsideBounds() {
        addTransactions();
        chainBlock.getByReceiverAndAmountRange("H",20.6,30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeThrowsWhenHighOutsideBounds() {
        addTransactions();
        chainBlock.getByReceiverAndAmountRange("H",10,10.5);
    }

    @Test
    public void getAllInAmountRange() {
        addTransactions();
        Iterable<Transaction> firstRange = chainBlock.getAllInAmountRange(0, 10.5);
        Iterable<Transaction> secondRange = chainBlock.getAllInAmountRange(20.5, 40.5);
        Iterable<Transaction> thirdRange = chainBlock.getAllInAmountRange(40.5, 50);
        Iterable<Transaction> firstEmpty = chainBlock.getAllInAmountRange(0, 10.4);
        Iterable<Transaction> secondEmpty = chainBlock.getAllInAmountRange(40.6, 50);

        int nFirst = 0;
        int nSecond = 0;
        int nThird = 0;
        int empty = 0;

        for (Transaction transaction : firstRange) {
            assertEquals(transactions[nFirst++],transaction);
        }
        for (Transaction transaction : secondRange) {
            assertEquals(transactions[2+nSecond++],transaction);
        }
        for (Transaction transaction : thirdRange) {
            assertEquals(transactions[4+nThird++],transaction);
        }
        for (Transaction transaction : firstEmpty) {
            empty++;
        }
        for (Transaction transaction : secondEmpty) {
            empty++;
        }
        assertEquals(2,nFirst);
        assertEquals(3,nSecond);
        assertEquals(1,nThird);
        assertEquals(0,empty);

    }

    @Test
    public void iterator() {
        addTransactions();
        Iterator<Transaction> iterator = this.chainBlock.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(transactions[index++], iterator.next());
        }
        assertEquals(transactions.length, index);
    }

    private void addTransactions() {
        for (Transaction transaction : transactions) {
            chainBlock.add(transaction);
        }
    }
}