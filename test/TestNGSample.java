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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @AfterMethod
    public void tearDown() throws Exception {
        detail.removeAllItemInPayemt();
        item.removeAll(item);
    }

    @DataProvider(name = "payments")
    public static Object[][] paymentList() {
        return new Object[][]{
            {new PaymentDetailDTO(1, "1st item", item), true},
            {new PaymentDetailDTO(2, "2nd item", item), false},
            {new PaymentDetailDTO(3, "3rd item", item), false}
        };
    }
 
    @Test(enabled = true,
            dataProvider = "payments")
    public void addNewValidPayment(PaymentDetailDTO payments, boolean expected) {
        assertEquals(expected, detail.addPaymentToList(payments));
    }

    @Test(enabled = false,
            dataProvider = "payments",
            timeOut = 200)
    public void addNewPaymentButTimeOut(PaymentDetailDTO payments, boolean expected) throws InterruptedException {
        Thread.sleep(300);
        assertEquals(expected, detail.addPaymentToList(payments));
    }

    @Test(enabled = true,
            expectedExceptions = NullPointerException.class)
    public void addNewPaymentWithNullItemList() {
        detail.addPaymentToList(new PaymentDetailDTO(1, "null item list", null));
    }

    @Test(enabled = true,
            expectedExceptions = IllegalArgumentException.class)
    public void addNewPaymentWithDuplicateID() {
        detail.addPaymentToList(new PaymentDetailDTO(1, "the 1st list", item));
        detail.addPaymentToList(new PaymentDetailDTO(1, "the 2nd list with duplicate ID", item));
    }

    @Test(enabled = true,
             expectedExceptions = NullPointerException.class
    /*, dependsOnMethods = {"addNewPaymentWithDuplicateID"}*/)
    public void addNewPayMentWithNullPaymentTitle() {
        detail.addPaymentToList(new PaymentDetailDTO(5, null, item));
        detail.addPaymentToList(new PaymentDetailDTO(3, null, item));
    }
}
