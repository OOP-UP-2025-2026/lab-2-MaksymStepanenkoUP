package ua.opnu;


public class TimeSpan {

    /**
     * The number of minutes in one hour.
     */
    private static final int MINUTES_PER_HOUR = 60;

    /**
     * The number of minutes in one hour.
     */
    private int hours;

    /**
     * The number of minutes in one hour.
     */
    private int minutes;

    TimeSpan(int hours, int minutes) {
        if (hours >= 0 && minutes >= 0 && minutes < MINUTES_PER_HOUR) {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    int getHours() {
        return this.hours;
    }

    int getMinutes() {
        return this.minutes;
    }

    void add(int hours, int minutes) {
        if (hours >= 0 && minutes >= 0 && minutes < MINUTES_PER_HOUR) {
            this.hours += hours;
            this.minutes += minutes;
            this.hours = this.hours + this.minutes / MINUTES_PER_HOUR;

            if (this.minutes >= MINUTES_PER_HOUR) {
                this.minutes = this.minutes - MINUTES_PER_HOUR;
            }
        }
    }

    void addTimeSpan(TimeSpan timespan) {
        this.hours += timespan.getHours();
        this.minutes += timespan.getMinutes();
        this.hours = this.hours + this.minutes / MINUTES_PER_HOUR;

        if (this.minutes >= MINUTES_PER_HOUR) {
            this.minutes = this.minutes - MINUTES_PER_HOUR;
        }
    }

    double getTotalHours() {
        return getHours() + (double) getMinutes() / MINUTES_PER_HOUR;
    }

    int getTotalMinutes() {
        return getMinutes() + getHours() * MINUTES_PER_HOUR;
    }

    void subtract(TimeSpan span) {
        int totalThis = this.hours * MINUTES_PER_HOUR + this.minutes;
        int totalOther = span.getHours() * MINUTES_PER_HOUR + span.getMinutes();

        if (totalOther > totalThis) {
            return;
        }

        int result = totalThis - totalOther;

        this.hours = result / MINUTES_PER_HOUR;
        this.minutes = result % MINUTES_PER_HOUR;
    }

    void scale(int factor) {
        if (factor > 0) {
            int multipliedTime = getTotalMinutes() * factor;
            this.hours = multipliedTime / MINUTES_PER_HOUR;
            this.minutes = multipliedTime % MINUTES_PER_HOUR;
        }
    }
}