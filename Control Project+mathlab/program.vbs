Set WshShell = WScript.CreateObject("WScript.Shell")
WshShell.AppActivate "D:\Control Project\KeilCode\KeilCode.uvproj"
WshShell.SendKeys "^{F7}"