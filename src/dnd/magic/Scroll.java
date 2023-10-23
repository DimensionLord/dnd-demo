package dnd.magic;

/**
 * вспомогательный класс, для описания работы со свитками
 */
public class Scroll {

    private Spell spell;

    public Scroll(Spell spell) {
        this.spell = spell;
    }


    public void destroy() {
        System.out.printf("Свиток '%s' был уничтожен%n", spell);
        spell = null;
    }

    public Spell getSpell() {
        return spell;
    }
}
