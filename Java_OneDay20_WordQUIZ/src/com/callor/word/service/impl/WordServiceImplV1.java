package com.callor.word.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.callor.word.model.WordVO;
import com.callor.word.service.WordService;

public class WordServiceImplV1 implements WordService {

	protected List<WordVO> wordList;
	protected final Integer 영어 = 0;
	protected final Integer 한글 = 1;
	protected Scanner scan;
	Random rnd;

	public WordServiceImplV1() {
		wordList = new ArrayList<WordVO>();
		scan = new Scanner(System.in);
		rnd = new Random();
		this.loadWord();
	}

	@Override
	public void loadWord() {
		// TODO txt파일 읽기 => wordList 삽입
		String fileName = "src/com/callor/word/word.txt";

		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);

			while (true) {
				String reader = buffer.readLine(); // 여기가 실질적으로 불러오는 것
				if (reader == null) {
					break;
				}
				String[] wordSet = reader.split(":");

				WordVO vo = new WordVO();
				vo.setEnglish(wordSet[영어]);
				vo.setKoreak(wordSet[한글]);
				wordList.add(vo);
			}
			buffer.close();

		} catch (FileNotFoundException e) {
			System.out.println("파일을 여는 동안 문제 발생");
		} catch (IOException e) {
			System.out.println("파일에서 데이터를 읽는 중 문제 발생");
		}

	}

	public void gameStory() throws InterruptedException {
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡\t\t\t\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡\t ! ! ! ✧*.◟(ˊᗨˋ)◞.*✧ ! ! !\tﾟ｡･ﾟヾ｡ﾟ･｡");
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡\t\t\t\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡괴도뤼팡이 나타났습니다!\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡뤼팡은 황금을 선물로\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡남겨놓았습니다.\t\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡다만 황금을 감춰둔 금고의 열쇠는\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡여러분이 찾아야 합니다.\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.print("\t\t>> Push Enter");
		String num = scan.nextLine();
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡");
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡뤼팡이 열쇠에 해당하는 영단어를\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡무작위로 배열한 알파벳으로\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡남겨놓았습니다.\t\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡여러분은 황금 열쇠를 찾아\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡금고속에 담겨있는 황금을\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡찾아 내기 바랍니다!\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.print("\t\t>> Push Enter");
		num = scan.nextLine();
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡");
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡게임내 포인트는 ⓖ 입니다!\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡문제를 맞추면 ⓖ + 5\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡재도전할 경우 ⓖ - 1\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡힌트를 받으면 ⓖ - 1\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡문제를 건너뛰면 ⓖ - 3\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
		TimeUnit.SECONDS.sleep(1);
		System.out.print("\t\t>> Push Enter");
		num = scan.nextLine();
	}

	@Override
	public void seletMenu() {
		// TODO Auto-generated method stub

		while (true) {
			System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡");
			System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡\t\t괴도뤼팡┌(˘⌣˘)s\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
			System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡");
			System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡\t\t\t\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
			System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡\t\t1. 새게임\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
			System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡\t\t2. 불러오기\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
			System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡\t\t3. 게임설명\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
			System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡\t\tQUIT. 종료\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
			System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡\t\t\t\t\tﾟ｡･ﾟヾ｡ﾟ･｡");
			System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡");

			System.out.print("\t\t메뉴 선택 >> ");

			String menu = scan.nextLine();
			if (menu.equals("QUIT")) {
				System.out.println();
				System.out.println("\t\t~ヾ(＾∇＾)");
				System.out.println("\t\t게임 종료!!!");
				System.out.println("\t\t안녕히가세요");
				System.out.println("\t\t~ヾ(＾∇＾)");
				return;
			}
			Integer intMenu = null;
			try {
				intMenu = Integer.valueOf(menu);
			} catch (NumberFormatException e1) {
				System.out.println("메뉴는 숫자나 QUIT만 입력가능 !!");
				continue;
			}

			if (intMenu == 1) {
				try {
					this.viewWord(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (intMenu == 2) {
				Integer loadPoint = this.loadInpo();
				if(loadPoint == null) {
					continue;
				}
				try {
					this.viewWord(loadPoint);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			} else if (intMenu == 3) {
				try {
					this.gameStory();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("메뉴를 선택해주세요 !!");
				continue;
			}
		}
	}

	@Override
	public void viewWord(int point) throws InterruptedException {
		// TODO Auto-generated method stub

		int winCount = 0;
		int loseCount = 0;

		// 새로운 단어문제를 내는 while
		while (true) {
			int retryCount = 0;
			int hintCount = 1;

			// this.getWord() method에서 랜덤단어 1set을 가져옴
			WordVO word = this.getWord();
			// 영어단어를 eng에 저장
			String eng = word.getEnglish();
			// 영어단어를 알파벳으로 조각내서 배열에 담기
			String[] divEng = eng.split("");
			// 조각난 영어단어 오리지널 하나 저장하기
			String[] origin = eng.split("");
			// 조각단 영어단어 순서섞기
			for (int i = 0; i < 50; i++) {
				int num1 = rnd.nextInt(divEng.length);
				int num2 = rnd.nextInt(divEng.length);
				String temp = divEng[num1];
				divEng[num1] = divEng[num2];
				divEng[num2] = temp;
			}

			System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡");
			System.out.println(word.toString());
			System.out.println("=".repeat(47));
			System.out.println("제시된 영단어를 바르게 배열하세요");
			System.out.println("(NEXT: 건너뛰기 / QUIT: 그만하기)");
			
			// 배열의 내용을 하나씩 출력하는 메서드 기억하기 ( Arrays.toString(배열) )
			while (true) {
				System.out.println("-".repeat(47));
				System.out.println(Arrays.toString(divEng));
				System.out.println("-".repeat(47));
				System.out.print(">> ");
				String answer = scan.nextLine();
				
				// QUIT 입력받았을 때
				if (answer.equals("QUIT")) {
					Integer intEnd = null;
					while (true) {
						System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡");
						System.out.println("1. 저장하고 끝내기");
						System.out.println("2. 그냥 끝내기");
						System.out.print(">> ");
						String end = scan.nextLine();

						try {
							intEnd = Integer.valueOf(end);
						} catch (NumberFormatException e) {
							System.out.println("1 또는 2를 입력해주세요!!!");
							continue;
						}
						break;
					}
					if (intEnd == 1) {
						System.out.println("저장할 이름을 입력해주세요");
						System.out.print(">> ");
						String inputName = scan.nextLine();
						this.saveInpo(inputName, point);
						System.out.println(inputName + " 유저의 정보를 저장했습니다!!");
						return;
					} else {
						return;
					}
				}


				// NEXT 입력받았을 때
				if (answer.equals("NEXT")) {
					if (point > 0) {
						System.out.println("\t다음 문제로 넘어뜁니다 ( ⓖ -3 )");
						point -= 3;
						System.out.println("\t현재 소지금 : " + point);
						TimeUnit.SECONDS.sleep(1);
						break;
					}else if (point <= 0) {
						System.out.println("\tⓖ 부족 !!!");
						System.out.println("\t다음 문제로 넘어갈 수 없습니다");
						System.out.println("\t현재 소지금 : " + point);
						TimeUnit.SECONDS.sleep(1);
						continue;
					}
				}

				// HINT 입력받았을 때
				if (answer.equals("HINT")) {
					if (point > 0) {
						if (retryCount < 1) {
							System.out.println("첫 입력에서는 힌트를 요청할 수 없습니다");
							System.out.println("( ᴗ_ᴗ̩̩ )");
						}else if (hintCount < 4) {
							this.getHint(origin, hintCount, point);
							point--;
							hintCount++;
						} else if (hintCount >= 4) {
							System.out.println("네번째 힌트는 요청할 수 없습니다");
							System.out.println("( ᴗ_ᴗ̩̩ )");
						}
					}else if(point <= 0) {
						System.out.println("\tⓖ 부족 !!!");
						System.out.println("\t힌트를 받을 수 없습니다");
						System.out.println("\t현재 소지금 : " + point);
					}
					continue;
				}


				// 정답, 재도전, 실패
				if (answer.equalsIgnoreCase(eng)) {
					System.out.println("\t정답입니다! ( ⓖ +5 )");
					System.out.println("\t✧*｡٩(ˊᗜˋ*)و✧*｡");
					point += 5;
					winCount++;
					System.out.println("\t현재 소지금 : " + point);
					TimeUnit.SECONDS.sleep(1);
					break;
				} else if (retryCount < 3) {
					System.out.println("\t다시 한번 생각해보세요 ( ⓖ -1 )");
					System.out.println("\t（´-`）.｡oO（  ）(HINT: 힌트)");
					if (point > 0) {
						point--;
					}
					retryCount++;
					System.out.println("\t현재 소지금 : " + point);
					TimeUnit.SECONDS.sleep(1);
					continue;
				} else if (retryCount >= 3) {
					System.out.println("\t틀렸습니다!");
					System.out.println("\t｡ﾟ(ﾟ´ω`ﾟ)ﾟ｡");
					System.out.println("\t다음 문제를 맞춰봐요");
					TimeUnit.SECONDS.sleep(1);
					loseCount++;
					break;
				}

			}
		}
	}

	protected WordVO getWord() {
		// 0 ~ wordList.zise 사이의 랜덤 정수 추출
		int num = rnd.nextInt(wordList.size());
		// 랜덤리스트 return
		WordVO word = wordList.get(num);
		return word;
	}

	protected void getHint(String[] origin, int hintCount, int point) {

		for(int i = 0 ; i < hintCount ; i++) {
			System.out.println("[" + origin[i] + "]");
		}
		
		if (hintCount == 1) {
			System.out.println("첫글자 힌트!  (ⓟ - 1)");
			System.out.println("[" + origin[0] + "]");
			System.out.println("현재 소지금 : " + point);
		} else if (hintCount == 2) {
			System.out.println("두번째글자 힌트!  (ⓟ - 1)");
			System.out.println("[" + origin[0] + origin[1] + "]");
			System.out.println("현재 소지금 : " + point);
		} else if (hintCount == 3) {
			System.out.println("세번째글자 힌트!  (ⓟ - 1)");
			System.out.println("[" + origin[0] + origin[1] + origin[2] + "]");
			System.out.println("현재 소지금 : " + point);
		}
	}

	public void saveInpo(String inputName, int point) {
		String fileName = "src/com/callor/word/" + inputName + "_word.txt";

		FileWriter fileWriter = null;
		PrintWriter out = null;

		try {
			fileWriter = new FileWriter(fileName);
			out = new PrintWriter(fileWriter);

			out.print(point);

			out.flush();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Integer loadInpo() {
		String inputName;

		String point;
		while (true) {
			System.out.println("저장되어 있는 이름을 입력해주세요");
			System.out.print(">> ");
			inputName = scan.nextLine();
			String fileName = "src/com/callor/word/" + inputName + "_word.txt";
			FileReader fileReader = null;
			BufferedReader buffer = null;
			point = null;
			try {
				fileReader = new FileReader(fileName);
				buffer = new BufferedReader(fileReader);

				point = buffer.readLine();

			} catch (FileNotFoundException e) {
				System.out.println("존재하지 않는 파일입니다");
				System.out.println("RE. 이름을 다시 입력하기");
				System.out.println("QUIT. 메뉴로 돌아가기");
				System.out.print(">> ");
				String num = scan.nextLine();
				if(num.equals("RE")) {
					continue;
				}else if(num.equals("QUIT")) {
					return null;
				}
			} catch (IOException e) {
				System.out.println("파일을 읽는 동안 문제가 발생했습니다");
				break;
			} 
			break;
		}
		Integer intPoint = Integer.valueOf(point);
		System.out.println("ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡･ﾟﾟ｡･ﾟヾ｡ﾟ･｡ﾟ｡");
		System.out.println("\t환영합니다! " + inputName + " 님 !");
		System.out.println("\t현재 소지금 : " + point);
		return intPoint;
	}

	@Override
	public void printWord() {
		// TODO Auto-generated method stub

	}

}
