# 查找表问题


LeetCode 242    Valid Anagram
判断字符串t是否是字符串s变换字符顺序后得到的结果
如：s = anagram t=nagaram   则返回true
    s = rat t = car 则返回false

LeetCode 202 Happy Number
判断一个数是否为happy number。
happy number 是指 一个数，将其替换为其各位数字的平方和，
重复这个过程，如果最终得到1 这是happy number 
如果这个过程包含1的循环，则不是happy number
比如  19 为例子
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1 Happy Number
 
 LeetCode 290 Word Pattern
 给出一个模式(pattern)以及一个字符串  判断这个字符串 是否符合模式
 如：pattern=abba str=dog cat cat dog 返回true
     pattern=abba str= daog cat fiash  返回false 
     
LeetCode 205 Isomorphic Strings
判断两个字符串是否同构
如果我们能够寻找一个字符集到字符集的映射，使得通过这个字符集的映射，s可以转化为t 则称为s和t重构
如：egg 和add  返回true
    foo 和 bar 返回false
    paper 和 title 返回true
    
LeetCode 451  Sort Character By Frequency
给定一个字符串  按照字母的出现频率倒序重组整个字符串
如   tree  返回 eert
     cccaaa 返回  cccaaa
     Aabb 返回 bbAa
     对于相同频次的字母  顺序任意 大小写敏感
     
     
LeetCode 15     3  Sum
给出一个整型数组，寻找所有不同的三元组（a,b,c） 使得a+b+c =0;
如 nums=[-1,0,1,2,-1,-4]
返回[[-1,0,1][-1,-1,2]]

LeetCode 18     4  Sum
给出一个整型数组，寻找所有不同的四元组（a,b,c,d） 使得a+b+c+d =0;
如 nums=[-1,0,1,2,-1,-4]
返回[[-1,0,1,0][-1,-1,2,0]]

LeetCode 16     3Sum Closest
给出一个整型数组，寻找所有不同的三元组（a,b,c） 使得a+b+c+d 接近targert;
如 nums=[-1,0,1,2,-1,-4] target = 1
结果为2（-1+2+2）= 2

 