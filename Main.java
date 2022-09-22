import java.util.*;

import javax.smartcardio.ATR;


public class Main {
    public static void main(String[] args){
        Programmer[] programmers = new Programmer[]{ 
            new Programmer(new String[] {"B", "A", "C"}),
            new Programmer(new String[] {"A", "B", "C"}),
            new Programmer(new String[] {"A", "C", "B"})
        };

        Company[] companies = new Company[]{
            new Company(new int[] {3, 1, 2}),
            new Company(new int[] {1, 2, 3}),
            new Company(new int[] {1, 3, 2})
        };

        hirePeople(programmers, companies);
    }

    public static void hirePeople(Programmer[] programmers, Company[] companies){
        HashMap<Integer, String> partnerships = new HashMap<>();
        int n = programmers.length;
        if (programmers.length != companies.length){
            System.out.println("Error: number of programmers not equal to the number of companies");
        }
        else {
            
            for (int i = 0; i < n; i++){
                boolean found = false;
                int counter = 0;
                while (found == false){
                    Programmer currentProgrammer = programmers[i]; 
                    if (!partnerships.containsValue(currentProgrammer.classement[counter])){
                        partnerships.put(i, currentProgrammer.classement[counter]);
                        found = true;
                    }
                    else {
                        counter++;
                    }
                }
            }
        }
        for (int i = 0; i< n; i++){
            String companyRank = partnerships.get(i);
            if (companyRank != programmers[i].classement[0]){
                for (int j = findIndex(programmers[i].classement, companyRank); j > 0; j--){
                    if (findIndexInt(companies[j].classement, i) < findIndexInt(partnerships.getKey())
                }
            }
        }
        System.out.println(partnerships.toString());
    }

    // Credit: https://www.geeksforgeeks.org/find-the-index-of-an-array-element-in-java/
    public static int findIndex(String[] arr, String t)
    {
        // Creating ArrayList
        ArrayList<String> clist = new ArrayList<>();
  
        // adding elements of array
        // to ArrayList
        for (int i = 0; i < arr.length; i++)
            clist.add(arr[i]);
  
        // returning index of the element
        return clist.indexOf(t);
    }

    public static int findIndexInt(int[] arr, int t)
    {
        // Creating ArrayList
        ArrayList<Integer> clist = new ArrayList<>();
  
        // adding elements of array
        // to ArrayList
        for (int i = 0; i < arr.length; i++)
            clist.add(arr[i]);
  
        // returning index of the element
        return clist.indexOf(t);
    }
}
