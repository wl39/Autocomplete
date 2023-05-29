# Autocomplete
- 사용 언어: Java
- Java swing을 이용해 만든 간단한 자동완성 프로그램입니다.
	- 텍스트 필드에 유저가 특정 알파벳(또는 단어, 문장)을 입력하면, 주어진 데이터 내에서 유저가 입력한 글자들과 가장 유사한 결과값들을 보여줍니다.
- 개발기간: 14일
- 마지막 수정일: 2018년 2월

---

## 사용방법
- java W04Practical <Input_file.txt> <The_number_of_candidates>
	- <Input_file.txt>: 자동완성을 수행하기 위해 필요한 인풋 파일입니다. 이 프로그램은 해당 파일에 존재하는 단어들에서 결과값을 가져오게 됩니다.
	- <The_number_of_candidates>: 프로그램이 보여줄 단어의 최대 갯수입니다.
	- 예시: "java W04Practical cities.txt 10"
		- 위의 코드를 실행하면, Autocomplete이 "cities.txt"에 있는 데이터를 이용해 자동완성을 수행합니다. 유저가 입력창에 글자를 입력하게 되면, "cities.txt"에 존재하는 단어들 중, 그와 가장 유사한, 단어 "10"개를 보여줍니다.
- 프로그램이 실행 되면 사용자는 프로그램 내 최상단에 존재하는 입력창에 글자를 입력하면 됩니다.


## 프로그램에서 주목해서 봐야할 점
- 다양한 Sorting 알고리즘들을 이용해, 프로그램을 구현
- Java Comparable Interface를 이용해 구현
