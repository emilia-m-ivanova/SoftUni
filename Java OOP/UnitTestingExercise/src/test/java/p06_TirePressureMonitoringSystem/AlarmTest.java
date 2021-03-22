package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class AlarmTest {
    private Alarm alarm;
    private Sensor mockSensor;
    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;
    private static final double BETWEEN_THRESHOLD = 17.5;
    private static final double ABOVE_THRESHOLD = 21.5;
    private static final double BELOW_THRESHOLD = 16.5;
    @Before
    public void setUp(){
        this.mockSensor = Mockito.mock(Sensor.class);
        this.alarm = new Alarm(mockSensor);
    }

    @Test
    public void getAlarmOnReturnsFalseWithParamBetweenThreshold() {
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(BETWEEN_THRESHOLD);
        this.alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void getAlarmOnReturnsFalseWithParamOnLowThreshold() {
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_THRESHOLD);
        this.alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void getAlarmOnReturnsFalseWithParamOnHighThreshold() {
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_THRESHOLD);
        this.alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void getAlarmOnReturnsTrueWithParamBelowThreshold() {
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(BELOW_THRESHOLD);
        this.alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void getAlarmOnReturnsTrueWithParamAboveThreshold() {
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(ABOVE_THRESHOLD);
        this.alarm.check();
        assertTrue(alarm.getAlarmOn());
    }
}