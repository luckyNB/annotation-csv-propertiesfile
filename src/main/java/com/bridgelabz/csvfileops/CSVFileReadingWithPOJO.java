package com.bridgelabz.csvfileops;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CSVFileReadingWithPOJO {
    private static final String SAMPLE_CSV_FILE_PATH = "/home/admin1/IdeaProjects/Read-Write-CSV-file/src/main/resources/user-data.csv";

    public static void main(String[] args) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CSVReader csvReader = new CSVReader(reader);
        CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true).build();

        Iterator<CSVUser> csvUserIterator=csvToBean.iterator();
        while (csvUserIterator.hasNext()){
            CSVUser csvUser=csvUserIterator.next();
            System.out.println("Name:"+csvUser.getName());
            System.out.println("Email:"+csvUser.getEmail());
            System.out.println("Phone:"+csvUser.getPhoneNo());
            System.out.println("Country:"+csvUser.getCountry());

        }
    }
}
