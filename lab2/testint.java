public class testint {
    public static void main(String[] args){
        int a[]={3,5,7};
        Sortint arr2=new Sortint(a);
        System.out.println(arr2.found(4));
        int arr1[]=arr2.add(6);
        for(int i=0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }
    }
}
