package com.askin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by askin_000 on 22.10.2016.
 */
public class FastaTool {

    ArrayList<Sequence> allSequences;

    public Integer longestSequenceLength;
    public Integer shortestSequenceLength;
    public Integer totalSequenceLength;
    public Integer rowCount;

    public Integer totala =0;
    public Integer totalc =0;
    public Integer totalg =0;
    public Integer totalu =0;
    public Integer totalnull = 0;

    public static Integer ROW_LENGTH= 60;

    public Integer lastNucleotideCount = 0;


    public FastaTool(List<String> lines){

        allSequences = new ArrayList<>();

        Sequence lastSeq = new Sequence("temp"); //To satisfy the compiler.

        for (String s:lines) {
            //System.out.println(s);

            if(s.charAt(0) == '>'){
                lastSeq = new Sequence(s.substring(1));
                allSequences.add(lastSeq);
            }else{
                lastSeq.pushNucleotides(s);

            }

        }

        //Calculation of the longest sequence length
        longestSequenceLength = 0;
        for(Sequence s : allSequences){
            if(s.GetLength() > longestSequenceLength){
                longestSequenceLength = s.GetLength();
            }

        }

        //Calculation of the shortest sequence length
        shortestSequenceLength = (int)longestSequenceLength;
        for(Sequence s: allSequences){
            if(s.GetLength() < shortestSequenceLength){

                shortestSequenceLength = s.GetLength();

            }
        }


        //Calculation of the total sequence length
        totalSequenceLength = 0;
        for(Sequence s:allSequences){
            totalSequenceLength += s.GetLength();
        }

        //To decide how many rows we need to print
        rowCount = (longestSequenceLength / ROW_LENGTH) +1;

        //This is going to be used in printing the last row's header
        lastNucleotideCount = longestSequenceLength % ROW_LENGTH;



        //Counting of each nucleotide
        for(Sequence s :allSequences){
            totala += s.GetCount(0);
            totalc += s.GetCount(1);
            totalg += s.GetCount(2);
            totalu += s.GetCount(3);
            totalnull += s.GetCount(4);
        }


    }

}
