package TypewiseAlert;

import TypewiseAlert.BreachClassifier.BreachType;
import TypewiseAlert.BreachClassifier.CoolingType;
import TypewiseAlert.AlertSender.AlertTarget;

public class TypewiseAlert { 

    // Represents the battery with cooling type and brand
    public static class BatteryCharacter {
        private final CoolingType coolingType;
        private final String brand;

        public BatteryCharacter(CoolingType coolingType, String brand) {
            this.coolingType = coolingType;
            this.brand = brand;
        }

        public CoolingType getCoolingType() {
            return coolingType;
        }

        public String getBrand() {
            return brand;
        }
    }

    // Checks temperature and triggers alert based on target and breach type
    public static void checkAndAlert(AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC) {
        BreachType breachType = BreachClassifier.classifyTemperatureBreach(batteryChar.getCoolingType(), temperatureInC);

        if (alertTarget == AlertTarget.TO_CONTROLLER) {
            AlertSender.sendToController(breachType);
        } else if (alertTarget == AlertTarget.TO_EMAIL) {
            AlertSender.sendToEmail(breachType);
        }
    }
}
