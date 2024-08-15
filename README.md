# [2024] 📖 독서 커뮤니티
다양한 연령층이 독서를 통해 지식을 습득하고 문화를 교류할 수 있도록 돕는 독서 커뮤니티 플랫폼입니다.
다양한 기능(댓글, 대댓글, 문의사항 등)을 통해 활발한 상호작용 촉진합니다.
이벤트와 독후감 공유를 통해 독서 동기 부여 및 참여 유도합니다.

## 목차 
- [개요](#개요)
- [프로젝트 구조](#프로젝트-구조)

## 개요 
- 프로젝트 이름 : Knock-Book 
- 프로젝트 지속기간 : 2024-06-11 ~ 2024-07-23
- Front : HTML5, CSS3, JavaScript
- Back : Java
- 협업 툴 : Discord, Notion, Github
- 멤버 : 팀 6캔두잇 (김민재, 김채영, 박혜선, 서혜원, 이종담, 전주영)

## 프로젝트 구조
```
├── README.md
├── .gitignore
├── public
│   └── index.jsp
└── src.com.book
└── admin
├── book
│   ├── controller
│   │   ├── AdminApplyListServlet.java
│   │   ├── ApplyStatusEndServlet.java
│   │   ├── BookCheckServlet.java
│   │   ├── BookDeleteServlet.java
│   │   ├── BookListServlet.java
│   │   ├── CreateBookEndServlet.java
│   │   ├── CreateBookServlet.java
│   │   └── EditBookServlet.java
│   ├── dao
│   └── vo
├── event
└── sg
```
## 맡은 기능

- **UI**
    - 페이지 : 사용자 문의사항, 관리자 문의사항, 관리자 페이지, 오류 페이지 (403, 404, 500)
    - 공통 컴포넌트 : 댓글
- **기능**
  - 사용자 문의사항 조회 및 작성 / 삭제, 관리자 문의사항 조회 및 답변 작성 / 수정 / 삭제, 관리자 문의사항 기본 답변 작성 / 수정 / 삭제, 댓글 등록 / 수정 / 삭제, 대댓글 등록 / 수정 / 삭제

## 페이지별 기능

