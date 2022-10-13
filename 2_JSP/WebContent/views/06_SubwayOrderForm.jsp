<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>서브웨이 주문 페이지</title>
    </head>
    <body>
        <h1 align="center" style="color: green">서브웨이 주문 페이지</h1>

        <form action="">
            <fieldset>
                <legend>주문정보</legend>
                <table>
                    <tr>
                        <th>메뉴표</th>
                        <td>
                            <select name="menu" id="">
                                <option value="에그마요">에그마요</option>
                                <option value="로티세리바베큐치킨">
                                    로티세리바베큐치킨
                                </option>
                                <option value="써브웨이클럽">
                                    써브웨이클럽
                                </option>
                                <option value="이탈리안비엠티">
                                    이탈리안비엠티
                                </option>
                                <option value="터키베이컨아보카도">
                                    터키베이컨아보카도
                                </option>
                                <option value="스테이크 & 치즈">
                                    스테이크 & 치즈
                                </option>
                            </select>
                        </td>
                    </tr>

                    <br />

                    <tr>
                        <th>토핑가격</th>
                        <td>
                            <input
                                type="checkbox"
                                name="topping"
                                id=""
                            />에그마요 추가
                        </td>
                        <td>
                            <input type="checkbox" name="topping" id="" />치즈
                            추가
                        </td>
                        <td>
                            <input
                                type="checkbox"
                                name="topping"
                                id=""
                            />베이컨, 페퍼로니 추가
                        </td>
                        <td>
                            <input
                                type="checkbox"
                                name="topping"
                                id=""
                            />아보카도 추가
                        </td>
                    </tr>
                    <br />
                    <tr>
                        <th>음료선택</th>
                        <td>
                            <input type="radio" name="beverage" id="" />콜라
                        </td>
                        <td>
                            <input type="radio" name="beverage" id="" />사이다
                        </td>
                        <td>
                            <input type="radio" name="beverage" id="" />환타
                        </td>
                        <td>
                            <input type="radio" name="beverage" id="" />제로콜라
                        </td>
                    </tr>
                    <br />
                    <tr>
                        <th>쿠키 선택</th>
                        <td>
                            <input type="checkbox" name="cookie" id="" />초코칩
                        </td>
                        <td>
                            <input
                                type="checkbox"
                                name="cookie"
                                id=""
                            />더블초코칩
                        </td>
                        <td>
                            <input
                                type="checkbox"
                                name="cookie"
                                id=""
                            />라즈베리치즈케익
                        </td>
                        <td>
                            <input
                                type="checkbox"
                                name="cookie"
                                id=""
                            />화이트초코마카다미아
                        </td>
                        <td>
                            <input
                                type="checkbox"
                                name="cookie"
                                id=""
                            />오트밀레이즌
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>
