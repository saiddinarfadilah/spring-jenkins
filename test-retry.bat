@echo off
echo Build deployment...

:: Simulate a build step that might fail randomly
set /a "randomNumber=%RANDOM% %% 2"

if %randomNumber%==0 (
    echo Build failed, retrying...
    exit /b 1
) else (
    echo Build successful!
    exit /b 0
)

echo Finished Build.
