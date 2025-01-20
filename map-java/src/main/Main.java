package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String,Integer> votes;

    public static void main(String[] args) throws Exception {
        votes = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String path = "";
    
        System.out.print("Enter file full path: ");
        path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);

                if (votes.containsKey(name)){
                    int countSoFar = votes.get(name);
                    votes.put(name, count + countSoFar);
                }else{
                    votes.put(name, count);
                }
                line = br.readLine();
            }

        } catch (Exception e) {
            System.out.println("error: " + e);
        }


        for (String key : votes.keySet()) {
            System.out.println(key + "," + votes.get(key));
        }
        sc.close();
    }
}
