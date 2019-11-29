package com.bridgelabz.csvfileops;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadingCSVDataAtATime {
    private static final String SAMPLE_CSV_FILE_PATH = "/home/admin1/IdeaProjects/Read-Write-CSV-file/src/main/resources/user-data.csv";

    public static void main(String[] args) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> allRecords=csvReader.readAll();

    for (String[] record:allRecords){
        System.out.println("Name:"+record[0]);
        System.out.println("Email:"+record[1]);
        System.out.println("Phone:"+record[2]);
        System.out.println("Country:"+record[3]);
        System.out.println("===================================");
    }
    }
}
