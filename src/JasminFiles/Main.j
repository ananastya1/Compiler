.class public MainClass
.super java/lang/Object

.field static my_triangle LTriangle;

.method public static main([Ljava/lang/String;)V
	.limit stack 100
	.limit locals 100

	.var 0 is args [Ljava/lang/String;

new Triangle
dup
invokespecial Triangle/<init>()V
putstatic MainClass/my_triangle LTriangle;
getstatic MainClass/my_triangle LTriangle;
ldc 3.0

putfield Triangle/side1 F
getstatic MainClass/my_triangle LTriangle;
ldc 4.0

putfield Triangle/side2 F
getstatic MainClass/my_triangle LTriangle;
ldc 5.0

putfield Triangle/side3 F
getstatic MainClass/my_triangle LTriangle;
invokestatic MainClass/is_right_triangle(LTriangle;)V

	return
.end method

.method public static is_right_triangle(LTriangle;)V
	.limit stack 100
	.limit locals 100

.var 0 is t LTriangle;
	.var 1 is a F
aload 0
getfield Triangle/side1 F

fstore 1
	.var 2 is b F
aload 0
getfield Triangle/side2 F

fstore 2
	.var 3 is c F
aload 0
getfield Triangle/side3 F

fstore 3
	fload 1
fload 1
fmul
fload 2
fload 2
fmul
fadd
fload 3
fload 3
fmul
fcmpl
ifne TrueBranch225
ldc 1
goto EndComparison225
TrueBranch225:
 ldc 0
EndComparison225:
ifeq ElseIF222
	ldc 1
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Z)V

goto EndIF222
ElseIF222:
	ldc 0
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Z)V

EndIF222:

return

.end method
