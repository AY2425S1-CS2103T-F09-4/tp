package tuteez.model.person.lesson;

/**
 * Enum to represent the days of the week.
 */
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    /**
     * Converts a string representation of a day into the corresponding {@code Day} enum value.
     *
     * <p>The string must be in lowercase (e.g., "monday", "tuesday"). If the string does not
     * match any of the valid days of the week, an exception is thrown.</p>
     *
     * @param dayInStr The string representing the day of the week (e.g., "monday", "mon").
     * @return The {@code Day} enum corresponding to the input string.
     * @throws IllegalArgumentException If the provided string does not match a valid day.
     */
    public static Day convertDayToEnum(String dayInStr) {
        return switch (dayInStr) {
        case "monday", "mon" -> MONDAY;
        case "tuesday", "tue" -> TUESDAY;
        case "wednesday", "wed" -> WEDNESDAY;
        case "thursday", "thu" -> THURSDAY;
        case "friday", "fri" -> FRIDAY;
        case "saturday", "sat" -> SATURDAY;
        case "sunday", "sun" -> SUNDAY;
        // Default case should not occur because input is validated before calling the method.
        default -> throw new IllegalArgumentException("Invalid day string: " + dayInStr);
        };
    }

    /**
     * Checks if the provided string is a valid day of the week.
     *
     * @param dayStr The string representing the day to check.
     * @return true if the string matches a valid day, false otherwise.
     */
    public static boolean isValidDay(String dayStr) {
        if (dayStr == null) {
            return false;
        }
        for (Day day : Day.values()) {
            if (day.name().equalsIgnoreCase(dayStr)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name();
    }
}
