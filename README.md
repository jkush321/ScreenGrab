ScreenGrab 2
==========

Created for the [InfaRP server](http://www.gametracker.com/server_info/rp.infa.us:27015/).

Only tested and compiled for Windows. Will probably work on other OS's with minor edits.

Uses Google's Guava. Lua addon originally coded by paellapablo.

Requirements
==========

* Java 7+ installed on server
* Windows (can work on others with minor edits)

Setup
==========

* Put ScreenGrab-Addon folder in garrysmod/addons
* Put gmsv_txtjpg4_win32.dll in garrysmod/lua/bin (create the folder if it isn't there yet)
* Put txtjpg.jar in the same folder as srcds.exe (the folder that contains garrysmod). This is probably called GarrysModDS
* Restart server

Usage
==========
* In game type *!sg name* in chat.
* After a few seconds you will see a screenshot of their game. It will even show things like the steam overlay.
* A .jpg file will be saved to the server in garrysmod/data/screengrabs/filename.jpg