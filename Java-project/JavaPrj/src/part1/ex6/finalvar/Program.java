package part1.ex6.finalvar;

import java.util.Scanner;

public class Program{
		
public static void main(String[] args) {
	
	int[] kors = new int[3];
	int total;
	float avg;
	int menu;

	Scanner scan = new Scanner(System.in);
	
	for(int i=0; i<3; i++) 
		kors[i] = 0;

	종료:
	while (true) {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│           메인 메뉴                  │");
		System.out.println("└───────────────────────────┘");
		System.out.println("\t1. 성적입력 ");
		System.out.println("\t2. 성적출력 ");
		System.out.println("\t3. 종료 ");
		System.out.println("\t선택> ");
		menu = scan.nextInt();

		
		switch(menu) {
		
		//input the grade
		case 1: 
			System.out.println("┌───────────────────────────┐");
			System.out.println("│           성적  입력                 │");
			System.out.println("└───────────────────────────┘");
			System.out.println();

			for(int i=0; i<3; i++)
			do {
				System.out.printf("국어%d : ", i+1);
				kors[i] = scan.nextInt();

				if (kors[i] < 0 || 100 < kors[i])
					System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");

			} while (kors[i] < 0 || 100 < kors[i]);
					
			System.out.println("─────────────────────────────");
			
		case 2:
		
		//print grade
			
			total = kors[0] + kors[1] + kors[2];
			avg = total / 3.0f;

			System.out.println("┌───────────────────────────┐");
			System.out.println("│           성적  출력                   │");
			System.out.println("└───────────────────────────┘");
			System.out.println();

			
			for (int i = 0; i < 3; i++) {
				System.out.printf("\t국어 %d : %3d\n", i+1, kors[i]);
			}

			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("─────────────────────────────");

		case 3:
			break 종료;
	
		
		default:
			System.out.println("입력 오류 1~3까지만 입력할 수 있습니다");
	  }
	}
	
	System.out.println("good bye~");

  }
}

