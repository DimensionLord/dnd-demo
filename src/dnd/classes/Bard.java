package dnd.classes;

import dnd.classes.extentions.ILearnScrolls;
import dnd.magic.Scroll;
import dnd.magic.ScrollSpellBook;

/**
 * Класс бард - разбойник со способностью к использованию заклинаний
 */
public class Bard extends Rogue implements ILearnScrolls {
    /**
     * состояние поет/не поект
     */
    private boolean isSinging;
    /**
     * Исполняемая песня
     */
    private final String song;
    /**
     * Волшебная книга с доступом к заклинаниям
     */
    private final ScrollSpellBook spellBook;

    public Bard(String song) {
        super("Бард", 12, 8, 10);
        this.song = song;
        spellBook = new ScrollSpellBook();
    }

    /**
     * Включить песню
     */
    public void songOn() {
        System.out.printf("Песня '%s' включена%n", song);
        isSinging = true;
    }

    /**
     * Выключить песню
     */
    public void songOff() {
        System.out.println("Песня выключена");
        isSinging = false;
    }

    /**
     * Барды могут выучить любое заклинание 2-6 уровня
     *
     * @param scroll
     * @return
     */
    @Override
    public boolean canLearn(Scroll scroll) {
        if (scroll.getSpell().getLevel() > 1 && scroll.getSpell().getLevel() < 7) {
            return true;
        }
        System.out.printf("Бард не может выучить заклинание уровня %d%n", scroll.getSpell().getLevel());
        return false;
    }

    /**
     * шанс выучить заклинание у барда всегда 40%
     *
     * @param scroll
     * @return
     */
    @Override
    public int getChanceToLearn(Scroll scroll) {
        return 40;
    }

    @Override
    public ScrollSpellBook getSpellBook() {
        return spellBook;
    }
}
