package com.askin;

import java.util.ArrayList;

/**
 * Created by askin_000 on 22.10.2016.
 */
public class Sequence {

    public ArrayList<Nucleotide> nucleotides;
    public String sequenceName;

    public Sequence(String _sequenceName) {
        sequenceName = _sequenceName;

        nucleotides = new ArrayList<>();

    }

    public void pushNucleotides(String sequenceAsString){
        char[] sequenceArray = sequenceAsString.toCharArray();
        for (char n : sequenceArray) {
            Nucleotide nuc = new Nucleotide();
            if (n == 'A') {
                nuc.type = 0;
            } else if (n == 'C') {
                nuc.type = 1;
            } else if (n == 'G') {
                nuc.type = 2;
            } else if (n == 'U') {
                nuc.type = 3;
            }else{
                nuc.type = 4;
            }
            nucleotides.add(nuc);
        }
    }
    public int GetLength() {
        return nucleotides.size();
    }


    public String prettyPrint(int row){
        int startsAt = 60*row;

        String sequenceString = "";

        for(int i = startsAt;i<startsAt + 60; i++){

            if(i<nucleotides.size()){
                sequenceString += nucleotides.get(i).printNucleotide();
            }

        }
        return sequenceString;
    }



    public String printSequence(){
        String sequenceString = "";
        for (Nucleotide n:nucleotides) {
            sequenceString += n.printNucleotide();
        }

        return sequenceName + " > " + sequenceString;
    }

    public int GetCount(int type) {
        int count = 0;

        for (Nucleotide n : nucleotides) {
            if(n.type ==type) {
                count++;
            }
        }

        return count;
    }
}
