import java.util.logging.Logger;

public class PracticeTest {
    private static final Logger l = Logger.getLogger(PracticeTest.class.getName());

    PracticeTest(){
        test2help th;
        th = new test2help();
        int n = th.checking(2);
        if(n == 2){
            l.info("test passed");
        }        
    }

    public static void main(String [] args){
        new PracticeTest();
    }
}
