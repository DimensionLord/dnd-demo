package mainapp;


import dnd.classes.*;
import dnd.classes.extentions.ICastSpells;
import dnd.classes.extentions.ILearnScrolls;
import dnd.magic.Spell;


public class Main {


    public static void main(String[] args) {
        PlayGround playGround = new PlayGround();
        Bard bard = logHeroCreation(new Bard("Боевая песня"));
        Mage mage = logHeroCreation(
                new Mage(
                        "Призвание", "Прорицание",
                        new Spell[]{Spell.FAT, Spell.KNOCK, Spell.COLOR_SPRAY, Spell.BLINDNESS}
                )
        );
        Sorcerer sorcerer = logHeroCreation(new Sorcerer());
        Thief thief = logHeroCreation(new Thief());

        Hero[] heroes = {bard, mage, sorcerer, thief};
        ICastSpells<?>[] spellCasters = {bard, mage, sorcerer};
        ILearnScrolls[] scrollLearners = {bard, mage};
        Wizard<?>[] wizards = {mage, sorcerer};
        Rogue[] rogues = {bard, thief};

        mage.levelUp();


        playGround.initHeroes(heroes);
        playGround.prepareSpell(mage);

        playGround.checkCastSpell(spellCasters);
        playGround.checkUseScroll(spellCasters);

        playGround.checkLearnScroll(scrollLearners);
        playGround.checkGetSpellReady(scrollLearners);

        playGround.checkWizard(sorcerer, mage, wizards);
        playGround.checkRogue(rogues);
    }

    private static <T extends Hero> T logHeroCreation(T hero) {
        PrintUtils.printSegment("Генерация персонажа '%s'".formatted(hero.getClassName()));
        return hero;
    }
}
