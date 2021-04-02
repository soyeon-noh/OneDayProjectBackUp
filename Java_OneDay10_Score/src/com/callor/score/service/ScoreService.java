package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.StudentVO;

public class ScoreService {

	protected Scanner scan;
	protected List<StudentVO> studentVO;
	protected int line;

	public ScoreService() {
		scan = new Scanner(System.in);
		studentVO = new ArrayList<StudentVO>();
		line = 70;
	}

	// 메인 메뉴
	public void menu() {
		// TODO 메인 메뉴
		Integer intMenu = null;
		
		while (true) {
			System.out.println("=".repeat(line));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("=".repeat(line));
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println("=".repeat(line));
			System.out.print("업무선택 >> ");

			intMenu = this.checkMenu();
			
			if(intMenu == null ) {
				break;
			}else if(intMenu == 1) {
				this.input();
			}else if(intMenu == 2) {
				this.printList();
			}
			
		} // end while
		System.out.println("프로그램을 종료합니다. 안녕히가세요.");
	}// end menu

	private Integer checkMenu() {
		// TODO 메뉴 입력 및 유효성 체크
		String strMenu = null;
		Integer intMenu = null;

		while (true) {
			strMenu = scan.nextLine();

			if (strMenu.equals("QUIT")) {
				break;
			}
			
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				this.menuErrorMessage();
				continue;
			}

			if (intMenu == 1 || intMenu == 2) {
				break;
			}else {
				this.menuErrorMessage();
				continue;
			}
		}
		return intMenu;
	}

	// 입력 및 개인성적 출력
	private void input() {
		//TODO 1. 학생별 성적 입력
		String name = "";
		int cSub = 5;
		Integer[] scores = new Integer[cSub];
		String[] subName = { "국어", "영어", "수학", "과학", "국사" };

		while (true) {
			// 이름
			System.out.println("=".repeat(line));
			System.out.println("학생이름을 입력하세요(입력을 중단하려면 QUIT)");
			System.out.println("=".repeat(line));
			System.out.print("이름 >> ");
			
			// 이름 입력 및 유효성 체크
			name = this.checkName();	
			if (name.equals("QUIT")) {
				return;
			}

			// 성적
			System.out.println("=".repeat(line));
			System.out.println(name + " 학생의 성적을 입력하세요");
			System.out.println("\t(성적범위 : 0 ~ 100, 입력을 중단하려면 QUIT)");
			System.out.println("=".repeat(line));

			// 성적 입력 및 유효성 체크
			for (int i = 0; i < subName.length; i++) {
				System.out.printf("%3s >> ", subName[i]);
				scores[i] = this.checkScore();

				if (scores[i] == null) {
					return;
				}
			}

			// 이름 및 성적 리스트에 추가
			StudentVO vo = new StudentVO();
			vo.setName(name);

			vo.setIntKor(scores[0]);
			vo.setIntEng(scores[1]);
			vo.setIntMath(scores[2]);
			vo.setIntSci(scores[3]);
			vo.setIntHis(scores[4]);

			studentVO.add(vo);

			this.printStd(vo);
		}
	}

	private String checkName() {
		// TODO 이름 입력 및 유효성 체크
		String strName = null;
		
		while(true){
			strName = scan.nextLine();
			if(strName.equals("QUIT")) {
				return strName;
			}else if(strName.length() > 3) {
				System.out.println("이름은 세글자까지만 입력해주세요.");
				System.out.print("이름 >> ");
				continue;
			}else if(strName.equals("")){
				System.out.println("이름이 입력되지 않았습니다.");
				System.out.println("이름 >> ");
				continue;
			}else {
				return strName;
			}
		}
	}
	
	private Integer checkScore() {
		// TODO 점수 입력 및 유효성 체크
		String strNum = null;
		Integer intNum = null;

		while (true) {
			strNum = scan.nextLine();

			if (strNum.equals("QUIT")) {
				intNum = null;
				break;
			}

			try {
				intNum = Integer.valueOf(strNum);
			} catch (Exception e) {
				this.numErrorMessage();
				continue;
			}

			if (intNum < 0 || intNum > 100) {
				this.numErrorMessage();
				continue;
			} else {
				break;
			}
		}
		return intNum;
	}

	private void printStd(StudentVO vo) {
		// TODO 개인성적 출력
		System.out.println("=".repeat(line));
		System.out.println(vo.getName() + " 학생의 성적이 추가 되었습니다.");
		System.out.println("=".repeat(line));
		System.out.println("국어 : " + vo.getIntKor());
		System.out.println("영어 : " + vo.getIntEng());
		System.out.println("수학 : " + vo.getIntMath());
		System.out.println("과학 : " + vo.getIntSci());
		System.out.println("국사 : " + vo.getIntHis());
	}

	// 총 성적표 생성 및 출력
	private void printList() {
		// TODO 2. 학생 성적 리스트 출력
		int sumKor = 0;
		int sumEng = 0;
		int sumMath = 0;
		int sumSci = 0;
		int sumHis = 0;
		int sumTotal = 0;
		float sumAvg = 0.0f;
		float avgAvg = 0.0f;

		this.makeTotalAvg();

		System.out.println("=".repeat(line));
		System.out.println("순번\t이름\t국어\t영어\t수학" + "\t과학\t국사\t총점\t평균");
		System.out.println("-".repeat(line));
		for (int i = 0; i < studentVO.size(); i++) {
			StudentVO vo = studentVO.get(i);
			sumKor += vo.getIntKor();
			sumEng += vo.getIntEng();
			sumMath += vo.getIntMath();
			sumSci += vo.getIntSci();
			sumHis += vo.getIntHis();
			sumTotal += vo.getIntTotal();
			sumAvg += vo.getFloatAvg();

			System.out.printf("%3d\t", i + 1);
			System.out.printf("%3s\t", vo.getName());
			System.out.printf("%3s\t", vo.getIntKor());
			System.out.printf("%3s\t", vo.getIntEng());
			System.out.printf("%3s\t", vo.getIntMath());
			System.out.printf("%3s\t", vo.getIntSci());
			System.out.printf("%3s\t", vo.getIntHis());
			System.out.printf("%3s\t", vo.getIntTotal());
			float avg = vo.getFloatAvg();
			System.out.printf("%5.2f\n", avg);
		}
		avgAvg = sumAvg / studentVO.size();

		System.out.println("=".repeat(line));
		System.out.printf("%3s\t", "총점");
		System.out.printf("%3s\t", "");
		System.out.printf("%3d\t", sumKor);
		System.out.printf("%3d\t", sumEng);
		System.out.printf("%3d\t", sumMath);
		System.out.printf("%3d\t", sumSci);
		System.out.printf("%3d\t", sumHis);
		System.out.printf("%3d\t", sumTotal);
		System.out.printf("%5.2f\n", avgAvg);
		System.out.println("=".repeat(line));
	}
	
	private void makeTotalAvg() {
		// TODO 총합평균 계산
		int total = 0;
		float avg = 0;
		int cSubject = 5;

		for (int i = 0; i < studentVO.size(); i++) {
			StudentVO vo = studentVO.get(i);
			total = vo.getIntKor();
			total += vo.getIntEng();
			total += vo.getIntMath();
			total += vo.getIntSci();
			total += vo.getIntHis();

			avg = (float) total / cSubject;

			vo.setIntTotal(total);
			vo.setFloatAvg(avg);
		}
	}



	// 오류메시지
	private void menuErrorMessage() {
		System.out.printf("오류 :  잘못된 입력입니다.\n");
		System.out.printf("\t1, 2, QUIT 를 다시 입력해주세요.\n");
		System.out.println("=".repeat(line));
		System.out.print("업무선택>> ");
	}
	
	private void numErrorMessage() {
		System.out.printf("오류 :  잘못된 입력입니다.\n");
		System.out.printf("\t0 ~ 100까지의 숫자를 다시 입력해주세요.\n");
		System.out.print("      >> ");
	}


}
