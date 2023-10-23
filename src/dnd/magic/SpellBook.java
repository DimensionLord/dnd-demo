package dnd.magic;

/**
 * Вспомогательный класс, реализующий логику хранения доступных заклинаний
 */
public abstract class SpellBook {
    /**
     * Количество уровней заклинаний
     */
    public final static int SPELL_LEVELS = 8;
    /**
     * Количество заклинаний на уровень
     */
    public final static int SPELLS_PER_LEVEL = 10;

    /**
     * хранилище доступных заклинаний
     */
    private final Spell[][] availableSpells = new Spell[SPELL_LEVELS][SPELLS_PER_LEVEL];

    /**
     * добавление заклинания в доступные
     *
     * @param spell
     */
    protected void addSpellsToAvailable(Spell spell) {
        for (int i = 0; i < SPELLS_PER_LEVEL; i++) {
            if (availableSpells[spell.getLevel() - 1][i] == null) {
                availableSpells[spell.getLevel() - 1][i] = spell;
                return;
            }
        }
        System.out.printf("Нет свободных слотов для заклинаний уровня '%d'%n", spell.getLevel());
    }

    /**
     * Получение массива доступных заклинаний
     *
     * @return
     */
    protected Spell[][] getAvailableSpells() {
        return availableSpells;
    }

    /**
     * Использование доступного заклинания
     *
     * @param spell
     * @return
     */
    public abstract boolean useSpell(Spell spell);
}
