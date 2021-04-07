<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@page import="cn.com.poetry_platform.pojo.User" %>
<%@page import="cn.com.poetry_platform.pojo.Goods" %>
<%
    request.setCharacterEncoding("utf-8");
    String path = request.getContextPath();
    User user = (User) session.getAttribute("user");
    System.out.println("获取到的user为" + user);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>云间诗路</title>
    <meta charset=UTF-8"/>
    <link rel="Stylesheet" type="text/css" href="css/css.css" charset="gb2312"/>
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/jquery.slides.js"></script>
    <script type="text/javascript" src="js/slider.js"></script>
</head>
<body>
<!------------头部-------------->
<div class="top_bg">
    <%
        if (user != null) {%>
    <a href="#" style="text-align: left;float: left;margin: 10px;position: absolute">用户：<%=user.getUsername()%>  欢迎来到云间诗路</a>
    <%}%>
    <div class="wrap">
        <div class="qrcode right mgt20">
            <div class="right">
                <img src="images/qrcode.jpg"/>
            </div>
            <div class="left">
                <ul>
                    <li><a href="login.jsp">用户登录</a></li>
                    <li><a href="reg.jsp">用户注册</a></li>
                </ul>
            </div>
            <div class="clear">
            </div>
        </div>
        <div class="logo left mgt20">
            <img src="images/logo.png" alt="云间诗路"/></div>
        <div class="clear">
        </div>
    </div>
</div>
<!------------搜索条-------------->
<div class="top_bar">
    <div class="wrap">
        <div class="right hotkeyword mgt10">
            <ul>
                <li><a href="https://baike.baidu.com/item/%E5%8C%97%E5%B2%9B/372?fr=aladdin">北岛</a></li>
                <li>
                    <a href="https://baike.baidu.com/item/%E4%B9%90%E5%BA%9C%E8%AF%97%E9%9B%86/982969?fr=aladdin">乐府诗</a>
                </li>
                <li><a href="https://baike.baidu.com/item/%E9%A3%9E%E9%B8%9F%E9%9B%86/732033?fr=aladdin">飞鸟集</a></li>
                <li><a href="https://www.zhihu.com/topic/19600626/hot">诗词赏析</a></li>
                <li>
                    <a href="https://baike.baidu.com/item/%E7%8E%B0%E4%BB%A3%E8%AF%97%E6%AD%8C/312492?fr=aladdin">现代诗歌</a>
                </li>
                <li><a href="http://www.zgshige.com/nts/">朗诵</a></li>
                <li><a href="http://blog.sina.com.cn/zgsgh">诗歌会</a></li>
                <li><a href="#">活动</a></li>
            </ul>
        </div>
        <div class="left searchbar">
            <div class="searchoption">
                <ul>
                    <li><a href="javascript:;" class="curr">诗歌</a></li>
                    <li><a href="javascript:;">诗人</a></li>
                    <li><a href="javascript:;">诗集</a></li>
                    <li><a href="javascript:;">图书</a></li>
                </ul>
            </div>
            <div class="searchinput">
                <input type="hidden" value="诗歌" id="hd_searchtype"/>
                <input type="button" class="right" onclick="alert('检索！')"/>
                <input type="text" class="left" placeholder="请先选择上方检索类型，再输入检索关键词"/>
                <div class="clear">
                </div>
            </div>
        </div>
        <div class="clear">
        </div>
    </div>
</div>
<!------------大屏广告-------------->
<div class="full pdtb30">
    <div class="slider_box" id="slider_name">
        <div class="mask">
        </div>
        <ul class="silder_con">
            <li class="silder_panel"><a href="https://baike.baidu.com/item/%E6%A0%91/2699565?fr=aladdin" class="f_l">
                <img src="images/slidepic/1.jpg"/></a></li>
            <li class="silder_panel"><a href="http://www.haoshici.com/a30rcsq.html" class="f_l">
                <img src="images/slidepic/2.jpg"/></a></li>
            <li class="silder_panel"><a href="http://blog.sina.com.cn/s/blog_eccbe48d0102w0bl.html" class="f_l">
                <img src="images/slidepic/3.jpg"/></a></li>
        </ul>
        <div class="silder_intro">
            <h3>
                推荐诗集《树》</h3>
            <div>
                <p>
                    短短二十行、百余字，转化为一幅有声有色、感性极强的画面，转化为一场动人的幻景</p>
            </div>
        </div>
        <div class="silder_intro">
            <h3>
                推荐诗集《清晨》</h3>
            <div>
                <p>
                    惯了孤单怯奉迎，公园独往听黄莺。偶逢同好两三个，一笑微微各自行。</p>
            </div>
        </div>
        <div class="silder_intro">
            <h3>
                推荐诗作：《孤钓翁》</h3>
            <div>
                <p>
                    山竹依篱院，烟萝织舍间。一声清笛起，几片白云还。时有花香至，常听涧水潺。相逢棋里趣，把酒品清闲。</p>
            </div>
        </div>
        <div class="silder_intro">
            <h3>
                味道江显武（私房菜）4</h3>
            <div>
                <p>
                    黑椒鸡排牛肉</p>
                <p>
                    特点：牛肉含有丰富的蛋白质和脂肪，其氨基酸组成接近于人体需要</p>
                <p>
                    口感：辣感十足，肉味鲜美，饶有嚼头，美味无处不在。</p>
            </div>
        </div>
        <div class="silder_intro">
            <h3>
                味道江显武（私房菜）5</h3>
            <div>
                <p>
                    黑椒鸡排牛肉</p>
                <p>
                    特点：牛肉含有丰富的蛋白质和脂肪，其氨基酸组成接近于人体需要</p>
                <p>
                    口感：辣感十足，肉味鲜美，饶有嚼头，美味无处不在。</p>
            </div>
        </div>
        <ul class="silder_nav dec">
            <li><a href="#">
                <img src="images/slidepic/s_1.jpg"/></a></li>
            <li><a href="#">
                <img src="images/slidepic/s_2.jpg"/></a></li>
            <li><a href="#">
                <img src="images/slidepic/s_3.jpg"/></a></li>
        </ul>
    </div>
