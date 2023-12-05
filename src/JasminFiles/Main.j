.class public MainClass
.super java/lang/Object

.field static a Z
.field static b Z
.field static result1 Z
.field static result2 Z
.field static result3 Z

.method public static main([Ljava/lang/String;)V
	.limit stack 100
	.limit locals 100

	.var 0 is args [Ljava/lang/String;

	ldc 1
	putstatic MainClass/a Z
	ldc 0
	putstatic MainClass/b Z
	getstatic MainClass/a Z
getstatic MainClass/b Z
ior
	putstatic MainClass/result1 Z
	getstatic MainClass/a Z
getstatic MainClass/b Z
iand
	putstatic MainClass/result2 Z
	getstatic MainClass/a Z
getstatic MainClass/b Z
ixor
	putstatic MainClass/result3 Z
getstatic MainClass/result1 Z
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Z)V
getstatic MainClass/result2 Z
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Z)V
getstatic MainClass/result3 Z
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Z)V

	return
.end method

