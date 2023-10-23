package mainapp;

import dnd.classes.*;
import dnd.classes.extentions.ICastSpells;
import dnd.classes.extentions.ILearnScrolls;
import dnd.magic.Scroll;
import dnd.magic.Spell;

public class PlayGround {
    void checkWizard(Sorcerer sorcerer, Mage mage, Wizard<?>[] wizards) {
        PrintUtils.printSegment("Wizard (getFamiliar)");
        PrintUtils.printMessage("Пожалуйста, добавьте колдуну заклинание FIND_FAMILIAR");
        sorcerer.levelUp();
        PrintUtils.printMessage("Маг подготавливает приживалу, успех зависит от предыдущих шагов");
        mage.getSpellReady(Spell.FIND_FAMILIAR);
        PrintUtils.printMessage("Пытаемся наколдовать приживалу. Для мага успех зависит от предыдущих шагов, для колдуна результат зависит от ввода пользователя");
        for (Wizard<?> wizard : wizards) {
            System.out.printf("%s: ", wizard.getClassName());
            wizard.castSpell(Spell.FIND_FAMILIAR);
        }
    }

    void checkGetSpellReady(ILearnScrolls[] scrollLearners) {
        PrintUtils.printSegment("ILearnScrolls (getSpellReady)");
        PrintUtils.printSubSegment("Подготовка выученного заклинания");
        for (ILearnScrolls scrollLearner : scrollLearners) {
            scrollLearner.getSpellReady(Spell.SUMMON_COW);
        }
        PrintUtils.printSubSegment("Подготовка невыученного заклинания");
        for (ILearnScrolls scrollLearner : scrollLearners) {
            scrollLearner.getSpellReady(Spell.FIRE_BALL);
        }
    }

    void checkLearnScroll(ILearnScrolls[] scrollLearners) {
        PrintUtils.printSegment("ILearnScrolls (learnSpell)");
        PrintUtils.printSubSegment("Валидный свиток, результат изучения рандомен");
        for (ILearnScrolls scrollLearner : scrollLearners) {
            Scroll scroll = new Scroll(Spell.SUMMON_COW);
            System.out.printf("%s: ", scrollLearner);
            scrollLearner.learnSpell(scroll);
        }
        PrintUtils.printSubSegment("Невалидные свитки");
        PrintUtils.printMessage("Найти приживалу, заклинание 1 уровня, результат для мага рандомен, для барда всегда провал без разрушения свитка");
        for (ILearnScrolls scrollLearner : scrollLearners) {
            Scroll scroll = new Scroll(Spell.FIND_FAMILIAR);
            System.out.printf("%s: ", scrollLearner);
            scrollLearner.learnSpell(scroll);
        }
        PrintUtils.printMessage("Истинное видение, заклинание 6 уровня школы прорицание, результат для мага провал без разрушения свитка, для барда рандомен");
        for (ILearnScrolls scrollLearner : scrollLearners) {
            Scroll scroll = new Scroll(Spell.TRUE_SIGHT);
            System.out.printf("%s: ", scrollLearner);
            scrollLearner.learnSpell(scroll);
        }
        PrintUtils.printSubSegment("Повторное изучение");
        for (ILearnScrolls scrollLearner : scrollLearners) {
            if (!scrollLearner.getSpellBook().isSpellLearned(Spell.SUMMON_COW)) {
                scrollLearner.getSpellBook().push(Spell.SUMMON_COW);
            }
        }
        PrintUtils.printMessage("Призвать корову, заклинание есть у обоих персонажей, провал в обоих случаях без разрешения свитка");
        for (ILearnScrolls scrollLearner : scrollLearners) {
            Scroll scroll = new Scroll(Spell.SUMMON_COW);
            System.out.printf("%s: ", scrollLearner);
            scrollLearner.learnSpell(scroll);
        }
    }

