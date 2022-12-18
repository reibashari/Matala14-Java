/**
 * maman 14  - 2 recursive methods . 
 * @Rei Bashari , 315522
 * @20-05-21 
 */
public class Ex14
{
    
    //----------------------------------------------Q1----------------------------------------------
    
    /**
     * The method checks if there is a stain and if so what its size . 
     * @param mat - the matrix we check . 
     * @param x - the x coordinate.  
     * @param y - the y coordinate. 
     * @return the size number of the stain . 
     */
    public static int size (boolean[][] mat, int x, int y)
    {
        if (x > mat.length-1 || x < 0 || y < 0 || y > mat[0].length-1 )
            return 0; 
        if (mat[x][y] == false) 
            return 0; 
        
        boolean[][] newArr = new boolean[mat.length][mat[0].length] ;
        copyArr (mat , newArr , 0 , 0 ) ; 
        return stain(newArr , x, y) ; 
    }
    
    private static int stain(boolean[][] mat , int x , int y) 
    {
        if (x > mat.length-1 || x < 0 || y < 0 || y > mat[0].length-1 ) 
            return 0; 
        if (mat[x][y] == false) 
            return 0;
        
        mat[x][y] = false ; 
        return 1+ (stain(mat,x,y+1) + stain(mat,x,y-1) + stain(mat,x+1,y) + stain(mat,x-1,y) +
        stain(mat,x-1,y-1) + stain(mat,x-1,y+1) + stain(mat,x+1,y+1) + stain(mat,x+1,y-1)) ;
    }
    
    private static void copyArr(boolean[][] mat1 , boolean[][] mat2 , int i , int j)
    {
        if(i == mat1.length) 
            return; 
        if(j == mat1[i].length)
            copyArr(mat1,mat2, i+1, 0) ;
        else {
            mat2[i][j] = mat1[i][j] ; 
            copyArr(mat1,mat2,i,j+1) ; 
        }
        
    }
    
    //----------------------------------------------Q2----------------------------------------------

    /**
     * The method checks if the two matrix contain the same number in a different order . 
     * @param matrix a - the first matrix . 
     * @param matrix b - the second matrix . 
     * @return true if the numbers in the matrix is same but in different order .
     */
    public static boolean isPermutation(int[] a, int[] b)
	{
		if (a.length != b.length)
		{
			return false;
		}

		return isPermutation(a, b, 0);
	}

	private static boolean isPermutation(int[] a, int[] b, int i)
	{
		if (i == a.length)
		{
			return true;
		}

		int num = a[i];
		int countNumInA = isPermutation(a, 0, num);
		int countNumInB = isPermutation(b, 0, num);
		if (countNumInA != countNumInB)
		{
			return false;
		}

		return isPermutation(a, b, i + 1);
	}

	private static int isPermutation(int[] a, int i, int num)
	{
		if (i == a.length)
		{
			return 0;
		}

		if (a[i] == num)
		{
			return 1 + isPermutation(a, i + 1, num);
		}

		return isPermutation(a, i + 1, num);
	}
}
