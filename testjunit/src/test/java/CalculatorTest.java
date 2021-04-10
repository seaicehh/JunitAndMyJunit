import org.junit.*;

import java.sql.SQLOutput;

public class CalculatorTest {
    private  Calculator cal;//测试的单元

    @BeforeClass
    public static void bc() throws Exception {
        System.out.println("beforeclass");

    }

    @Before
    public void setUp() throws Exception {
        System.out.println("before");
        cal=new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after");
        cal=new Calculator();
    }

    @AfterClass
    public static  void ac() throws Exception {
        System.out.println("Afterclass");

    }
    @org.junit.Test
    public void add() {
        System.out.println("add测试");
        Assert.assertEquals(3,cal.add(2,1));
    }

    @org.junit.Test
    public void sub() {
        System.out.println("sub测试");
        Assert.assertEquals(3,cal.add(2,1));
    }
}