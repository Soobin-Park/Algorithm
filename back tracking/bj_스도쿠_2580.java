package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_스도쿠_2580 {
    static int[][] sudoku;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sudoku = new int[9][9];

        for(int i=0;i<9;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solveSudoku(0,0);

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    
    
    //visited를 반환값으로 전달하는 느낌
    static boolean solveSudoku(int i, int j){
        if(j == 9){
            i++;
            j=0;
        }
        if(i == 9)
            //스도쿠 다채움
            return true;
        
        if(sudoku[i][j] !=0)
            //다음칸이동
            return solveSudoku(i,j+1);

        for(int n=1;n<=9;n++){
            //가로, 세로, 정사각형 체크
            if(isValid(i,j,n)){
                sudoku[i][j] = n;

                if(solveSudoku(i,j+1))
                    return true;
                
            //채웠다가 다른 것에 의해 바뀌어야할 수도 있음
            sudoku[i][j] = 0;
            }
        }
        return false;
        
    }
    
    
    static boolean isValid(int i, int j, int n){
        //가로 체크
        for(int k=0;k<9;k++){
            if(sudoku[i][k] == n)
                return false;
        }
        
        //세로 체크
        for(int k=0;k<9;k++){
            if(sudoku[k][j] == n)
                return false;
        }
        
        //정사각형 체크
        int startI = (i/3)*3;
        int startJ = (j/3)*3;
        for(int k=startI;k<startI+3;k++){
            for(int l = startJ;l<startJ+3;l++){
                if(sudoku[k][l] == n)
                    return false;
            }
        }
        return true;
    }
}
