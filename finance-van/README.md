## 개요

### 서비스명

금융 VAN 시스템 / Finance VAN

### 역할

* 여러 은행의 계좌에 대한 거래를 중계해주는 **외부** 시스템
* 은행 계좌 정보를 함께 관리

### 기능

1. 계좌 등록
2. 계좌 잔액 조회
3. 입금이체
4. 출금이체
5. 수취조회

## 주요 도메인

### 은행 | Bank

* 은행 정보를 관리하는 도메인
* VAN 시스템에 등록된 은행의 이름, 은행 코드 등을 관리

### 은행 계좌 | Bank Account

* 은행 계좌 정보를 관리하는 도메인
* 계좌 잔액의 증감 및 거래내역을 처리

### 파트너 | Partner

* VAN 시스템을 사용하는 고객사를 관리하는 도메인
* 고객사 이름, 인증 키 등을 관리

### 핀테크 이용자 | Fintech User

* 금융 중계 서비스(Finance VAN)에 계좌를 등록할 때 실제 계좌번호 대신 발급되는 가상번호
* 은행과 거래(통신)시에는 해당 값을 계좌번호 대신 사용

### 거래 내역 | Transaction History

* 파트너사의 요청에 의해 수행된 거래의 수행 내역
* 요청 시간, 응답 시간, 요청 파트너사, 요청 고객, 처리 결과 등을 관리

## Infrastructure

* Slave 없는 1EA MySQL Instance
* 2개 이상의 Application Instance