package dnd.classes;

/**
 * Класс-вор - разбойник, с расширенными воровскими навыками
 */
public class Thief extends Rogue {
    public Thief() {
        super("Вор", 12, 15, 20);
    }

    /**
     * Метод вскрытия сундуков
     */
    public void unlockChest(Object target) {
        System.out.println("Не удалось открыть сундук");
    }

    /**
     * Метод снятия ловушек
     */
    public void clearTrap(Object trap) {
        System.out.println("Не удалось снять ловушку");
    }

    /**
     * Метод установки ловушки
     *
     * @param trap
     */
    public void setTrap(Object trap) {
        System.out.println("Не удалось установить ловушку");
    }
}