</div>
<!------------各类推荐-------------->
<div class="full" style="background: #FFF">
    <div class="wrap pdtb30 recomm">
        <div class="right recomm_bar" style="margin-right: 0">
            <div class="recomm_tit">
                <img src="images/it_4.jpg" alt="朗读推荐"/></div>
            <div class="recomm_content langdu">
                <ul>
                    <li>
                        <div class="right">
                            <h3>
                                意大利，米兰大教堂</h3>
                            <h5>
                                作者：黄亚洲 朗诵者：李科</h5>
                        </div>
                        <div class="left">
                            <img src="images/avatar/t1.jpg"/></div>
                        <div class="clear">
                        </div>
                        <a class="vioce">这一柱白色火炬，是谁举着三千五百支固体白色火苗</a></li>
                    <li>
                        <div class="right">
                            <h3>
                                一块石头也有春天</h3>
                            <h5>
                                作者：戴瑀 朗诵者：刘亚</h5>
                        </div>
                        <div class="left">
                            <img src="images/avatar/t2.jpg"/></div>
                        <div class="clear">
                        </div>
                        <a class="vioce">面对一块石头，能说出什么所以然来</a>
                    </li>
                    <li>
                        <div class="right">
                            <h3>
                                母亲行走的范围</h3>
                            <h5>
                                作者：闲人 朗诵者：帆帆</h5>
                        </div>
                        <div class="left">
                            <img src="images/avatar/t3.jpg"/></div>
                        <div class="clear">
                        </div>
                        <a class="vioce">刚进城的那些年，母亲每天要到离家七八里远，离家七</a>
                    </li>
                </ul>
            </div>
            <a class="dianji" href="langdu.jsp">+ 点击进入</a>
        </div>
        <div class="left recomm_bar">
            <div class="recomm_tit">
                <img src="images/it_3.jpg" alt="新作推荐"/></div>
            <div class="recomm_content xinzuo">
                <div class="xinzuo_item">
                    <h3>
                        星空之问</h3>
                    <h5>
                        沈浩波</h5>
                    <div>
                        <p>
                            一个人仰望星空</p>
                        <p>
                            一个人面对宇宙无数年的荒凉</p>
                        <p>
                            一个人处在荒凉的核心</p>
                        <p>
                            一个人被这荒凉的美包裹</p>
                    </div>
                </div>
                <div class="xinzuo_item">
                    <h3>
                        致一位擦鞋的女人</h3>
                    <h5>
                        伊夫</h5>
                    <div>
                        <p>
                            她是这座城原始的雕塑</p>
                        <p>
                            在风吹日晒之后</p>
                        <p>
                            我不知道她的颜值还能有多少</p>
                        <p>
                            我看到她的双肩</p>
                        <p>
                            像失去中心的天平秤</p>
                    </div>
                </div>
            </div>
            <a class="dianji" href="xinxuo.jsp">+ 点击进入</a>
        </div>
        <div class="left recomm_bar">
            <div class="recomm_tit">
                <img src="images/it_2.jpg" alt="诗人推荐"/></div>
            <div class="recomm_content shiren">
                <ul>
                    <li>
                        <div class="right">
                            <h3>
                                白居易</h3>
                            <h5>
                                <span>中国</span><span>唐代</span><span>诗人</span></h5>
                        </div>
                        <div class="left">
                            <img src="images/avatar/baijuyi.jpg"/></div>
                        <div class="clear">
                        </div>
                        <div class="brief">
                            字乐天，号香山居士，河南郑州新郑人，是我国伟大的现实主义诗人。
                        </div>
                    </li>
                    <li>
                        <div class="right">
                            <h3>
                                李白</h3>
                            <h5>
                                <span>中国</span><span>唐代</span><span>诗人</span></h5>
                        </div>
                        <div class="left">
                            <img src="images/avatar/libai.jpg"/></div>
                        <div class="clear">
                        </div>
                        <div class="brief">
                            字太白，号青莲居士，唐朝浪漫主义诗人，被后人誉为“诗仙”。
                        </div>
                    </li>
                    <li>
                        <div class="right">
                            <h3>
                                冰心</h3>
                            <h5>
                                <span>中国</span><span>现代</span><span>诗人</span></h5>
                        </div>
                        <div class="left">
                            <img src="images/avatar/bingxin.jpg"/></div>
                        <div class="clear">
                        </div>
                        <div class="brief">
                            原名谢婉莹，福建长乐人 ，中国民主促进会（民进）成员，著名诗人。
                        </div>
                    </li>
                </ul>
            </div>
            <a class="dianji" href="shiren.jsp">+ 点击进入</a>
        </div>
        <div class="left recomm_bar">
            <div class="recomm_tit">
                <img src="images/it_1.jpg" alt="诗歌推荐"/></div>
            <div class="recomm_content shige">
                <div class="shige_item">
                    <h3>
                        如梦令·一饷凝情无语</h3>
                    <h5>
                        一饷凝情无语,手捻梅花何处。</h5>
                    <h5 class="author">
                        ——宋·王之道</h5>
                </div>
                <div class="shige_item">
                    <h3>
                        水调歌头·丙辰中秋</h3>
                    <h5>
                        明月几时有？把酒问青天。</h5>
                    <h5 class="author">
                        ——宋·苏轼</h5>
                </div>
                <div class="shige_item">
                    <h3>
                        将进酒</h3>
                    <h5>
                        君不见，黄河之水天上来。</h5>
                    <h5 class="author">
                        ——唐·李白</h5>
                </div>
                <div class="shige_item">
                    <h3>
                        满江红·写怀</h3>
                    <h5>
                        怒发冲冠，凭栏处、潇潇雨歇。</h5>
                    <h5 class="author">
                        ——宋·岳飞</h5>
                </div>
            </div>
            <a class="dianji" href="shige.jsp">+ 点击进入</a>
        </div>
        <div class="clear">
        </div>
    </div>
