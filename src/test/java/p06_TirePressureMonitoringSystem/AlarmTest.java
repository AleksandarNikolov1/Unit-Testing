package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class AlarmTest {

    private static final double BOTTOM_BOUND = 17;
    private static final double UP_BOUND = 21;

    private Sensor sensor;
    private Alarm alarm;

    @Before
    public void setUp(){
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmIsOnWhenPressureLowerBottomBound(){
        when(sensor.popNextPressurePsiValue()).thenReturn(BOTTOM_BOUND - 0.1);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOffWhenPressureEqualsToBottomBound(){
        when(sensor.popNextPressurePsiValue()).thenReturn(BOTTOM_BOUND);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureBetweenBounds(){
        when(sensor.popNextPressurePsiValue()).thenReturn(18.50);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureEqualsToUpBound(){
        when(sensor.popNextPressurePsiValue()).thenReturn(UP_BOUND);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureGreaterThanUpBound(){
        when(sensor.popNextPressurePsiValue()).thenReturn(UP_BOUND + 0.1);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }


}
