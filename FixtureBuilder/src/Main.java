public class Main
{
    public static void main(String[] args)
    {
        System.out.println("--------------- TFF Trendyol Süperlig Fikstür Oluşturma  ---------------");
        Teams team = new Teams();
        System.out.println();
        team.teamsadd();
        {
            System.out.println("Fikstür 1 Ev 1 Deplasman şeklinde oluşturalacaktır.");
        }
        team.matchandWeeksNumber();
        team.generateFixture();

    }
}
