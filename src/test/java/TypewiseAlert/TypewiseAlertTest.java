package TypewiseAlert;

import static org.junit.Assert.*;
import org.junit.Test;
import TypewiseAlert.BreachClassifier.BreachType; 
import TypewiseAlert.BreachClassifier.CoolingType;
import TypewiseAlert.AlertSender.AlertTarget;
import TypewiseAlert.TypewiseAlert.BatteryCharacter;

public class TypewiseAlertTest {

    @Test
    public void testInferBreachTooLow() {
        BreachType breachType = BreachClassifier.inferBreach(10, 15, 30);
        assertEquals(BreachType.TOO_LOW, breachType);
    }

    @Test
    public void testInferBreachTooHigh() {
        BreachType breachType = BreachClassifier.inferBreach(50, 20, 30);
        assertEquals(BreachType.TOO_HIGH, breachType);
    }

    @Test
    public void testInferBreachNormal() {
        BreachType breachType = BreachClassifier.inferBreach(25, 20, 30);
        assertEquals(BreachType.NORMAL, breachType);
    }

    @Test
    public void testTempBreachForPassiveCooling() {
        BreachType breachType = BreachClassifier.classifyTemperatureBreach(CoolingType.PASSIVE_COOLING, 36);
        assertEquals(BreachType.TOO_HIGH, breachType);
    }

    @Test
    public void testTempBreachForHiActiveCooling() {
        BreachType breachType = BreachClassifier.classifyTemperatureBreach(CoolingType.HI_ACTIVE_COOLING, 46);
        assertEquals(BreachType.TOO_HIGH, breachType);
    }

    @Test
    public void testTempBreachForMedActiveCooling() {
        BreachType breachType = BreachClassifier.classifyTemperatureBreach(CoolingType.MED_ACTIVE_COOLING, 41);
        assertEquals(BreachType.TOO_HIGH, breachType);
    }

    @Test
    public void testCheckAndAlertToController() {
        BatteryCharacter batteryChar = new TypewiseAlert.BatteryCharacter(CoolingType.PASSIVE_COOLING, "BrandY");
        TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER, batteryChar, 37);
    }

    @Test
    public void testCheckAndAlertToEmail() {
        BatteryCharacter batteryChar = new TypewiseAlert.BatteryCharacter(CoolingType.PASSIVE_COOLING, "BrandY");
        TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL, batteryChar, 37);
    }
}

