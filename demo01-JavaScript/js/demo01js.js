/**
 * 正则表达式对象 RegExp
 * 1.正则表达式：定义字符串组成的规则
 * 单个字符：[]
 * 如：[a] [ab] [a-zA-z0-9]
 * 特殊符号代表特殊含义的单个字符：
 * \d:单个数字字符[0-9]
 * \w:单个单词字符[a-zA-z0-9_]
 *
 * 量词符号：
 * 表示出现0次或一次 ？
 * 表示出现0次或多次 *
 * 表示出现1次或多次 +
 * 表示 m<=数量<=n  {m,n}
 *      m如果缺省 {,n} 最多n次
 *      n如果缺省 {m,} 最少m次
 *
 * 开始结束符号
 * ^ 开始
 * $ 结束
 *
 * 正则对象
 * 1.创建
 * var reg1 = new RegExp("正则表达式");
 * var reg2 = /正则表达式/;
 *
 * 2.方法
 * test(); 验证
 */
var reg1 = new RegExp("\\w{2}");
var reg2 = /^\w{6,10}$/;


var username = "xu";

var flag1 = reg1.test(username);
var flag2 = reg2.test(username);
alert(flag1);
alert(flag2);


