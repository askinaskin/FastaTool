package com.askin;

/**
 * Created by askin_000 on 22.10.2016.
 */
public class Nucleotide {

    public int type;

    // 0=> A
    // 1=> C
    // 2=> G
    // 3=> U
    // 4=> -

    public String printNucleotide(){
        if(type == 0){
            return "A";
        }else if(type==1){
            return "C";
        }else if(type==2){
            return  "G";
        }else if(type ==3){
            return "U";
        }else{
            return "-";
        }
    }

}
