package dnd.classes;

public abstract class Rogue extends Hero {
    private final int pickPocketChancePerLevel;
    private final int getSearchForTrapsChancePerLevel;
    private int pickPocketChance;
    private int searchForTrapsChance;

    /**
     * С ростом уровня разбойник лучше крадет и лучше ищет ловушки
     */
    @Override
    public void onLevelUp() {
        pickPocketChance += pickPocketChancePerLevel;
        searchForTrapsChance += getSearchForTrapsChancePerLevel;
    }

    public Rogue(String name, int hpPerLevel, int pickPocketChancePerLevel, int getSearchForTrapsChancePerLevel) {
        super(name, hpPerLevel);
        this.pickPocketChancePerLevel = pickPocketChancePerLevel;
        this.getSearchForTrapsChancePerLevel = getSearchForTrapsChancePerLevel;
    }


    /**
     * попытка обчистить карманы цели
     *
     * @param targetResistance
     * @return
     */
    public boolean trySteal(int targetResistance) {
        if (targetResistance < pickPocketChance) {
            System.out.println("Кража удалась");
            return true;
        }
        System.out.println("Кража не удалась!");
        return false;

    }

    /**
     * Поиск ловушек вокруг
     *
     * @param trapsAround
     * @return
     */
    public boolean searchForTraps(int[] trapsAround) {
        for (int trap : trapsAround) {
            if (trap < searchForTrapsChance) {
                System.out.println("Кажется, я видел ловушку");
                return true;
            }
        }
        System.out.println("Видишь ловушки? И я не вижу, а они есть =)");
        return false;
    }
}
