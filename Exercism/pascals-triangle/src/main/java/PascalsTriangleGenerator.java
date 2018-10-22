//input: n
//output: là 1 mảng 2 chiều dưới 
//dạng tam giác pascal n tầng
//vd: n=4;
//output: {{1},
//        {1,1},
//        {1,2,1},
//        {1,3,3,1}}
public class PascalsTriangleGenerator {


    PascalsTriangleGenerator(){

    }

    public int[][] generateTriangle(int n){
        //tạo mảng 2d chứa tối đa n mảng
         int[][] pascalArray=new int[n][];
        if(n==0)
            return pascalArray;

        for(int i=0;i<n;i++){
            int[] a= new int[i+1];
            for(int j=0;j<i+1;j++){
                //vị trí phần tử đầu tiên và cuối cùng sẽ = 1
                if(j==0||j==i)
                    a[j]=1;
                else{
                    //phần tử bên dưới = phần tử bên + phần tử trước đó
                    a[j]=pascalArray[i-1][j]+pascalArray[i-1][j-1];
                }
            }
            pascalArray[i]=a;
        }
        return pascalArray;
    }
}
