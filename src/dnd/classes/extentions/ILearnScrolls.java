package dnd.classes.extentions;

import dnd.dice.DiceUtils;
import dnd.magic.Scroll;
import dnd.magic.Spell;
import dnd.magic.ScrollSpellBook;

/**
 * Интерфейс отображает заклинателей, которые используют заклинания из волшебной книги
 */
public interface ILearnScrolls extends ICastSpells<ScrollSpellBook> {
    /**
     * Проверяет возможность изучения свитка
     * Реализация зависит от класса заклинателя
     *
     * @param scroll
     * @return
     */
    boolean canLearn(Scroll scroll);


    /**
     * возвращает шанс выучить заклинание
     * зависит от класса заклинателя
     *
     * @param scroll
     * @return
     */
    int getChanceToLearn(Scroll scroll);

    /**
     * получает волшебную книгу, но поскольку в интерфейсе нет полей, то оставляем обращение к полю конечному классу
     *
     * @return
     */
    @Override
    ScrollSpellBook getSpellBook();

    /**
     * Переписывает заклинание из свитка в волшебную книгу
     *
     * @param scroll
     */
    default void learnSpell(Scroll scroll) {
        if (scroll.getSpell() == null) {
            System.out.println("Свиток потерял свою силу");
            return;
        }
        if (getSpellBook().isSpellLearned(scroll.getSpell())) {
            System.out.printf("Заклинание '%s' уже было выучено%n", scroll.getSpell());
            return;
        }
        if (!canLearn(scroll)) {
            return;
        }
        if (DiceUtils.throwDice(100) < getChanceToLearn(scroll)) {
            getSpellBook().push(scroll.getSpell());
            System.out.printf("Успешно выучено заклинание '%s'%n", scroll.getSpell());
        } else {
            System.out.printf("Не удалось выучить заклинание '%s'%n", scroll.getSpell());
        }
        scroll.destroy();
    }

    /**
     * Добавляет заклинание в активные
     *
     * @param spell
     */
    default void getSpellReady(Spell spell) {
        getSpellBook().activateSpell(spell);
    }
}
