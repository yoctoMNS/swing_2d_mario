package org.entity.creature;

public enum CreatureDirection {
    STOP(0),
    UP(1),
    DOWN(2),
    LEFT(3),
    RIGHT(4);

    private int value;

    private CreatureDirection(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CreatureDirection getValue(int value) {
        for (CreatureDirection element : CreatureDirection.values()) {
            if (element.value == value) {
                return element;
            }
        }

        return null;
    }
}
