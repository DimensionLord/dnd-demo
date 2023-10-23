package dnd.magic;

import java.util.Objects;

/**
 * вспомогательный класс, для описания заклинаний
 */
public enum Spell {
    MAGIC_ARROW("Проявление", "Волшебная стрела", 1),
    COLOR_SPRAY("Воплощение", "Цветные брызги", 1),
    FAT("Призвание", "Жир", 1),
    BLINDNESS("Иллюзия", "Ослепление", 1),
    FIND_FAMILIAR("Призвание", "Найти приживалу", 1),
    KNOCK("Преобразование", "Стук", 2),
    SUMMON_COW("Призвание", "Призвать корову", 2),
    FIRE_BALL("Проявление", "Огненный шар", 3),
    TRUE_SIGHT("Прорицание", "Истинное видение", 6);


    private final String school;
    private final String title;
    private final int level;

    Spell(String school, String title, int level) {
        this.school = school;
        this.title = title;
        this.level = level;
    }

    public String getSchool() {
        return school;
    }

    @Override
    public String toString() {
        return title;
    }

    public int getLevel() {
        return level;
    }
}
