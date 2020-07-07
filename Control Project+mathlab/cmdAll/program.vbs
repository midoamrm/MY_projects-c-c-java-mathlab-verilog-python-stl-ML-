Set WshShell = WScript.CreateObject("WScript.Shell")
WshShell.AppActivate "D:\Control Project\KeilCode\Combined.uvproj"
WshShell.SendKeys "^{F7}"