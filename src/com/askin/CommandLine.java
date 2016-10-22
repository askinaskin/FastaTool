package com.askin;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by askin_000 on 22.10.2016.
 */
public class CommandLine {

    public CommandLine(String stringPath){


        Path filePath = Paths.get(stringPath); //We've got the path as path

        List<String> lines;
        try{
            lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        }catch (IOException e){
            System.out.println("File read error, please give FULL PATH of the file as 1st argument.");
            return;
        }


        FastaTool ft = new FastaTool(lines);



        String nameFormat = "%-30s%s%n";
        for (int i =0;i<ft.rowCount;i++){

            for(Sequence s : ft.allSequences){

                System.out.printf(nameFormat,s.sequenceName,s.prettyPrint(i));

            }
            System.out.print("\n\n");

        }

        System.out.println("Number of sequences: " + ft.allSequences.size() ) ;
        System.out.println("Shortest sequence length : " +ft.shortestSequenceLength);
        System.out.println("Longest sequence length : " + ft.longestSequenceLength);
        System.out.println("Avrage sequence length : " + ft.totalSequenceLength / ft.allSequences.size());

        System.out.println("Counts: A: "+ft.totala+", C: "+ft.totalc+", G: "+ft.totalg+", U: "+ft.totalu+", -: "+ft.totalnull+"");




    }
}
