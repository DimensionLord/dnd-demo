package dnd.magic;

import java.util.Arrays;

/**
 * Класс реализующий логику волшебной книги колдуна
 * Заклинания колдуна навсегда занимают слот в активных заклинаниях и не могут быть изменены
 */
public class SorcererSpellBook extends SpellBook {
    /**
     * кеш использованных "сегодня" заклинаний
     */
    private final int[] usedSpells = new int[SPELL_LEVELS * SPELLS_PER_LEVEL];

    /**
     * добавление заклинания в активные
     * заклинание будет добавлено навсегда
     *
     * @param spell
     */
    public void addSpell(Spell spell) {
        addSpellsToAvailable(spell);
    }

    /**
     * использование заклинания из книги колдуна
     *
     * @param spell
     * @return
     */
    @Override
    public boolean useSpell(Spell spell) {
        for (int i = 0; i < SPELLS_PER_LEVEL; i++) {
            Spell candidate = getAvailableSpells()[spell.getLevel() - 1][i];
            int id = isSpellUsed(spell.getLevel() * (i + 1));
            if (spell.equals(candidate) && id != -1) {
                usedSpells[id] = spell.getLevel() * (i + 1);
                return true;
            }
        }
        return false;
    }

    public void refresh() {
        Arrays.fill(usedSpells, 0);
    }

    private int isSpellUsed(int id) {
        int i;
        for (i = 0; usedSpells[i] != 0; i++) {
            if (usedSpells[i] == id) {
                return -1;
            }
        }
        return i;
    }
}
