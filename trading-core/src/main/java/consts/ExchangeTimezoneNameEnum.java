package consts;

public class ExchangeTimezoneNameEnum {
    public enum ExchangeTimezone {
        // North America
        AMERICA_NEW_YORK("America/New_York", "Eastern Time (US & Canada)"),
        AMERICA_CHICAGO("America/Chicago", "Central Time (US & Canada)"),
        AMERICA_LOS_ANGELES("America/Los_Angeles", "Pacific Time (US & Canada)"),
        AMERICA_TORONTO("America/Toronto", "Eastern Time (Canada)"),

        // Europe
        EUROPE_LONDON("Europe/London", "Greenwich Mean Time"),
        EUROPE_PARIS("Europe/Paris", "Central European Time"),
        EUROPE_BERLIN("Europe/Berlin", "Central European Time"),
        EUROPE_ZURICH("Europe/Zurich", "Central European Time"),

        // Asia
        ASIA_TOKYO("Asia/Tokyo", "Japan Standard Time"),
        ASIA_HONG_KONG("Asia/Hong_Kong", "Hong Kong Time"),
        ASIA_SHANGHAI("Asia/Shanghai", "China Standard Time"),
        ASIA_SINGAPORE("Asia/Singapore", "Singapore Time"),
        ASIA_KOLKATA("Asia/Kolkata", "India Standard Time"),

        // Australia & Pacific
        AUSTRALIA_SYDNEY("Australia/Sydney", "Australian Eastern Time"),
        AUSTRALIA_MELBOURNE("Australia/Melbourne", "Australian Eastern Time"),
        PACIFIC_AUCKLAND("Pacific/Auckland", "New Zealand Time"),

        // Middle East
        ASIA_DUBAI("Asia/Dubai", "Gulf Standard Time"),
        ASIA_RIYADH("Asia/Riyadh", "Arabian Standard Time"),

        // Africa
        AFRICA_JOHANNESBURG("Africa/Johannesburg", "South Africa Standard Time");

        private final String timezoneId;
        private final String description;

        ExchangeTimezone(String timezoneId, String description) {
            this.timezoneId = timezoneId;
            this.description = description;
        }

        public String getTimezoneId() {
            return timezoneId;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return timezoneId + " (" + description + ")";
        }
    }
}
