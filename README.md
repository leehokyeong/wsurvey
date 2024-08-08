# _wsurvey study project_


1. 멀티 모듈 프로젝트
- 공통 모듈(공통 유틸, 기능 등) : core


- web 모듈(web 화면 서비스) : web


- api 모듈(Rest-api 서비스) : api


***


2. profile 설정
- 공통 모듈(core) yaml 설정


- application-common.yml


- applicaiton-common-local.yml


- applicaiton-common-qas.yml


- application-common-prd.yml


- 일반 모듈(web, api) yaml 설정
  

- application.yml


- application-local.yml


- application-qas.yml


- applicaiton-prd.yml


- 프로파일 group 도 설정


- development, quality-assurance, production 으로 profile group 설정


***


3. logging 추가 - logback 설정


- console 로그


- local 에서만 사용


- 기본 spring boot 설정 사용


- pattern 만 변경


- file 로그


- local, qas, prd 에서 사용


- 기본 spring boot 설정 사용하지 않음


- core 모듈에 file-appender.xml 파일 추가 후 커스텀


- file은 일반 파일 로그 와 에러 파일 로그 로 구분


***


4. ErrorCode 추가

   
- 에러 코드를 Enum 형태로 관리


- http 코드 반환 : status


- 에러 코드 값 : errorCode


- 에러 메세지 : errorMessage


***


5. BusinessException


- Business 로직 수행 시 발생하는 예외를 처리하기 위한 Exception 클래스


- RuntimeException 을 상속받도록 함.


***

6. validation

- api request 에 대한 valid 적용

  
- thymeleaf 입력 폼 설정 및 valid 적용
