package behring.android.study.mylibrary;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyLibraryUtilsTest {
    @Test
    public void testPlus() {
        assertEquals(4, new MyLibraryUtils().plus(2, 2));
    }

    @Test
    public void testSub() {
        assertEquals(0, new MyLibraryUtils().sub(2, 2));
    }
}