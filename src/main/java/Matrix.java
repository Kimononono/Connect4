import java.util.ArrayList;
import java.util.List;

public class Matrix {
    double[][] data;
    int row; int col;

    public Matrix(int row, int col){
        this.row = row;
        this.col = col;
        data=new double[row][col];
        for(int i=0;i< data.length;i++){
            for(int ii=0;ii<data[0].length;ii++){
                data[i][ii] = Math.random()*2 - 1;
            }
        }
    }

    public void add(double scalar){
        for(int i=0;i< data.length;i++){
            for(int ii=0;ii<data[0].length;ii++){
                data[i][ii] += scalar;
            }
        }
    }

    public void add(Matrix m){
        if(m.col != col || m.row != row) {
            System.out.println("Not Same Size");
            return;
        }
        for(int i=0;i< data.length;i++){
            for(int ii=0;ii<data[0].length;ii++){
                data[i][ii] += m.data[i][ii];
            }
        }
    }
    public static Matrix subtract(Matrix a, Matrix b){
        Matrix c = new Matrix(a.row,a.col);
        for(int i=0;i< c.data.length;i++){
            for(int ii=0;ii<c.data[0].length;ii++){
                c.data[i][ii] = a.data[i][ii] - b.data[i][ii];
            }
        }
        return c;
    }
    public static Matrix transpose(Matrix m){
        Matrix a = new Matrix(m.col,m.row);
        for(int i=0;i< a.data.length;i++){
            for(int ii=0;ii<a.data[0].length;ii++){
                a.data[i][ii] = m.data[ii][i];
            }
        }
        return a;
    }
    public static Matrix dot(Matrix a, Matrix b){
        Matrix c = new Matrix(a.row,b.col);
        for(int i = 0; i < c.row; i++){
            for(int ii = 0; ii< c.col; ii++){
                double sum = 0;
                for(int iii = 0; iii < a.row; iii++){
                    sum+=a.data[i][iii]*b.data[iii][ii];
                }
                c.data[i][ii]= sum;
            }
        }
    }
    public void multiply(Matrix a){
        for(int i = 0; i < a.row; i++) {
            for (int ii = 0; ii < a.col; ii++) {
                this.data[i][ii]*=a.data[i][ii];
            }
        }
    }
    public void multiply(double a){
        for(int i = 0; i < row; i++) {
            for (int ii = 0; ii < col; ii++) {
                this.data[i][ii]*=a;
            }
        }
    }
    public void sigmoid() {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
                this.data[i][j] = 1/(1+Math.exp(-this.data[i][j]));
        }

    }

    public Matrix dsigmoid() {
        Matrix temp=new Matrix(row,col);
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
                temp.data[i][j] = this.data[i][j] * (1-this.data[i][j]);
        }
        return temp;

    }

    public static Matrix fromArray(double[]x)
    {
        Matrix temp = new Matrix(x.length,1);
        for(int i =0;i<x.length;i++)
            temp.data[i][0]=x[i];
        return temp;

    }

    public List<Double> toArray() {
        List<Double> temp= new ArrayList<Double>()  ;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                temp.add(data[i][j]);
            }
        }
        return temp;
    }
}
