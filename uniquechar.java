import java.util.HashMap;
import java.util.List;
import java.util.*;

/**
 * Created by yueyangzou on 15/12/20.
 * the 1.1-1.8 of cc150 (Containuniquechar1 and Containuniquechar2);
 */
public class uniquechar {

public static void main(String[] args) {
    uniquechar c = new uniquechar();

//    System.out.println(c.Containuniquechar2("d"));//test of 1.1
//    System.out.println(c.Containuniquechar1("d"));//test of 1.1
//    System.out.println(c.reverse("abcde"));//test of 1.2
//    System.out.println(c.PerMu("aaaaba", "aabaaa"));//test of 1.3
//    System.out.println(c.StringReplace("Mr John Smith    "));//test of 1.4
//    System.out.println(c.StrCompress("abcde"));//test of 1.5
//    int b[][] = {{1, 2, 0}, {4, 5, 6}, {7, 8, 9}};//test of 1.6
//    int[][] cdd = c.rotate90Image(b);
//    c.setZeros(b);
//    System.out.println(c.containSubString("waterbottle","erbottlewat"));

//    ArrayList<String> newstr = new ArrayList<>();
//    newstr = c.generateParenthesis(2);

    int[] nums = {-1, 1, 0, 1, 2, -2};
    c.fourSum(nums, 0);




//    System.out.println(c.countDigitOne(13));
}
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Integer> diff = new ArrayList<Integer>();

        result.add("");
        diff.add(0);

        for (int i = 0; i < 2 * n; i++) {
            ArrayList<String> temp1 = new ArrayList<String>();
            ArrayList<Integer> temp2 = new ArrayList<Integer>();

            for (int j = 0; j < result.size(); j++) {
                String s = result.get(j);
                int k = diff.get(j);

                if (i < 2 * n - 1) {
                    temp1.add(s + "(");
                    temp2.add(k + 1);
                }

                if (k > 0 && i < 2 * n - 1 || k == 1 && i == 2 * n - 1) {
                    temp1.add(s + ")");
                    temp2.add(k - 1);
                }
            }

            result = temp1;
            diff = temp2;
        }

        return result;
    }


    public  int findDuplicate(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int low = 1, high = nums.length - 1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid)
                    count++;
            }
            if (count > mid)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;

        if (nums.length == 0) return result;
        int k = 0, m = 0, sum = 0;
        for (int i = 0; i < n - 3; i++) {
            //while(i< n - 3 && nums[i]==nums[i + 1]) ++i; // skip outer loop

            if(nums[i]<<2 > target) return result;
            for (int j = i + 1; j < n - 2; j++) {
                if(nums[j]<<2 < target) break;
                k = j + 1;
                m = n - 1;
                while (k < m) {
                    sum = nums[i] + nums[j] + nums[k] + nums[m];
                    if (sum < target) k++;
                    else if (sum > target) m--;
                    else {
                        result.add(Arrays.asList(nums[i] , nums[j] , nums[k] , nums[m]));
                        while (++k < m && nums[k] == nums[k - 1]) continue;
                        while (--m > k && nums[m] == nums[m + 1]) continue;
                    }

                }

            }

        }
        return result;

    }



