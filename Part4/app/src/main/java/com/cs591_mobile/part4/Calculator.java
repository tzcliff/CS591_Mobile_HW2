package com.cs591_mobile.part4;

public class Calculator {
    protected double rst;//last result
    protected int op;
    protected boolean ref, cal;//if refresh is false, refresh text when input #s
    //if cal, do calculation when operator pressed

    protected boolean flag;
    protected boolean percenFlag;
    protected boolean dotFlag;

    public Calculator() {
        flag = true;
        percenFlag = true;
    }

    public void setOp(int x) {
        op = x;
    }

    public void setRef(boolean x) {
        ref = x;
    }

    public void setPercenFlag(boolean x) {
        percenFlag = x;
    }

    public void setFlag(boolean x) {
        flag = x;
    }

    public void setCal(boolean x) {
        cal = x;
    }

    public void clean() {
        rst = 0;
        op = 0;
        ref = true;
        cal = true;
        flag = true;
        percenFlag = true;
        dotFlag = true;
    }

    public String calFuction(String input){
        String ans = "";
        if (flag == true) {
            if (!cal || input.length() == 0)
                return ans;
            double opNum = Double.valueOf(input);

            flag = false;
            switch (op) {
                case 0:
                    rst = rst + opNum;
                    break;
                case 1:
                    rst = rst - opNum;
                    break;
                case 2:
                    rst = rst * opNum;
                    break;
                case 3:
                    if (opNum == 0) {
                        ans = "error";
                        ref = true;
                        return ans;
                    }
                    rst = rst / opNum;
                    break;
                default:
                    break;
            }

            if (rst == Math.floor(rst)) {
                ans =  String.valueOf((long) rst);
            } else ans = String.valueOf(rst);

            flag = false;
            return ans;
        } else return ans;
    }

    public String addDot(String str) {
        ref = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                dotFlag = false;
                return str;
            }
        }
        dotFlag = true;
        return str + ".";
    }

    public String setNum(String num, String current) {
        String ans = "";
        if (num.equals(".")) {
            ans = addDot(current);
        } else {
            if (ref ) {
                ans = num;
                ref = false;
                if (!cal) {
                    rst = 0;
                    op = 0;
                    cal = true;
                }
            } else {
                ans = current + num;
            }
        }
        flag = true;
        percenFlag = true;
        return ans;
    }

    public String sqrt(double num) {
        if (num < 0 ) {
            return "ERROR";
        }
        return String.valueOf(Math.sqrt(num));
    }
 }
