
class Matrix {
    private  String[] matrixString;
    public int numberOfRow;
    public int numberOfCol;

    Matrix(String matrixAsString) {

        this.numberOfRow=matrixAsString.split("\n").length;

        matrixAsString=matrixAsString.replace("\n"," ");
        this.matrixString=matrixAsString.split(" ");
        this.numberOfCol=this.matrixString.length/numberOfRow;

    }

    int[] getRow(int rowNumber) {


        int[] row=new int[numberOfCol];
        for(int i=numberOfCol*rowNumber,j=0;j<numberOfCol;i++,j++){
            row[j]=Integer.parseInt(this.matrixString[i]);
        }
        return row;
    }

    int[] getColumn(int columnNumber) {
        int[] col=new int[numberOfRow];
        for(int i=columnNumber,j=0;j<numberOfRow;i+=numberOfCol,j++)
            col[j]=Integer.parseInt(this.matrixString[i]);
        return col;
    }
}
