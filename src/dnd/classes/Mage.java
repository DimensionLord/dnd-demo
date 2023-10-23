package dnd.classes;


import dnd.classes.extentions.ILearnScrolls;
import dnd.magic.Scroll;
import dnd.magic.Spell;
import dnd.magic.ScrollSpellBook;

/**
 * Класс маг - волшебник, со способностью записывать и использовать записанные заклинания
 */
public class Mage extends Wizard<ScrollSpellBook> implements ILearnScrolls {

    private final static int CHANCE_TO_LEARN_PER_LEVEL = 15;

    /**
     * шанс выучить заклинание для мага растет с уровнем
     */
    int chanceToLearn;
    /**
     * Школа с повышенной вероятностью выучить заклинание
     */
    private final String primarySchool;
    /**
     * Запрещенная школа
     */
    private final String forbiddenSchool;


    public Mage(String primarySchool, String forbiddenSchool, Spell[] initialSpells) {
        super("Маг", 8, new ScrollSpellBook());
        this.primarySchool = primarySchool;
        this.forbiddenSchool = forbiddenSchool;
        for (Spell spell : initialSpells) {
            getSpellBook().push(spell);
        }

    }


    /**
     * Каждый уровень маг увеличивает свой шанс на успешное запоминание заклинаний
     */
    @Override
    protected void onLevelUp() {
        chanceToLearn += CHANCE_TO_LEARN_PER_LEVEL;
    }

    /**
     * Маг может выучить любое заклинание, если оно не принадлежит запрещенной школе
     *
     * @param scroll
     * @return
     */
    @Override
    public boolean canLearn(Scroll scroll) {
        if (scroll.getSpell().getSchool().equals(forbiddenSchool)) {
            System.out.printf("Школа '%s' недоступна для волшебника с основной школой '%s'%n", scroll.getSpell().getSchool(), primarySchool);
            return false;
        }
        return true;
    }

    /**
     * высчитывает шанс выучить заклинание, в зависимости от школы
     *
     * @param scroll
     * @return
     */
    @Override
    public int getChanceToLearn(Scroll scroll) {
        return scroll.getSpell().getSchool().equals(primarySchool) ? chanceToLearn * 2 : chanceToLearn;
    }


}
