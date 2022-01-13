declare void @putint(i32)
declare void @memset(i32*, i32, i32)
define dso_local i32 @main(){
%1 = alloca i32
%2 = alloca  [ 8 x i32]
%3= getelementptr [8 x i32],[8 x i32]* %2,i32 0,i32 0
call void @memset(i32* %3, i32 0, i32 32)
%4=getelementptr [8 x i32],[8 x i32]* %2,i32 0,i32 0
store i32 1, i32* %4
%5=getelementptr [8 x i32],[8 x i32]* %2,i32 0,i32 1
store i32 2, i32* %5
%6=getelementptr [8 x i32],[8 x i32]* %2,i32 0,i32 2
store i32 3, i32* %6
%7=getelementptr [8 x i32],[8 x i32]* %2,i32 0,i32 3
store i32 4, i32* %7
%8=getelementptr [8 x i32],[8 x i32]* %2,i32 0,i32 4
store i32 5, i32* %8
%9=getelementptr [8 x i32],[8 x i32]* %2,i32 0,i32 5
store i32 6, i32* %9
%10=getelementptr [8 x i32],[8 x i32]* %2,i32 0,i32 6
store i32 7, i32* %10
%11=getelementptr [8 x i32],[8 x i32]* %2,i32 0,i32 7
store i32 8, i32* %11
%12 = alloca  [ 8 x i32]
%13= getelementptr [8 x i32],[8 x i32]* %12,i32 0,i32 0
call void @memset(i32* %13, i32 0, i32 32)
%14=getelementptr [8 x i32],[8 x i32]* %12,i32 0,i32 0
store i32 1, i32* %14
%15=getelementptr [8 x i32],[8 x i32]* %12,i32 0,i32 1
store i32 2, i32* %15
%16=getelementptr [8 x i32],[8 x i32]* %12,i32 0,i32 2
store i32 3, i32* %16
%17=getelementptr [8 x i32],[8 x i32]* %12,i32 0,i32 3
store i32 0, i32* %17
%18=getelementptr [8 x i32],[8 x i32]* %12,i32 0,i32 4
store i32 5, i32* %18
%19=getelementptr [8 x i32],[8 x i32]* %12,i32 0,i32 5
store i32 0, i32* %19
%20= add i32 0,0
%21=getelementptr [8 x i32],[8 x i32]* %12,i32 0,i32 6
store i32 7, i32* %21
%22=getelementptr [8 x i32],[8 x i32]* %12,i32 0,i32 7
store i32 8, i32* %22
%23 = alloca  [ 8 x i32]
%24= getelementptr [8 x i32],[8 x i32]* %23,i32 0,i32 0
call void @memset(i32* %24, i32 0, i32 32)
%25= add i32 0,0
%26=mul i32 2,2
%27= add i32 %25,%26
%28=mul i32 1,1
%29= add i32 %27,%28
%30= getelementptr [8 x i32],[8 x i32]* %12,i32 0, i32 %29
%31=load i32,i32* %30
%32=getelementptr [8 x i32],[8 x i32]* %23,i32 0,i32 0
store i32 %31, i32* %32
%33= add i32 0,0
%34=mul i32 2,2
%35= add i32 %33,%34
%36=mul i32 1,1
%37= add i32 %35,%36
%38= getelementptr [8 x i32],[8 x i32]* %2,i32 0, i32 %37
%39=load i32,i32* %38
%40=getelementptr [8 x i32],[8 x i32]* %23,i32 0,i32 1
store i32 %39, i32* %40
%41=getelementptr [8 x i32],[8 x i32]* %23,i32 0,i32 2
store i32 3, i32* %41
%42=getelementptr [8 x i32],[8 x i32]* %23,i32 0,i32 3
store i32 4, i32* %42
%43=getelementptr [8 x i32],[8 x i32]* %23,i32 0,i32 4
store i32 5, i32* %43
%44=getelementptr [8 x i32],[8 x i32]* %23,i32 0,i32 5
store i32 6, i32* %44
%45=getelementptr [8 x i32],[8 x i32]* %23,i32 0,i32 6
store i32 7, i32* %45
%46=getelementptr [8 x i32],[8 x i32]* %23,i32 0,i32 7
store i32 8, i32* %46
%47= add i32 0,0
%48=mul i32 2,3
%49= add i32 %47,%48
%50=mul i32 1,1
%51= add i32 %49,%50
%52=mul i32 1,0
%53= add i32 %51,%52
%54= getelementptr [8 x i32],[8 x i32]* %23,i32 0, i32 %53
%55=load i32,i32* %54
%56= add i32 0,0
%57=mul i32 2,0
%58= add i32 %56,%57
%59=mul i32 1,0
%60= add i32 %58,%59
%61=mul i32 1,0
%62= add i32 %60,%61
%63= getelementptr [8 x i32],[8 x i32]* %23,i32 0, i32 %62
%64=load i32,i32* %63
%65=add i32 %55 , %64
%66= add i32 0,0
%67=mul i32 2,0
%68= add i32 %66,%67
%69=mul i32 1,1
%70= add i32 %68,%69
%71=mul i32 1,0
%72= add i32 %70,%71
%73= getelementptr [8 x i32],[8 x i32]* %23,i32 0, i32 %72
%74=load i32,i32* %73
%75=add i32 %65 , %74
%76= add i32 0,0
%77=mul i32 2,3
%78= add i32 %76,%77
%79=mul i32 1,0
%80= add i32 %78,%79
%81= getelementptr [8 x i32],[8 x i32]* %12,i32 0, i32 %80
%82=load i32,i32* %81
%83=add i32 %75 , %82
call void @putint(i32 %83)
store i32 0,i32* %1
br label %mainReturn
mainReturn:
%84=load i32,i32* %1
ret i32 %84
}