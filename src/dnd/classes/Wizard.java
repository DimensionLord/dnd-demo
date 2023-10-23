package dnd.classes;


import dnd.classes.extentions.ICastSpells;
import dnd.dice.DiceUtils;
import dnd.magic.Familiar;
import dnd.magic.Spell;
import dnd.magic.SpellBook;

public abstract class Wizard<SpellBookType extends SpellBook> extends Hero implements ICastSpells<SpellBookType> {

    /**
     * Уникальное свойство волшебников - возможность найти приживалу, который меняет способности волшебника
     */
    private Familiar familiar;

    private final SpellBookType spellBook;

   @Override
    public SpellBookType getSpellBook() {
        return spellBook;
    }

    public Wizard(String name, int hpPerLevel, SpellBookType spellBook) {
        super(name, hpPerLevel);
        this.spellBook = spellBook;
    }

    @Override
    public boolean castSpell(Spell spell) {
        if (!ICastSpells.super.castSpell(spell)) {
            return false;
        }
        if (spell == Spell.FIND_FAMILIAR) {
            if (familiar == null) {
                familiar = Familiar.values()[DiceUtils.throwDice(Familiar.values().length) - 1];
            }
            System.out.printf("Привет, я %s%n", familiar);
        }
        return true;
    }

    /**
     * Определяет приживалу для каждого волшебника при первом обращении и всегда возвращает его
     *
     * @return
     */
    public Familiar getFamiliar() {
        if (familiar == null) {
            System.out.println("Приживала еще не был создан");
        }
        return familiar;
    }
}