</div>

<!------------链-------------->
<div class="full">
    <div class="tit_bar wrap">
        <div class="right">
            <a href="#">更多 +</a></div>
        <div class="tit_4 left">
        </div>
        <div class="clear">
        </div>
    </div>
    <div class="wrap lian">
        <ul>
            <li><a href="http://www.zgsgxh.com/Index.html">中国诗歌学会</a></li>
            <li><a href="http://www.zhscxh.com/default.aspx">中华诗歌学会</a></li>
            <li><a href="http://www.zgshige.com/c/2016-06-15/1378947.shtml">文艺报社</a></li>
            <li><a href="http://1662.qikan.qwfbw.com/">人民文学杂志社</a></li>
            <li><a href="http://www.sc1618.com/">中华诗词论坛</a></li>
            <li><a href="http://www.zgzjzzs.com/">中国作家杂志社</a></li>
            <li><a href="http://www.mzwxzz.com/">民族文学网</a></li>
            <li><a href="https://www.haotougao.com/zhcf/">中华辞赋杂志社</a></li>
            <li><a href="http://www.zgshige.com/c/2016-06-19/1397182.shtml">扬子江诗刊社</a></li>
            <li><a href="http://www.zgshige.com/c/2016-06-19/1397185.shtml">星星诗刊社</a></li>
            <li><a href="http://www.zgshige.com/c/2016-06-19/1397942.shtml">绿风诗刊社</a></li>
            <li><a href="http://www.zgshige.com/c/2016-06-19/1397946.shtml">诗选刊社</a></li>
        </ul>
        <div class="clear"></div>
    </div>
</div>
<!------------尾部-------------->
<div class="footer">
    <div class="wrap">
        <div class="right footr">
            <ul>
                <li style="width: 80px;">
                    <img src="images/qrcode.jpg" width="70" height="70"/></li>
                <li style="width: 80px;">
                    <img src="images/qrcode.jpg" width="70" height="70"/></li>
                <li style="width: 220px;">
                    <h2 style="color: White">
                        关于我们</h2>
                    <h5 style="color: White">
                        地址：永州市零陵区湖南科技学院</h5>
                    <h5 style="color: White">
                        电话：027-87419228</h5>
                </li>
                <li style="width: 430px; color: White; font-size: 14px; margin-top:30px;">鄂ICP备09037671号-2
                    武汉市公安局备案编号：110105000501<br/>
                    Copyright © 2006-2016 All Right Reserved.
                </li>
            </ul>
        </div>
        <div class="left footl">
            <div class="logo2"><img src="images/logo2.png" alt="云间诗路"/></div>
            <div style="margin-top:60px;">
                <span>友情链接</span>
                <span>联系我们</span>
                <span>网站地图</span>
                <span>湖南科技学院互联网+诗歌出版与传播</span>
            </div>
        </div>
        <div class="clear">
        </div>
    </div>
</div>
</body>
</html>
