import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Teams
{
    private int number;
    private int matchNumber;
    private int weeksNumber;
    private int bay=0;
    public Teams() {}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public int getRoundNumber() {
        return weeksNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.weeksNumber = roundNumber;
    }

    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    List<String> teamsName = new ArrayList<>();

    public void teamsadd()
    {
        System.out.println("Fikstürde kaç adet takım olmasını istersiiniz : ");
        this.number = input.nextInt();
        System.out.println("Lütfen takım isimlerini giriniz :  ");
        int a = 0;
        for (int i = 0 ; i < number ;i++)
        {
            System.out.print( ++a + ". takım ;");
            teamsName.add(input2.nextLine());
        }
        if(number%2 !=0)
        {
            this.bay=1;
            System.out.println("Takım sayısı çift olmadığından ");
            System.out.println("Hafta da 1 takım BAY geçecektir");
            teamsName.add("BAY");
        }

    }

    public void matchandWeeksNumber()
    {
        Collections.shuffle(teamsName);
        this.matchNumber=(teamsName.size()*(teamsName.size()-1));
        this.weeksNumber=(this.matchNumber/teamsName.size())*2;
        if (this.bay==1)
        {
            System.out.println(teamsName.size() -1  + " adet takım toplamda ;");
        }
        else
        {
            System.out.println(teamsName.size() + " adet takım toplamda ;");
        }
        System.out.println(this.weeksNumber + " hafta ");
        System.out.println(this.matchNumber + " adet maç oynayacaktır");
    }

    public void generateFixture()
    {
        String[] host = new String[this.matchNumber / 2];
        String[] away = new String[this.matchNumber / 2];

        for (int i = 0, a = 0; i < teamsName.size() - 1; i++)
        {
            
            for (int j = 0; j < teamsName.size() / 2; j++)
            {
                if (teamsName.get(j) != null && teamsName.get(teamsName.size() - 1 - j) != null)
                {
                    host[a] = teamsName.get(j);
                    away[a] = teamsName.get(teamsName.size() - 1 - j);
                    a++;
                }
            }
            Collections.rotate(teamsName.subList(1, teamsName.size()), 1);
        }
        for (int i = 0, a = 0, b = 0; i < weeksNumber; )
        {
            System.out.println("========================");
            System.out.println("\n" + (++i) + ". Hafta");
            for (int j = 0; j < teamsName.size()/2; j++, a++)
            {
                System.out.println(host[a] + " vs " + away[a]);
            }
            System.out.println("========================");
            System.out.println("\n" + (++i) + ". Hafta");
            for (int j = 0; j < teamsName.size()/2; j++, b++)
            {
                System.out.println(away[b] + " vs " + host[b]);
            }
            System.out.println("========================");
        }
    }


}
