import java.util.*;

public class Main {
    public static void main(String[] args){
        
        // Test values. Can be editted to trial different values.
        char[][] programmers = {{'b','a','c'}, {'b','a','c'}, {'b','c','a'}};
        int[][] companies = {{3,1,2}, {1,2,3}, {1,3,2}};

        hirePeople(programmers, companies);
    }

    public static void hirePeople(char[][] programmers, int[][] companies){
        HashMap<Integer, Character> partnerships = new HashMap<>();
        int n = programmers.length;
        // Makes initial partnerships based on the programmer's preferences
        for (int i = 0; i < n; i++){
            boolean found = false;
            int counter = 0;
            while (found == false){
                 char[] currentProgrammer = programmers[i];
                 if (!partnerships.containsValue(currentProgrammer[counter])){
                     partnerships.put(i + 1, currentProgrammer[counter]);
                     found = true;
                        }
                 else {
                    counter++;
                        }
                    }
        }
        
        // Iterates through programmers, checks for unsatisfactory partnerships
        for (int i = 1; i<= n; i++){
            for (int j=0; j <  findIndex(programmers[i-1], partnerships.get(i)); j++){
                char companyJName = programmers[i-1][j];
                int b = ((int) companyJName) - 97;
                int companyJProgrammer = getKey(partnerships, companyJName);
                // if company b likes programmers[i] more than their current programmer AND programmers[i] likes company b more than their current company, swap programmers
                if ( findIndexInt(companies[b], i) < findIndexInt(companies[b], companyJProgrammer) && findIndex(programmers[i-1], partnerships.get(i)) > findIndex(programmers[i-1], companyJName)){
                    char tempCompany = partnerships.get(i);
                    partnerships.put(i, companyJName);
                    partnerships.put(companyJProgrammer, tempCompany);
                    i = 1;
                }
            }
        }
        // Prints resulting pairings
        System.out.println(partnerships.toString());
    }



    // Credit: https://www.geeksforgeeks.org/find-the-index-of-an-array-element-in-java/
    public static int findIndex(char[] arr, char t)
    {
        // Creating ArrayList
        ArrayList<Character> clist = new ArrayList<>();

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

    public static int getKey(HashMap<Integer, Character> map, Character value){
        for(int i =1; i<= map.size(); i++)  {
            // if give value is equal to value from entry
            // return the corresponding key
            if(map.get(i) == value) {
                return i;
            }
        }
        return -1;
    }

}
