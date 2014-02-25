@echo off
cd bin/
java -cp D:\antlr4\antlr-4.2-complete.jar; org.antlr.v4.runtime.misc.TestRig %1 %2 -gui < in.txt
cd ..