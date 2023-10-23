package dnd.classes.extentions;

import dnd.magic.Scroll;
import dnd.magic.Spell;
import dnd.magic.SpellBook;

/**
 * общий интерфейс для всех заклинателей
 */
public interface ICastSpells<SpellBookType extends SpellBook> {
    /**
     * Получает доступ к книге заклинаний
     */
    SpellBookType getSpellBook();

    /**
     * Бросок заклинания из книги
     *
     * @param spell
     */
    default boolean castSpell(Spell spell) {
        if (getSpellBook().useSpell(spell)) {
            System.out.printf("Чтение заклинания '%s'%n", spell);
            return true;
        }
        System.out.printf("Заклинание '%s' не было активировано%n", spell);
        return false;
    }

    /**
     * Использование свитка заклинания, не зависит от класса заклинателя
     *
     * @param scroll
     */
    default void useScroll(Scroll scroll) {
        if (scroll.getSpell() == null) {
            System.out.println("Свиток не существует");
            return;
        }
        System.out.printf("Использован свиток '%s'%n", scroll.getSpell());
        scroll.destroy();
    }
}
