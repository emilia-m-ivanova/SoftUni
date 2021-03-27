package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;


import java.util.Map;

public class BankVaultTest {
    private Item item1;
    private Item item2;
    private BankVault vault;

    @Before
    public void setUp() throws Exception {
        item1 = new Item("A","1");
        item2 = new Item("B","2");
        vault = new BankVault();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getVaultCells() {
        Map<String, Item> vaultCells = vault.getVaultCells();
        vaultCells.values()
                .forEach(Assert::assertNull);
        vaultCells.put("A1",new Item("new owner", "new Id"));
    }

    @Test
    public void addItemSuccessfully() throws OperationNotSupportedException {
        String message = vault.addItem("A1", item1);
        Map<String, Item> vaultCells = vault.getVaultCells();
        assertEquals(vaultCells.get("A1").getItemId(),item1.getItemId());
        assertEquals(vaultCells.get("A1").getOwner(),item1.getOwner());
        assertEquals("Item:" + item1.getItemId() + " saved successfully!",message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addItemToBusyCell() throws OperationNotSupportedException {
        vault.addItem("A1",item1);
        vault.addItem("A1",item2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addItemToNonExistingCell() throws OperationNotSupportedException {
        vault.addItem("Non-existing",item1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addAlreadyExistingItem() throws OperationNotSupportedException {
        vault.addItem("A1",item1);
        vault.addItem("A2",item1);
    }


    @Test
    public void removeItemSuccessfully() throws OperationNotSupportedException {
        vault.addItem("A1",item1);
        String message = vault.removeItem("A1", item1);
        Map<String, Item> vaultCells = vault.getVaultCells();
        assertNull(vaultCells.get("A1"));
        assertEquals("Remove item:" + item1.getItemId() + " successfully!",message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeItemFromNonExistingCell() throws OperationNotSupportedException {
        vault.removeItem("Non-existing",item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeItemFromEmptyCell() throws OperationNotSupportedException {
        vault.removeItem("A1",item1);
    }

}