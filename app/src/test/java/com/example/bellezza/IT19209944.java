package com.example.bellezza;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class IT19209944 {
    private ConfirmOrderActivity confirm_order;
    int tot;

    //   @BeforeClass

    @Before
    public void createObj(){

        confirm_order = new ConfirmOrderActivity();
    }

    @Test
    public void finalTotCal_isCorrect() {


    tot = confirm_order.finalTotCal(100,1220);
    assertEquals(1320, tot, 0.001);


    }




    @After
    public void clearData()
    {
        tot = 0;
    }

    //@AfterClass
}