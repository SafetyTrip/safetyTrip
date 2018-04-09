# safetyTrip

com.controller
API 서버, JSP Servlet을 사용해 개발
회원가입, 로그인, 국가 정보 검색, 국가별 상세페이지의 정보 제공 등의 기능을 제공한다.

com.dao
MyBatis를 사용해 DB 연동작업을 할 때 service와 mapper 사이에서 연동 역할을 해준다.
static으로 개발하여, 웹 어플리케이션 실행 시 연동되며, 서버가 종료될 때까지 유지된다.
필요할 때마다 세션을 주고 받는 형태로 구동된다.

com.dto
도시, 국가, 호텔, 유저, 안전 정보 등 웹 서비스에서 필요한 정보를 객체로 저장하고 사용하게 해준다.
class 형태로, 생성자를 사용해 객체를 생성하며 getter, setter 메서드로 해당 객체에 데이터를 저장하고 사용한다.

com.exception
개발자가 임의로 만들어낸 excption class이다.
발생한 에러를 캐치하여 message로 전달하는 기능을 수행한다.

com.filter
클라이언트에서 서버로 요청이 올 때 filter의 역할을 수행하며,
UTF-8을 사용해 한글 깨짐을 방지한다.

com.jdbc
DB와 연동되는 정보를 가지고 있는 jdbc.properties와 DB의 정보를 sql문을 사용해 제어하는 Mapper.xml로 구성되어있다.

com.openData
open API에서 안전정보를 가져와 DB에 데이터를 쌓는 기능과
Google Map API에서 도시를 기준으로 호텔 정보를 가져와 DB에 데이터를 쌓는 기능을 한다.
JAVA 프로그램이므로 따로 돌려줘야한다.

com.service
controller와 dao 사이에서 DB 연동 작업을 수행하며,
각 메서드를 트랜잭션 단위로 수행하도록 한다.
