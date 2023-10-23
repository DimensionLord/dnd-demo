package dnd.classes;

import dnd.dice.DiceUtils;

import java.util.Random;

public abstract class Hero {
    private final String className;
    private final int hpPerLevel;
    private int level;

    private int hp;

    public Hero(String name, int hpPerLevel) {
        this.className = name;
        this.hpPerLevel = hpPerLevel;
    }

    public final void levelUp() {
        hp += DiceUtils.throwDice(hpPerLevel);
        level++;
        onLevelUp();
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "%s %d уровня с '%d' очками здоровья".formatted(className, level, hp);
    }

    protected abstract void onLevelUp();


    protected int getLevel() {
        return level;
    }
}
