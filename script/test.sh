echo "打印信息!"
a="变量1"
echo ${a} 变量2

for skill in Ada Coffe Action Java; do
    echo "I am good at ${skill} Script"
done

# 截断字符串
string="runoob is a great site"
echo ${string:5:1}

#数组
array_name=(value0 value1 value2 value3)
for (( i = 1; i <= ${#array_name[@]}; i++ )); do
    echo ${array_name[i]}
done
echo "${array_name[1]}"

echo "Shell 传递参数实例！";
echo "执行的文件名：$0";
echo "第一个参数为：$1";
echo "第二个参数为：$2";
echo "第三个参数为：$3";
echo "参数数量: $#"
echo "\$\*结果: $*"
echo "\$\@结果: $@"

echo "\$\@ 遍历结果:"
for var in "$@"
do
    echo "$var"
done

echo "\$\* 遍历结果:"
for var1 in "$*"
do
    echo "$var1"
done



