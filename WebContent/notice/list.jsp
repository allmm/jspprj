
<%@page import="com.newlecture.web.dao.file.FileNoticeDao"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@page import="javax.naming.NoInitialContextException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	NoticeDao noticeDao = new FileNoticeDao();
	List<Notice> notices = noticeDao.getList();

/*
List<Notice> notices = new ArrayList<>();
//데이터를 가져오는 w제공하는 코드 블록{ -> 
	//List<Notice> getNoticeList()
	FileInputStream fis = new FileInputStream("D:\\java\\workspace\\JSPprj\\WebContent\\WEB-INF\\data\\notice-file.df");
	Scanner fscan = new Scanner(fis);
	String line ="";
	
	while(fscan.hasNextLine()){
		line = fscan.nextLine();
		Notice notice = new Notice(line.split(","));
		notices.add(notice);
	}
	
	fscan.close();
	fis.close(); 
	//}
*/
%>


<!DOCTYPE html>
<html lang="en" style="font-size:10px;">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <!-- 스타일 속성(x) -> 선택자 이용 스타일 부여 -->
    <style>
        #main-menu-list{
            color: cadetblue
        }
        .mainmenu{
            color: darkgoldenrod
        }
    </style>
    <link rel="stylesheet" type="text/css" href="../CSS/style.css">
</head>

<body>
    <!-- --- header block ---------------------------------------------------------------------------------------------------------------- -->
    <header id="header">
    <div class="content-box">   
        
        <h1 id="logo">뉴렉처 온라인</h1>
        <section id="header-menu-list">
            <h1 class="d-none">머릿말</h1>
           <nav id="main-menu-list">
                <h1 class="d-none" style="color: darkmagenta;font-size: 25px;">메인메뉴</h1>
                <!-- <h2>나나나</h2> -->
                <ul class="mainmenu"  >
                    <li><a href="">학습가이드</a></li>
                    <li><a href="">강좌선택</a></li>
                    <li><a href="">AnswerIs</a></li>
                </ul>
            </nav>

            <section id="lecture-search-form">
                <h1 class="d-none">강좌검색 폼</h1>
                <form action="">
                    <label>과정검색</label>
                        <input type="text">
                        <input type="submit" value="검색">
                </form>
            </section>
            <nav id="member-menu-list">
                <h1 class="d-none">회원메뉴</h1>
                <ul class="mainmenu">
                    <li>HOME</li>
                    <li>로그인</li>
                    <li>회원가입</li>
                </ul>
            </nav>

            <nav id="direct-menu">
                <h1 class="d-none">자주사용하는 메뉴</h1>
                <ul class="mainmenu">
                    <li>마이페이지</li>
                    <li>고객센터</li>
                </ul>
            </nav>
        </section> 
   
    </div>
    </header>
