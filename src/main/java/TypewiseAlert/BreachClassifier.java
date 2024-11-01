package TypewiseAlert;

public class BreachClassifier {

    // Enum-like pattern for BreachType with constants for each breach level
    public static class BreachType {
        public static final BreachType NORMAL = new BreachType("NORMAL");
        public static final BreachType TOO_LOW = new BreachType("TOO_LOW");
        public static final BreachType TOO_HIGH = new BreachType("TOO_HIGH");

        private final String breachLevel;

        private BreachType(String breachLevel) {
            this.breachLevel = breachLevel;
        }

        public String getBreachLevel() {
            return breachLevel;
        }

        @Override
        public String toString() {
            return breachLevel;
        }
    }

    // Enum-like pattern for CoolingType with temperature limits for each type
    public static class CoolingType {
        public static final CoolingType PASSIVE_COOLING = new CoolingType(0, 35);
        public static final CoolingType HI_ACTIVE_COOLING = new CoolingType(0, 45);
        public static final CoolingType MED_ACTIVE_COOLING = new CoolingType(0, 40);

        private final int lowerLimit;
        private final int upperLimit;

        private CoolingType(int lowerLimit, int upperLimit) {
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
        }

        public int getLowerLimit() {
            return lowerLimit;
        }

        public int getUpperLimit() {
            return upperLimit;
        }
    }

    // Determines breach type based on temperature range and values
    public static BreachType inferBreach(double value, int lowerLimit, int upperLimit) {
        if (value < lowerLimit) {
            return BreachType.TOO_LOW;
        }
        if (value > upperLimit) {
            return BreachType.TOO_HIGH;
        }
        return BreachType.NORMAL;
    }

    // Classifies temperature breach based on cooling type
    public static BreachType classifyTemperatureBreach(CoolingType coolingType, double temperatureInC) {
        return inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
    }
}
