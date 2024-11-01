package TypewiseAlert;

import TypewiseAlert.BreachClassifier.BreachType;

public class AlertSender {

    // Enum-like pattern for AlertTarget with different alert destinations
    public static class AlertTarget {
        public static final AlertTarget TO_CONTROLLER = new AlertTarget("TO_CONTROLLER");
        public static final AlertTarget TO_EMAIL = new AlertTarget("TO_EMAIL");

        private final String target;

        private AlertTarget(String target) {
            this.target = target;
        }

        public String getTarget() {
            return target;
        }

        @Override
        public String toString() {
            return target;
        }
    }

    // Sends breach information to a controller
    public static void sendToController(BreachType breachType) {
        int header = 0xfeed;
        System.out.printf("%x : %s\n", header, breachType);
    }

    // Sends breach notification email based on the type of breach
    public static void sendToEmail(BreachType breachType) {
        String recipient = "alert@company.com";
        System.out.printf("To: %s\n", recipient);
        if (breachType == BreachType.TOO_LOW) {
            System.out.println("Alert: Temperature is critically low.\n");
        } else if (breachType == BreachType.TOO_HIGH) {
            System.out.println("Alert: Temperature is critically high.\n");
        }
    }
}