//    public ArrayList<String> generateParenthesis(int n) {
//        ArrayList<String> m=new ArrayList<>();
//        generate(m, "", n, n);
//        return m;
//    }
//    public void generate(ArrayList m, String s, int l, int r){
//        if(l==0 && r==0){
//            m.add(s);
//            return;
//        }
//        if(l>0) generate(m, s+"(",  l-1,  r);
//        if(r>l) generate(m, s+")",  l,  r-1);
//    }

    public int countDigitOne(int n) {

        if (n == 1) {
            return 1;
        }
        else if (n <= 0) {
            return 0;
        }
        int m = n;
        int digitnumber = 0;

        while (m != 0) {
            if ((m % 10) == 1){
                digitnumber++;
            }
            m = m / 10;
        }
        return countDigitOne(n - 1) + digitnumber;
    }



    // the way without hashtables.
    public boolean Containuniquechar1(String s) {
        if (s == null) return true;
        char[] arr = s.toCharArray();
        boolean[] flag = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            if (flag[arr[i]]) {
                return false;
            } else {
                flag[arr[i]] = true;
            }
        }
        return true;
    }


    //the way with hashtables of 1.1.
    public boolean Containuniquechar2(String s) {
        if (s == null) {
            return true;
        }
        char[] arr = s.toCharArray();
        HashMap<Character, Boolean> map = new HashMap<>();
        for (Character c : arr) {
            if (map.containsKey(c)) return false;
            else {
                map.put(c, true);
            }
        }
        return true;
    }

    //test 1.2
    public String reverse(String s) {
        if (s == null) return null;
        StringBuffer reverseSen = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            reverseSen.append(s.charAt(i));
        }
        return reverseSen.toString();
    }

    //test 1.3
    public boolean PerMu(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(arr1[i])) {
                int newVale = map.get(arr1[i]) + 1;
                map.put(arr1[i], newVale);
            } else {
                map.put(arr1[i], 1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (map.containsKey(arr2[i])) {
                int newValue2 = map.get(arr2[i]) - 1;
                if (newValue2 > -1) {
                    map.put(arr2[i], newValue2);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    //test 1.4
    public String StringReplace(String s) {
        if (s == null) return null;

        char[] arrOri = s.toCharArray();
        boolean flag = false;
        int current = arrOri.length - 1;
        for (int i = arrOri.length - 1; i >= 0; i--) {
            if (arrOri[i] != ' ') {
                arrOri[current--] = arrOri[i];
                flag = true;

            } else if (flag == true && arrOri[i] == ' ') {
                arrOri[current--] = '0';
                arrOri[current--] = '2';
                arrOri[current--] = '%';
            }

        }
        String s1 = new String(arrOri);
        return s1;
    }

    //test 1.5
    public String StrCompress(String s) {
        char[] arr = s.toCharArray();
        StringBuilder arr2 = new StringBuilder();
        int current = 0;
        int count = 0;
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == arr[current]) {
                count++;
            } else {
                arr2.append(arr[i - 1]);
                arr2.append(count);
                current = i;
                count = 1;
            }

        }
        arr2.append(arr[len - 1]);
        arr2.append(count);
        if (arr2.length() < s.length()) return arr2.toString();
        else return s;

    }

    //test 1.6
    public int[][] rotate90Image(int[][] m) {
        printMatrix(m);
        int row = m.length;
        for (int r = 0; r < row / 2; r++) {
            for (int i = 0; i < row - 1 - 2 * r; i++) {
                int temp = m[row - i - r - 1][r];//4 to temp;
                m[row - i - r - 1][r] = m[row - r - 1][row - r - i - 1];//3 to 4;
                m[row - r - 1][row - r - i - 1] = m[r + i][row - r - 1];//2 to 3;
                m[r + i][row - r - 1] = m[r][r + i];// 1 to 2;
                m[r][r + i] = temp;//temp to 1;
            }
        }
        printMatrix(m);

        return m;

    }

    public void printMatrix(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    //test 1.7
    public int[][] setZeros(int[][] m) {
        int row1 = m.length;
        int col1 = m[0].length;
        printMatrix(m);

        boolean[] a = new boolean[row1];
        boolean[] b = new boolean[col1];
        for (int i = 0; i <= row1 - 1; i++) {
            for (int j = 0; j <= col1 - 1; j++) {
                if (m[i][j] == 0) {
                    b[j] = true;
                    a[i] = true;
                    break;
                }
            }
        }
        for (int k = 0; k < row1; k++) {
            if (a[k]) {
                for (int n = 0; n < col1; n++) {
                    m[k][n] = 0;
                }
            }

        }
        for (int k = 0; k < col1; k++) {
            if (b[k]) {
                for (int n = 0; n < row1; n++) {
                    m[n][k] = 0;
                }
            }

        }
        printMatrix(m);
        return m;
    }
    //test 1.8
    public boolean containSubString(String s1, String s2) {
        String s3 = s1+s2;
        if (s3.indexOf(s2)!=-1){
            return true;
        }else{
            return false;
        }

        //str.indexOf(substr)!=-1;
    }

}
