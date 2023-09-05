public class Main {
    public static void main(String[] args) {
        int[] tab = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        for (int el: tab)
            System.out.print(el + " ");
        System.out.println();
        System.out.println(searchIt(tab,15));
        System.out.println(searchRec(tab,15));
    }

    static int searchIt(int[] tab, int num) {
        int l = 0, r = tab.length - 1;
        while (l<=r) {
            int mid = (l + r) / 2;
            if (tab[mid] == num)
                return mid;
            else if (tab[mid] < num)
                l = mid + 1;
            else if (tab[mid] > num)
                r = mid -1;
        }
        return -1;
    }

    static int searchRec(int[] tab, int num) {
        int l = 0, r = tab.length - 1;
        int mid = (l + r) / 2;
        if (r<l)
            return Integer.MIN_VALUE;
        if (tab[mid] == num) {
            return mid;
        }
        else if (tab[mid] > num){
            int[] tabNew = new int[mid];
            System.arraycopy(tab, 0, tabNew, 0,mid);
            return searchRec(tabNew, num);
        }
        else if (tab[mid] < num) {
            int[] tabNew = new int[r-mid];
            System.arraycopy(tab, mid+1, tabNew, 0, r-mid);
            return mid + searchRec(tabNew, num) + 1;
        }
        return -1;
    }
}