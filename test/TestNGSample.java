/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.thienan.testingWithTestNG.core.ItemDTO;
import com.thienan.testingWithTestNG.core.PaymentDetail;
import com.thienan.testingWithTestNG.core.PaymentDetailDTO;
import java.util.ArrayList;

import static org.testng.AssertJUnit.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author thien
 */
public class TestNGSample {

    private static PaymentDetail detail;
    private static ArrayList<ItemDTO> item;

    @BeforeClass
    public static void setUpClass() throws Exception {
        detail = new PaymentDetail();
        item = new ArrayList<>();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUp() throws Exception {
        item.add(new ItemDTO("iphone", 3, 400));
        item.add(new ItemDTO("samsung", 3, 200));
    }

    @AfterClass
    public void tearDown() throws Exception {
        detail.removeAllItemInPayemt();
        item.removeAll(item);
    }

    @Test
    public void addNewValidPayment() {
        boolean expected = true;
        boolean result = detail.addPaymentToList(new PaymentDetailDTO(1, "phoneItem", item));
        assertEquals(expected, result);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void addNewPaymentWithNullItemList() {
        detail.addPaymentToList(new PaymentDetailDTO(1, "null item list", null));
    }

    @Test(expectedExceptions = IllegalAccessException.class)
    public void addNewPaymentWithDuplicateID() {
        detail.addPaymentToList(new PaymentDetailDTO(1, "the 1st list", item));
        detail.addPaymentToList(new PaymentDetailDTO(1, "the 2nd list with duplicate ID", item));
    }
    
   //addNewPayMentWithNullPaymentTitle
    //do the same with ItemDTO
}
