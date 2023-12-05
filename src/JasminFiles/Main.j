.class public MainClass
.super java/lang/Object

.field static n I

.method public static main([Ljava/lang/String;)V
	.limit stack 100
	.limit locals 100

	.var 0 is args [Ljava/lang/String;

	ldc 10
	putstatic MainClass/n I

	return
.end method

