package com.example.a3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.math.BigDecimal;
import java.lang.Math;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,
            btn_7,btn_8,btn_9,btn_clear,btn_percent,
            btn_del,btn_leftbra,btn_rightbra,btn_PandM,
            btn_squ2,btn_sin,btn_cos,btn_div,btn_mul,
            btn_sub,btn_add,btn_equ,btn_p;
    EditText text;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_0.setOnClickListener(this);

        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_1.setOnClickListener(this);

        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_2.setOnClickListener(this);

        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_3.setOnClickListener(this);

        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_4.setOnClickListener(this);

        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_5.setOnClickListener(this);

        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_6.setOnClickListener(this);

        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_7.setOnClickListener(this);

        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_8.setOnClickListener(this);

        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_9.setOnClickListener(this);

        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(this);

        btn_percent = (Button) findViewById(R.id.btn_jc);
        btn_percent.setOnClickListener(this);

        btn_del = (Button) findViewById(R.id.btn_del);
        btn_del.setOnClickListener(this);

        btn_leftbra = (Button) findViewById(R.id.btn_leftbra);
        btn_leftbra.setOnClickListener(this);

        btn_rightbra = (Button) findViewById(R.id.btn_rightbra);
        btn_rightbra.setOnClickListener(this);

        btn_PandM = (Button) findViewById(R.id.btn_PandM);
        btn_PandM.setOnClickListener(this);

        btn_squ2 = (Button) findViewById(R.id.btn_squ2);
        btn_squ2.setOnClickListener(this);

        btn_sin = (Button) findViewById(R.id.btn_sin);
        btn_sin.setOnClickListener(this);

        btn_cos = (Button) findViewById(R.id.btn_cos);
        btn_cos.setOnClickListener(this);

        btn_div = (Button) findViewById(R.id.btn_div);
        btn_div.setOnClickListener(this);

        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_mul.setOnClickListener(this);

        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_sub.setOnClickListener(this);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);

        btn_equ = (Button) findViewById(R.id.btn_equ);
        btn_equ.setOnClickListener(this);

        btn_p = (Button) findViewById(R.id.btn_p);
        btn_p.setOnClickListener(this);

        text=(EditText) findViewById(R.id.text);
    }

    @Override
    public void onClick(View v) {
        String str = text.getText().toString();
        switch(v.getId()){
            case R.id.btn_del:
                if(str.length()>1){
                    str=str.substring(0,str.length()-1);
                }
                else{
                    str="0";
                }
                text.setText(str);
                break;
            case R.id.btn_clear:
                str="0";
                text.setText(str);
                break;
            case R.id.btn_0:
                if (str.equals("0")){
                    str="0";
                }
                else{
                    str+="0";
                }
                text.setText(str);
                break;
            case R.id.btn_1:
                if (str.equals("0")){
                    str="1";
                }
                else{
                    str+="1";
                }
                text.setText(str);
                break;
            case R.id.btn_2:
                if (str.equals("0")){
                    str="2";
                }
                else{
                    str+="2";
                }
                text.setText(str);
                break;
            case R.id.btn_3:
                if (str.equals("0")){
                    str="3";
                }
                else{
                    str+="3";
                }
                text.setText(str);
                break;
            case R.id.btn_4:
                if (str.equals("0")){
                    str="4";
                }
                else{
                    str+="4";
                }
                text.setText(str);
                break;
            case R.id.btn_5:
                if (str.equals("0")){
                    str="5";
                }
                else{
                    str+="5";
                }
                text.setText(str);
                break;
            case R.id.btn_6:
                if (str.equals("0")){
                    str="6";
                }
                else{
                    str+="6";
                }
                text.setText(str);
                break;
            case R.id.btn_7:
                if (str.equals("0")){
                    str="7";
                }
                else{
                    str+="7";
                }
                text.setText(str);
                break;
            case R.id.btn_8:
                if (str.equals("0")){
                    str="8";
                }
                else{
                    str+="8";
                }
                text.setText(str);
                break;
            case R.id.btn_9:
                if (str.equals("0")){
                    str="9";
                }
                else{
                    str+="9";
                }
                text.setText(str);
                break;
            case R.id.btn_p:
                if(str.charAt(str.length()-1)=='+'||str.charAt(str.length()-1)=='-'||str.charAt(str.length()-1)=='×'||str.charAt(str.length()-1)=='÷'||str.charAt(str.length()-1)=='.'){
                    Toast.makeText(MainActivity.this,"Input error!",Toast.LENGTH_SHORT).show();
                    text.setText(str);
                }
                else{
                    str+=".";
                    text.setText(str);
                }
                break;
            case R.id.btn_add:
                if(str.charAt(str.length()-1)=='+'||str.charAt(str.length()-1)=='-'||str.charAt(str.length()-1)=='×'||str.charAt(str.length()-1)=='÷'||str.charAt(str.length()-1)=='.'){
                    Toast.makeText(MainActivity.this,"Input error!",Toast.LENGTH_SHORT).show();
                    text.setText(str);
                }
                else{
                    str+="+";
                    text.setText(str);
                }
                break;
            case R.id.btn_sub:
                if(str.charAt(str.length()-1)=='+'||str.charAt(str.length()-1)=='-'||str.charAt(str.length()-1)=='×'||str.charAt(str.length()-1)=='÷'||str.charAt(str.length()-1)=='.'){
                    Toast.makeText(MainActivity.this,"Input error!",Toast.LENGTH_SHORT).show();
                    text.setText(str);
                }
                else {
                    str += "-";
                    text.setText(str);
                }
                break;
            case R.id.btn_mul:
                if(str.charAt(str.length()-1)=='+'||str.charAt(str.length()-1)=='-'||str.charAt(str.length()-1)=='×'||str.charAt(str.length()-1)=='÷'||str.charAt(str.length()-1)=='.'){
                    Toast.makeText(MainActivity.this,"Input error!",Toast.LENGTH_SHORT).show();
                    text.setText(str);
                }
                else {
                    str += "×";
                    text.setText(str);
                }
                break;
            case R.id.btn_div:
                if(str.charAt(str.length()-1)=='+'||str.charAt(str.length()-1)=='-'||str.charAt(str.length()-1)=='×'||str.charAt(str.length()-1)=='÷'||str.charAt(str.length()-1)=='.'){
                    Toast.makeText(MainActivity.this,"Input error!",Toast.LENGTH_SHORT).show();
                    text.setText(str);
                }
                else {
                    str += "÷";
                    text.setText(str);
                }
                break;
            case R.id.btn_leftbra:
                if (str.length()==1){
                    str="(";
                }
                else if(!str.contains("+")&&!str.contains("-")&&!str.contains("×")&&!str.contains("÷")){
                    str="("+str;
                }
                else {
                    str += "(";
                }
                text.setText(str);
                break;
            case R.id.btn_rightbra:
                if (str.length()==1){
                    str="0";
                }
                else {
                    str += ")";
                }
                text.setText(str);
                break;
            case R.id.btn_equ:
                if(str.charAt(str.length()-1)=='+'||str.charAt(str.length()-1)=='-'||str.charAt(str.length()-1)=='×'||str.charAt(str.length()-1)=='÷'){
                    Toast.makeText(MainActivity.this,"Please complete the formula!",Toast.LENGTH_SHORT).show();
                    text.setText(str);
                }
                else {
                    String ero = isMatched(str);
                    if (ero.equals("no error")) {
                        String re = getResult();
                        if (re.contains("Infinity")) {
                            Toast.makeText(MainActivity.this, "0 cannot be used as a divior!", Toast.LENGTH_SHORT).show();
                            text.setText("0");
                        } else {
                            text.setText(re);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, ero, Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btn_squ2:
                if(str.charAt(0)=='-'){
                    Toast.makeText(MainActivity.this,"Negative numbers cannot be squared!",Toast.LENGTH_SHORT).show();
                    text.setText("0");
                }
                else if(str.contains("+")||str.contains("-")||str.contains("×")||str.contains("÷")){
                    Toast.makeText(MainActivity.this,"Symbols cannot be squared!",Toast.LENGTH_SHORT).show();
                    text.setText("0");
                }
                else{
                    double x=Double.parseDouble(str);
                    x=Math.sqrt(x);
                    String x2=String.format("%.9f",x);
                    x2 = x2.replaceAll("0+?$", "");//去掉多余的0
                    x2 = x2.replaceAll("[.]$", "");//如最后一位是.则去掉
                    text.setText(x2);
                }
                break;
            case R.id.btn_jc:
                if(str.contains(".")){
                    Toast.makeText(MainActivity.this,"阶乘必须为整数!",Toast.LENGTH_SHORT).show();
                    text.setText("0");
                }else {
                    int jie = Integer.parseInt(str);
                    int re=1;

                    while(jie > 0){
                        re *= jie;
                        jie--;
                    }

                    String jie1=""+re;
                    jie1 = jie1.replaceAll("[.]$", "");//如最后一位是.则去掉
                    text.setText(jie1);
                }
                break;
            case R.id.btn_sin:
                double sinn=Double.parseDouble(str);
                sinn=Math.toRadians(sinn);
                sinn=Math.sin(sinn);
                String sinn1=String.format("%.9f",sinn);//规避极小误差
                sinn1 = sinn1.replaceAll("0+?$", "");//去掉多余的0
                sinn1 = sinn1.replaceAll("[.]$", "");//如最后一位是.则去掉
                text.setText(sinn1);
                break;
            case R.id.btn_cos:
                double coss=Double.parseDouble(str);
                coss=Math.toRadians(coss);
                coss=Math.cos(coss);
                String coss1=String.format("%.9f",coss);//规避极小误差
                coss1 = coss1.replaceAll("0+?$", "");//去掉多余的0
                coss1 = coss1.replaceAll("[.]$", "");//如最后一位是.则去掉
                text.setText(coss1);
                break;
            case R.id.btn_PandM:
                if(str.charAt(0)>='0'&&str.charAt(0)<='9'){
                    if(str.equals("0")){
                        text.setText("0");
                    }
                    else{
                        text.setText("-"+str);
                    }
                    //
                }
                else if(str.charAt(0)=='-')
                    text.setText(str.substring(1,str.length()));
                else if(str.lastIndexOf('(') > str.lastIndexOf(')')){
                    if(str.charAt(str.lastIndexOf('(')+1) == '-'){
                        text.setText(str.substring(0,str.lastIndexOf('-'))+
                                str.substring(str.lastIndexOf('-')+1, str.length()));
                    }else{
                        text.setText(str.substring(0,str.lastIndexOf('(')+1)
                                +'-'+str.substring(str.lastIndexOf('(')+1, str.length()));
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     * 将中缀表达式转成相应的List
     */
    public static List<String> toInfixExpressionList(String s){
        //定义一个list，存放中缀表达式对应的内容
        List<String> ls = new ArrayList<String>();
        String str;//对多位数的拼接
        char c;
        boolean flag = true;//用来保存正负

        for(int i = 0; i < s.length(); i++){
            if(((c=s.charAt(i))<'0' || (c=s.charAt(i)) >'9') && (c=s.charAt(i))!='.'){
                //如果c是一个非数字，需要加入ls
                ls.add("" + c);
                if(c=='(' && s.charAt(i+1) == '-'){
                    flag=false;
                    i++;
                }else if(i==0 && s.charAt(i)=='-'){
                    flag=false;
                    ls.remove(i);
                }else{
                    flag=true;
                }

            }else {//如果是一个数，需要考虑多位数
                str="";//先将str置成
                while (i < s.length() &&(((c = s.charAt(i)) >= '0'
                        && (c = s.charAt(i)) <= '9') || ((c=s.charAt(i))=='.'))) {
                    str += c;// 拼接
                    i++;
                }
                i--;
                if(flag==false) {
                    str = "-" + str;
                }

                ls.add(str);
            }
        }
        return ls;
    }

    //将得到的中缀表达式对应的List转换为后缀表达式List
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        // 定义两个栈
        Stack<String> s1 = new Stack<String>(); // 符号栈
        // 说明：因为s2这个栈，在整个转换过程中没有pop操作，而且后面我们还需要逆序输出
        // 因此比较麻烦，这里我们就不用Stack<String>直接使用List<String> s2
        // Stack<String> s2 = new Stack<String>();//储存中间结果的栈s2
        List<String> s2 = new ArrayList<String>();// 储存中间结果的List s2

        // 遍历ls
        for (String item : ls) {
            // 如果是一个数，加入s2
            if ((item.matches("-?\\d+") || item.matches("-?\\d+.\\d+"))) {// 3->遇到操作数时，将其压入s2
                s2.add(item);
            } else if (item.equals("(")) {// 5.1->如果是左括号"(",则直接压入s1
                s1.push(item);
            } else if (item.equals(")")) {
                // 5.2->如果是右括号")",则依次弹出s1栈顶的运算符弹出，并压入s2，直到遇到左括号为止
                // 此时将这一对括号，丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();// !!!将(弹出s1栈，去除小括号
            } else {
                // 当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并压入到s2中
                // 再次转到（4.1）与s1中新的栈顶运算符相比较；
                // 问题：我们缺少一个比较优先级高低的方法。。
                // 方法：创建一个类operation，用来比较
                while (s1.size() != 0
                        && Operation.getValue(s1.peek()) >= Operation
                        .getValue(item)) {
                    s2.add(s1.pop());
                }
                // 还需要将item压入栈
                s1.push(item);
            }
        }

        // 7->s1剩余的运算符，依次弹出，并压入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2; // 注意因为是存放到List，因此按顺序输出就是对应的后缀表达式
    }

    // 完成对后缀表达式的运算
    public static double calculate(List<String> ls) {
        // 创建给栈，只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        // 遍历ls
        for (String item : ls) {
            // 这里使用正则表达式来取出数
            if ((item.matches("-?\\d+") || item.matches("-?\\d+.\\d+"))) {// 匹配的是多位数
                // 入栈
                stack.push(item);
            } else {
                // pop出两个数，并运算，再入栈
                double num2 = Double.parseDouble(stack.pop());
                double num1 = Double.parseDouble(stack.pop());
                double res = 0;
                if (item.equals("+")) {
                    res = num2 + num1;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("×")) {
                    res = num1 * num2;
                } else if (item.equals("÷")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符错误");
                }
                // 把res入栈
                stack.push("" + res);
            }
        }

        // 最后留在stack中的数据是运算结果
        return Double.parseDouble(stack.pop());
    }

    public String getResult(){
        String infix = text.getText().toString();
        List<String> l1 = toInfixExpressionList(infix);
        List<String> l2 = parseSuffixExpressionList(l1);
        Double result=calculate(l2);

//        StringBuffer stb = toPostfix(infix);
//        double result=toValue(stb);

        String re=String.format("%.7f",result);//规避极小误差
        re = re.replaceAll("0+?$", "");//去掉多余的0
        re = re.replaceAll("[.]$", "");//如最后一位是.则去掉
        return re;
    }

    public static String isMatched(String infix){
        Stack<String> stack=new Stack<String>();
        for (int i=0;i<infix.length();i++){
            char ch=infix.charAt(i);
            switch(ch){
                case'(':
                    stack.push(ch+"");
                    break;
                case')':
                    if(stack.isEmpty()||!stack.pop().equals("("))
                        return "expect   (";
            }
        }
        return(stack.isEmpty())?"no error":"expect   )";
    }
}

// 编写一个类，Operation可以返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    // 写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "×":
                result = MUL;
                break;
            case "÷":
                result = DIV;
                break;
            default:
                System.out.printf("%s不是运算符\n", operation);
                break;
        }
        return result;
    }
}

