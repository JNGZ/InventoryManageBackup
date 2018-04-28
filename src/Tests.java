import CSV.Utility;
import org.junit.Before;
import org.junit.Test;


public class Tests {

    Utility utility;
    Store store;

    @Before@Test
    public void init(){
        utility = new Utility();
        store = Store.getInstance();
    }

    @Test
    public void testReadItemList(){
        store.getStock().loadItems();
    }

    @Test
    public void testStock(){
        store.getStock().getItems();
    }

    @Test
    public void testWriteItemList(){
        store.getStock().saveItems();
    }

    @Test
    public void testReadManifest(){
        System.out.println("Ref: " + store.getManifest().getRefTruck().getCargo());
        System.out.println("Ord: " + store.getManifest().getOrdTruck().getCargo());
    }

    @Test
    public void testWriteManifest(){
        store.getManifest().saveManifest();
    }

    @Test
    public void testCapital(){
        System.out.println(store.getCapital());
    }
}
