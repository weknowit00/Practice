package part3.ex5.추상화;

import java.util.Scanner;

public abstract class ExamConsole {
	
	//Composition Has A 일체형
	private ExamList list = new ExamList();

	public void print() {
		this.print(list.size());
	}
		
	public void print(int size) {
		System.out.println("┌───────────────────────────┐");
	    System.out.println("│           성적  출력                  │");
	    System.out.println("└───────────────────────────┘");
	    System.out.println();	
	    
	    //int size = list.current;
	    
	    for(int i=0; i<size; i++) {
	    	Exam exam = list.get(i);//this.exams[i];
		    int kor = exam.getKor();
		    int eng = exam.getEng();
		    int math = exam.getMath();
		   
		    int total = exam.total();//kor + eng + math;
		    float avg = exam.avg();//total/3.0f;
		    
		    System.out.printf("국어 : %d\n", kor);	
		    System.out.printf("영어 : %d\n", eng);	
		    System.out.printf("수학 : %d\n", math);	
		    
		    onPrint(exam);
		        
		    System.out.printf("총점 : %3d\n", total);
		    System.out.printf("평균 : %6.2f\n", avg);
		    System.out.println("─────────────────────────────");		   
	    }	  
	}
	    
		public void input() {
			Scanner scan = new Scanner(System.in);
			System.out.println("┌───────────────────────────┐");
			System.out.println("│           성적  입력                  │");
			System.out.println("└───────────────────────────┘");
			System.out.println();
			
				int kor, eng, math;
				
				do {
				    System.out.printf("국어 : ");
				    kor = scan.nextInt();
				
				    if(kor < 0 || 100 < kor)
				    	System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
				    
				}while(kor < 0 || 100 < kor);
				
				do {
				    System.out.printf("영어 : ");
				    eng = scan.nextInt();
				
				    if(eng < 0 || 100 < eng)
				    	System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");
				    
				}while(eng < 0 || 100 < eng);
				
				do {
				    System.out.printf("수학 : ");
				    math = scan.nextInt();
				
				    if(math < 0 || 100 < math)
				    	System.out.println("수학성적은 0~100까지의 범위만 입력이 가능합니다.");
				    
				}while(math < 0 || 100 < math);
				
				
				/*
				exam.setKor(kor);
				exam.setEng(eng);
			    exam.setMath(math);
			    */
			    
				//Exam exam = new Exam(kor, eng, math);
				Exam exam = makeExam();
				exam.setKor(kor);
				exam.setEng(eng);
				exam.setMath(math);
				
				onInput(exam);

//				add---------------------------------------
				
				list.add(exam);
			    
							
		}

		protected abstract void onInput(Exam exam);

	    protected abstract void onPrint(Exam exam);

		protected abstract Exam makeExam();
}
