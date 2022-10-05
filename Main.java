import java.util.*;

public class Main {
    public static void main(String[] args){

        char[][] programmers = {{'b','a','c'}, {'b','a','c'}, {'b','c','a'}};
        int[][] companies = {{3,1,2}, {1,2,3}, {1,3,2}};

        System.out.println(Arrays.deepToString(programmers));
        hirePeople(programmers, companies);
    }

    public static void hirePeople(char[][] programmers, int[][] companies){
        HashMap<Integer, Character> partnerships = new HashMap<>();
        int n = programmers.length;
        if (programmers.length != companies.length){
            System.out.println("Error: number of programmers not equal to the number of companies");
        }
        else {
            // Makes initial partnerships based on the programmer's preferences
            for (int i = 0; i < n; i++){
                boolean found = false;
                int counter = 0;
                while (found == false){
                    char[] currentProgrammer = programmers[i];
                    if (!partnerships.containsValue(currentProgrammer[counter])){
                        partnerships.put(i, currentProgrammer[counter]);
                        found = true;
                    }
                    else {
                        counter++;
                    }
                }
            }
        }
        for (int i = 0; i< n; i++){
            for (int j=0; j <  findIndex(programmers[i], partnerships.get(i)); j++){
                char companyJName = (char)(j + 97);
                int companyJProgrammer = getKey(partnerships, companyJName);
                // if company companies[j] likes programmers[i] more than their current programmer AND programmers[i] likes companies[j] more than their current company, swap programmers
                if ( findIndexInt(companies[j], i+1) < findIndexInt(companies[j], companyJProgrammer) && findIndex(programmers[i], partnerships.get(i)) > findIndex(programmers[i], companyJName)){
                    char tempCompany = partnerships.get(i);
                    partnerships.put(i, companyJName);
                    partnerships.put(companyJProgrammer, tempCompany);
                }

            }
        }
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
        for(int i =0; i< map.size(); i++)  {
            // if give value is equal to value from entry
            // print the corresponding key
            if(map.get(i) == value) {
                return i;
            }
        }
        return -1;
    }

}
