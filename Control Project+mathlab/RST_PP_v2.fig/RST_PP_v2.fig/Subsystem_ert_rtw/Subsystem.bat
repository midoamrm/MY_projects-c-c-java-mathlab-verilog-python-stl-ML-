set MATLAB=D:\Programs\MLB2015bx32-x64

cd .

if "%1"=="" (D:\Programs\MLB2015bx32-x64\bin\win64\gmake -f Subsystem.mk all) else (D:\Programs\MLB2015bx32-x64\bin\win64\gmake -f Subsystem.mk %1)
@if errorlevel 1 goto error_exit

exit /B 0

:error_exit
echo The make command returned an error of %errorlevel%
An_error_occurred_during_the_call_to_make
