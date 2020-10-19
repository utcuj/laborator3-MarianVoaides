package com.company;
import com.company.Bilete;
import java.util.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class Loterie
{

    private int numereCastigatoare[]=new int[6];

    public static void main(String[] args)
    {


        Scanner in = new Scanner(System.in);
        Loterie l = new Loterie();
        int[] numereCastigatoare = l.extragere();
        int[] numereAlese = new int[6];
        System.out.println("Introduceti numerele: ");
        for (int k  = 0; k < 6; k++){
            numereAlese[k] = in.nextInt();
        }
        int count = 0;
        Bilete b = new Bilete(numereAlese);
        for(int i=0;i<6;i++)
        {
            int[] nrBilet =b.getNumere();
            for(int j=0;j<6;j++)
            {
                if(nrBilet[j]==numereAlese[i]);
                count++;
            }
        }
        if(count == 6)
        {
            System.out.println("Ai castigat!");
        }
        else
        {
            System.out.println("Ai pierdut!");
        }

        System.out.print("Probabilitatea de a castiga este = ");
        float cazpos = (49f * 48 * 47 * 46 * 45 * 44)/720f;
        BigDecimal p = new BigDecimal(100f/cazpos);
        System.out.println(p+"%");

        long x = 0;
        for(int m = 0; m < 6; m++)
        {
            x = x | (1 << numereAlese[m]);
        }

        int k = 0;

        while(x != 0)
        {
            if(x % 2 == 1)
            {
                System.out.println(k);
            }
            x = x >>> 1;
            k++;
        }





    }

    public int[] extragere()
    {
        Random r= new Random();
        for(int i=0;i<6;i++) {
            numereCastigatoare[i] = r.nextInt(50);
        }
        return numereCastigatoare;
    }


}