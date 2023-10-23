package dnd.classes;

import dnd.magic.SorcererSpellBook;
import dnd.magic.Spell;
import dnd.magic.SpellBook;

import java.util.Scanner;

/**
 * Класс чародей - волшебник, с неизменными активными заклинаниями
 */
public class Sorcerer extends Wizard<SorcererSpellBook> {


    public Sorcerer() {
        super("Колдун", 7, new SorcererSpellBook());
    }

    /**
     * на каждом левел апе колдун может навсегда добавить в активные еще одно заклинание
     * для выбора заклинания используется сканнер
     */
    @Override
    protected void onLevelUp() {
        System.out.println("Ура, колдун стал немного мудрее и может выучить новое заклинание");
        System.out.print("Допустимые значения: ");
        for (Spell spell : Spell.values()) {
            System.out.print(spell.name() + " ");
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String spell = scanner.nextLine();
        getSpellBook().addSpell(Spell.valueOf(spell));
    }
}
