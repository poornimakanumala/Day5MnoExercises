package com.assignments;

import java.util.Arrays;

public class MobileSum {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//input1=mno,input2=9
		int result = mobileSum(9912508172l,9);
		System.out.println("The mobile sum result is:= "+result);
	}
	
public static int mobileSum(long M,int N) {
	int[] mno = new int[10];
	int result=0;
	for(int i=mno.length-1;i>=0;i--) {
			mno[i]=(int) (M%10);
			M=M/10;
	}		
	System.out.println("Mobile number into Array:" + Arrays.toString(mno));
	//Checking each element with target in 1 go
	for(int i=0;i<mno.length;i++) {
		if(mno[i]==N) {
			mno[i]=0;
			}
		}
	System.out.println("Array after each element equals to Target:= " + Arrays.toString(mno));
	//Checking if 2digits sum is equal to target value-N
	for(int i=0;i<mno.length;i++) {
		for(int j=i+1;j<mno.length;j++) {
			if(mno[i]+mno[j]==N) {
				mno[i]=0;
				mno[j]=0;
			}
		}
	}	
	System.out.println("Array after possibility based on 2digits:= " + Arrays.toString(mno));
	//Finally sum the left  out digits
	for(int i:mno) {
		result+=i;
	}
	return result;
}
}
