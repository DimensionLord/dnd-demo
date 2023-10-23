package dnd.magic;

import java.util.Arrays;

/**
 * Класс реализующий логику волшебной книги мага. В такую книгу можно записывать заклинания из свитка, а доступные заклинания свободно меняются
 */
public class ScrollSpellBook extends SpellBook {

    /**
     * Хранилище выученных заклинаний
     */
    private final Spell[] learnedSpells = new Spell[500];
    /**
     * индекс в массиве выше для более быстрого доступа
     */
    private int currentLearnedSpellIndex;


    /**
     * метод "запихивания" заклинания в волшебную книгу
     *
     * @param spell
     */
    public void push(Spell spell) {
        learnedSpells[currentLearnedSpellIndex++] = spell;
    }

    /**
     * Проверка выцченности заклинания
     *
     * @param spell
     * @return
     */
    public boolean isSpellLearned(Spell spell) {
        for (int i = 0; i < currentLearnedSpellIndex; i++) {
            if (spell.equals(learnedSpells[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Добавление заклинания в активные
     *
     * @param spell
     */
    public void activateSpell(Spell spell) {
        if (!isSpellLearned(spell)) {
            System.out.println("Невозможно добавить в используемые заклинание, которое не было выучено");
            return;
        }
        System.out.println("Заклинание '"+spell+"' добавлено в активные");
        addSpellsToAvailable(spell);
    }

    /**
     * Использование заклинания из волшебной книги
     *
     * @param spell
     * @return
     */
   @Override
    public boolean useSpell(Spell spell) {
        for (int i = 0; i < SPELLS_PER_LEVEL; i++) {
            if (!spell.equals(getAvailableSpells()[spell.getLevel() - 1][i])) {
                continue;
            }
            getAvailableSpells()[spell.getLevel() - 1][i] = null;
            return true;
        }
        return false;
    }

    /**
     * сброс активных заклинаний
     */
    public void dropAvailableSpells() {
        Spell[][] availableSpells = getAvailableSpells();
        for (Spell[] spells : availableSpells) {
            Arrays.fill(spells, null);
        }
    }

}
