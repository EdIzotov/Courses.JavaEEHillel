package testmath;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class MockSpyTest {
    @Test
    public void checkMockList() {
        List mock = mock(List.class);
        when(mock.get(10)).thenReturn(12);
        when(mock.size()).thenReturn(-1);
        Assert.assertEquals(12, mock.get(10));
        Assert.assertEquals(-1, mock.size());
        Assert.assertNull(mock.get(200));
    }

    @Test
    public void checkSpyList() {
        ArrayList arrayList = new ArrayList(Arrays.asList(1, 3, 5, 7));
        ArrayList spy = spy(arrayList);
        when(spy.get(0)).thenReturn(34);
        spy.get(0);
        verify(spy, times(1)).get(anyInt());
        //Assert.assertNull(spy.get(200));
    }
}
