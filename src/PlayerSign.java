package src;

public enum PlayerSign {
    X('X'),
    O('O');

    private final char sign;

    PlayerSign(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return this.sign;
    }
}
