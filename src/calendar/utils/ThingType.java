package calendar.utils;

public enum ThingType {
    reminder('r'), task('t'), appointment('a');

    private final char rep;

    ThingType(char rep) {
        this.rep = rep;
    }

    public char toChar() {
        return this.rep;
    }
}