    void checkCastSpell(ICastSpells<?>[] spellCasters) {
        PrintUtils.printSegment("Проверка ICastSpells (castSpell)");
        PrintUtils.printSubSegment("Заклинание 'Стук' колдовство");
        PrintUtils.printMessage("Бард: провал, Маг: Успех, Колдун: в зависимости от выбранного заклинания при повышении уровня");
        for (ICastSpells<?> spellCaster : spellCasters) {
            System.out.printf("%s: ", spellCaster);
            spellCaster.castSpell(Spell.KNOCK);
        }
        PrintUtils.printSubSegment("Каст неподготовленного заклинания");
        PrintUtils.printMessage("Провал для всех трех персонажей, заклинание не было подготовлено");
        for (ICastSpells<?> spellCaster : spellCasters) {
            System.out.printf("%s: ", spellCaster);
            spellCaster.castSpell(Spell.KNOCK);
        }
    }

    void initHeroes(Hero[] heroes) {
        PrintUtils.printSegment("Повышение уровней");
        for (Hero hero : heroes) {
            hero.levelUp();
        }

        PrintUtils.printSegment("Созданы герои");
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    void checkRogue(Rogue[] rogues) {
        PrintUtils.printSegment("Rogue (searchForTraps)");
        PrintUtils.printSubSegment("Ловушки");
        PrintUtils.printMessage("Есть легкая ловушка, успех для обоих персонажей");
        for (Rogue rogue : rogues) {
            System.out.printf("%s: ", rogue.getClassName());
            rogue.searchForTraps(new int[]{5, 15, 20});
        }
        PrintUtils.printMessage("Есть средняя ловушка, успех только для вора");
        for (Rogue rogue : rogues) {
            System.out.printf("%s: ", rogue.getClassName());
            rogue.searchForTraps(new int[]{15, 20});
        }
        PrintUtils.printMessage("Только тяжелая ловушка, провал для обоих");
        for (Rogue rogue : rogues) {
            System.out.printf("%s: ", rogue.getClassName());
            rogue.searchForTraps(new int[]{20});
        }
        PrintUtils.printSubSegment("Кража");
        PrintUtils.printMessage("Легкая кража, успех для обоих персонажей");
        for (Rogue rogue : rogues) {
            System.out.printf("%s: ", rogue.getClassName());
            rogue.trySteal(4);
        }
        PrintUtils.printMessage("Средняя кража, успех только для вора");
        for (Rogue rogue : rogues) {
            System.out.printf("%s: ", rogue.getClassName());
            rogue.trySteal(14);
        }
        PrintUtils.printMessage("Сложная кража, провал для обоих персонажей");
        for (Rogue rogue : rogues) {
            System.out.printf("%s: ", rogue.getClassName());
            rogue.trySteal(25);
        }
    }


    void checkUseScroll(ICastSpells<?>[] spellCasters) {
        PrintUtils.printSegment("Проверка ICastSpells (useScroll)");
        PrintUtils.printSubSegment("Использование валидного свитка");
        PrintUtils.printMessage("Использование свитков одинаково для всех трех персонажей. Успех");
        for (ICastSpells<?> spellCaster : spellCasters) {
            Scroll scroll = new Scroll(Spell.SUMMON_COW);
            spellCaster.useScroll(scroll);
        }
        PrintUtils.printSubSegment("Использование невалидного свитка");
        Scroll scroll = new Scroll(Spell.KNOCK);
        scroll.destroy();
        PrintUtils.printMessage("Использование свитков одинаково для всех трех персонажей. Провал");
        for (ICastSpells<?> spellCaster : spellCasters) {
            spellCaster.useScroll(scroll);
        }
    }


    public void prepareSpell(ILearnScrolls spellCaster) {
        PrintUtils.printSegment("Подготовка заклинаний");
        PrintUtils.printMessage("Подготовка заклинания 'Стук' для мага");
        spellCaster.getSpellReady(Spell.KNOCK);
    }
}
