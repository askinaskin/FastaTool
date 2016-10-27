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


    //This method analyzes incoming sequence, parses it, and creates corresponding nucleotides.
    public void pushNucleotides(String sequenceAsString){
        char[] sequenceArray = sequenceAsString.toCharArray();
        for (char n : sequenceArray) {
            Nucleotide nuc = new Nucleotide();
            if (n == 'A' ||n=='a') {
                nuc.type = 0;
            } else if (n == 'C' || n=='c') {
                nuc.type = 1;
            } else if (n == 'G' ||n=='g') {
                nuc.type = 2;
            } else if (n == 'U' ||n=='u') {
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



    //This method decides which nucletodies need to be printed, and concats them into a string.
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

    //This is a method for exporting sequences. If we need to
    public String printSequence(){
        String sequenceString = "";
        for (Nucleotide n:nucleotides) {
            sequenceString += n.printNucleotide();
        }

        return sequenceName + " > " + sequenceString;
    }


    //To obtain counts of different nucleotides.
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