<!-- --- visual block ---------------------------------------------------------------------------------------------------------------- -->
<div id="visual">
    <div class="content-box" style="position: relative">
        
        <!-- <div style="height: 100px; width: 100px; border: 1px solid red;
        background: url(https://img1.daumcdn.net/thumb/S600x434/?scode=1boon&fname=https://t1.daumcdn.net/news/201811/03/starnews/20181103152130511pdgw.jpg);
        background-size: cover;
        background-attachment: fixed;">
        </div> -->
        <span style="left:100px;top:100px;position:sticky;">헨리야헨리야</span>
        <!-- <img src="https://img1.daumcdn.net/thumb/S600x434/?scode=1boon&fname=https://t1.daumcdn.net/liveboard/mbcweeks/ae1819c696dd41038132185905ab587b.jpeg" style="left:100px;top:100px;position:absolute;" > -->
        
        
    </div>

</div>
<!-- --- Body block ---------------------------------------------------------------------------------------------------------------- -->
<div id="body">
    <div class="content-box">

    <aside>
        <h1 id="aside-title">고객센터</h1>
        <nav id="customer-menu">
            <h1>고객센터메뉴</h1>
            <ul>
                <li><a href="">공지사항</a></li>
                <li><a href="">자주하는 질문</a></li>
                <li><a href="">수강문의</a></li>
                <li><a href="">이벤트</a></li>
            </ul>
        </nav>
        <nav id="cooperator">
            <h1>협력업체</h1>
            <ul>
                <li><a href="">노트펍스</a></li>
                <li><a href="">나무랩연구소</a></li>
                <li><a href="">한빛미디어</a></li>
            </ul>
        </nav>
    </aside>

    <main>
        <section>
            <h1 id="main-title">공지사항</h1>
            <section>
                <h1>공지사항 검색 폼</h1>
                <select>
                   <option>제목</option>
                   <option>작성자</option>
                   <option>내용</option>
                </select>    
                <input type="text">
                <input type="submit" value="검색">
            </section>

            <section id="breadcrumb">
                <h1 class="d-none">경로</h1>
                <ol>
                    <li>home</li>
                    <li>고객센터</li>
                    <li>공지사항</li>
                </ol>
            </section>
            <section id="notice">
                <h1>공지사항 목록</h1>
                <table>
                    <thead>
                        <tr>
                            <td class="num">번호</td>
                            <td class="title">제목</td>
                            <td class="writer">작성자</td>
                            <td class="date">작성일</td>
                            <td class="hit">조회수</td>

                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <td>3</td>
                            <td class="title"><a href=""> 백엔드 개발자들을 위한 새로운 강의를 녹음 중에 있습니다.<span>[23]</span></a></td>
                            <td>newlec</td>
                            <td>2019-02-18</td>
                            <td>256</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td class="title">유투브에 jQuery와 Angular 프레임워크 1강이 등록되었습니다.</td>
                            <td>newlec</td>
                            <td>2019-02-18</td>
                            <td>177</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td class="title">앞으로 모든 강의를 무료로 새로 시작합니다.</td>
                            <td>newlec</td>
                            <td>2018-11-18</td>
                            <td>767</td>
                        </tr>
                    </tbody>
                </table>
            </section>

            <section id="page-index">
                <h1 class="d-none">페이지 정보</h1>
                <div>
                    <span class="color-highlight font-bold">1</span>
                     / 1 pages
                </div>
            </section>

            <section id="pager">
                <h1 class="d-none">페이지</h1>
                <div>
                    <div class="icon-prev-page">이전</div>
                    <ul>
                        <li class="current">1</li>
                        <li>2</li>
                        <li>3</li>
                    </ul>
                    <div class="icon-next-page">다음</div>
                </div>
            </section>
        </section>
    </main> 
    <!-- <div style="clear:left;">안녕 나는 막내야</div> -->
    </div>
</div>
<!-- --- footer block ---------------------------------------------------------------------------------------------------------------- -->
    <footer id="footer">
        <div class="content-box">
        <!-- <section>
            <h1>회사정보</h1>

            <section>
                <h1>소유권자 정보</h1>
                <dt>
                    주소:
                </dt>
                <dd>서울특별시 마포구 토정로35길 11, 인우빌딩 5층 266호</dd>
                <dt>
                    관리자메일:
                </dt>
                <dd>admin@newlecture.com</dd>
                <dt>
                    사업자 등록번호:
                </dt>
                <dd>132-18-46763</dd>
                <dt>
                    통신 판매업:
                </dt>
                <dd>신고제 2013-서울강동-0969 호</dd>
                <dt>
                    상호:
                </dt>
                <dd>뉴렉처</dd>
                <dt>
                    대표:
                </dt>
                <dd>박용우</dd>
                <dt>
                    전화번호:
                </dt>
                <dd>070-4206-4084</dd>
            </section>
            </dl>

            <section>
                <h1>저작권자 정보</h1>
                <div>
                    Copyright ⓒ newlecture.com 2012-2014 All Right Reserved. Contact admin@newlecture.com for more
                    information
                </div>
            </section>
        </section>     -->
        </div>
    </footer>

</body>

</html>